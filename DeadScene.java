import java.io.File;
/**
 * Write a description of class EatScene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class DeadScene extends Scene
{
    private Actor actor;
    public DeadScene(Actor actor){
        super(actor.getScreen());
        this.actor = actor;
        this.loadScene();
    }

    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        for(int frame=0;frame<=10;frame++){
            Frame currentFrame = new Frame();
            currentFrame.loadFromFile(new File("assets/iconDead.txt"));
            this.frames.add(currentFrame);
        }

    }


}
