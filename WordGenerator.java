import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)imp
import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStream;
import java.awt.Color;

/**
 * This class is going to scan words from the word files and output the strings to DisplayWord class
 * This class uses an arraylist
 * 
 * @Kathy Zhuang
 */
public class WordGenerator extends Actor
{
    static ArrayList<String> wordList = new ArrayList<String>();
    
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

    // this method creates a new scanner, read the words in the word files and add them to the arraylist
    public void addWord(String fileName, ArrayList<String> list)
    {
        Scanner myScanner = getScanner(fileName);
        while (myScanner.hasNext())
        {
            String nextWord = myScanner.next();
            list.add(nextWord);
        }
    } 

    // this method gets a random word from the arraylist using getRandomNumber() method
    public static String getRandomString()
    {
        int index = Greenfoot.getRandomNumber(wordList.size());
        String r = (String)wordList.get(index);
        return r;
    }
}