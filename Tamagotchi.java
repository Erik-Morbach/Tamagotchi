import java.util.ArrayList;

/**
 * Definicao do Tamagotchi
 *
 * @author Erik
 * @version 1.0.0
 */
public class Tamagotchi extends Actor
{
    // Definicao das constantes de probabilidade
    private final double sleepyProbability = 0.2; // Probabilidade de dormir
    private final double boredProbability = 0.2; // Probabilidade de ficar entediado
    private final double hungryProbability = 0.2; // Probabilidade de ficar com fome
    /**
     * Causa da morte do Tamagotchi
     */
    private CauseOfDeath causeOfDeath;
    /**
     * nome do Tamagotchi
     */
    private String name;
    /**
     * Idade do tamagotchi
     */
    private int age;
    /**
     * Peso do tamagotchi
     */
    private int weight;
    /**
     * Pontos que o tamagotchi conseguiu
     */
    private int points;

    /**
     * Flag de sonolento
     */
    private boolean sleepy;
    /**
     * Contador de vezes que o sono foi ignorado
     */
    private int sleepyCounter;

    /**
     * Flag de faminto
     */
    private boolean hungry;
    /**
     * Flag de necessidade de comer muito
     */
    private boolean eatALotNeeded;
    /**
     * Flag que define se o tamagotchi ja executou alguma acao de comer
     * Utilizada para nao possibilitar ele de criar a necessidade de correr/caminhar
     * sem antes ter comido.
     */
    private boolean alreadyEated;

    /**
     * Flag de entediado
     */
    private boolean bored;

    /**
     * Metodo construtor, utiliza o nome e define de forma padrao os outros atributos
     */
    public Tamagotchi(String name){
        super();
        this.name = name;
        this.causeOfDeath = CauseOfDeath.NONE;
        this.age = 0;
        this.weight = 1;
        this.points = 0;

        this.sleepy = false;
        this.sleepyCounter = 0;

        this.hungry = false;
        this.eatALotNeeded = false;
        this.alreadyEated = false; // Ainda nao foi alimentado

        this.bored = false;
    }

    /**
     * Retorna as acoes possiveis que podem ser executadas no tamagotchi
     */
    public ArrayList<Action> getActionsToTake(){
        ArrayList<Action> response = new ArrayList<Action>();
        if(this.sleepy) // Sono e necessario se ja foi ignorado 5 vezes
            response.add(new SleepAction(this, this.sleepyCounter >= 5));
        if(this.hungry){
            response.add(new EatAction(this, false));
            response.add(new EatALotAction(this, this.eatALotNeeded));
        }
        if(this.bored){
            response.add(new WalkAction(this, false));
            response.add(new RunAction(this, false));
        }
        response.add(new DanceAction(this, false));
        return response;
    }

    /**
     * Retorna uma String com a descricao das necessidades atuais do tamagotchi
     */
    public String getNeeds(){
        String response = "";
        if(this.sleepy) response += "Sonolento ";
        if(this.hungry) response += "Faminto ";
        if(this.bored) response += "Entediado ";
        if(response.length()==0) return "";
        return response.strip();
    }

    /**
     * Retorna True se possui alguma necessidade
     */
    public boolean haveSomeNecessity(){
        return this.bored || this.hungry || this.sleepy;
    }

    /**
     * Acao de nao fazer nada / dancar
     */
    public void doNothing(){
        if(this.sleepy) this.sleepyCounter+=1;
        if(this.hungry) this.weight -= 2;
        this.verifyDeath(); // Necessario a verificacao
    }
    /**
     * Somente Seta a causa da morte se o tamagotchi ainda nao morreu
     */
    private void setCauseOfDeathIfEmpty(CauseOfDeath cause){
        if(this.causeOfDeath==CauseOfDeath.NONE)
            this.causeOfDeath = cause;
    }
    /**
     * Verifica se esta morto e seta a causa da morte
     */
    public boolean verifyDeath(){
        if(this.age >= 15){
            this.setCauseOfDeathIfEmpty(CauseOfDeath.OLD);
            return true;
        }
        if(this.weight >= 20){
            this.setCauseOfDeathIfEmpty(CauseOfDeath.EXPLOSION);
            return true;
        }
        if(this.weight <= 0){
            this.setCauseOfDeathIfEmpty(CauseOfDeath.STARVED);
            return true;
        }
        return false;
    }

    /**
     * Acao de dormir
     */
    public void sleep(){
        this.sleepy = false;
        this.sleepyCounter = 0;
        this.age += 1;
        this.points++;
        this.verifyDeath();
    }
    /**
     * Acao de comer muito
     */
    public void eatALot(){
        this.hungry = false;
        this.eatALotNeeded = false;
        this.weight += 5;
        this.setSleepyNecessity();
        this.sleepyCounter = 5; // Como o sono e necessario, o contador e setado direto para 5
        this.alreadyEated = true;
        this.points++;
        this.verifyDeath();
    }
    /**
     * Acao de comer
     */
    public void eat(){
        this.hungry = false;
        this.weight += 1;
        this.alreadyEated = true;
        this.points++;
        this.verifyDeath();
    }
    /**
     * Acao de caminhar
     */
    public void walk(){
        this.bored = false;
        this.weight -= 1;
        this.eatALotNeeded = false;
        this.setHungryNecessity();
        this.points++;
        this.verifyDeath();
    }
    /**
     * Acao de correr
     */
    public void run(){
        this.bored = false;
        this.weight -= 4;
        this.setHungryNecessity();
        this.eatALotNeeded = true;
        this.points++;
        this.verifyDeath();
    }

    /**
     * Gera uma necessidade aleatoria para o tamagotchi
     */
    public void generateRandomNecessity(){
        double rand = Math.random(); // numero aleatorio
        // 0 - P(dormir) -> Sonolento
        // P(dormir) - P(dormir) + P(Fome) -> Faminto
        // P(dormir) + P(Fome) - P(dormir) + P(Fome) + P(tedio) -> Tedio
        if(rand <= this.sleepyProbability) this.setSleepyNecessity();
        else if(rand <= this.sleepyProbability + this.hungryProbability) this.setHungryNecessity();
        else if(this.alreadyEated && rand <= this.sleepyProbability + this.hungryProbability + this.boredProbability) this.setBoredNecessity();
    }

    /**
     * Seta a necessidade de dormir
     */
    public void setSleepyNecessity(){
        this.sleepy = true;
        this.sleepyCounter = Math.max(this.sleepyCounter, 1);
    }
    /**
     * Seta a necessidade de comer
     */
    public void setHungryNecessity(){
        this.hungry = true;
    }
    /**
     * Seta a "necessidade" de Tedio
     */
    public void setBoredNecessity(){
        this.bored = true;
    }
    /**
     * retorna True se esta vivo
     */
    public boolean isAlive(){
        return this.causeOfDeath == CauseOfDeath.NONE;
    }

    //Metodos de acesso
    public String getName(){ return this.name; }
    public int getAge(){ return this.age; }
    public int getWeight(){ return this.weight; }
    public int getPoints(){ return this.points; }
    public CauseOfDeath getCauseOfDeath(){ return this.causeOfDeath; }
}
