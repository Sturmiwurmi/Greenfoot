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

    private Held held =new Zauberer("Gustaf",3,100);
    private Monster monster = new Monster("Peter",3,100);
    private Wuerfel wuerfel = new Wuerfel();
    private Waffe waffe = new Waffe("Holz",5); // String Material, int Magie

    private Knopf knopf1 = new Knopf();
    private Knopf knopf2 = new Knopf();
    private String heldausgewählt;
    private boolean heldgewählt = false;

    private String Heldname; 
    private int lebenHeld;
    private boolean heldlebt;
    private int angriffswertHeld;
    private int schadenswertHeld; 
    private int Kriegerwaffennutzung = 0;

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


        myWorld.addObject(monster,194,256);
        myWorld.addObject(wuerfel,320,120);

        myWorld.addObject(knopf1,321,77);
        myWorld.addObject(knopf2,323,171);

        Heldname = held.getName();
        monstername = monster.getName();       
    }

    public void act(){
        Heldauswahl();
        // Würfel
        wuerfelgedrückt= wuerfel.getwuerfelgedrückt();

        if(wuerfelgedrückt){
            held.berechneLeben();
            monster.berechneLeben();
            wuerfel.setwuerfelgedrückt(false);
        }

        if(Kriegerwaffennutzung<1){  // Der Krieger kann seine Waffe nur einmal benutzen 
            if(held.Waffebenutzt){
                monster.berechneLeben();
                myWorld.removeObject(waffe);
                Kriegerwaffennutzung++;
            }

        }

        lebenHeld = held.getLebenspunkte();        // Held         
        angriffswertHeld = held.getAngriffswert(); 
        schadenswertHeld = angriffswertMonster;
        held.setSchadenswert(schadenswertHeld); 
        wuerfelwertheld = wuerfel.getWuerfelwertHeld();
        held.setwuerfelwert(wuerfelwertheld);

        held.setWaffenbonus(waffe.Bonus());//Waffenbonus an Held weiterleiten

        lebenMonster = monster.getLebenspunkte();    // Monster
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
                myWorld.removeObject(held);
                wuerfel.setSpielläuft(false);
                break;

        }
    }

    public void Heldauswahl(){
        if(heldgewählt == false){
            if(!knopf1.getheldausgewählt().equals("keiner")){
                heldausgewählt = knopf1.getheldausgewählt();
                //System.out.println(heldausgewählt);
                if(heldausgewählt.equals("Zauberer")){
                    held = new Zauberer("Gustaf",3,100);
                    myWorld.addObject(held,467,244); //für Zauberer
                    getWorld().removeObjects(getWorld().getObjects(Knopf.class));
                    heldgewählt = true;
                }               
            }
            else if(!knopf2.getheldausgewählt().equals("keiner")){
                heldausgewählt = knopf2.getheldausgewählt();
                //System.out.println(heldausgewählt);
                if(heldausgewählt.equals("Krieger")){
                    held = new Krieger("Gustaf",3,100);
                    myWorld.addObject(held,467,270); //für Krieger
                    myWorld.addObject(waffe,476,170);
                    getWorld().removeObjects(getWorld().getObjects(Knopf.class));
                    heldgewählt = true;
                }        
            }
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
        if(heldgewählt){
            switch(Gewinner()){
                case "Niemand":
                    this.getWorld().showText(String.valueOf(lebenMonster), 194,180); //        
                    this.getWorld().showText(String.valueOf(lebenHeld), 476,130); 
                    break;
                case "Held":
                    this.getWorld().showText(String.valueOf("TOD"), 194,180);
                    this.getWorld().showText(String.valueOf("Sieger"), 476,130); 
                    break;

                case "Monster":
                    this.getWorld().showText(String.valueOf("Sieger"), 194,180);
                    this.getWorld().showText(String.valueOf("TOD"), 476,130); 
                    break;
            }

        }
    }

}
