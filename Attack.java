import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class creates a moving projectile with a set speed, damage to characters, and target position of where
 * it is moving. It animates itself with frames given in the child classes. It also updates its damage
 * based on the user input, where typing correct words increases the damage of the projectile, but only if 
 * the attacker (which is stored in a variable to track who launched it) is the player. It gets deleted from 
 * the world when it hits the edge of the screen, or another character.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class Attack extends Actor
{
    private int speed; // speed of attack's movement
    private int damage; // damage the attack deals
    private int targetX, targetY; // location towards which the attack moves
    private Character attacker; // character that dealt this attack
    private boolean canHit = true; // the attak can hit others by default

    private GreenfootImage[] frames; // array of frames for the attack animation
    private int currFrame = 0; // current frame count
    private final int loopPoint = 7; // frame from which the animation starts looping

    // constructor is passed arguments that are used in the parent class's methods as variables
    public Attack(boolean canHit, int speed, int damage, Character attacker, int targetX, int targetY, int numFrames) {
        this.canHit = canHit;
        this.speed = speed;
        this.damage = damage;
        this.attacker = attacker;

        frames = new GreenfootImage[numFrames];
        //populating the array with frames of attack animation
        for(int i = 1; i <= numFrames; i++) 
            frames[i-1] = new GreenfootImage("attackOne" + i + ".png");

        // turn the attack towards a target towards which it will move
        turnTowards(targetX, -targetY);
    }

    public void act(){
        animate(); // play the animation frame by frame 
        move(speed); // move attack a little bit for each act
        // if attack is at edge of screen
        if(getX() > getWorld().getWidth() - 5 || getX() < 5 || getY() > getWorld().getHeight() - 5 || getY() < 5) {
            if(((Stages)getWorld()).getTurn() == 3) // if turn is 3
                ((Stages)getWorld()).nextTurn(); // change the turn
            getWorld().removeObject(this); // remove attack from world
        }
        if(canHit) { // if attack can hit anyone
            hit();
        }
    }

    // this method checks whether the attack has hit anyone, and then decreases their health
    public void hit() {
        Character player = (Character)getOneObjectAtOffset(0,0, Character.class); // character that is touched by the attack object
        if(player != null && player != attacker){ // if someone is hit and it is not the attacker himself
            player.lowerHealth(damage); // lower health of the character by the attack's given damage
            ((Stages)getWorld()).nextTurn(); // change turn
            getWorld().removeObject(this); // remove attack object from world
        }
    }

    // this method changes the object's image to a specific frame for one act, and loops it from a certain point after it plays the initial animation
    public void animate() {
        if(currFrame == frames.length){ // when end of animation is reached
            currFrame = loopPoint; // always set initial frame to this specific loop point frame
        }
        setImage(frames[currFrame]); // set object image to an image at specified index in array of frames
        currFrame++; // increment the index of frame 
    }

    // this method updates the damage at turn 0 (when the player is trying to gain attack power through typing words)
    public void updateTurn0Damage() {
        String validStringTyped = InputReader.getCorrectString(); // store the correctly typed string in a variable (null if incorrect)
        if(((Stages)getWorld()).getTurn() == 0) // if turn is 0
            if(validStringTyped != null) // if correct string present
                this.damage += validStringTyped.length()/4; // add a quarter of its length to player's attack power (damage)
    }

    public void canHit(boolean can) {
        canHit = can;
    }

    public int getDamage(){
        return damage;
    }
}
