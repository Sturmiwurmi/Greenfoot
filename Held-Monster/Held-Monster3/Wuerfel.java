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
    
    public void act()
    {
        Wuerfeln();
    }
    public void Wuerfeln(){
    if(Greenfoot.mousePressed(this)){
        wuerfelwertHeld = Greenfoot.getRandomNumber(16);
        wuerfelwertMonster = Greenfoot.getRandomNumber(16);
        System.out.println("Würfel Held: " + wuerfelwertHeld); 
        System.out.println("Würfel Monster: " + wuerfelwertMonster); 
        }
    }
    
    public int getWuerfelwertHeld(){
    return wuerfelwertHeld;
    }
    public int getWuerfelwertMonster(){
    return wuerfelwertMonster;
    }
    
}
