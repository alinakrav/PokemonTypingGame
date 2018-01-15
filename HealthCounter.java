import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This class is used to create the "HP: __" portion of the character name tag, which 
 * displays their health numerically. It updates as the health variable changes.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class HealthCounter extends Actor
{
    int health; // health of hp counter object

    // constructor sets this object's health to a given health
    public HealthCounter(int health){
        this.health = health; // set health 
    } 

    public void act() 
    { 
        updateHealthCounter(); // update hp counter to current health
    }

    // this method sets the healthCounter image to that of the current health
    public void updateHealthCounter(){
        setImage(new GreenfootImage("HP: "+ health, 12, Color.WHITE, Color.ORANGE)); //draws the text out and sets it as image
    }

    // this method sets the current health of the health counter object to a given integer
    public void setHealth(int health){
        this.health = health;
    }
}