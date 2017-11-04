import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    int pause = 0;
    private final int pauseTime = 20;
    boolean up = false;
    private final int bounceX = 0;
    private final int bounceY = 10; 
    
    private int health;
    private int damage;
    private int width;
    private int height;
    private String name;
    GreenfootImage picture;
    boolean started;
    
    HealthBar healthbar;
    HealthCounter healthcounter;
    
    public Enemy(int health, int damage, String name, GreenfootImage picture, int width, int height){
        this.health = health;
        this.damage = damage;
        this.name = name;
        this.picture = picture;
        this.width = width;
        this.height = height;
        picture.scale(width, height);
        setImage(picture);
        healthbar = new HealthBar(health);
        healthcounter = new HealthCounter(health);
    }
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        bounce();
        die();
        if(!started){
            getWorld().addObject(healthbar, getX(), getY() + 30);
            getWorld().addObject(healthcounter, getX(), getY() + 30);
            started = true;
            displayName();
        }
    }
    public int getHealth(){
        return health;
    }
    public void changeHealth(int health){ //changes health by set value
        this.health += health;
    }

    public void lowerHealth(){
        health--;
    }

    public void lowerHealth(int damage){
        healthbar.lowerHealth(damage);
        healthcounter.lowerHealth(damage);
        health-= damage;
    }
    
    public void die(){
        if(health <= 0){
            World world = getWorld();
            Stages stages= (Stages)world;
            world.removeObject(this);
        }
    }
    
    public void bounce(){
        if (pause == pauseTime && up == false){
            setLocation(getX()+bounceX, getY()+bounceY);
            pause = 0;
            up = true;
        }
        else if(pause == pauseTime && up == true){
            setLocation(getX()-bounceX, getY()-bounceY);
            pause = 0;
            up = false;
        }
        pause++;
    }
    
    public void displayName(){ //will display the pokemon's name above the pokemon
        //getWorld().setFont("Times New Roman").drawString(name, 100, 100);
    }
    
}
