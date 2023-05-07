import java.util.Scanner;

/**
 * Main
 *
 * @author Erik
 * @version 1.0.0
 */
public class Principal
{
    /**
     * Main
     */
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in); // Cria um novo scanner
        System.out.print("Digite o nome do sapo: ");
        String nome = scn.nextLine(); // Pega a proxima linha e utiliza como nome do tamagotchi
        scn.close(); // Essa referencia do scanner nao sera mais utilizada

        Screen screen = new Screen(10, 20, 50); // Cria uma tela com 10fps, 20 linhas e 50 colunas
        Tamagotchi tamagotchi = new Tamagotchi(nome); // Cria um tamagotchi
        IoEvent io = new IoEvent(tamagotchi); // Cria um gerenciador de teclado

        // Seta as referencias do ator e da tela
        screen.setActor(tamagotchi);
        tamagotchi.setScreen(screen);

        // Seta a cena padrao. Obs: Bom lugar para testar o funcionamento das cenas
        tamagotchi.setDefaultScene(new IdleScene(tamagotchi));

        // Cria o objeto das threads
        Thread ioThread = new Thread(new IoEventThread(io, tamagotchi));
        Thread tamagotchiThread = new Thread(new TamagotchiThread(tamagotchi));
        Thread screenThread = new Thread(new ScreenThread(screen, tamagotchi));

        // Start todas as threads
        screenThread.start();
        ioThread.start();
        tamagotchiThread.start();

        try{ // Espera as threads finalizarem
            ioThread.join();
            tamagotchiThread.join();
            screenThread.join();
        } catch(InterruptedException e){
            System.err.println(e);
        }
    }
}
