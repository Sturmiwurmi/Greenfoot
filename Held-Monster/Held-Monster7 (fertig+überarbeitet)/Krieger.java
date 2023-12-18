import greenfoot.*; 
public class Krieger extends Held
{
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
}
