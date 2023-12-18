import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Säule here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Saeule extends Actor
{
    /**
     * Act - do whatever the Säule wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int Zahl; 
    public Saeule(int pZahl){
        Zahl =pZahl;
        
        this.getImage().scale(50, 50*Zahl);
   
    }
    
    
    
    public void act()
    {
       
    }
}
