import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is used to make buttons that can be pressed, and 
 * that execute some command when pressed. Such a command is 
 * defined in child classes of the Button class.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class Button extends Actor
{   
    public void act() {
        MouseInfo info = Greenfoot.getMouseInfo(); // see what is being done with mouse
        if(Greenfoot.mouseClicked(this)) { // if this object is clicked
            whenClicked(); // execute appropriate method
        }
    }

    // this method is called when the button is clicked. It is defined in the subclasses 
    // for functionality that is specific to that button type.
    public void whenClicked() {}
}
