package com.adventure.characters;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Arrays;

public abstract class GameCharacter extends Thread {
    protected int health;
    protected int experience;
    protected String tradeChoice;
    protected String pathChoice;

    // In main class or GameCharacter:
    protected static volatile int dragonHealth = 300;
    protected static final Object dragonLock = new Object();
    protected static AtomicInteger treasureCount = new AtomicInteger(3);
    protected static List<String> battleResults = new ArrayList<>();
    protected static int[] characterDamage = new int[3];
    //protected static int totalDamage = Arrays.stream(characterDamage).sum();
   
   
    public abstract void levelUp();
    public abstract String getHeroName();
    public abstract String getRole();
    public abstract String getAbilities();
    public abstract String getLevelups();
    public abstract void continueAdventure();

    
    // Concrete methods all characters can use

    public void takeDamage(int damage) {
        this.health -= damage;
    }
    
    public void gainExperience(int exp) {
        this.experience += exp;
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
                dragonHealth -= 25;
                System.out.println(getHeroName() + " damages dragon! Dragon health: " + dragonHealth);
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

}

