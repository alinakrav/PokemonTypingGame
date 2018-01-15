import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class displays end screens based on the game's outcome.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class End extends World
{
    //frames counter until next screen is shown
    int nextScreenCounter;
    String winOrLose;

    // constructor sets the outcome of the game and sets the image
    public End(String result)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        //string stores game outcome to prepend it to generic screen name (Screen.png) and get that screen
        winOrLose = result;
        //set the first image to generic game over screen
        setBackground(new GreenfootImage("gameOverScreen.png"));
    }

    public void act() {
        //increment counter by 1 per frame 
        nextScreenCounter++;
        //once 100 frames passed
        if(nextScreenCounter == 100) {
            //set image to screen for appropriate game outcome
            setBackground(new GreenfootImage(winOrLose + "Screen.png"));
            //stop game completely
            Greenfoot.stop();
        }
    }
}
