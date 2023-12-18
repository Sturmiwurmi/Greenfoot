import greenfoot.*;
public class Zauberer extends Held
{
    private boolean Heilungmoeglich = true;    
    public Zauberer(String pName, int pStaerke, int pLebenspunkte){
        super("", 0,0);        
        this.name = pName; 
        this.staerke = pStaerke; 
        this.lebenspunkte = pLebenspunkte;      
    }
    
    public void act()
    {
        heilen();        
        Angriffswertberechnen();  
    } 
    public void heilen(){
        if(lebenspunkte <=80){             
            if(Heilungmoeglich){                 
                if(Greenfoot.mousePressed(this)){
                    this.lebenspunkte = this.lebenspunkte+20;
                    Heilungmoeglich = false;
                }            
            }
        }
    }
}
