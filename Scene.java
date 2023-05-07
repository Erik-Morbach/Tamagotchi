import java.util.ArrayList;

/**
 * Define a base de uma Cena
 *
 * @author Erik
 * @version 1.0.0
 */
public class Scene
{
    /**
     * Todos os frames
     */
    protected ArrayList<Frame> frames;
    /*
     * indice do proximo frame que deve ser mostrado
     */
    protected int frameIndex;
    /*
     * Referencia para a tela
     */
    protected Screen screen;

    /**
     * Construtor
     */
    public Scene(Screen screen){
        this.frames = new ArrayList<Frame>();
        this.frameIndex = 0;
        this.screen = screen;
    }

    /**
     * Retorna true se a cena ja foi mostrada por completo, falso caso contrario
     */
    public boolean isSceneEnded(){
        return this.frameIndex >= this.frames.size();
    }

    /**
     * Volta a cena para o inicio
     */
    public void reset(){
        this.frameIndex = 0;
    }

    /**
     * Retorna o proximo frame da Cena. Null caso ela ja tenha acabado
     */
    public Frame getNextFrame(){
        if(this.isSceneEnded()) return null;
        return this.frames.get(this.frameIndex++);
    }
}
