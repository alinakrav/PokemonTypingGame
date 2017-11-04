import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int pause = 0; //the pause counter
    private final int pauseTime = 20; //time for one pause
    boolean up = false; //whether the object bounced up or down
    private final int bounceAmount = 15; //how much the object bounces
    private int health = 50;
    boolean started;

    HealthBar playerHealthBar = new HealthBar(health);
    HealthCounter playerHealthCounter = new HealthCounter(health);

    public Player(){
        //setting the object to the correct image
        GreenfootImage player = new GreenfootImage("player.png"); 
        player.scale(300, 300);
        setImage(player);

    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        bounce();
        World world = getWorld();
        Stages stages= (Stages)world;
        if(stages.getTurn() == 1){
            attack();
        }
        if(!started){
            getWorld().addObject(playerHealthBar, getX(), getY() + 3);
            getWorld().addObject(playerHealthCounter, getX(), getY() + 30);
        }
    }

    /**
     * Checks current turn in the world, if it is the player's turn to attack then 
     * attack by creating a new Attack object
     */
    public void attack(){
        World world = getWorld();
        Stages stages= (Stages)world;

    }

    public void bounce(){
        if (pause == pauseTime && up == false){
            setLocation(getX()+bounceAmount, getY()+bounceAmount);
            pause = 0;
            up = true;
        }
        else if(pause == pauseTime && up == true){
            setLocation(getX()-bounceAmount, getY()-bounceAmount);
            pause = 0;
            up = false;
        }
        pause++;
    }

    public void lowerHealth(int damage){
        playerHealthBar.lowerHealth(damage);
        playerHealthCounter.lowerHealth(damage);
        health-=damage;
        
    }

    public int getHealth(){
        return health;
    }
}
