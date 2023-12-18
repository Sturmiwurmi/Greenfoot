import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mogelpalast here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mogelpalast extends World
{
public static int X() {
      return new Gulli().Xsetter();
     } 
      public static int Y() {
      return new Gulli().Ysetter();
     } 
private static int zellenGroesse = 50;
    /**
     * Constructor for objects of class Erdgeschoss4.
     * 
     */
    public Mogelpalast()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(21, 16, zellenGroesse);
        setBackground("images/Schuleboden.png");
        setPaintOrder(String.class, Rover.class, Marke.class, Gestein.class, Huegel.class);
        Greenfoot.setSpeed(35);
        
        
        
        
         this.addObject(new Gulli(), 3, 7);
    }
    public void act(){
          if(Y() == 6 && X() == 20){
            Greenfoot.setWorld(new Computerraum());
        }
        
      if(Y() == 5 && X() == 20){
            Greenfoot.setWorld(new Computerraum());
        }
        
      if(Y() == 7 && X() == 20){
            Greenfoot.setWorld(new Computerraum());
        }
       
        if(Y() == 6 && X() == 0){
            Greenfoot.setWorld(new Turm310());
        }
        
      if(Y() == 5 && X() == 0){
            Greenfoot.setWorld(new Turm310());
        }
        
      if(Y() == 7 && X() == 0){
            Greenfoot.setWorld(new Turm310());
        }
        System.out.println(Y()); 
        System.out.println(X()); 
}
}
