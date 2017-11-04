import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class XP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthCounter extends Actor
{
    int health;
    
    public HealthCounter(int health){
        this.health = health;
    }
    /**
     * Act - do whatever the XP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        update();
        
    }
    public void update(){
        setImage(new GreenfootImage("HP: "+health, 12, Color.WHITE, Color.BLACK)); //draws the word out
    }
    public void lowerHealth(int health){
        this.health-=health;
    }
    public void setHealth(int health){
        this.health=health;
    }
}