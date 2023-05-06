import java.io.File;

/**
 * Write a description of class RunScene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class RunScene extends Scene
{
    public RunScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

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
