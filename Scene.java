import java.util.ArrayList;

/**
 * Write a description of class Scene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class Scene
{
    protected ArrayList<Frame> frames;
    protected int frameIndex;
    protected Screen screen;

    public Scene(Screen screen){
        this.frames = new ArrayList<Frame>();
        this.frameIndex = 0;
        this.screen = screen;
    }

    public boolean isSceneEnded(){
        return this.frameIndex >= this.frames.size();
    }

    public void reset(){
        this.frameIndex = 0;
    }

    public Frame getNextFrame(){
        if(this.isSceneEnded()) return null;
        return this.frames.get(this.frameIndex++);
    }

}
