import java.util.Scanner;

/**
 * Write a description of class Principal here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class Principal
{
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Digite o nome do sapo: ");
        String nome = scn.nextLine();
        Screen screen = new Screen(10, 50, 20);
        Tamagotchi tamagotchi = new Tamagotchi(nome);
        IoEvent io = new IoEvent(tamagotchi);

        screen.setActor(tamagotchi);
        tamagotchi.setScreen(screen);

        tamagotchi.setDefaultScene(new IdleScene(tamagotchi));

        Thread ioThread = new Thread(new IoEventThread(io, tamagotchi));
        Thread tamagotchiThread = new Thread(new TamagotchiThread(tamagotchi));
        Thread screenThread = new Thread(new ScreenThread(screen, tamagotchi));

        screenThread.start();
        ioThread.start();
        tamagotchiThread.start();

        try{
            ioThread.join();
            tamagotchiThread.join();
            screenThread.join();
        } catch(InterruptedException e){
            System.err.println(e);
        }
        scn.close();
    }
}
