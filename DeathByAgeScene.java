import java.io.File;

/**
 * Cena da morte por Idade
 *
 * @author Erik
 * @version 1.0.0
 */
public class DeathByAgeScene extends Scene
{
    /**
     * Utiliza o construtor de Cena e carrega a cena da morte
     */
    public DeathByAgeScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    /**
     * Carrega a cena da morte por velhice. Diretorio "assets/old/"
     */
    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        for(int frame=1;frame<=20;frame++){
            Frame currentFrame = new Frame();
            currentFrame.loadFromFile(new File("assets/old/oldF" + frame + ".txt"));
            this.frames.add(currentFrame);
        }
    }
}
