
/**
 * Write a description of class DanceAction here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class DeathAction extends Action
{
    public DeathAction(Tamagotchi tamagotchi){
        super("Death", tamagotchi, true);
    }
    public void execute(){
        switch(this.tamagotchi.getCauseOfDeath()){
            case OLD:
                this.tamagotchi.setCurrentScene(new DeathByAgeScene(this.tamagotchi));
                break;
            case STARVED:
                this.tamagotchi.setCurrentScene(new StarvedScene(this.tamagotchi));
                break;
            case EXPLOSION:
                this.tamagotchi.setCurrentScene(new ExplosionScene(this.tamagotchi));
                break;
            default:
                this.tamagotchi.setCurrentScene(new ExplosionScene(this.tamagotchi)); // Just for fun
                break;
        }
        this.tamagotchi.setDefaultScene(new DeadScene(this.tamagotchi));
    }
}
