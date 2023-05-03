import java.util.ArrayList;
import java.io.File;

/**
 * Write a description of class EatALotScene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class IdleScene extends Scene
{
    private Actor actor;
    public IdleScene(Actor actor){
        super(actor.getScreen());
        this.actor = actor;
        this.loadScene();
    }

    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        for(int frame=0;frame<=5;frame++){
            Frame currentFrame = new Frame();
            currentFrame.loadFromFile(new File("assets/icon.txt"));
            this.frames.add(currentFrame);
        }
    }
}
