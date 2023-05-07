import java.io.File;

/**
 * Cena de morte por fome
 *
 * @author Erik
 * @version 1.0.0
 */
public class StarvedScene extends Scene
{
    /**
     * Utiliza o construtor e carrega a cena
     *
     * @param actor Utilizado para pegar a referencia da tela
     */
    public StarvedScene(Actor actor){
        super(actor.getScreen());
        this.loadScene();
    }

    /**
     * Carrega a cena de morte por fome. Arquivos do Diretorio "assets/starve/"
     */
    private void loadScene(){
        this.frames.clear();
        this.frameIndex = 0;
        for(int frame=4;frame<=7*4;frame++){ // existem somente 7 frames
                                             // A multiplicacao e para deixar a animacao mais lenta
            Frame currentFrame = new Frame();
            currentFrame.loadFromFile(new File("assets/starve/starveF"+(frame/4)+".txt")); // Aqui ocorre a divisao
                                                                                           // o frame passa a cada
                                                                                           // 4 iteracoes
            this.frames.add(currentFrame);
        }
    }
}
