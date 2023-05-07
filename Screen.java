import java.util.ArrayList;

/**
 * Define a Cena
 *
 * @author Erik
 * @version 1.0.0
 */
public class Screen
{
    /*
     * framerate da tela
     */
    private int frameRate;
    /*
     * Dimensoes da tela
     */
    private int rows, columns;
    /*
     * Ator principal da cena
     */
    private Actor actor;

    /**
     * Construtor
     */
    public Screen(int frameRate, int rows, int columns){
        this.frameRate = frameRate;
        this.rows = rows;
        this.columns = columns;
    }

    // Metodos de acesso
    public void setActor(Actor actor){ this.actor = actor; }
    public Actor getActor(){ return this.actor; }
    public int getFrameRate(){ return this.frameRate; }
    public int getRows(){ return this.rows; }
    public int getColumns(){ return this.columns; }

    /**
     * pega a cena atual
     */
    public Scene getCurrentScene(){
        if(this.actor == null) return null; // Se nao tem ator, nao tem cena
        Scene currentScene = this.actor.getCurrentScene(); // pega cena atual do ator
        if(currentScene == null){ // se a cena atual for nula
            currentScene = this.actor.getDefaultScene(); // pega cena padrao
            currentScene.reset(); // reseta a cena
            this.actor.setCurrentScene(currentScene); // seta como cena atual do ator
        }
        return currentScene;
    }

    /**
     * seta a cena atual para nullo
     */
    public void popCurrentScene(){
        if(this.actor != null)
            this.actor.setCurrentScene(null);
    }

    /**
     * Gera uma string de barra de status para o tamagotchi
     */
    public String generateHeaderString(Tamagotchi tamagotchi){
        String stateStr = "";
        stateStr += "-".repeat(this.columns+2) + "\n"; // Borda

        // Status padrao (nome, idade, peso)
        String aux = String.format("Nome: %s; Idade: %d; Peso: %d", tamagotchi.getName(), tamagotchi.getAge(), tamagotchi.getWeight());
        stateStr += String.format("|%"+this.columns+"s|\n",aux);

        // Necessidades atuais
        aux = String.format("Necessidades: %s", tamagotchi.getNeeds());
        stateStr += String.format("|%-"+this.columns+"s|\n",aux);

        // Pontuacao atual
        aux = String.format("Pontuacao: %s", tamagotchi.getPoints());
        stateStr += String.format("|%-"+this.columns+"s|\n",aux);

        stateStr += "-".repeat(this.columns+2) + "\n"; // Borda
        return stateStr;
    }

    /**
     * Se o tamagotchi esta vivo, gera uma barra com as acoes possiveis
     * Se o tamagotchi esta morto, gera uma barra com a causa da morte
     */
    public String generateFooterString(Tamagotchi tamagotchi){
        String actionsStr = "";
        actionsStr += "-".repeat(this.columns+2) + "\n"; // borda
        if(tamagotchi.isAlive()){ // Se esta vivo
            ArrayList<Action> actions = tamagotchi.getActionsToTake(); // pega as acoes possivei
            actionsStr += this.generateMenuString(actions); // Gera menu com as acoes
        }
        else{ // se esta Morto
            actionsStr += this.generateEndGameString(tamagotchi); // Gera menu de fim de jogo
        }
        actionsStr += "-".repeat(this.columns+2) + "\n"; // borda
        return actionsStr;
    }

    /**
     * Gera uma string com o frame
     */
    public String generateFrameString(Frame frame){
        String frameStr = "";

        frameStr += "-".repeat(this.columns+2) + "\n"; // borda

        for(String line: frame.getData()) // Desenha o frame 
            frameStr += String.format("|%-"+this.columns+"s|\n",line);

        frameStr += "-".repeat(this.columns+2) + "\n"; // borda

        return frameStr;
    }

    /**
     * Dadas acoes, gera um menu com as acoes, seus indices e quais sao necessarias
     */
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

    /**
     * Gera o menu de fim de jogo com a causa da morte do tamagotchi
     */
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

