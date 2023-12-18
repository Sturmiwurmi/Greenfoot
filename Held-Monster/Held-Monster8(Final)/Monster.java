import greenfoot.*; 
public class Monster extends Actor
{
    protected String name;
    protected String kname; 
    protected int staerke; 
    protected int angriffswert; 
    protected int lebenspunkte;
    protected int Schadenswert;
    protected int Bonus;     
    protected int wuerfelwert;    

    public Monster(String hName, int hStaerke, int pLebenspunkte){
        name = hName; 
        staerke = hStaerke; 
        lebenspunkte =pLebenspunkte; 
    }
    public void act(){
        Angriffswertberechnen();
    }
    public void Angriffswertberechnen(){
        angriffswert = staerke+wuerfelwert;
    }
    public void berechneLeben(){
        this.lebenspunkte = this.lebenspunkte - Schadenswert ;
    } 
    
    public String getName(){
        return this.name; 
    }
    public int getAngriffswert(){
        return angriffswert; 
    }
    public int getLebenspunkte(){
        return lebenspunkte; 
    }    
    
    public void setSchadenswert(int pSchadenswert){
        Schadenswert = pSchadenswert; 
    }
    public void setwuerfelwert(int pWert){
        wuerfelwert = pWert; 
    }
    
}
