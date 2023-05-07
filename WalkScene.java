import java.io.File;

/**
 * Cena de caminhar
 *
 * @author Erik
 * @version 1.0.0
 */
public class WalkScene extends Scene
{
    /**
     * Utiliza o construtor e carrega a cena
     *
     * @param actor Utilizado para pegar a referencia da tela
     */
    public WalkScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    /**
     * Carrega a cena de corrida. Diretorio "assets/walk/"
     */
    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        for(int frame=0;frame<=51;frame++){
            Frame currentFrame = new Frame();
            currentFrame.loadFromFile(new File("assets/walk/F"+frame+".txt"));
            this.frames.add(currentFrame);
        }
    }
}
