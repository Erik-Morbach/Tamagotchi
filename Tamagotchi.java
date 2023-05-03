import java.util.ArrayList;

/**
 * Write a description of class Tamagotchi here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class Tamagotchi extends Actor
{
    private final double sleepyProbability = 0.2;
    private final double boredProbability = 0.2;
    private final double hungryProbability = 0.2;
    private CauseOfDeath causeOfDeath;
    private String name;
    private int age;
    private int weight;
    private int points;

    private boolean sleepy;
    private int sleepyCounter;

    private boolean hungry;
    private boolean eatALotNeeded;
    private boolean alreadyEated;

    private boolean bored;

    public Tamagotchi(String name){
        super();
        this.name = name;
        this.causeOfDeath = CauseOfDeath.NONE;
        this.age = 14;
        this.weight = 1;
        this.points = 0;
        
        this.sleepy = false;
        this.sleepyCounter = 0;

        this.hungry = false;
        this.eatALotNeeded = false;
        this.alreadyEated = false;

        this.bored = false;
    }

    public ArrayList<Action> getActionsToTake(){
        ArrayList<Action> response = new ArrayList<Action>();
        if(this.sleepy)
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

    public String getNeeds(){
        String response = "";
        if(this.sleepy) response += "Sleepy ";
        if(this.hungry) response += "Hungry ";
        if(this.bored) response += "Bored ";
        if(response.length()==0) return "";
        return response.substring(0, response.length()-1);
    }

    public boolean haveSomeNecessity(){
        return this.bored || this.hungry || this.sleepy;
    }

    public void doNothing(){
        if(this.sleepy) {
            this.sleepyCounter+=1;
        }
        if(this.hungry) this.weight -= 2;
        this.verifyDeath();
    }
    private void setCauseOfDeathIfEmpty(CauseOfDeath cause){
        if(this.causeOfDeath==CauseOfDeath.NONE)
            this.causeOfDeath = cause;
    }
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

    public void sleep(){
        this.sleepy = false;
        this.sleepyCounter = 0;
        this.age += 1;
        this.points++;
    }
    public void eatALot(){
        this.hungry = false;
        this.eatALotNeeded = false;
        this.weight += 5;
        this.setSleepyNecessity();
        this.sleepyCounter = 5; // Sleep needed
        this.alreadyEated = true;
        this.points++;
    }
    public void eat(){
        this.hungry = false;
        this.weight += 1;
        this.alreadyEated = true;
        this.points++;
    }
    public void walk(){
        this.bored = false;
        this.weight -= 1;
        this.eatALotNeeded = false;
        this.setHungryNecessity();
        this.points++;
    }
    public void run(){
        this.bored = false;
        this.weight -= 4;
        this.setHungryNecessity();
        this.eatALotNeeded = true;
        this.points++;
    }


    public void generateRandomNecessity(){
        double rand = Math.random();
        if(rand <= this.sleepyProbability) this.setSleepyNecessity();
        else if(rand <= this.sleepyProbability + this.hungryProbability) this.setHungryNecessity();
        else if(this.alreadyEated && rand <= this.sleepyProbability + this.hungryProbability + this.boredProbability) this.setBoredNecessity();
    }

    public void setSleepyNecessity(){
        this.sleepy = true;
        this.sleepyCounter = Math.max(this.sleepyCounter, 1);
    }
    public void setHungryNecessity(){
        this.hungry = true;
    }
    public void setBoredNecessity(){
        this.bored = true;
    }

    public CauseOfDeath getCauseOfDeath(){
        return this.causeOfDeath;
    }

    public boolean isAlive(){
        return this.causeOfDeath == CauseOfDeath.NONE;
    }


    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public int getWeight(){
        return this.weight;
    }

    public int getPoints(){
        return this.points;
    }

}
