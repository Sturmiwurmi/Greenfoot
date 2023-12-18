import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Säule here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Saeule extends Actor
{
    
    private int Zahl; 
    
    public Saeule(int pZahl){
        Zahl =pZahl;
       
       this.getImage().scale(40, 50*Zahl); 
   
    }
    public int getZahl(){
    return Zahl;
    }
    
    
    
    
    public void act()
    {
       
    }
}

