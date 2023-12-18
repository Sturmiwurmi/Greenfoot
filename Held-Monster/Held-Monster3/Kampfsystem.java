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
    private Wuerfel wuerfel = new Wuerfel();
   
   
  
    private String Heldname; 
    private int lebenHeld;
    private boolean heldlebt;
    private int angriffswertHeld;
    private int schadenswertHeld;
    
    private int wuerfelwertheld; 
    
    
    
    private String monstername; 
    private int lebenMonster;
    private boolean Monsterlebt;
    private int angriffswertMonster;
    private int schadenswertMonster; 
    
    private int wuerfelwertmonster; 
    
    /**
     * Constructor for objects of class Kampfsystem
     */
    public Kampfsystem(World _myPlanet){
        super();
        myWorld = _myPlanet;
        
        myWorld.addObject(zauberer,467,244);
        myWorld.addObject(monster,194,256);
        myWorld.addObject(wuerfel,320,120);
        
        Heldname = zauberer.getName();
         monstername = monster.getName();       
    }
    public void act(){
    // System.out.println(Heldname);
    
    
       
        lebenHeld = zauberer.getLebenspunkte();       
        heldlebt = zauberer.getheldlebt(); 
        angriffswertHeld = zauberer.getAngriffswert(); 
        schadenswertHeld = angriffswertMonster;
        zauberer.setSchadenswert(schadenswertHeld); 
        
        
        lebenMonster = monster.getLebenspunkte(); 
        Monsterlebt = monster.getmonsterlebt(); 
        angriffswertMonster = monster.getAngriffswert(); 
        schadenswertMonster = angriffswertHeld; 
        monster.setSchadenswert(schadenswertMonster); 
        
        Lebenanzeigen(); 
    }
   
    public String getHeldname(){
    return Heldname;
    }
    
    
    
    public void Lebenanzeigen(){
       // System.out.println(lebenHeld);
    this.getWorld().showText(String.valueOf(lebenMonster), 194,180); // 
    this.getWorld().showText(String.valueOf(lebenHeld), 467,130); // Leben Held
    //System.out.println(lebenHeld);
}
    
    
    

    
  
}
