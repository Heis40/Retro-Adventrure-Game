package com.adventure.characters;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.atomic.AtomicInteger;
import com.adventure.interfaces.Combat;

public class Wizard extends GameCharacter implements Combat {
    private String name;
    private String role;
    private String abilities;
    private String levelups;

    

    public Wizard() {
        this.name = "Gandalf the Grey";
        this.role = "Mage";
        this.abilities = "Fireball, Teleportation";
        this.levelups = "Increased Mana, Improved Spell Power";
        this.health = 100;
        this.experience = 0;
    }
    
    public void levelUp() {
        System.out.println(name + " has leveled up!");
        System.out.println("Gained: " + levelups);
        health += 15; // Bonus health on level up
    }
    
    public String getRole() {
        return role;
    }
    
    public String getAbilities() {
        return abilities;
    }
    
    public String getLevelups() {
        return levelups;
    }
    
    public String getHeroName() {
        return name;
    }
    
    public void attack() {
        System.out.println(name + " casts a powerful spell!");
    }
    
    public void defend() {
        System.out.println(name + " conjures a magical barrier!");
    }
    
    // Runs first phase of wizard's adventure
    public void run() {
        System.out.println("Abilities: " + getAbilities());
        System.out.println("The brave wizard has set out on a quest to vanquish the dragon!");

        
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Wizard: Step" + i);
                Thread.sleep(rand.nextInt(1000) + 500);
            }
        } catch (InterruptedException e) {
            System.out.println("Wizard's quest was interrupted!");
        }
        
        System.out.println("The wizard arrives at a peaceful village.");
    }
    
    // Continues the wizard's adventure based on choices
    public void continueAdventure() {

        if (tradeChoice != null && pathChoice != null) {
       
            //Chooses to trade or not based on tradeChoice
            if (tradeChoice.equalsIgnoreCase("yes")) {
                System.out.println("The wizard trades with the villagers and gains valuable supplies.");

                synchronized(this) {
                    if(grabTreasure()){
                        battleResults.add(getHeroName() + " acquired treasure while trading.");
                    }
                }
            } else {
                System.out.println("The wizard decides not to trade and continues on his quest.");
            }

            System.out.println("The wizard reaches a fork in the road: a dark forest to the left and towering mountains to the right.");
       
            //Chooses forest or mountains based on pathChoice
            if (pathChoice.equalsIgnoreCase("forest")) {
                enterForest();
            } else {
                climbMountains();
            }

            /* 
            // Dragon battle section
            System.out.println("The wizard unites with the knight and thief to form a powerful party.");
            System.out.println("Together, they make their way to the dragon's castle, ready for the final battle!");
            System.out.println("The party confronts the fearsome dragon!");
            
            // Use synchronized dragon attack
            attackDragon();

            System.out.println(getHeroName() + " takes damage from dragon!");
            takeDamage(30);
            System.out.println("Health remaining: " + health);

            // FIXED: Corrected the victory logic
            if (hasAlive()) {  // Changed from !hasAlive()
                battleResults.add(getHeroName() + " defeated the dragon.");
                gainExperience(100);
                System.out.println(getHeroName() + " gains massive experience! Total: " + experience);

                
                System.out.println("Battle Results:");
                battleResults.forEach(result -> System.out.println("- " + result));

                System.out.println("After an epic battle, the party emerges victorious over the dragon!");
                System.out.println("The kingdom is saved, and the heroes are celebrated!");
            } else {
                System.out.println(getHeroName() + " has fallen to the Dragon!");
                return;
            }
            */
        }
    } 
    private void enterForest(){
         System.out.println("The wizard bravely enters the dark forest, ready for whatever challenges lie ahead.");
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Forest: Step" + i);
                        Thread.sleep(rand.nextInt(1000) + 500);
                    }
                    System.out.println("The wizard encounters a group of goblins!");
                    attack();
                    defend();

                    // Track damage and battle result
                   
                    battleResults.add(getHeroName() + " defeated goblins in the forest.");
                    System.out.println("The wizard has defeated the goblins and continues on his quest!");
                } catch (InterruptedException e) {
                    System.out.println("Wizard's journey through the forest was interrupted!");
                }
    }
    
    private void climbMountains(){
        System.out.println("The wizard begins to climb the towering mountains, determined to reach the summit.");
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Climbing: Step" + i);
                        Thread.sleep(rand.nextInt(1000) + 500);
                    }
                    System.out.println("The wizard encounters a group of rock people!");
                    attack();
                    defend();

                    // Track damage and battle result
                    
                    battleResults.add(getHeroName() + " defeated rock people in the mountains.");
                    System.out.println(getHeroName() + " takes damage!");
                    takeDamage(20);
                    System.out.println("Health remaining: " + health);

                    if (!hasAlive()) {
                        System.out.println(getHeroName() + " has fallen!");
                        return;
                    }

                    gainExperience(50);
                    System.out.println(getHeroName() + " gains experience! Total: " + experience);
                    System.out.println("The wizard has defeated the rock people and continues to the summit!");
                } catch (InterruptedException e) {
                    System.out.println("Wizard's climb was interrupted!");
                }
                System.out.println("The wizard leaves the mountains and continues on his quest!");
            
    }

    
} 