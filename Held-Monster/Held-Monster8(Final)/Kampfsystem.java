import greenfoot.*;
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
        Lebenanzeigen(); 
        Gewinnerfeststellen();
        KommunikationHeldMonster();

        wuerfelgedrückt= wuerfel.getwuerfelgedrückt();// Würfel

        if(wuerfelgedrückt){
            held.berechneLeben();
            monster.berechneLeben();
            wuerfel.setwuerfelgedrückt(false);
        }

       
        
        if(held.getClass() == Krieger.class){
        if(Kriegerwaffennutzung<1){  // Der Krieger kann seine Waffe nur einmal benutzen 
            if(myWorld.getObjects(Krieger.class).getWaffebenutzt()){  // ich finde keine Möglichkeit auf die Methode der vererbten klasse zuzugreifen
                monster.berechneLeben();
                myWorld.removeObject(waffe);
                Kriegerwaffennutzung++;
            }
        }
       }
        
        
     }
     
   

    public void KommunikationHeldMonster(){
        lebenHeld = held.getLebenspunkte();        // Held         
        angriffswertHeld = held.getAngriffswert(); 
        schadenswertHeld = angriffswertMonster;
        held.setSchadenswert(schadenswertHeld); 
        wuerfelwertheld = wuerfel.getWuerfelwertHeld();
        held.setwuerfelwert(wuerfelwertheld); // Das Ergebniss des Würfels vom Helden wird an den Held weitergegeben

        if(held.getClass() == Krieger.class){
        held.setWaffenbonus(waffe.Bonus());//Waffenbonus an Held weiterleiten // ich finde keine Möglichkeit auf die Methode der vererbten klasse zuzugreifen
        }
        lebenMonster = monster.getLebenspunkte();    // Monster
        angriffswertMonster = monster.getAngriffswert(); 
        schadenswertMonster = angriffswertHeld; 
        monster.setSchadenswert(schadenswertMonster); 
        wuerfelwertmonster = wuerfel.getWuerfelwertMonster();
        monster.setwuerfelwert(wuerfelwertmonster);   // Das Ergebniss des Würfels vom Monster wird an das Monster weitergegeben  

    }

    public void Gewinnerfeststellen(){
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
                if(heldausgewählt.equals("Zauberer")){
                    held = new Zauberer("Gustaf",3,100);
                    myWorld.addObject(held,467,244); //für Zauberer
                    getWorld().removeObjects(getWorld().getObjects(Knopf.class));
                    heldgewählt = true;
                }               
            }
            else if(!knopf2.getheldausgewählt().equals("keiner")){
                heldausgewählt = knopf2.getheldausgewählt();
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
