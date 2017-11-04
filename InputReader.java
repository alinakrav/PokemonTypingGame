import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InputReader extends Actor
{
    //edge case for instantiating box object
    Wordbox box = new Wordbox("");

    public void act() 
    {   
        String text = readKeys();   
        //if final String is returned (if not returned, String is being built still)
        if(text != null) {
            removeIfCorrect(text);
        }   
    }

    public String readKeys() {
        //get key currently pressed
        String key = Greenfoot.getKey();

        //if nothing is pressed, nothing is returned
        if(key == null)
            return null;

        //if 'space' is entered, print actual ' ' space
        if(key.equals("space"))
            key = " ";

        //if 'shift' is pressed, don't print 'shift'
        if(key.equals("shift"))
            key = "";

        //if 'backspace' is pressed
        if(key.equals("backspace")) {
            if(box.string.length() > 0) 
            //remove last-stacked character
                changeTxt(box.string.substring(0,box.string.length() - 1));
        }
        //if key is pressed, and it's not 'backspace' or 'enter'
        else if(!key.equals("enter"))               
            changeTxt(box.string + key);
        //if key pressed is 'enter'
        else if(key.equals("enter"))
        //return final String if it's not empty
            if(box.string.length() > 0)
                return box.string;
        //have to have certainly reachable return statement;
        return null;
    }

    //deletes the old text object and makes a new one under the same variable and same coords
    public void changeTxt(String str) {
        Wordbox box2 = new Wordbox(str);
        getWorld().removeObject(box);
        box = box2;
        //change the coordinates later to whatever the group wants (either set location or varying)
        getWorld().addObject(box, 100,100);
    }

    //removes text object from world and clears its string for next word
    public void clearInput(Wordbox input) {
        getWorld().removeObject(input);
        box = new Wordbox("");
    }

    public void removeIfCorrect(String str) {
        //for every key in map of words on screen
        for(String s : WordObjects.words.keySet()) {
            //if entered text is the same as the key
            if(str.equals(s)) {
                //clear wordbox
                clearInput(box);
                //remove moving word
                getWorld().removeObject(WordObjects.words.get(s));
            }
        }
    }
}
