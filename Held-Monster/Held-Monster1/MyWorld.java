import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Held zauberer; 
    private Monster monster;
    private Kampfsystem kampfsystem; 
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        zauberer = new Zauberer("Gustaf",3,100,true);
        Monster monster = new Monster("Peter",3,100,true);
         
        addObject(zauberer,467,244);
        addObject(monster,194,256);
       
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    
   
   public  Held getZauberer(){
    return zauberer; 
   }
    public Monster getMonster(){
    return monster; 
   } 
   public Kampfsystem getKampfsystem(){
    return kampfsystem; 
    }
}
