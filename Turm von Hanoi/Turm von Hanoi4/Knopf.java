import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Knopf extends Actor
{
    private char X1;
    private char X2;    
    private World spielfeld;
    private boolean sortierknopf;
    public Knopf(char x1, char x2,World pSpielfeld){
        X1 = x1; // = Startturm
        X2 = x2; // = Zielturm
        if(X1 == '/' && X2 == '/'){        
        sortierknopf = true;
        }
        if(!sortierknopf){
        this.getImage().drawImage(new GreenfootImage(Character.toString(X1)+" zu "+Character.toString(X2), 25, Color.BLACK, new Color(0, 0, 0, 0)),this.getImage().getWidth()/2-28,this.getImage().getHeight()/2-10);
        }
        else{
        this.getImage().drawImage(new GreenfootImage("sortieren", 25, Color.BLACK, new Color(0, 0, 0, 0)),this.getImage().getWidth()/2-42,this.getImage().getHeight()/2-10);
                }
        spielfeld = pSpielfeld;
    }
    public void act(){
        if(Greenfoot.mouseClicked(this)&& !sortierknopf){
            ((Spielfeld)spielfeld).XzuX(X1, X2);
        }   
        else if(Greenfoot.mouseClicked(this) && sortierknopf){ 
            ((Spielfeld)spielfeld).sortieren(((Spielfeld)spielfeld).getstartturm(),((Spielfeld)spielfeld).getzielturm(),((Spielfeld)spielfeld).getanzahlSteine());
           
        }
    }
}
