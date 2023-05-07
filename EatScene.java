import java.util.ArrayList;
import java.io.File;

/**
 * Cena de comer
 *
 * Unica diferenca(em relacao a Cena de comer muito) e a quantidade de moscas na tela
 *
 * @author Erik
 * @version 1.0.0
 */
public class EatScene extends Scene
{
    /**
     * Utiliza o construtor de Cena e carrega ela
     *
     * @param actor Gera a referencia para a tela
     */
    public EatScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    /**
     * Gera os frames da cena
     */
    private void loadScene(){
        // Limpa os frames
        this.frames.clear();
        this.frameIndex = 0;

        // carrega o icone de Idle para usar como base
        Frame idleFrame = new Frame();
        idleFrame.loadFromFile(new File("assets/icon.txt"));

        // Define o centro da mosca
        Actor bug = new Actor();
        bug.setCol(0);
        bug.setRow(7);

        // Define a ponta atual da lingua
        Actor tongue = new Actor();
        tongue.setRow(14);
        tongue.setCol(24);

        for(int frame=0;frame<=40;frame++){
            Frame currentFrame = new Frame();
            // Copia as strings para o novo frame
            ArrayList<String> data = new ArrayList<String>(idleFrame.getData());
            currentFrame.setData(data);

            /*
             * frames < 20 -- Somente as moscas se movimentam ate chegar no centro da tela
             * 20 <= frames <= 30 -- Lingua esta subindo ate chegar na altura das moscas
             * 30 < frames -- Lingua esta voltando para o tamagotchi
             */

            if(frame <= 30) // Desenha as moscas
                this.drawBug(bug, currentFrame, frame);

            if(frame >= 20) // Desenha a lingua dando a porcentagem baseada no frame
                this.drawTongue(tongue, bug, currentFrame, (frame-20.0)/20.0);

            currentFrame.setData(data);

            this.frames.add(currentFrame);
        }
    }

    /**
     * desenha a lingua no frame. 0 ate 50% a lingua esta indo em direcao ao alvo
     * 51 ate 100% a lingua esta voltando
     *
     * @param begin Base da lingua
     * @param target Alvo que a lingua deve alcancar
     * @param frame Frame onde sera carregada
     * @param percent Porcentagem da animacao
     */
    private void drawTongue(Actor begin, Actor target, Frame frame, double percent){
        // carrega as referencias para melhor utilizacao
        int col = begin.getCol();
        int beginR = begin.getRow();
        int targetR = target.getRow();

        // Define o tamanho que a lingua deve ter baseada na porcentagem
        int diffR = Math.abs(targetR - beginR);
        if(percent <= 0.5) diffR = (int)(diffR * percent*2.0); // porcentagem mapeada de 0.0 - 0.5 para 0.0 - 1.0
        else diffR = (int) (diffR * (0.5 - (percent-0.5))*2.0); // porcentagem mapeada de 0.51 - 1.00 para 0.5 - 0.0
                                                                // A lingua deve voltar ate a base,
                                                                // por isso o sentido invertido

        int currentEndTongue = beginR - diffR; // A lingua vai para o sentido negativo (topo da tela)

        for(int j=currentEndTongue;j<=beginR;j++){ // para cada uma das linhas do fim da lingua ate a base
                                                   // desenha a lingua nas strings
            char row[] = frame.getData().get(j).toCharArray();
            char l = '|';
            char r = '|';
            if(j==currentEndTongue) { // Modifica os caracteres para desenhar a ponta
                l = '/'; r = '\\';
            }
            row[col] = l; row[col+1] = r;
            frame.getData().set(j, String.valueOf(row));
        }

    }

    /**
     * Desenha a mosca na tela baseado no frame em que esta
     * Da ponta esquerda ate o centro da tela com a altura (considera que o frame vai de 0 a 30)
     * variando de acordo com uma senoide
     *
     * @param bug Ponto atual da mosca
     * @param frame Frame onde sera carregada
     * @param frameIndex indice do frame para saber a porcentagem da animacao
     */
    private void drawBug(Actor bug, Frame frame, int frameIndex){
        ArrayList<String> data = frame.getData();
        
        char rowData[] = data.get(bug.getRow()).toCharArray();
        for(int i=-1;i<=1;i++) // Desenha as moscas no frame
            rowData[Math.max(bug.getCol()+i,0)] = '~';
        data.set(bug.getRow(), String.valueOf(rowData));

        // Seta a posicao do proximo frame
        // Seta a altura com um offset + sin(colunaAtual)
        int y = 7 + (int)Math.ceil(Math.sin(bug.getCol()/3.0)*2); // Constantes para melhorar a visualizacao
        // define quanto a mosca vai andar nas colunas
        // baseada no indice frame atual
        double bugDelta = 25.0/30.0;
        int x = (int)(frameIndex * bugDelta);
        bug.setRow(y);
        bug.setCol(x);
    }
}
