/**
 * Write a description of class WalkAction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WalkAction extends Action
{
    public WalkAction(Tamagotchi tamagotchi, boolean needed){
        super("Caminhar", tamagotchi, needed);
    }

    public void execute(){
        this.setAlreadyExecuted();
        this.tamagotchi.walk();
        this.tamagotchi.setCurrentScene(new WalkScene(this.tamagotchi));
    }
}
