import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Feld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Feld extends Actor
{
    private int Zahl;
    private int width = this.getImage().getWidth()/2;
    private int Schriftgroeße = 16;

    private int Schicht; // in welcher Schicht sich das Feld befindet 
    private int SchichtX; // in welcher Position der Schicht sich das Feld befindet 

    public Feld(int pZahl){
        Zahl = pZahl;

        

        if(Zahl<10){
            width-= 6;   
        }else if(Zahl<100){
            width-= 9;    
        }else if(Zahl<1000){
            width-= 12;    
        }else if(Zahl<10000){
            width-=15;
        }else if(Zahl<100000){
            width-= 18;
        }else if(Zahl<1000000){
            width-= 21;
        }
        else{
            width-= 21;
            Schriftgroeße = 12;
        }
        this.getImage().drawImage(new GreenfootImage(Integer.toString(Zahl), Schriftgroeße, Color.BLACK, new Color(0, 0, 0, 0)),width,this.getImage().getHeight()/2-8);

    }

    public void setSchicht(int pSchicht){
        Schicht = pSchicht;
    }

    public void setSchichtX(int X){
        SchichtX = X;
    }

    public int getZahl(){
        return Zahl;
    }
    
    public int getSchicht(){
        return Schicht;
    }
    
    public void ausgewählt(){
        this.setImage("Feldausgewählt.png");        
        this.getImage().drawImage(new GreenfootImage(Integer.toString(Zahl), Schriftgroeße, Color.BLACK, new Color(0, 0, 0, 0)),width,this.getImage().getHeight()/2-8);
    }

    public void abgewählt(){
        this.setImage("Feld.png");        
        this.getImage().drawImage(new GreenfootImage(Integer.toString(Zahl), Schriftgroeße, Color.BLACK, new Color(0, 0, 0, 0)),width,this.getImage().getHeight()/2-8);   
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(this)){
            ausgewählt();
            if(Zahl>1){   
                ((MyWorld)this.getWorld()).getDreieckXY(SchichtX,Schicht-1).ausgewählt();         
            }
            if(Zahl>1){   
                ((MyWorld)this.getWorld()).getDreieckXY(SchichtX-1,Schicht-1).ausgewählt();         
            }               
        }
    }
}
