/**
 * Implementacao da Acao de danca
 *
 * @author Erik
 * @version 1.0.0
 */
public class DanceAction extends Action
{
    /**
     * Metodo construtor
     */
    public DanceAction(Tamagotchi tamagotchi, boolean need){
        super("Dancar", need, tamagotchi);
    }
    /**
     * Utiliza a acao de nao fazer nada
     * apos isso seta como cena atual a cena da Danca
     */
    public void executeImpl(){
        this.tamagotchi.doNothing();
        this.tamagotchi.setCurrentScene(new DanceScene(this.tamagotchi));
    }
}
