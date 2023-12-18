import greenfoot.*; 
public class Held extends Actor
{
    protected String name; 
    protected int staerke ; 
    protected int angriffswert; 
    protected int lebenspunkte;
    protected int Schadenswert;
    protected int wuerfelwert;
    protected int Bonus;

    /**protected int Waffenbonus; //für Krieger
    protected boolean Waffebenutzt = false;  */  

    public Held(String pname, int pStaerke, int pLebenspunkte)
    {
        name = pname; 
        staerke = pStaerke; 
        lebenspunkte = pLebenspunkte;    
    } 
    public void act(){
        Angriffswertberechnen();
        berechneLeben();    
    }
    
    /** public void benutzewaffe(){
        if(Greenfoot.mousePressed(this)){
            if(Waffebenutzt == false){
                angriffswert = Waffenbonus;    
                Waffebenutzt = true;
            }
        }
    }**/
    
    public void Angriffswertberechnen(){
        int Angriff; 
        angriffswert = 0; 
        angriffswert = staerke + wuerfelwert; 

    }
    public void berechneLeben(){

        this.lebenspunkte = this.lebenspunkte - Schadenswert ;

    }
    
    public String getName(){
        return this.name; 
    }    
    public int getAngriffswert(){
        return this.angriffswert; 
    }
    public int getLebenspunkte(){
        return this.lebenspunkte; 
    }
    
    
    
    public void setwuerfelwert(int pWert){
        wuerfelwert = pWert; 
    }
    public void setBonus(int pBonus){
        this.Bonus = pBonus; 
    }
    public void setSchadenswert(int pSchadenswert){
        Schadenswert = pSchadenswert; 
    }
   
}
