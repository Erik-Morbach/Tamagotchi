/**
 * Acao de Comer Muito
 *
 * @author Erik
 * @version 1.0.0
 */
public class EatALotAction extends Action
{
    /**
     * Metodo construtor
     *
     * @param tamagotchi Referencia utilizada para comer muito
     * @param needed define se a acao e necessaria
     */
    public EatALotAction(Tamagotchi tamagotchi, boolean needed){
        super("Comer muito", needed, tamagotchi);
    }

    /**
     * Faz a referencia comer muito e seta a cena atual para cena de comer muito
     */
    public void executeImpl(){
        this.tamagotchi.eatALot();
        this.tamagotchi.setCurrentScene(new EatALotScene(this.tamagotchi));
    }
}
