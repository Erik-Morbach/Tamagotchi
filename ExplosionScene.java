import java.io.File;

/**
 * Cena de explosao
 *
 * @author Erik
 * @version 1.0.0
 */
public class ExplosionScene extends Scene
{
    /**
     * Utiliza o construtor e carrega a cena
     * @param actor Utilizado para conseguir uma referencia para a tela
     */
    public ExplosionScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    /**
     * Carrega a cena da morte por explosao. Diretorio "assets/explosion/"
     */
    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        for(int frame=1;frame<=29;frame++){
            Frame currentFrame = new Frame();
            currentFrame.loadFromFile(new File("assets/explosion/explosionF"+frame+".txt"));
            this.frames.add(currentFrame);
        }
    }
}
