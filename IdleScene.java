import java.io.File;

/**
 * Cena Padrao
 *
 * @author Erik
 * @version 1.0.0
 */
public class IdleScene extends Scene
{
    /**
     * Utiliza o construtor e carrega a cena
     *
     * @param actor Utilizado para conseguir uma referencia da tela
     */
    public IdleScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    /**
     * carrega a cena baseada no unico frame "assets/icon.txt"
     */
    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        Frame currentFrame = new Frame();
        currentFrame.loadFromFile(new File("assets/icon.txt"));
        this.frames.add(currentFrame);
    }
}
