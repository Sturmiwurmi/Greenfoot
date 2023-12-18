import greenfoot.*;
/**
 * Write a description of class Kampfsystem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kampfsystem extends Actor
{
    World myWorld;
    
    private Held zauberer = new Zauberer("Gustaf",3,100,true);
    private Monster monster = new Monster("Peter",3,100,true);
   
  
    private String Heldname; 
    private int lebenHeld;
    private boolean heldlebt;
    private int angriffswertHeld;
    
    private String Monstername; 
    private int lebenMonster;
    private boolean Monsterlebt;
    private int angriffswertMonster;
    
    
    /**
     * Constructor for objects of class Kampfsystem
     */
    public Kampfsystem(World _myPlanet){
        super();
        myWorld = _myPlanet;
        
        myWorld.addObject(zauberer,467,244);
        myWorld.addObject(monster,194,256);
        
        Heldname = zauberer.getName();
    }

   
    public String getHeldname(){
    return Heldname;
    }
    
    public void act(){
    System.out.println(Heldname);
    }
    
    public void testprinter(){
        
    }

    
  
}
