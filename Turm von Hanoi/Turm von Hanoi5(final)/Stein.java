import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Stein extends Actor
{

    private int Nummer; 

    public Stein(int pNummer)
    {
        Nummer = pNummer;       
        this.getImage().scale(Nummer*20,40); // um die Steine in verschiedene Größen zu bringen
        this.getImage().drawImage(new GreenfootImage(Integer. toString(Nummer), 25, Color.BLACK, new Color(0, 0, 0, 0)),this.getImage().getWidth()/2-5,this.getImage().getHeight()/2-10); // um die Nummer des Steins in die Mitte von ihm zu malen
    }  

    public int getNummer(){
        return Nummer;
    }

}
