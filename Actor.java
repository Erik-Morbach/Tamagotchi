
/**
 * Classe base Ator, define a Cena atual, uma Cena padrão e a tela em que se encontra
 *
 * @author Erik
 * @version 1.0.0
 */
public class Actor
{
    /**
     * Cena que esta sendo executada
     */
    private Scene currentScene;
    /**
     * Cena padrão que é utilizada quando a atual acabou
     */
    private Scene defaultScene;
    /**
     * Tela em que o ator esta
     */
    protected Screen screen;
    /*
     * Posicao linha,coluna atual do ator na tela
     */
    private int row,column;

    /**
     * Construtur padrão
     */
    public Actor(){
        this.row = 0;
        this.column = 0;
    }

    /**
     * métodos de acesso
     */
    public void setCurrentScene(Scene scene) { this.currentScene = scene; }
    public void setDefaultScene(Scene scene) { this.defaultScene = scene; }
    public Scene getCurrentScene() { return this.currentScene; }
    public Scene getDefaultScene() { return this.defaultScene; }
    public int getRow() { return this.row; }
    public int getCol() { return this.column; }
    public void setRow(int row) { this.row = row; }
    public void setCol(int column) { this.column = column; }
    public void setScreen(Screen screen) { this.screen = screen; }
    public Screen getScreen() { return this.screen; }
}
