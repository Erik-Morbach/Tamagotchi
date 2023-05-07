/**
 * Acao de morte. Utilizada para setar a cena correta baseada na forma da morte
 *
 * @author Erik
 * @version 1.0.0
 */
public class DeathAction extends Action
{
    /**
     * Metodo Construtor
     *
     * @param tamagotchi Referencia que sera utilizada na execucao
     */
    public DeathAction(Tamagotchi tamagotchi){
        super("Death", true, tamagotchi);
    }
    /**
     * Seta a cena baseado na forma da morte do tamagotchi
     */
    public void executeImpl(){
        switch(this.tamagotchi.getCauseOfDeath()){
            case OLD:
                this.tamagotchi.setCurrentScene(new DeathByAgeScene(this.tamagotchi));
                break;
            case STARVED:
                this.tamagotchi.setCurrentScene(new StarvedScene(this.tamagotchi));
                break;
            case EXPLOSION:
                this.tamagotchi.setCurrentScene(new ExplosionScene(this.tamagotchi));
                break;
            default:
                this.tamagotchi.setCurrentScene(new ExplosionScene(this.tamagotchi));
                break;
        }
        this.tamagotchi.setDefaultScene(new DeadScene(this.tamagotchi));
    }
}
