import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This subclass has stats specific to enemy characters, and is also used to 
 * track whether its attacks are currently effective against the player, as 
 * the player subclass has the functionality to dodge attacks. It also has specific 
 * health, damage, location, and target location variables. 
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class SubEnemy extends Character
{
    private static String name = "geodude"; 
    private static int tagX = 470; 
    private static int tagY = 180;
    private static int bounceX = 0; 
    private static int bounceY = 10; 

    private static int health = 20; // geodude is at 20 hp intially

    private static int damage = 10; // geodude deals 10 hp damage per hit
    private static int width = 221; // size of geodude image
    private static int height = 112;

    private boolean attacked; // whether geodude attacked yet
    AttackOne attack; // attack projectile object sent from geodude

    boolean canHit = true; // geodude can intially hit player (if he doesn't dodge after)

    // constructor passes arguments to the superconstructor (which has more functionality needed to operate this class)
    public SubEnemy() {
        super(name, health, damage, width, height, tagX, tagY, bounceX, bounceY);
    }

    public void act() 
    {
        super.act(); // act out parent actions
    }    

    // this method is used to create a moving attack in a specific direction, that can hit and damage the character it hits
    public void attack() {
        if(!attacked){ // if not attacked yet
            // crate projectile from this character, that can hit, and moves towards coordinates
            attack = new AttackOne(canHit, this, damage, -400, -150);
            getWorld().addObject(attack, getX() + 55, getY()); // add projectile to world beside the character's coordinates
            attacked = true; // do not do this until next turn
        }
    }

    // this method is used to set the enemy's ability to hit
    public void canHit(boolean can) {
        canHit = can;
    }

    // this method is used to reset the 'attacked' status so the character can attack in the next turn
    public void resetAttacked() {
        attacked = false;
    }
}
