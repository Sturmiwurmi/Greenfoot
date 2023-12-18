import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wuerfel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wuerfel extends Actor
{
    /**
     * Act - do whatever the Wuerfel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int wuerfelwertHeld;
    private int wuerfelwertMonster;
    
    private boolean wuerfelgedrückt;
    
    private boolean spielläuft = true;
    public void act()
    {
        Wuerfeln();
        
       
      
      
    }
    public void Wuerfeln(){
        if(spielläuft){
    if(Greenfoot.mousePressed(this)){
        wuerfelwertHeld = Greenfoot.getRandomNumber(16);
        wuerfelwertMonster = Greenfoot.getRandomNumber(16);
        //System.out.println("Würfel Held: " + wuerfelwertHeld); 
        //System.out.println("Würfel Monster: " + wuerfelwertMonster); 
        wuerfelgedrückt = true; 
    
        }
    }
    }
  
    public void setSpielläuft(boolean pZustand){
    spielläuft = pZustand; 
    }
    
    public void setwuerfelgedrückt(boolean pgedrückt){
    wuerfelgedrückt = pgedrückt;
    }
    
    public boolean getwuerfelgedrückt(){
    return wuerfelgedrückt;
    }
    
    public int getWuerfelwertHeld(){
    return wuerfelwertHeld;
    }
    public int getWuerfelwertMonster(){
    return wuerfelwertMonster;
    }
    
}
