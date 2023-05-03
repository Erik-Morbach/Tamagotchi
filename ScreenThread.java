import java.lang.Runnable;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Write a description of class ScreenThread here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class ScreenThread implements Runnable
{
    private Screen screen;
    private Tamagotchi tamagotchi;
    public ScreenThread(Screen screen, Tamagotchi tamagotchi){
        this.screen = screen;
        this.tamagotchi = tamagotchi;
    }
    public void run(){
        while(true){
            try{
                Thread.sleep((int)((double)1/this.screen.getFrameRate()*1000));
            } catch(Exception e){

            }
            Scene currentScene = screen.getCurrentScene();
            if(currentScene.isSceneEnded()){
                this.screen.popCurrentScene();
                continue;
            }
            Frame currentFrame = currentScene.getNextFrame();
            if(currentFrame == null) continue;
            String frameString = "";
            frameString += '\u000C'; // Clear screen on BlueJ
            frameString += this.screen.generateStateString(this.tamagotchi);
            frameString += this.screen.generateFrameString(currentFrame);
            frameString += this.screen.generateActionsString(this.tamagotchi);

            System.out.println(frameString);
        }
    }

}
