import java.util.Scanner;
import java.util.ArrayList;

/**
 * Classe que define as acoes do teclado
 *
 * @author Erik
 * @version 1.0.0
 */
public class IoEvent
{
    /**
     * Scanner utilizado para pegar as informacoes do teclado
     */
    private Scanner scanner;
    /**
     * Referencia para o tamagotchi (Utilizado para pegar as acoes possievies)
     */
    private Tamagotchi tamagotchi;

    /**
     * Construtor
     */
    public IoEvent(Tamagotchi tamagotchi){
        this.scanner = new Scanner(System.in);
        this.tamagotchi = tamagotchi;
    }

    /**
     * Fecha o scanner
     */
    public void close(){
        this.scanner.close();
    }

    /**
     * Le o proximo Int do teclado
     *
     * @return proximo int digitado
     */
    public int readOption(){
        return scanner.nextInt();
    }

    /**
     * Carrega as acoes possiveis e executa a opcao selecionada
     *
     */
    public void executeOption(int option){
        ArrayList<Action> actions = tamagotchi.getActionsToTake();
        if(option < 0 || option >= actions.size()) return; // Caso acao esteja fora das possiveis, nao faz nada

        Action wantedAction = actions.get(option); // pega a acao selecionada

        if(actions.stream().anyMatch(action -> action.isExecutionNeeded())) // Caso alguma acao seja necessaria
            if(!wantedAction.isExecutionNeeded()) // se nao selecionou um necessaria, nao faz nada
                return;

        wantedAction.execute(); // Executa a acao
    }
}
