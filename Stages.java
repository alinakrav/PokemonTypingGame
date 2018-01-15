import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * For the turns, 0 is the turn for the player to type a word
 * 1 is when the attack happens
 * 2 is the turn when the enemy is going to attack and the user must type a random word to avoid it
 * 3 is the turn when the enemy attack happens and the user gets hit or not
 * 
 * add the objects in each turn (change the names after the classes are done)
 * 
 * turn zero: WordObjects --> display words + get user input
 * turn one: attack --> player + attack 
 * turn two: enemy attack --> enemy + attack
 * turn three: user gets hit or not --> idk the object yet !!!!!

 * @author Alex, Kathy, Alina 
 * @version November 9th, 2017
 */

public class Stages extends World
{
    //enemy and player objects extend the Character class
    private Character enemy, player;
    //reader reads and displays user input
    public static InputReader reader;
    //words moving across the screen
    public WordObjects words;
    //world is not yet started (this is the first act)
    private boolean started;

    private int turn = 0; //the turn (stage) counter
    private final int turn_MAX = 3; //the maximum number of turns
    int count; //counter used to count frames between words


    // constructor gets the speed with which words should pass in WordObjects,
    // sets the background image, and makes the Character objects
    public Stages(int initWordSpeed)
    {    
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        GreenfootImage background = new GreenfootImage("grass background.png"); //create the background object
        background.scale(getWidth(), getHeight()); //scale it to the resolution of the world
        setBackground(background); //set the background

        //set the intial word speed 
        Word.setSpeed(initWordSpeed);
        WordObjects.words.clear(); //clear the hashmap so that leftover information from the previous reset will be cleared completely
        prepare(); //prepare the world
    }

    public void act(){ 
        //create object that makes words across the screen (on startup)
        makeWordObjects();

        //at set intervals,
        count++;
        if(count == words.wordInterval) {
            //and if the turn is 0 or 2
            if(getTurn() == 0 || getTurn() == 2) {
                //make words for one turn
                words.turn0And2();
                //determine if player is able to dodge based on words typed
                words.determineDodge((SubPlayer)player, (SubEnemy)enemy);
            }
            //reset the interval count
            count=0;
        }

        //player attacks in turn 1
        if(getTurn() == 1) {
            player.attack(); 
            //do not let player dodge before it's set by word intervals
            ((SubPlayer)player).resetDodge();
        }
        //enemy attacks in turn 3
        if(getTurn() == 3) {
            enemy.attack();
        }
    }

    //this method returns the current turn
    public int getTurn(){
        return turn;
    }

    //this method makes the game go to the next turn
    public void nextTurn() { 
        //if max turn is not reached
        if(turn < turn_MAX){
            //increase turn
            turn++;
        } else { //if at max turns go back to the first turn at turn = 0
            turn = 0;
        }
        //reset the 'attacked' status of characters
        ((SubPlayer)player).resetAttacked();
        ((SubEnemy)enemy).resetAttacked();
    }

    //this method changes to a specific turn in the game and executes actions for that turn
    public void nextTurn(int turn){ 
        this.turn = turn; 
        if(turn == 1)
            player.attack();
        else if(turn == 3){
            enemy.attack();
        }
    }

    //this method creates an instance of WordObjects and InputReader in the world
    private void makeWordObjects() {
        if (!started) {
            reader = new InputReader();
            addObject(reader, 10, 10);
            started = true;

            words = new WordObjects();
            addObject(words, 100, 200);
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        //initialise player and enemy subclass objects
        player = new SubPlayer();
        addObject(player, 191, 443);
        player.setLocation(180, 458);
        player.setLocation(165, 502);
        player.setLocation(163, 488);

        enemy = new SubEnemy();
        addObject(enemy, 740, 266);
        enemy.setLocation(737, 208);
        enemy.setLocation(745, 226);
        enemy.setLocation(753, 225);
        enemy.setLocation(722, 248);
    }

    //this method returns the world instance's player
    public Character getPlayer() {
        return player;
    }

    //this method returns the world instance's enemy object
    public Character getEnemy() {
        return enemy;
    }
}