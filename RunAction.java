
/**
 * Write a description of class RunAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RunAction extends Action
{
    public RunAction(Tamagotchi tamagotchi, boolean needed){
        super("Correr", tamagotchi, needed);
    }

    public void execute(){
        this.setAlreadyExecuted();
        this.tamagotchi.run();
        this.tamagotchi.setCurrentScene(new RunScene(this.tamagotchi));
    }
}
