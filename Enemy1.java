import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Enemy
{
    private static int health = 20;
    private static int damage = 1;
    private static String name = "Geodude";
    private static GreenfootImage picture = new GreenfootImage("Enemy1.png");
    private static int width = 442/2;
    private static int height = 225/2;
    public Enemy1(){
        super(health, damage, name, picture, width, height);
    }
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
}
