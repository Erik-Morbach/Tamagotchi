
/**
 * Write a description of class EatAction here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class EatAction extends Action
{
    public EatAction(Tamagotchi tamagotchi, boolean needed){
        super("Comer", tamagotchi, needed);
    }

    public void execute(){
        this.setAlreadyExecuted();
        this.tamagotchi.eat();
        this.tamagotchi.setCurrentScene(new EatScene(this.tamagotchi));
    }

}
