/**
 * Acao de dormir
 *
 * @author Erik
 * @version 1.0.0
 */
public class SleepAction extends Action
{
    /**
     * Utiliza o construtor de acao
     *
     * @param tamagotchi Referencia para a execucao da acao
     * @param needed Flag que define se a acao e necessaria
     */
    public SleepAction(Tamagotchi tamagotchi, boolean needed){
        super("Dormir", needed, tamagotchi);
    }

    /**
     * Executa a acao no tamagotchi e seta a cena atual para cena de dormir
     */
    public void executeImpl(){
        this.tamagotchi.sleep();
        this.tamagotchi.setCurrentScene(new SleepScene(this.tamagotchi));
    }
}
