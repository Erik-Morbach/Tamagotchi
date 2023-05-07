/**
 * Acao de comer
 *
 * @author Erik
 * @version 1.0.0
 */
public class EatAction extends Action
{
    /**
     * Metodo construtor
     *
     * @param tamagotchi Referencia onde a acao sera executada
     * @param needed Flag que define se a acao é necessaria
     */
    public EatAction(Tamagotchi tamagotchi, boolean needed){
        super("Comer", needed, tamagotchi);
    }

    /**
     * Acao e executada no tamagotchi e cena de comer e setada
     */
    public void executeImpl(){
        this.tamagotchi.eat();
        this.tamagotchi.setCurrentScene(new EatScene(this.tamagotchi));
    }
}
