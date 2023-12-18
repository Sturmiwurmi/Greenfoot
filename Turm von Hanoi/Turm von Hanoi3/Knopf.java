import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Knopf extends Actor
{
    private char X1;
    private char X2;    
    private World Spielfeld;
    private boolean sortierknopf;
    
    private String Testsrting = "test";
    public Knopf(char x1, char x2,World pSpielfeld){
        X1 = x1;
        X2 = x2;
        if(X1 == '/' && X2 == '/'){        
        sortierknopf = true;
        }
        if(!sortierknopf){
        this.getImage().drawImage(new GreenfootImage(Character.toString(X1)+" zu "+Character.toString(X2), 25, Color.BLACK, new Color(0, 0, 0, 0)),this.getImage().getWidth()/2-28,this.getImage().getHeight()/2-10);
        }
        else{
        this.getImage().drawImage(new GreenfootImage("sortieren", 25, Color.BLACK, new Color(0, 0, 0, 0)),this.getImage().getWidth()/2-42,this.getImage().getHeight()/2-10);
                }
        Spielfeld = pSpielfeld;
    }

    
    public void act(){
        if(Greenfoot.mouseClicked(this)&& !sortierknopf){
            ((Spielfeld)Spielfeld).XzuX(X1, X2);
        }   
        else if(Greenfoot.mouseClicked(this) && sortierknopf){        
           
            ((Spielfeld)Spielfeld).sortieren('A','C',((Spielfeld)Spielfeld).getanzahlSteine());
        }
    }
}
