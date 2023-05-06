import java.util.ArrayList;
import java.io.File;

/**
 * Write a description of class SleepScene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class SleepScene extends Scene
{
    public SleepScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        Frame backgroundFrame = new Frame();
        backgroundFrame.loadFromFile(new File("assets/iconSleep.txt"));
        for(int frame=0;frame<=10;frame++){
            Frame currentFrame = new Frame();
            currentFrame.setData(new ArrayList<String>(backgroundFrame.getData()));

            this.drawZzz(currentFrame, frame);
            this.frames.add(currentFrame);
        }
    }
    
    private void drawZzz(Frame frame, int frameIndex){
        int beginRow = 14;
        int beginCol = 32;
        int dr = -1;
        int dc = 2;
        int currentCol = beginCol;
        int currentRow = beginRow;
        for(int i=0;i<frameIndex;i++){
            if(currentRow < 0) break;
            ArrayList<String> data = frame.getData();
            char[] rowData = data.get(currentRow).toCharArray();

            if(i%2==0) rowData[currentCol] = 'z';
            else rowData[currentCol] = 'Z';

            data.set(currentRow, String.valueOf(rowData));

            currentCol += dc;
            currentRow += dr;
            dc = -dc;
            if(dc==-2) dr = -2;
            else dr = -1;
        }

    }
}
