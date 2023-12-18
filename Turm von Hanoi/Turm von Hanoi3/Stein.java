import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Stein extends Actor
{
   
    private int Nummer; 
    
    public Stein(int pNummer)
    {
      Nummer = pNummer; 
      
       // this.getImage().drawImage(new GreenfootImage(Integer. toString(Nummer), 25, Color.BLACK, new Color(0, 0, 0, 0)),this.getImage().getWidth()/2-5,this.getImage().getHeight()/2-10);
        scale(Nummer*20,40); // x = Nummer*2 y = 4 für Anzahlsteine = 100
         this.getImage().drawImage(new GreenfootImage(Integer. toString(Nummer), 25, Color.BLACK, new Color(0, 0, 0, 0)),this.getImage().getWidth()/2-5,this.getImage().getHeight()/2-10);
     
    }
    public void act(){     
    }
    
    public int getNummer(){return Nummer;}
    
    public void scale(int x, int y){    
    this.getImage().scale(x, y);
    } 
   
}
