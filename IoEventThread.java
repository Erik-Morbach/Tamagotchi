import java.lang.Runnable;

/**
 * Thread que gerencia a utiliza da classe IoEvent
 *
 * @author Erik
 * @version 1.0.0
 */
public class IoEventThread implements Runnable
{
    /**
     * Utilizada para utilizar o teclado e executar as acoes
     */
    private IoEvent io;
    /**
     * Referencia para o tamagotchi
     */
    private Tamagotchi tamagotchi;

    /**
     * Metodo construtor com as referencias necessarias
     */
    public IoEventThread(IoEvent io, Tamagotchi tamagotchi){
        this.io = io;
        this.tamagotchi = tamagotchi;
    }

    /**
     * Metodo de execucao da Thread.
     */
    public void run(){
        while(this.tamagotchi.isAlive()){ // Enquanto tamagotchi estiver vivo
            int option = io.readOption(); // Espera a proxima entrada do teclado
            this.tamagotchi.verifyDeath(); // Atualiza a situacao de morte do tamagotchi
            if(!this.tamagotchi.isAlive()) break; // Se nao estiver vivo, nao faz nada
            io.executeOption(option); // Executa a acao
        }
    }
}
