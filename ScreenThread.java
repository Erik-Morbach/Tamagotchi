import java.lang.Runnable;

/**
 * Thread que gerencia a tela
 *
 * @author Erik
 * @version 1.0.0
 */
public class ScreenThread implements Runnable
{
    /**
     * Referencia para a tela
     */
    private Screen screen;
    /**
     * Referencia para o Tamagotchi
     */
    private Tamagotchi tamagotchi;

    /**
     * Construtor
     */
    public ScreenThread(Screen screen, Tamagotchi tamagotchi){
        this.screen = screen;
        this.tamagotchi = tamagotchi;
    }
    /**
     * Metodo de execucao da Thread
     */
    public void run(){
        while(true){
            try{
                // pausa para o framerate ficar correto
                Thread.sleep((int)((double)1/this.screen.getFrameRate()*1000));
            } catch(Exception e){}

            Scene currentScene = screen.getCurrentScene(); // Pega cena atual da tela
            if(currentScene.isSceneEnded()){ // Se a cena ja acabou 
                this.screen.popCurrentScene(); // Remove a referencia da tela
                if(currentScene instanceof DeadScene) // Se estiver na ultima cena do jogo
                    break; // Finaliza a execucao da thread
                continue; // Se não, continua para o proximo frame
            }
            Frame currentFrame = currentScene.getNextFrame(); // Pega o proxima frame da cena
            if(currentFrame == null) continue;
            String frameString = "";
            frameString += '\u000C'; // Limpa o terminal do blueJ
            frameString += this.screen.generateHeaderString(this.tamagotchi); // Gera a barra de status
            frameString += this.screen.generateFrameString(currentFrame); // Gera o frame
            frameString += this.screen.generateFooterString(this.tamagotchi); // Gera a barra de acoes/fim de jogo

            System.out.println(frameString); // Printa na tela
        }
    }

}
