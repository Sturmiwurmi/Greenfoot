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
    protected int Schadenswert;
    protected int Wuerfelwert;
    protected int Bonus;
    protected boolean heldlebt; 
    
    protected int Testi; 
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
    public void act(){
    
    }
   
    public String getName(){
        return this.name; 
    }
    
    public int getTesti(){
    return Testi;
    }
    
    public int getAngriffswert(){
    return this.angriffswert; 
    }
    
    public int getLebenspunkte(){
    return this.lebenspunkte; 
    }
    
    public boolean getheldlebt(){
    return this.heldlebt; 
    }
    
    
    public void setBonus(int pBonus){
    this.Bonus = pBonus; 
    }
    
    public void setSchadenswert(int pSchadenswert){
     Schadenswert = pSchadenswert; 
    }
    
    
    public int Angriffswertberechnen(){
        int Angriff; 
        angriffswert = 0; 
        Angriff = angriffswert + staerke + Wuerfelwert; 
        return Angriff; 
    }
    public int berechneLeben(){
        int leben; 
        leben = this.lebenspunkte - Schadenswert ;
        return leben; 
    }
    public void sterbe(){
    }
    public void angreifen(){
        angriffswert = Angriffswertberechnen(); 
    }
    
}
