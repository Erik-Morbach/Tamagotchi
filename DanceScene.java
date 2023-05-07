import java.io.File;

/**
 * Cena de Danca
 *
 * @author Erik
 * @version 1.0.0
 */
public class DanceScene extends Scene
{
    /**
     * Utiliza o construtor padrão de cena e carrega a cena
     */
    public DanceScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    /**
     * carrega a cena baseado nos arquivos do diretorio "assets/dance/"
     */
    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        for(int repetitions = 0; repetitions <7;repetitions++){
            for(int i=1;i<=7;i++){
                Frame currentFrame = new Frame();
                String framePath = "assets/dance/danceF"+i+".txt";
                currentFrame.loadFromFile(new File(framePath));
                this.frames.add(currentFrame);
            }
        }
    }
}
