import java.io.File;

/**
 * Write a description of class EatScene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class StarvedScene extends Scene
{
    public StarvedScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        for(int frame=4;frame<=7*4;frame++){
            Frame currentFrame = new Frame();
            currentFrame.loadFromFile(new File("assets/starve/starveF"+(frame/4)+".txt"));
            this.frames.add(currentFrame);
        }

    }


}
