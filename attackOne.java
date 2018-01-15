import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This subclass creates an object with the functionality of the Attack class, that
 * has a unique speed and set of frames to animate through. It is a moving
 * projectile that can hit characters with a given amount of damage.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class AttackOne extends Attack
{
    static int numFrames = 10; // number of frames in animation
    private GreenfootImage[] frames = new GreenfootImage[numFrames]; // array of frames

    private static int speed = 13; // specific speed of attack type
    //private static int damage; // initial damage dealt by attack

    // constructor calls superconstructor and passes arguments related to the subclass
    public AttackOne(boolean canHit, Character attacker, int damage, int targetX, int targetY) { 
        super(canHit, speed, damage, attacker, targetX, targetY, numFrames);
    }

    public void act() 
    {
        super.act(); // call act method of superclass
    }

}
