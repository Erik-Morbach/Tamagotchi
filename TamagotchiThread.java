/**
 * Write a description of class TamagotchiThread here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TamagotchiThread implements Runnable
{
    private final long interventionPeriod = 1000;
    private Tamagotchi tamagotchi;
    public TamagotchiThread(Tamagotchi tamagotchi){
        this.tamagotchi = tamagotchi;
    }

    public void run(){
        while(this.tamagotchi.isAlive()){
            this.tamagotchi.verifyDeath();
            try{
                Thread.sleep(interventionPeriod);
            } catch(InterruptedException e){
                System.err.println(e);
            }
            if(!this.tamagotchi.haveSomeNecessity())
                this.tamagotchi.generateRandomNecessity();
        }
        DeathAction action = new DeathAction(this.tamagotchi);
        action.execute();
    }
}
