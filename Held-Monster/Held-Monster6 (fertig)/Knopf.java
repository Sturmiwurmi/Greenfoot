import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Knopf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knopf extends Actor
{
    /**
     * Act - do whatever the Knopf wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String Knopfart;
    private String heldasugewählt = "keiner";
    public Knopf(){

    }

    public void act()
    {
        
        gedrückt();
        Knopfartsetzten();        
    }

    public void Knopfartsetzten(){
        if(getY() == 77){
            Knopfart ="Zauberer"; 
        }
        if(getY()==171){
            Knopfart ="Krieger";
        }

        if(Knopfart.equals("Zauberer")){
            getImage().clear();
            setImage("images/Knopf-Zauberer.png");
        }
        else
        {
            getImage().clear();
            setImage("images/Knopf-Krieger.png");
        }
    }
    
    public void gedrückt(){
    if(Greenfoot.mousePressed(this)){
        if(Knopfart.equals("Zauberer")){
            
        heldasugewählt = "Zauberer";
        // getWorld().removeObjects(getWorld().getObjects(this.getClass()));
        }
        else if(Knopfart.equals("Krieger")){
            
         heldasugewählt = "Krieger";   
        // getWorld().removeObjects(getWorld().getObjects(this.getClass()));
        }
    }
}
public String getheldausgewählt(){
return heldasugewählt;
}
}
