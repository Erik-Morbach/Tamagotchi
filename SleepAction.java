
/**
 * Write a description of class SleepAction here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class SleepAction extends Action
{
    public SleepAction(Tamagotchi tamagotchi, boolean needed){
        super("Dormir", tamagotchi, needed);
    }

    public void execute(){
        this.setAlreadyExecuted();
        this.tamagotchi.sleep();
        this.tamagotchi.setCurrentScene(new SleepScene(this.tamagotchi));
    }
}
