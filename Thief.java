
import java.util.Random;

public class Thief extends Thread{
    public void run()
    {
        System.out.println("The cunning thief has set out on a quest to steal the dragon's treasure!");
        Random rand = new Random();

        try{
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thief: Step" +i);
                Thread.sleep(rand.nextInt(1000)+500);
            }

        }catch (InterruptedException e){
            System.out.println("Thief's quest was interrupted!");
        }
        System.out.println("The thief returns victorious!");
    }

}