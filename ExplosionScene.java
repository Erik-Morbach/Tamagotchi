import java.util.ArrayList;
import java.io.File;
/**
 * Write a description of class EatScene here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class ExplosionScene extends Scene
{
    private Actor actor;
    public ExplosionScene(Actor actor){
        super(actor.getScreen());
        this.actor = actor;
        this.loadScene();
    }

    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        // 0 -> 10 (only the base explosion expanding)
        // 11 -> 20 (begin to encolher(pouco) e subir(pouco))
        // 21 -> 40 (continua subindo e base começa a aparecer)
        for(int frame=0;frame<=40;frame++){
            Frame currentFrame = new Frame();
            if(frame <= 10)
                this.drawBaseExplosion(currentFrame, frame);
            else if(frame <= 20)
                this.drawExplosionFloatingFirstStage(currentFrame, frame);
            else this.drawExplosionFinalStage(currentFrame, frame);
            currentFrame.loadFromFile(new File("assets/iconDead.txt"));
            this.frames.add(currentFrame);
        }
    }

    private void drawBaseExplosion(Frame frame, int frameIndex){

    }
    private void drawExplosionFloatingFirstStage(Frame frame, int frameIndex){

    }
    private void drawExplosionFinalStage(Frame frame, int frameIndex){

    }


}
