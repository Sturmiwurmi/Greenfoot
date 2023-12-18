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
    protected int staerke; 
    protected int angriffswert; 
    protected int lebenspunkte;
    protected int Schadenswert;
    protected int Bonus;
    protected boolean monsterlebt; 
    
    
     public Monster(String pName, int pStaerke, int pLebenspunkte, boolean pMonsterlebt){
        name = pName; 
        staerke = pStaerke; 
        lebenspunkte =pLebenspunkte; 
        monsterlebt = pMonsterlebt; 
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
    
    public boolean getmonsterlebt(){
    return monsterlebt; 
    }
    
    public void setSchadenswert(int pSchadenswert){
     Schadenswert = pSchadenswert; 
    }
    
    
    public int Angriffswertberechnen(){
        return 1; 
    }
    public int berechneLeben(){
         int leben; 
        leben = this.lebenspunkte - Schadenswert ;
        return leben;  
    }
    public void sterbe(){
    }
    public void angreifen(){
    }
}
