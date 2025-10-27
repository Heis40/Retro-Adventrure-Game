import java.util.Random;

public class Wizard extends Thread{
    public void run()
    {
        System.out.println("The wise wizard has set out on a quest to slay the dragon!");
        Random rand = new Random();

        try{
            for (int i = 1; i <= 5; i++) {
                System.out.println("Wizard: Step" +i);
                Thread.sleep(rand.nextInt(1000)+500);
            }

        }catch (InterruptedException e){
            System.out.println("Wizard's quest was interrupted!");
        }
        System.out.println("The wizard returns victorious!");
    }

}