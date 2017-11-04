import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stages here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Stages extends World
{
    public static InputReader reader;
    public WordObjects word;
    private boolean started;
    
    private int turn = 0; //the turn counter
    private final int turn_MAX = 3; //the maximum number of turns
    
    /**
     * For the turns, 0 is the turn for the player to type a word
     * 1 is when the attack happens
     * 2 is the turn when the enemy is going to attack and the user must type a random word to avoid it
     * 3 is the turn when the enemy attack happens and the user gets hit or not
     */
    
    /**
     * add the objects in each turn (change the names after the classes are done)
     * 
     * turn zero: WordObjects --> display words + get user input
     * turn one: attack --> player + attack 
     * turn two: enemy attack --> enemy + attack
     * turn three: user gets hit or not --> idk the object yet !!!!!
     */
   /*
    private TurnZeroObject zero = new TurnZeroObject();
    private TurnOneObject one = new TurnOneObject();
    private TurnTwoObject two = new TurnTwoObject();
    private TurnThreeObject three = new TurnThreeObject();*/
    
    /**
     * Constructor for objects of class Stages.
     * 
     */
    public Stages()
    {    
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        GreenfootImage background = new GreenfootImage("grass background.png"); //create the background object
        background.scale(getWidth(), getHeight()); //scale it to the resolution of the world
        setBackground(background); //set the background

        prepare(); //prepare the world
    }

    public void act(){ //makes the stage move
        //changeTurn(); //not sure about this yet
        
        if (!started) {
            reader = new InputReader();
            addObject(reader, 10, 10);
            started = true;

            word = new WordObjects();
            addObject(word, 100, 200);
        }
    }
    //return current turn
    public int getTurn(){
        return turn;
    }

    public void nextTurn(){ //will go to next turn if no specific turn is indicated
        if(turn < turn_MAX){
            turn++;
        } else { //if at max turns go back to the first turn at turn = 0
            turn = 0;
        }
    }

    public void nextTurn(int turn){ //will change the current turn
        this.turn = turn; 
    }

    /**
     * How does the changeTurn() class word?
     * (check my "new try" greenfoot demo)
     * 1. Add an object to the world 
     * e.g. the WordObjects class
     * 2. Then the object is going to run all the method in its own class 
     * (the addObject method usually triggers the object to start working)
     * e.g.output words are displayed (this is a method in the WordObjects class)
     * 3. When the turn ends, get a boolean from the class 
     * e.g. if the user input is equal to the output word, a boolean in the wordObjects class will equal
     * to true, and there should be a get method which allows the stage to get the boolean's value
     * 4. If the boolean's value is true, then the current turn ends, and the next turn starts
     * 
     * IF YOU CAN'T UNDERSTAND THIS just check out the greenfoot demo called "new try" it's on google drive
     * 
     *//*
    public void changeTurn(){
    if (turn == 0)
    {
    addObject(zero, 10, 10 ); // add the turn zero object to the stage, the position does not matter

    // SomethingObject0.turnZeroEnds() gives me a boolean created in the SomethingObject0 class 
    // if the boolean = true, it means that the class has done all its work and the turn ends
    if (SomethingObject0.turnZeroEnds() == true) 
    {
    removeObject(zero); // removes the object 
    turn = 1; // this turn ends and will go to the next turn in the next act
    }
    }
    else if (turn == 1)
    {
    addObject(one, 10, 10 ); 
    if (SomethingObject1.turnOneEnds() == true) 
    {
    removeObject(one); // removes the object 
    turn = 2; // this turn ends and will go to the next turn in the next act
    }
    }
    else if (turn == 2)
    {
    addObject(two, 10, 10 ); 
    if (SomethingObject2.turnTwoEnds() == true) 
    {
    removeObject(two); // removes the object 
    turn = 3; // this turn ends and will go to the next turn in the next act
    }
    }
    else if (turn == 3)
    {
    addObject(three, 10, 10 ); 
    if (SomethingObject3.turnThreeEnds() == true) 
    {
    removeObject(three); // removes the object 
    turn = 0; // goes back to turn zero
    }
    }
    //else {} not sure how the game ends, should be something related to the health bar
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player, 191, 443);
        player.setLocation(180, 458);
        player.setLocation(165, 502);
        player.setLocation(163, 488);
        Enemy1 enemy1 = new Enemy1();
        addObject(enemy1, 740, 266);
        enemy1.setLocation(737, 208);
        enemy1.setLocation(745, 226);
        enemy1.setLocation(753, 225);
        enemy1.setLocation(722, 248);
    }
    private void updateHealth(){
        
    }
}