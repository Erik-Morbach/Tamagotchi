import java.util.ArrayList;
import java.io.File;
/**
 * Write a description of class EatScene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class EatScene extends Scene
{
    private Actor actor;
    public EatScene(Actor actor){
        super(actor.getScreen());
        this.actor = actor;
        this.loadScene();
    }

    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        Frame idleFrame = new Frame();
        idleFrame.loadFromFile(new File("assets/icon.txt"));

        Actor bug = new Actor();
        bug.setCol(0);
        bug.setRow(7);

        Actor tongue = new Actor();
        tongue.setRow(14);
        tongue.setCol(24);

        for(int frame=0;frame<=40;frame++){
            Frame currentFrame = new Frame();
            ArrayList<String> data = new ArrayList<String>(idleFrame.getData());
            currentFrame.setData(data);

            if(frame <= 30)
                this.drawBug(bug, currentFrame, frame);

            if(frame >= 20)
                this.drawTongue(tongue, bug, currentFrame, (frame-20.0)/20.0);

            currentFrame.setData(data);

            this.frames.add(currentFrame);
        }
    }

    /**
     * draw a tongue on frame. 0 to 50% the tongue is going to target
     * 51 to 100% the tongue is coming back
     *
     * @param begin 
     * @param target 
     * @param frame 
     * @param percent 
     */
    private void drawTongue(Actor begin, Actor target, Frame frame, double percent){

        int col = begin.getCol();
        int beginR = begin.getRow();
        int endR = target.getRow();

        int diffR = Math.abs(endR - beginR);
        if(percent <= 0.5) diffR = (int)(diffR * percent*2.0);
        else diffR = (int) (diffR * (0.5 - (percent-0.5))*2.0); // 51 - 100% -> 50 - 0%
        
        int currentEndTongue = beginR - diffR;
        
        for(int j=currentEndTongue;j<=beginR;j++){
            char row[] = frame.getData().get(j).toCharArray();
            char l = '|';
            char r = '|';
            if(j==currentEndTongue) {
                l = '/'; r = '\\';
            }
            row[col] = l; row[col+1] = r;
            frame.getData().set(j, String.valueOf(row));
        }

    }

    private void drawBug(Actor bug, Frame frame, int frameIndex){
        double bugDelta = 25.0/30.0;
        ArrayList<String> data = frame.getData();
        
        char rowData[] = data.get(bug.getRow()).toCharArray();
        for(int i=-1;i<=1;i++)
            rowData[Math.max(bug.getCol()+i,0)] = '~';
        data.set(bug.getRow(), String.valueOf(rowData));

        int y = 7 + (int)Math.ceil(Math.sin(bug.getCol()/3.0)*2);
        int x = (int)(frameIndex * bugDelta);
        bug.setRow(y);
        bug.setCol(x);
    }


}
