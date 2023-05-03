import java.lang.Runnable;
import java.util.Scanner;

/**
 * Write a description of class IoEventThread here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class IoEventThread implements Runnable
{
    private IoEvent io;
    private Tamagotchi tamagotchi;
    public IoEventThread(IoEvent io, Tamagotchi tamagotchi){
        this.io = io;
        this.tamagotchi = tamagotchi;
    }

    public void run(){
        while(this.tamagotchi.isAlive()){
            int option = io.readOption();
            this.tamagotchi.verifyDeath();
            if(!this.tamagotchi.isAlive()) break;
            io.executeOption(option);
        }
    }
}
