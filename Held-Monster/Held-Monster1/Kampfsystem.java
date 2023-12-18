import greenfoot.*;
/**
 * Write a description of class Kampfsystem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kampfsystem 
{
    
    private Held Held;
    private String Heldname; 

    /**
     * Constructor for objects of class Kampfsystem
     */
    public Held setHeld(){
    return new MyWorld().getZauberer(); 
    }
    public String setHeldname(){
    return Held.getName();
    }
    public String getHeldname(){
    return Heldname;
    }
    
    public Kampfsystem()
    {
     //Heldname = setHeldname(); 
    }
    
    public void testprinter(){
        
    }

    
  
}
