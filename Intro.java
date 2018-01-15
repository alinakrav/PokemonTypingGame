import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class starts playing the background music,
 * and sets images to introduction screens that 
 * decsribe how the game works.
 * It presents the user with an option to play in easy or hard mode,
 * which are presented with buttons on the last screen.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class Intro extends World
{
    // whether the first act was played yet
    boolean started;

    //counts screen number
    int screenCounter = 0;
    GreenfootSound song;
    int cooldownCount = 0;
    int cooldown = 30;

    // constructor sets the first screen image 
    public Intro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        //set first screen to background
        setBackground(new GreenfootImage("introScreen0.png"));
    }

    public void act() { 
        cooldownCount++; // count frames until cooldown ends
        //do in the first act
        if(!started) {
            //play theme song on loop
            song = new GreenfootSound("theme.mp3");
            song.playLoop();
            //do not repeat this action for other acts
            started = true;
        }

        //get keyboard key pressed
        String key = Greenfoot.getKey();
        //if it's spacebar
        if(key == "space" && cooldownCount >= cooldown && screenCounter < 3) {
            //increase the screen number count
            if(screenCounter < 3)
                screenCounter++;
            //set background to new screen number count (next screen in set of screens for intro)
            setBackground(new GreenfootImage("introScreen" + screenCounter + ".png"));
            //if last screen image was shown, then move onto the main menu
            if(screenCounter == 3) {
                //set up the difficulty buttons
                addObject(new PlayButton("easy"), getWidth()/2, getHeight()*3/4);
                addObject(new PlayButton("hard"), getWidth()/2, getHeight()/4);
                screenCounter++;
            }
            cooldownCount = 0; // reset the cooldown
        }
    }
}
