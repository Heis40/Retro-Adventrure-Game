package com.adventure.main;

import java.util.Scanner;
import com.adventure.characters.GameCharacter;
import com.adventure.characters.Knight;
import com.adventure.characters.Thief;
import com.adventure.characters.Wizard;


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
       
        try {
            // Small delay to ensure all arrival messages are printed before proceeding
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Handle exception
        }
        
        System.out.println("== ALL HEROES HAVE ARRIVED AT VILLAGE ==");

       //PHASE 2: Trading Encounter
        System.out.println("== THE VILLAGE ==");
        String tradeChoice;
        // Get valid trade choice from user
        while (true) {
            System.out.println("Do you want to trade with the villagers? (yes/no)");
            tradeChoice = scanner.nextLine().trim();
            if (tradeChoice.equalsIgnoreCase("yes") || tradeChoice.equalsIgnoreCase("no")) {
                break;
            }
            System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
        }
        //PHASE 3: Path Encounter
        System.out.println("== FORK IN THE ROAD ==");
        String pathChoice;
        // Get valid path choice from user
        while (true) {
            System.out.println("Does the party choose to enter the forest or the mountains? (forest/mountains)");
            pathChoice = scanner.nextLine().trim();
            if (pathChoice.equalsIgnoreCase("forest") || pathChoice.equalsIgnoreCase("mountains")) {
                break;
        }
        System.out.println("Invalid choice. Please enter 'forest' or 'mountains'.");
        }

        //PHASE 4: Final chapter.
        System.out.println("== THE FINAL CHAPTER ==");

        // Set choices for each character
        knight.setChoices(tradeChoice, pathChoice);
        wizard.setChoices(tradeChoice, pathChoice);
        thief.setChoices(tradeChoice, pathChoice);

        // Continue adventures with existing character objects (NO new threads)
        knight.continueAdventure();
        wizard.continueAdventure();
        thief.continueAdventure();

        scanner.close();
    }
}