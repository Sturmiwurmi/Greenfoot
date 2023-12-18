import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Turm extends Actor
{
    
      
     private Stack<Stein> Steinstapel = new Stack<Stein>();
     int Ywert = 570; // y = 590-yZähler für anzahlSteine = 100
    public void act()
    {
       
    }
    public Stack<Stein> getSteinstapel(){
    return Steinstapel;
    }
    
}
