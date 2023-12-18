import greenfoot.*; 
public class Krieger extends Held
{
    
    protected int Waffenbonus; //für Krieger
    protected boolean Waffebenutzt = false;
    
    public Krieger(String pName, int pStaerke, int pLebenspunkte){
        super("", 0,0);
        this.name = pName; 
        this.staerke = pStaerke; 
        this.lebenspunkte =pLebenspunkte; 
    }
    public void act()
    {
        benutzewaffe();
        Angriffswertberechnen();  
    }    
    
    public void benutzewaffe(){
        if(Greenfoot.mousePressed(this)){
            if(Waffebenutzt == false){
                angriffswert = Waffenbonus;    
                Waffebenutzt = true;
            }
        }
    }
    
    public boolean getWaffebenutzt(){
    return Waffebenutzt;
    }
    
    public void setWaffenbonus(int pWaffenbonus){
        Waffenbonus = pWaffenbonus;
    }
}
