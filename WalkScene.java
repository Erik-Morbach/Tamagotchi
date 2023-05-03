import java.util.ArrayList;
import java.io.File;

/**
 * Write a description of class WalkScene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class WalkScene extends Scene
{
    private Actor actor;
    public WalkScene(Actor actor){
        super(actor.getScreen());
        this.actor = actor;
        this.loadScene();
    }

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
