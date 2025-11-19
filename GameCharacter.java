public abstract class GameCharacter extends Thread {
    protected int health;
    protected int experience;
    protected String tradeChoice;
    protected String pathChoice;
   
   
   
    public abstract void levelUp();
    public abstract String getHeroName();
    public abstract String getRole();
    public abstract String getAbilities();
    public abstract String getLevelups();

    // In main class or GameCharacter:
    private static volatile int dragonHealth = 300;
    private static final Object dragonLock = new Object();

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
    
}

