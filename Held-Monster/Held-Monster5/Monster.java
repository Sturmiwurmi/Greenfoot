import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
       // System.out.println(String.valueOf(angriffswert));
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
    
    public void Angriffswertberechnen(){
        angriffswert = staerke+wuerfelwert;
    }
    public void berechneLeben(){
        this.lebenspunkte = this.lebenspunkte - Schadenswert ;
    }
    public void sterbe(){
    }
    public void angreifen(){
    }
}
