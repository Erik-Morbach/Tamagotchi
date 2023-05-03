import java.util.ArrayList;
/**
 * Write a description of class EatScene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class StarvedScene extends Scene
{
    private Actor actor;
    public StarvedScene(Actor actor){
        super(actor.getScreen());
        this.actor = actor;
        this.loadScene();
    }

    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        for(int frame=0;frame<=10;frame++){
            Frame currentFrame = new Frame();
            ArrayList<String> data = new ArrayList<String>();

            for(int row=0;row<=20;row++){
                String line = " ";
                if(row == 10)
                    line = "Death by starve";
                line = String.format("%17s %2d", line, frame);
                data.add(line);
            }
            currentFrame.setData(data);
            this.frames.add(currentFrame);
        }

    }


}
