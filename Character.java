import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * This class builds an object that:
 * bounces (idle position),
 * can shoot modifiable projectile attacks,
 * has a health count,
 * creates a name tag specific to the character name and health,
 * can be hit by projectiles,
 * has health that can be lowered from outside classes,
 * can die when health is depleted.
 * 
 * The subclasses SubEnemy and SubPlayer have more specific functionality 
 * (specifically, attacks), and those can create characters with player or 
 * enemy traits.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class Character extends Actor
{
    // counts the time until the next bounce movement
    int bounceTimer = 0;
    // how much time there is between bounce movements
    private final int bounceInterval = 20;
    // how many pixels character moves horizontally and vertically
    int bounceX;
    int bounceY;

    // initial health of the character
    private int health;
    // whether the character has acted yet
    boolean started;
    // whether the character attacked yet (or else it'll spam the attacks if it's not counted)
    public static boolean attacked;

    // initial damage of the character's attacks
    private int damage; 

    // counts frames until death
    int deathCounter;

    // the name tag of the character
    NameTag tag;

    // The Character constructor gives the child object: name, damage, width, height, x and y coordinates 
    // of name tag, and vertical and horizontal bounce. It also sets the image for the character and rescales it.
    public Character(String name, int health, int damage, int width, int height, int tagX, int tagY, int bounceX, int bounceY) {
        // the name tag uses the name, health, and coordinates to create a tag in the world
        tag = new NameTag(name, health, tagX, tagY);

        this.bounceX = bounceX;
        this.bounceY = bounceY;
        this.damage = damage;
        this.health = health;
        GreenfootImage image = new GreenfootImage(name + ".png"); 
        image.scale(width, height);
        setImage(image);
    }

    public void act() 
    {
        //bounce continuously
        bounce();

        //do this only for the first act
        if(!started) {
            // add the name tag to the world
            getWorld().addObject(tag, tag.getX(), tag.getY());
            // don't add it again
            started = true;
        }

        // the character is always able to die
        die();
    }

    // this method removes the character from the world and goes to the end screen when the health is
    // depleted and a short break time is passed
    public void die() {
        // when no more health
        if(health <= 0) { 
            deathCounter++; // count frames until death           
            if(deathCounter == 80) { // after 80 frames             
                if(this instanceof SubPlayer) // if the child object is of the SubPlayer class,
                    Greenfoot.setWorld(new End("lose")); // set world to lose screen because the player died 
                else // if anyone besides the player died
                    Greenfoot.setWorld(new End("win")); // set world to win screen
            }
        }
    }

    // this method returns the health of the character
    public int getHealth(){
        return health;
    }

    //this method lowers the health of the character by a set amount of damage
    public void lowerHealth(int damageReceived){
        health -= damageReceived;
        if(health < 0) //health cannot be less than 0
            health = 0;    
        tag.setHealth(health); // update character's health on their name tag
    }

    // this method times intervals between a character's small movements around their original position
    public void bounce() {
        bounceTimer++; // count frames
        if(bounceTimer == bounceInterval) { // when frame count reaches required interval between movements
            bounceX *= -1; // make the next movements in opposite directions of current ones
            bounceY *= -1;
            setLocation(getX() + bounceX, getY() + bounceY); // add those movements to current position (can be pos or neg)
            bounceTimer = 0; //reset interval timer
        }
    }

    // this method lets the character throw an attack. It is defined in the child classes
    public void attack() {}
}
