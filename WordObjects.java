import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.HashMap;

/**
 * This class creates words that float across the screen, based on how many 
 * one wants to make for each turn in the game. The words are made to look different
 * relative to their length (and thus difficulty to type). This class is also 
 * used to tell whether the player can currently dodge an attack (based on whether
 * the user typed out all words in a turn).
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class WordObjects extends Actor
{
    boolean started; // whether first act was played yet
    int count = 0; // counter 
    public boolean makeWords; // whether words should be made
    int numWords = 4; // number of words per turn
    static int wordsTyped = 0; // how many words were typed correctly
    int wordInterval = 100; // amount of frames between words being created

    // hashmap has word objects as values, mapped to their strings
    static public HashMap<String, Word> words = new HashMap<String, Word>();

    public void act() 
    {
        //only execute on start
        if(!started) {
            getWorld().addObject(new WordGenerator(), 0, 0); // create the word generator
            started = true;
        }
    }       

    // this method incrases the amount of words typed correctly by one
    public static void wordTyped() {
        wordsTyped++;
    }

    // this method resets the number of words that should be made
    public void resetNumWords(){
        numWords = 4;  
    }

    // this method tells WordObjects whether words should still be made
    public void setMakeWords(boolean makeWords){
        this.makeWords = makeWords;
    }

    // execute actions for turns 0 and 2, which is creating a specific number of words per turn
    public void turn0And2() {
        if(numWords > 0) { // if words should stil be made
            createWord(WordGenerator.getRandomString()); // create new random word in world
            numWords--;
        } 
        else if(noWords()) { // when all words are made
            resetNumWords(); // reset needed number of words
            ((Stages)getWorld()).nextTurn(); // change turn
        }
    }

    // this method creates new Word objects that has characteristics based on their length
    public void createWord(String s)
    {
        // a random word
        Word w;

        // a variable that keeps track of the number of act
        Color color;
        int x, y; 

        // the position and color of the words are based on the word length, representing different attack level
        if (s.length() <= 4)
        {
            y = 200;
            color = Color.GREEN;
        }
        if (s.length() > 4 && s.length() <= 6)
        {
            y = 150;
            color = Color.YELLOW;
        }
        if (s.length() > 6 && s.length() <= 9)
        {
            y = 100;
            color = Color.ORANGE;
        }
        else
        {
            y = 50;
            color = Color.PINK;
        }

        // the words are always generated on the left edge
        x = 0;

        // add the object Word here in order to display the random word generated in this class
        w = new Word(s, color);
        getWorld().addObject(w, x, y);

        //map the string to Word object of that string
        words.put(s, w);
    }

    // this method determines whether the user typed all words correctly, and thus should dodge the enemy attack
    public void determineDodge(SubPlayer player, SubEnemy enemy) {
        //after all words are made
        if(noWords()) { //after all words are made
            // if amount of words typed is how many there are initially, player can dodge, otherwise he can't
            player.canDodge(numWords == wordsTyped);
            // if player can dodge, enemy cannot hit, and vice versa
            enemy.canHit(numWords != wordsTyped);
            wordsTyped = 0; // reset number of words typed
        }
    }

    // this method changes the number of words that are made per turn
    public void changeNumWords(int num){
        numWords = num;
    }

    // this method returns whether or not the hashmap of words is empty
    public boolean noWords(){
        return words.isEmpty();
    }

    // this method gets the current frame count
    public int getCount(){
        return count;
    }

    // this method gets the number of required words to be made for this class's objects
    public int getNumWords(){
        return numWords;
    }

    // this method gets the number of words typed by the user (correctly) in current turn
    public int getWordsTyped(){
        return wordsTyped;
    }
}
