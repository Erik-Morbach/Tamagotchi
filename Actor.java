
/**
 * Write a description of class Actor here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class Actor
{
    private Scene currentScene;
    private Scene defaultScene;
    protected Screen screen;
    /*
     * Current x,y position of the Actor on the screen
     */
    private int x,y;
    public Actor(){
        this.x = 0;
        this.y = 0;
    }
    protected void setCurrentScene(Scene scene){ this.currentScene = scene; }
    protected void setDefaultScene(Scene scene){ this.defaultScene = scene; }

    public Scene getCurrentScene(){ return this.currentScene; }
    public Scene getDefaultScene(){
        return this.defaultScene;
    }

    public int getRow(){ return this.x; }
    public int getCol(){ return this.y; }
    public void setRow(int x){ this.x = x; }
    public void setCol(int y){ this.y = y; }

    public void setScreen(Screen screen){
        this.screen = screen;
    }
    public Screen getScreen(){
        return this.screen;
    }

}
