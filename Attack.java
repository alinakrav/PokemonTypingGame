import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack extends Actor
{
    private int speed;
    private int damage;
    private boolean enemy;
    public Attack(int speed, int damage, boolean enemy){
        this.speed = speed;
        this.damage = damage;
        this.enemy = enemy;
    }
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if(getX() > getWorld().getWidth()-5 || getX() < 5){
            getWorld().removeObject(this);
        } else {
            move(speed);
            hit();
        }
    }
    public void hit(){
        if(enemy){
            Player player = (Player)getOneObjectAtOffset(0,0,Player.class);
            if(player!=null){
                player.lowerHealth(damage);
                getWorld().removeObject(this);
            }
        } else {
            Enemy enemy = (Enemy) getOneObjectAtOffset(0, 0, Enemy.class);
            if (enemy != null) {
                enemy.lowerHealth(damage);
                getWorld().removeObject(this);
            }
        }
    }
    public int getDamage(){
        return damage;
    }
   
}
