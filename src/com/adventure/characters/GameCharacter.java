package com.adventure.characters;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;


public abstract class GameCharacter extends Thread {
    protected int health;
    protected int experience;
    protected int level;
    protected String tradeChoice;
    protected String pathChoice;

    // In main class or GameCharacter:
    protected static volatile int dragonHealth = 300;
    protected static final Object dragonLock = new Object();
    protected static AtomicInteger treasureCount = new AtomicInteger(3);
    protected static List<String> battleResults = new ArrayList<>();
    protected static final int EXP_PER_LEVEL = 100;

    // Abstract methods to be implemented by subclasses
    public abstract void levelUp();
    public abstract String getHeroName();
    public abstract String getRole();
    public abstract String getAbilities();
    public abstract String getLevelups();
    public abstract void continueAdventure();

    protected Random rand = new Random();
    
    // Concrete methods all characters can use

    public void takeDamage(int damage) {
        this.health -= damage;
    }
    
    public void gainExperience(int exp) {
        this.experience += exp;
        System.out.println(getHeroName() + " gains " + exp + " experience! Total: " + this.experience);
        while (this.experience >= EXP_PER_LEVEL * (level + 1)) {
            level++;
            levelUp();
        }
    }

    public int getLevel() {
        return level;
    }
    
    public boolean hasAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
    }
    
    public void setChoices(String tradeChoice, String pathChoice) {
        this.tradeChoice = tradeChoice;
        this.pathChoice = pathChoice;
    }

    // Synchronized dragon attack method
    public void attackDragon() {
        synchronized(dragonLock) {
            if (dragonHealth > 0) {
                int damage;
                boolean isCritical = rand.nextInt(100) < 20; // 20% chance
                if (isCritical) {
                    damage = rand.nextInt(40) + 40; // Critical hit
                    System.out.println(getHeroName() + " lands a CRITICAL HIT!");
                } else {
                    damage = rand.nextInt(20) + 10;// Normal hit
                    System.out.println(getHeroName() + " attacks the dragon.");
                }
                dragonHealth -= damage;
                System.out.println("Dragon Health: " + dragonHealth);

                if (dragonHealth <= 0) {
                    System.out.println("The dragon has been defeated!");
                }

            }
           
        }
    }

    // Limited treasure competition method
    public boolean grabTreasure() {
        int remaining = treasureCount.decrementAndGet();
        if (remaining >= 0) {
            System.out.println(getHeroName() + " found treasure! " + remaining + " left");
            return true;
        } else {
            treasureCount.incrementAndGet();
            System.out.println(getHeroName() + " - no treasure left!");
            return false;
        }
    }

    // Final dragon battle method
    protected void dragonBattle(){
     System.out.println(getHeroName() + " unites with the party to form a powerful team.");
     System.out.println("Together, they make their way to the dragon's castle, ready for the final battle!");
     System.out.println("The party confronts the fearsome dragon!");

     attackDragon();

     System.out.println(getHeroName() + " takes damage from dragon!");
     takeDamage(30);
     System.out.println("Health remaining: " + health);

     // Check if character is alive after battle
     if (hasAlive()) {
         battleResults.add(getHeroName() + " defeated the dragon.");
         gainExperience(100);

         System.out.println("Battle Results:");
         battleResults.forEach(result -> System.out.println("- " + result));

         System.out.println("After an epic battle, the party emerges victorious over the dragon!");
         System.out.println("The kingdom is saved, and the heroes are celebrated!");
     } else {
         System.out.println(getHeroName() + " has fallen to the Dragon!");
     }
}

}

