import java.util.ArrayList;
import java.io.File;

/**
 * Cena de dormir
 *
 * @author Erik
 * @version 1.0.0
 */
public class SleepScene extends Scene
{
    /**
     * Utiliza o construtor e carrega a cena
     *
     * @param actor Utilizado para pegar a referencia da tela
     */
    public SleepScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    /**
     * Carrega a cena
     */
    private void loadScene(){
        // Limpa os frames
        this.frames.clear();
        this.frameIndex = 0;

        Frame backgroundFrame = new Frame();
        backgroundFrame.loadFromFile(new File("assets/iconSleep.txt")); // Carrega uma imagem de background

        for(int frame=0;frame<=10;frame++){ // Para cada frame
            Frame currentFrame = new Frame();
            currentFrame.setData(new ArrayList<String>(backgroundFrame.getData())); // Copia o frame de background

            this.drawZzz(currentFrame, frame); // Desenha na tela os Z z Z z
            this.frames.add(currentFrame);
        }
    }
    
    /**
     * Desenha no Frame os Z z, para demonstrar sono
     *
     * @param frame Referencia onde sera gerado os simbolos
     * @param frameIndex define em que ponto da animacao esta (0 - 10)
     */
    private void drawZzz(Frame frame, int frameIndex){
        int beginRow = 14; // Linha onde esta o primeiro simbolo
        int beginCol = 32; // coluna onde esta o primeiro simbolo
        int dr = -1; // delta entre simbolos
        int dc = 2; // delta entre simbolos
        int currentRow = beginRow; // linha atual
        int currentCol = beginCol; // coluna atual
        for(int i=0;i<frameIndex;i++){
            if(currentRow < 0) break; // Se passou do topo da tela, cancela
            ArrayList<String> data = frame.getData();
            char[] rowData = data.get(currentRow).toCharArray();

            if(i%2==0) rowData[currentCol] = 'z'; // Simbolos diferentes dependendo da paridade
            else rowData[currentCol] = 'Z';

            data.set(currentRow, String.valueOf(rowData));

            currentCol += dc; // Atualiza coordenadas do proximo simbolo
            currentRow += dr;

            dc = -dc; // Os simbolos sao feitos em formato de escada
                      // portanto os deltas se modificam
            if(dc==-2) dr = -2;
            else dr = -1;
        }

    }
}
