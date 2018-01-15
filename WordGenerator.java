import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)imp
import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStream;
import java.awt.Color;

/**
 * This class is used to scan words from provided word files and put them in an ArrayList.
 * A random word is then picked from the list using a method that can be called from other classes.
 * 
 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */
public class WordGenerator extends Actor
{
    static ArrayList<String> wordList = new ArrayList<String>(); // list of words

    // constructor parses through the following text files and adds all the words into arrayList
    public WordGenerator() {
        addWord("verbs.txt", wordList);
        addWord("adjectives.txt", wordList);
        addWord("nouns.txt", wordList);
    }   

    // this method gets a scanner that can read words from the word files
    public Scanner getScanner(String filename)
    {
        InputStream myFile = getClass().getResourceAsStream(filename);
        if(myFile != null) {
            return new Scanner(myFile);
        }
        return null;
    } 

    // this method creates a new scanner, reads the words in a word file and adds them to an arraylist
    public void addWord(String fileName, ArrayList<String> list)
    {
        Scanner myScanner = getScanner(fileName); // create scanner of certain text file
        while (myScanner.hasNext()) // while more words to scan left
        {
            String nextWord = myScanner.next(); // word parsed from text file
            list.add(nextWord); // add word to given arrayList
        }
    } 

    // this method gets a random word from the arraylist using getRandomNumber() method
    public static String getRandomString()
    {
        int index = Greenfoot.getRandomNumber(wordList.size()); // get random number that falls withitn the range of the list's indices
        String r = (String)wordList.get(index); // get string from list that's under that index
        return r; // return random string
    }
}