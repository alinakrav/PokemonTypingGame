import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This subclass is used to make buttons that, when pressed, instantiate a game with
 * the speed that is assigned to each given mode. Passing it a different mode changes 
 * the speed of the game that starts when the specific play button is pressed.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class PlayButton extends Button
{
    int gameSpeed; // speed of the game being played now
    int easySpeed = 3; 
    int hardSpeed = 5; 

    // constructor makes a button for a specific mode and assigns the main game speed
    public PlayButton(String mode) {
        super(); // get functionality of superclass
        setImage(new GreenfootImage(mode + "Button.png")); // set image to the button appropriate to the mode
        getImage().scale(400, 250);

        // set game speed based on given mode
        if(mode.equals("easy"))
            gameSpeed = easySpeed;
        else if(mode.equals("hard"))
            gameSpeed = hardSpeed;
    }   

    // this method is executed in the parent's act method
    public void whenClicked() {
        Greenfoot.setWorld(new Stages(gameSpeed)); // start game world with specified speed 
        getWorld().removeObject(this); // remove button from world
    }
}
