import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class reads keys pressed by the user, and once he hits 'enter', the typed string
 * is checked for existence among the word objects currently on the screen. Both the 
 * user input and the word object are deleted if a match is found, and user can continue to type.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class InputReader extends Actor
{
    Wordbox box = new Wordbox(""); // create a wordBox for user input

    static String correctStr; // correctly typed string

    public void act() 
    {   
        String text = readKeys(); // take string entered by the user (after it's built with readKeys())  
        //if final String is returned (if not returned, String is still being built)
        if(text != null)
            ifCorrect(text); // check if string is correct and perform appropriate actions on it (delete it)
    }

    // this method continuously reads keys typed by the user and changes the text in the Wordbox object accordingly
    public String readKeys() {
        //get key currently pressed
        String key = Greenfoot.getKey();

        if(key == null) // if nothing is pressed, nothing is returned
            return null;
        if(key.equals("space")) //if 'space' is entered, print actual ' ' space
            key = " ";
        if(key.equals("shift")) //if 'shift' is pressed, don't print 'shift'
            key = "";
        if(key.equals("backspace")) { //if 'backspace' is pressed
            if(box.string.length() > 0) // if there is still text to be deleted in wordbox object
                changeTxt(box.string.substring(0,box.string.length() - 1)); // change wordbox text to a copy, minus the last character
        }
        else if(!key.equals("enter")) //if key is pressed, and it's not 'backspace' or 'enter'             
            changeTxt(box.string + key); // add key to string in wordbox
        else if(key.equals("enter")) //if key pressed is 'enter'
            if(box.string.length() > 0) //return final String if it's not empty
                return box.string;
        return null; //have to have certainly reachable return statement;
    }

    // this method deletes the old text object and makes a new one under the same variable, with any text given
    public void changeTxt(String str) {
        Wordbox box2 = new Wordbox(str); // make new wordbox with given string
        getWorld().removeObject(box); // remove old wordbox from world
        box = box2; // give variable the new wordbox

        // add wordbox to world in given coordinates
        getWorld().addObject(box, 100,100);
    }

    // this method removes text object (with typed string) from world and clears its string for next word
    public void removeBoxAndWord(Wordbox input, Word w) {
        getWorld().removeObject(input); // remove wordbox object from world
        box = new Wordbox(""); // new wordbox is empty

        getWorld().removeObject(w); //remove moving word object that corresponds to string
    }

    // this method loops through the words object hashmap and checks to see if any existing words' text was entered out by user;
    // if so, that object is removed
    public void ifCorrect(String str) {
        correctStr = null; // correct string not found yet 
        //for every key in map of words on screen
        for(String s : WordObjects.words.keySet()) {
            if(str.equals(s)) { //if entered text is the same as the key (IF CORRECT WORD ENTERED)
                correctStr = str; // give correct string value
                removeBoxAndWord(box, WordObjects.words.get(s)); // clear wordbox and remove correct word object from world
            }
        }
        //to avoid java.util.ConcurrentModificationException, we have to remove correct word from map only after we've looped through it
        if(correctStr != null) { // if value was saved during the loop
            WordObjects.words.remove(str); //remove word from map after the iteration
            WordObjects.wordTyped(); // increase number-of-words-typed counter in WordObjects
        }
    }

    // this method returns the currently correct string if it was entered by user
    public static String getCorrectString() {
        String string = null; // variable to store correct string
        if(correctStr != null) { // if correct string was entered
            string = correctStr; // save it in our new variable
            correctStr = null; // reset the correct string for future acts
        }
        return string; // return saved string 
    }
}
