
/**
 * Write a description of class DanceAction here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class DanceAction extends Action
{
    public DanceAction(Tamagotchi tamagotchi, boolean need){
        super("Dancar", tamagotchi, need);
    }
    public void execute(){
        this.tamagotchi.doNothing();
        this.tamagotchi.setCurrentScene(new DanceScene(this.tamagotchi));
    }
}
