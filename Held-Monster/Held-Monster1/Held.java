import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Held here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Held extends Actor
{
   protected String name; 
   protected int staerke; 
   protected int angriffswert; 
   protected int lebenspunkte;
   protected boolean heldlebt; 
    
    /**
     * Act - do whatever the Held wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Held(String pName, int pStaerke, int pLebenspunkte, boolean pHeldlebt)
    {
    name = pName; 
    staerke = pStaerke; 
    lebenspunkte = pLebenspunkte;
    heldlebt = pHeldlebt;
    }
    
    public String getName(){
    return name; 
   }
}
