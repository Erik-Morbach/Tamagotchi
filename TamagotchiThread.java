/**
 * Gerenciador das necessidades do Tamagotchi
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TamagotchiThread implements Runnable
{
    /**
     * Tempo entre as intervencoes
     */
    private final long interventionPeriod = 100;
    /**
     * Referencia para o tamagotchi
     */
    private Tamagotchi tamagotchi;
    /**
     * Construtor
     */
    public TamagotchiThread(Tamagotchi tamagotchi){
        this.tamagotchi = tamagotchi;
    }

    /**
     * Metodo de execucao da Thread
     */
    public void run(){
        while(this.tamagotchi.isAlive()){ // Enquanto estiver vivo
            this.tamagotchi.verifyDeath(); // Verifica situacao da morte
            try{
                Thread.sleep(interventionPeriod); // Aguarda o tempo da intervencao
            } catch(InterruptedException e){
                System.err.println(e);
            }
            if(!this.tamagotchi.haveSomeNecessity()) // Se nao tiver nenhuma necessidade
                this.tamagotchi.generateRandomNecessity(); // Gera uma necessidade aleatoria
        }
        // Ao chegar nesta linha, o tamagotchi necessariamente esta morto
        DeathAction action = new DeathAction(this.tamagotchi); // Gera a acao da morte
        action.execute();
    }
}
