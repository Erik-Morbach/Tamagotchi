import java.io.File;

/**
 * Cena da Corrida
 *
 * @author Erik
 * @version 1.0.0
 */
public class RunScene extends Scene
{
    /**
     * Utiliza o construtor e carrega a cena
     *
     * @param actor Utilizado para pegar a referencia da tela
     */
    public RunScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    /**
     * Carrega a cena de corrida. Diretorio "assets/run/"
     */
    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        for(int frame=0;frame<=50;frame++){
            Frame currentFrame = new Frame();
            currentFrame.loadFromFile(new File("assets/run/F"+frame+".txt"));
            this.frames.add(currentFrame);
        }
    }
}
