import greenfoot.*; 
public class Wuerfel extends Actor
{
    private int wuerfelwertHeld;
    private int wuerfelwertMonster;    
    private boolean wuerfelgedrückt;    
    private boolean spielläuft = true;

    public void act()
    {
        Wuerfeln();      
    }
    public void Wuerfeln(){
        if(spielläuft){
            if(Greenfoot.mousePressed(this)){
                wuerfelwertHeld = Greenfoot.getRandomNumber(16);
                wuerfelwertMonster = Greenfoot.getRandomNumber(16);
                wuerfelgedrückt = true; 
            }
        }
    }
    
    public boolean getwuerfelgedrückt(){
        return wuerfelgedrückt;
    }
    public int getWuerfelwertHeld(){
        return wuerfelwertHeld;
    }
    public int getWuerfelwertMonster(){
        return wuerfelwertMonster;
    }
    
    public void setSpielläuft(boolean pZustand){
        spielläuft = pZustand; 
    }
    public void setwuerfelgedrückt(boolean pgedrückt){
        wuerfelgedrückt = pgedrückt;
    }
}
