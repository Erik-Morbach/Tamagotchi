import java.util.Scanner;
import java.util.ArrayList;


/**
 * Write a description of class IoEvent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IoEvent
{
    private Scanner scanner;
    private Tamagotchi tamagotchi;

    public IoEvent(Tamagotchi tamagotchi){
        scanner = new Scanner(System.in);
        this.tamagotchi = tamagotchi;
    }

    public int readOption(){
        return scanner.nextInt();
    }

    public void executeOption(int option){
        ArrayList<Action> actions = tamagotchi.getActionsToTake();
        if(option < 0 || option >= actions.size()) return;
        Action wantedAction = actions.get(option);
        if(actions.stream().anyMatch(action -> action.isExecutionNeeded()))
            if(!wantedAction.isExecutionNeeded())
                return;
        if(wantedAction.isAlreadyExecuted()) return;
        wantedAction.execute();
    }
}
