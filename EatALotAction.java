
/**
 * Write a description of class EatALotAction here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class EatALotAction extends Action
{
    public EatALotAction(Tamagotchi tamagotchi, boolean needed){
        super("Comer muito", tamagotchi, needed);
    }

    public void execute(){
        this.setAlreadyExecuted();
        this.tamagotchi.eatALot();
        this.tamagotchi.setCurrentScene(new EatALotScene(this.tamagotchi));
    }
}
