package com.adventure.characters;


import com.adventure.interfaces.Combat;

public class Thief extends GameCharacter implements Combat {
    private String name;
    private String role;
    private String abilities;
    private String levelups;

   
    // Constructor
    public Thief() {
        this.name = "Jack the Shadow";
        this.role = "Rogue";
        this.abilities = "Stealth, Pickpocketing";
        this.levelups = "Increased Agility, Improved Sneak";
        this.health = 100;
        this.experience = 0;
    }

    // Level up method
    public void levelUp() {
        System.out.println(name + " has leveled up!");
        System.out.println("Gained: " + levelups);
        health += 10; // Bonus health on level up
    }

    // Getters methods
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
        System.out.println(name + " strikes from the shadows!");
    }

    public void defend() {
        System.out.println(name + " disappears into the shadows to evade the attack!");
    }

    // Runs first phase of thief's adventure
    public void run() {
        System.out.println("Abilities: " + getAbilities());// Displays the thief's abilities
        System.out.println("The brave thief has set out on a quest to vanquish the dragon!");// Intro message

        // Simulate steps taken by the thief
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thief: Step" + i);
                Thread.sleep(rand.nextInt(1000) + 500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thief's quest was interrupted!");
        }
        
        System.out.println("The thief arrives at a peaceful village.");
    }

    // Continues the adventure based on user choices
    public void continueAdventure() {

       // Check if choices are set
        if (tradeChoice != null && pathChoice != null) {
            
            // Trading encounter
            if (tradeChoice.equalsIgnoreCase("yes")) {
                System.out.println("The thief trades with the villagers and gains valuable supplies.");

                
                    if(grabTreasure()){
                        battleResults.add(getHeroName() + " acquired treasure while trading.");
                    }
                
            } 
            else  {
                System.out.println("The thief decides not to trade and continues on his quest.");
            }
            

            System.out.println("The thief reaches a fork in the road: a dark forest to the left and towering mountains to the right.");
            
            // Path encounter
            if (pathChoice.equalsIgnoreCase("forest")) {
                exploreForest();
            } 
            else  {
                climbMountains();
            }
            
             // Final battle with the dragon method call 
             dragonBattle();
             
           
        }
    
    } 
    
    // Thief explores the forest
    private void exploreForest(){
        // Simulate forest exploration
        System.out.println("The thief bravely enters the dark forest, ready for whatever challenges lie ahead.");
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Forest: Step" + i);
                        Thread.sleep(rand.nextInt(1000) + 500);
                    }
                    System.out.println("The thief encounters a group of goblins!");
                    attack();
                    defend();

                    //Record Battle damage
                    
                    battleResults.add(getHeroName() + " defeated goblins in the forest.");
                    gainExperience(50);
                    System.out.println(getHeroName() + " gains experience! Total: " + experience);
                    System.out.println("The thief has defeated the goblins and continues on his quest!");
                } catch (InterruptedException e) {
                    System.out.println("Thief's journey through the forest was interrupted!");
                }
    }

    // Thief climbs the mountains
    private void climbMountains() {
        // Simulate mountain climbing
        System.out.println("The thief begins to climb the towering mountains, determined to reach the summit.");
                try {
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Climbing: Step" + i);
                        Thread.sleep(rand.nextInt(1000) + 500);
                    }
                    System.out.println("The thief encounters a group of rock people!");
                    attack();
                    defend();

                    
                    System.out.println(getHeroName() + " takes damage!");
                    takeDamage(20);
                    System.out.println("Health remaining: " + health);

                    if (!hasAlive()) {
                        System.out.println(getHeroName() + " has fallen!");
                        return;
                    }

                    //Record Battle damage
                    
                    battleResults.add(getHeroName() + " defeated rock people in the mountains.");
                    gainExperience(50);
                    System.out.println(getHeroName() + " gains experience! Total: " + experience);
                    System.out.println("The thief has defeated the rock people and continues to the summit!");
                } catch (InterruptedException e) {
                    System.out.println("Thief's climb was interrupted!");
                }
                System.out.println("The thief leaves the mountains and continues on his quest!");
    }

    
} 