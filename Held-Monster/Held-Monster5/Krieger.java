import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Krieger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Krieger extends Held
{
   
    
    /**
     * Act - do whatever the Krieger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public Krieger(String pName, int pStaerke, int pLebenspunkte){
        super("", 0,0);
        
        this.name = pName; 
        this.staerke = pStaerke; 
        this.lebenspunkte =pLebenspunkte; 
        }
    public void act()
    {
                
      Angriffswertberechnen();  
    }
    public void benutzewaffe(){
    angriffswert = angriffswert + Waffenbonus; 
    }
    
}
