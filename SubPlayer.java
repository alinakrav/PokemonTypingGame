import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a subclass of Character, and it has functionality specific to the player 
 * character of the game. it changes the damage dealt by the player based on user input,
 * and can dodge enemy attacks as well. It has stats differnt from the enemy subclass,
 * so its health and damage, as well as target location, are class-specific.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class SubPlayer extends Character
{
    //boolean lets Player know that player can dodge (after typing all 4 words in turn 2)
    private boolean canDodge;
    static int dodgeCounter;

    private static String name = "player";
    private static int tagX = 450;
    private static int tagY = 490;
    private static int bounceX = 15;
    private static int bounceY = 15; 

    private static int health = 30;

    private static int damage;
    private static int width = 300;
    private static int height = 300;

    private boolean attacked;

    // constructor passes arguments to the superconstructor (which has more functionality needed to operate this class)
    public SubPlayer() {
        super(name, health, damage, width, height, tagX, tagY, bounceX, bounceY);
    }

    public void act() 
    {
        super.act(); // get act method actions from parent class
        updateTurn0Damage(); // always check if damage should be increased based on what the user types in correctly
        if(((Stages)getWorld()).getTurn() == 3 && canDodge) { //what to do in turn 3 for the player (dodging)
            dodge(); //dodge the enemy projectile
        }
    }

    // this method is used to create an attack in a specific direction that can git and damage the character it hits
    // (the damage is based on previous user input)
    public void attack() { 
        if(!attacked) { // if not attacked yet 
            // create attack by player, that can hit another, that has a specific amount of damage based on
            // previous user input, and that targets a specific location
            AttackOne attack = new AttackOne(true, this, damage, 720, 300);
            // add projectile attack to world next to character
            getWorld().addObject(attack, getX()+55, getY());
            damage = 0; // set next damage to zero again (for the next player turn)
            attacked = true; // do not attack again until next turn
        }
    }

    // this method moves the player to one side, and then back a few frames later
    public void dodge() {
        if(dodgeCounter == 0) // if frame count just started 
            setLocation(getX() + 300, getY()); // move player 300 pixels to the right
        else if(dodgeCounter == 60) { // HAS TO BE 60 OR FEWER FRAMES BETWEEN MOVES
            setLocation(getX() - 300, getY()); // move player 300 pixels to the let (back to original)
        }
        dodgeCounter++; // increase frame count
    }

    // this method updates the player's damage for turn 0 based on user input length
    public void updateTurn0Damage() {
        String validStringTyped = InputReader.getCorrectString(); // get the correctly typed word by the user
        if(((Stages)getWorld()).getTurn() == 0) // if the turn is 0
            if(validStringTyped != null) // if there is a correctly typed word for the act
                this.damage += validStringTyped.length()/4; // increase the player's damage by a quarter of the word length
    }

    // this method either lets or forbids the player to dodge an attack
    public void canDodge(boolean can) {
        canDodge = can;
    }

    // this method resets the player's ability to dodge an attack 
    public void resetDodge() {
        dodgeCounter = 0;
    }

    // this method resets the ability of enemy character to attack
    public void resetAttacked() {
        attacked = false;
    }
}
