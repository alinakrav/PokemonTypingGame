import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.HashMap;

/**
 * Write a description of class WordObjects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordObjects extends Actor
{
    boolean started;
    int count = 0;
    private int numWords = 4;

    static HashMap<String, Word> words = new HashMap<String, Word>();

    public void act() 
    {
        //only execute on start
        if(!started) {
            getWorld().addObject(new WordGenerator(), 0, 0);
            started = true;
        }

        count++; 
        // counts the acts in order to generate the words in a wanted time periods
        // the if statement can be changed based on the game's features and levels
        if(count == 100){
            if(numWords > 0){
                //if (count % 50 == 0) 
                createWord(WordGenerator.getRandomString());
                numWords--;
            }
            count=0;
        }
    }    

    // this method creates a new DisplayWord object then inputs the word that need to be displayed on the screen
    public void createWord(String s)
    {
        // a random word
        Word w;

        // a variable that keeps track of the number of act
        Color color;
        int x, y; 

        if (s.length() <= 4)
        {
            y = 400;
            color = Color.GREEN;
        }
        if (s.length() > 4 && s.length() <= 6)
        {
            y = 350;
            color = Color.YELLOW;
        }
        if (s.length() > 6 && s.length() <= 9)
        {
            y = 300;
            color = Color.ORANGE;
        }
        else
        {
            y = 250;
            color = Color.PINK;
        }
        // the position and color of the words are based on the word length, representing different attack level
        x = 0;
        // the words are always generated on the left side

        // add the object DisplayWord here in order to display the random word generated in this class
        w = new Word(s, color);
        getWorld().addObject(w, x, y);

        //map the string to Word object of that string
        words.put(s, w);
    }
    public void changeNumWords(int num){
        numWords = num;
    }
}
