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

    private String monstername; 
    private int lebenMonster;
    private boolean Monsterlebt;
    private int angriffswertMonster;
    private int schadenswertMonster; 

    
    private int wuerfelwertmonster; 
    private int wuerfelwertheld; 
    private boolean wuerfelgedrückt;

   
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

        // Würfel
        wuerfelgedrückt= wuerfel.getwuerfelgedrückt();

        if(wuerfelgedrückt){
            zauberer.berechneLeben();
            monster.berechneLeben();
            wuerfel.setwuerfelgedrückt(false);
        }

        
        lebenHeld = zauberer.getLebenspunkte();         // Held 
        heldlebt = zauberer.getheldlebt(); 
        angriffswertHeld = zauberer.getAngriffswert(); 
        schadenswertHeld = angriffswertMonster;
        zauberer.setSchadenswert(schadenswertHeld); 
        wuerfelwertheld = wuerfel.getWuerfelwertHeld();
        zauberer.setwuerfelwert(wuerfelwertheld);

        lebenMonster = monster.getLebenspunkte();    // Monster
        Monsterlebt = monster.getmonsterlebt(); 
        angriffswertMonster = monster.getAngriffswert(); 
        schadenswertMonster = angriffswertHeld; 
        monster.setSchadenswert(schadenswertMonster); 
        wuerfelwertmonster = wuerfel.getWuerfelwertMonster();
        monster.setwuerfelwert(wuerfelwertmonster);

        Lebenanzeigen(); 
        //System.out.println(Gewinner());
        
        switch(Gewinner()){
        case "Niemand": 
            //System.out.println("Niemand");
            break;
            
        case "Held": 
            myWorld.removeObject(monster);
            wuerfel.setSpielläuft(false);
            break;
        case "Monster":
            myWorld.removeObject(zauberer);
            wuerfel.setSpielläuft(false);
            break;
        
        
        }
    }

    public String Gewinner(){
        if(lebenMonster == 0 && lebenHeld == 0){
            return "Unnentschieden";
        }
        if(lebenMonster < 0 && lebenHeld < 0){
            if(lebenMonster>lebenHeld){
            return "Monster";
            }
            else if(lebenMonster<lebenHeld)
            {
            return "Held";
            }           
        }
        if(lebenMonster <=0 ){
            return "Held";
        }
        if(lebenHeld <=0){
            return "Monster";
        }
        return "Niemand";
    }

    public String getHeldname(){
        return Heldname;
    }
    
    
    
    public int getwuerfelwertheld(){
        return wuerfelwertheld;    
    }

    public int getwuerfelwertmonster(){
        return wuerfelwertmonster;    
    }

    /**  
    public void setwuerfelwertheld(int pWuerfelwert){
    wuerfelwertheld = pWuerfelwert;
    }

    public void setwuerfelwertmonster(int pWuerfelwert){
    wuerfelwertmonster = pWuerfelwert;
    }*/

    public void Lebenanzeigen(){
       switch(Gewinner()){
           case "Niemand":
              this.getWorld().showText(String.valueOf(lebenMonster), 194,180); //        
              this.getWorld().showText(String.valueOf(lebenHeld), 467,130); 
              break;
           case "Held":
               this.getWorld().showText(String.valueOf("TOD"), 194,180);
               this.getWorld().showText(String.valueOf(lebenHeld), 467,130); 
              break;
               
           case "Monster":
           this.getWorld().showText(String.valueOf(lebenMonster), 194,180);
           this.getWorld().showText(String.valueOf("TOD"), 467,130); 
           break;
        }
        
    }

    
}
