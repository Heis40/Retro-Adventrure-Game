import java.util.Scanner;
import java.util.Random;
public class RetroMultithreadingAdventure  {
    public static void main(String[] args) {
        //PHASE 1: Introduction
        //Scanner to get user input for character choices.
        Scanner scanner = new Scanner(System.in);

       System.out.println("==ADVENTURE BEGINS==");
        
        // Create character instances
        GameCharacter knight = new Knight();
        GameCharacter wizard = new Wizard();
        GameCharacter thief = new Thief();

        // Start character threads
        knight.start();
        wizard.start();
        thief.start();

       
        // Wait for all threads to finish
        try {
            knight.join();
            wizard.join();
            thief.join();
        } catch (InterruptedException e) {
            System.out.println("Adventure was interrupted.");
        }
       

        //PHASE 2: Trading Encounter
        System.out.println("== THE VILLAGE ==");
        System.out.println("Do you want to trade with the villagers? (yes/no)");
        String tradeChoice = scanner.nextLine();

        //PHASE 3: Path Encounter.
        System.out.println("== FORK IN THE ROAD ==");
        System.out.println("Does the party choose to enter the forest or the mountains? (forest/mountains)");
        String pathChoice = scanner.nextLine();

        //PHASE 4: Final chapter.
        System.out.println("== THE FINAL CHAPTER ==");

        // Set choices for each character
        ((Knight)knight).setChoices(tradeChoice, pathChoice);
        ((Wizard)wizard).setChoices(tradeChoice, pathChoice);
        ((Thief)thief).setChoices(tradeChoice, pathChoice);

        // Continue adventures with existing character objects (NO new threads)
        ((Knight)knight).continueAdventure();
        ((Wizard)wizard).continueAdventure();
        ((Thief)thief).continueAdventure();

    }
}