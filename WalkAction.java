/**
 * Acao de caminhar
 *
 * @author Erik
 * @version 1.0.0
 */
public class WalkAction extends Action
{
    /**
     * Utiliza o construtor de acao
     *
     * @param tamagotchi Referencia para a execucao da acao
     * @param needed Flag que define se a acao e necessaria
     */
    public WalkAction(Tamagotchi tamagotchi, boolean needed){
        super("Caminhar", needed, tamagotchi);
    }

    /**
     * Executa a acao no tamagotchi e seta a cena atual para cena de Caminhar
     */
    public void executeImpl(){
        this.tamagotchi.walk();
        this.tamagotchi.setCurrentScene(new WalkScene(this.tamagotchi));
    }
}
