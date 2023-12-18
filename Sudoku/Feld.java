import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Feld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Feld extends Actor
{
    /**
     * Act - do whatever the Feld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean nummerset;
    private int Nummer;

    private int X; 
    private int Y; 

    private MyWorld Welt;

    public Feld(int pX, int pY, World pWelt){
        X = pX;
        Y = pY;
        Welt = (MyWorld)pWelt;
    }

    public int getNummer(){
        return Nummer;
    }

    public void entferneNummer(){
        this.getImage().clear();
        this.setImage("images/Feld.png");
        Nummer = 0;
        nummerset = false;
    }

    public void setNummer(int pNummer){ 
        if(!nummerset){
            if( pNummer > 0 && pNummer < 10){
                if(Welt.Nummermoeglich(pNummer, X, Y)){
                    Nummer = pNummer;
                    this.getImage().clear();
                    this.setImage("images/Feld.png");
                    this.getImage().drawImage(new GreenfootImage(Integer.toString(Nummer), 30, Color.BLACK, new Color(0, 0, 0, 0)),this.getImage().getWidth()/2-6,this.getImage().getHeight()/2-15);
                    nummerset = true;
                }
                else{
                    Welt.fehler();
                }
            }
        }
    }

    public void setNummerohnefehler(int pNummer){ 
        if(!nummerset){
            if( pNummer > 0 && pNummer < 10){
                if(Welt.Nummermoeglich(pNummer, X, Y)){
                    Nummer = pNummer;
                    this.getImage().clear();
                    this.setImage("images/Feld.png");
                    this.getImage().drawImage(new GreenfootImage(Integer.toString(Nummer), 30, Color.BLACK, new Color(0, 0, 0, 0)),this.getImage().getWidth()/2-6,this.getImage().getHeight()/2-15);
                    nummerset = true;
                }
            }
        }
    }

    public void act()
    {        
        if(!nummerset){
            if(Greenfoot.mouseClicked(this)){
                setNummer(Integer.valueOf(JOptionPane.showInputDialog("Nummer zwischen 1 und 9")));
            }
        }
    }
}
