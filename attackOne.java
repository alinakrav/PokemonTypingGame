import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class attackOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class attackOne extends Attack
{
    private GreenfootImage[] frames = {
        new GreenfootImage("attackOne1.png"), 
        new GreenfootImage("attackOne2.png"),
        new GreenfootImage("attackOne3.png"),
        new GreenfootImage("attackOne4.png"),
        new GreenfootImage("attackOne5.png"),
        new GreenfootImage("attackOne6.png"),
        new GreenfootImage("attackOne7.png"),
        new GreenfootImage("attackOne8.png"),
        new GreenfootImage("attackOne9.png"),
        new GreenfootImage("attackOne10.png"),
        new GreenfootImage("attackOne11.png"),
        new GreenfootImage("attackOne8.png"),
        new GreenfootImage("attackOne9.png"),
        new GreenfootImage("attackOne10.png"),
    };
    private int frame = 0;
    private static int speed = 10;
    private static int damage = 10;
    private static boolean enemy = false;
    private final int loopPoint = 7;
    public attackOne(){
        super(speed, damage, enemy);
    }

    /**
     * Act - do whatever the attackOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        super.act();
        animate();
    }

    public void animate(){
        if(frame == frames.length){
            frame=loopPoint;
        }
        setImage(frames[frame]);
        frame++;
    }
}
