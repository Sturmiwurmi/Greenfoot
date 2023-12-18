import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zauberer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zauberer extends Held
{
    /**
     * Act - do whatever the Zauberer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
 
     public Zauberer(String pName, int pStaerke, int pLebenspunkte, boolean pHeldlebt){
        super("", 0,0,true);
        
        this.name = pName; 
        this.staerke = pStaerke; 
        this.lebenspunkte = pLebenspunkte; 
        this.heldlebt = pHeldlebt;
        }
    public void act()
    {
       
    }
    public String getName(){
    return this.name; 
    }
    
}
