import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Computerraum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computerraum extends World
{

private static int zellenGroesse = 50;
    /**
     * Constructor for objects of class Erdgeschoss4.
     * 
     */
    public Computerraum()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(21, 17, zellenGroesse);
        setBackground("images/Schuleboden.png");
        setPaintOrder(String.class, Rover.class, Marke.class, Gestein.class, Huegel.class);
        Greenfoot.setSpeed(35);
        
        
        
        
         this.addObject(new Gulli(), 10, 7);
    }
}
