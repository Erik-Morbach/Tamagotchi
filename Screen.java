import java.util.ArrayList;

/**
 * Write a description of class Screen here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class Screen
{
    private int frameRate;
    private int rows, columns;
    private Actor actor;

    public Screen(int frameRate, int rows, int columns){
        this.frameRate = frameRate;
        this.rows = rows;
        this.columns = columns;
    }

    public void setActor(Actor actor){ this.actor = actor; }
    public Actor getActor(){ return this.actor; }

    public Scene getCurrentScene(){
        if(this.actor == null) return null;
        Scene currentScene = this.actor.getCurrentScene();
        if(currentScene == null){
            currentScene = this.actor.getDefaultScene();
            currentScene.reset();
            this.actor.setCurrentScene(currentScene);
        }

        return currentScene;
    }

    public void popCurrentScene(){
        if(this.actor != null)
            this.actor.setCurrentScene(null);
    }

    public int getFrameRate(){
        return this.frameRate;
    }
    public int getRows(){
        return this.rows;
    }
    public int getColumns(){
        return this.columns;
    }


    public String generateStateString(Tamagotchi tamagotchi){
        String stateStr = "";
        stateStr += "-".repeat(this.columns+2) + "\n";

        String aux = String.format("Nome: %s; Idade: %d; Peso: %d", tamagotchi.getName(), tamagotchi.getAge(), tamagotchi.getWeight());
        stateStr += String.format("|%"+this.columns+"s|\n",aux);

        aux = String.format("Necessidades: %s", tamagotchi.getNeeds());
        stateStr += String.format("|%-"+this.columns+"s|\n",aux);
        aux = String.format("Pontuacao: %s", tamagotchi.getPoints());
        stateStr += String.format("|%-"+this.columns+"s|\n",aux);
        stateStr += "-".repeat(this.columns+2) + "\n";
        return stateStr;
    }

    public String generateActionsString(Tamagotchi tamagotchi){
        String actionsStr = "";
        actionsStr += "-".repeat(this.columns+2) + "\n";
        if(tamagotchi.isAlive()){
            ArrayList<Action> actions = tamagotchi.getActionsToTake();
            actionsStr += this.generateMenuString(actions);
        }
        else{
            actionsStr += this.generateEndGameString(tamagotchi);
        }
        actionsStr += "-".repeat(this.columns+2) + "\n";
        return actionsStr;
    }

    public String generateFrameString(Frame frame){
        int rows = frame.getData().size();
        int columns = 0;
        if(rows >= 1) columns = frame.getData().get(0).length();

        String frameStr = "";

        //Draw border
        frameStr += "-".repeat(this.columns+2) + "\n";

        for(String line: frame.getData())
            frameStr += String.format("|%-"+this.columns+"s|\n",line);
        
        //Draw border
        frameStr += "-".repeat(this.columns+2) + "\n";

        return frameStr;
    }

    public String generateMenuString(ArrayList<Action> actions){
        String menuStr = "";

        for(int index = 0; index < actions.size(); index++){
            String aux = String.format("%d: %s", index, actions.get(index));
            if(actions.get(index).isExecutionNeeded())
                aux += " <-- Acao Necessaria";
            menuStr += String.format("|%-"+this.columns+"s|\n", aux);
        }
        return menuStr;
    }

    public String generateEndGameString(Tamagotchi tamagotchi){
        String endGameStr = "";
        CauseOfDeath cod = tamagotchi.getCauseOfDeath();
        String codStr = "";
        switch(cod){
            case OLD:
                codStr = "Muito velho :(";
                break;
            case EXPLOSION:
                codStr = "Comeu muito e explodiu :O";
                break;
            case STARVED:
                codStr = "Passando fome ;(";
                break;
            default:
                break;
        }

        String aux = String.format("Causa da morte: %s",codStr);
        endGameStr += String.format("|%-"+this.columns+"s|\n", aux);
        return endGameStr;
    }
}

