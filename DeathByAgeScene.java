import java.io.File;

/**
 * Write a description of class EatScene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class DeathByAgeScene extends Scene
{
    public DeathByAgeScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

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
