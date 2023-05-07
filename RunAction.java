/**
 * Acao de correr
 *
 * @author Erik
 * @version 1.0.0
 */
public class RunAction extends Action
{
    /**
     * Utiliza o construtor de acao
     *
     * @param tamagotchi Referencia para a execucao da acao
     * @param needed Flag que define se a acao e necessaria
     */
    public RunAction(Tamagotchi tamagotchi, boolean needed){
        super("Correr", needed, tamagotchi);
    }

    /**
     * Executa a acao no tamagotchi e seta a cena atual para cena de corrida
     */
    public void executeImpl(){
        this.tamagotchi.run();
        this.tamagotchi.setCurrentScene(new RunScene(this.tamagotchi));
    }
}
