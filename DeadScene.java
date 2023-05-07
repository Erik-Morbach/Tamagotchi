import java.io.File;

/**
 * Cena de morte
 *
 * @author Erik
 * @version 1.0.0
 */
public class DeadScene extends Scene
{
    /**
     * Utiliza o construtor padrão de cena e carrega a cena
     */
    public DeadScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    /**
     * Esta cena e constituida por um unico frame
     */
    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        Frame currentFrame = new Frame();
        currentFrame.loadFromFile(new File("assets/iconDead.txt"));
        this.frames.add(currentFrame);
    }
}
