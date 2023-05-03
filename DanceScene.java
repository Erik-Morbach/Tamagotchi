import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class DanceScene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class DanceScene extends Scene
{
    private Actor actor;
    public DanceScene(Actor actor){
        super(actor.getScreen());
        this.actor = actor;
        this.loadScene();
    }

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
