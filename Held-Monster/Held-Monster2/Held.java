import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Held here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Held extends Actor
{
   protected String name = new String("Test"); 
   protected int staerke; 
   protected int angriffswert; 
   protected int lebenspunkte;
   protected boolean heldlebt; 
    /**
     If you attempt to dereference num before creating the object you get a
     NullPointerException. In the most trivial cases, the compiler will catch
     the problem and let you know that "num may not have been initialized," 
     but sometimes you may write code that does not directly create the object.
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
   public void act(){
    
    }
}
