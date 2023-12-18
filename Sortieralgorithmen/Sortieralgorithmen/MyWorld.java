import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private Saeule[] Saeulen; 
    Random random = new Random();
    public MyWorld()
    {

        super(1000, 800, 1); 
        Saeulen = new Saeule[this.getWidth()/31];
        System.out.println(this.getWidth()/31);
        System.out.println(Saeulen.length);

        for(int i = 0; i<Saeulen.length;i++){
            Saeulen[i] = new Saeule(random.nextInt(79));
            this.addObject(Saeulen[i], 31*i+15, 800);
        }
    }

    public void tauschesauele(int pvonIndex, int pnachIndex){
        int XKoordinatevon = Saeulen[pvonIndex].getX();
        int XKoordinatenach = Saeulen[pnachIndex].getX();

        Saeulen[pvonIndex].setLocation(XKoordinatenach, Saeulen[pvonIndex].getY()); //Positionstausch 
        Saeulen[pnachIndex].setLocation(XKoordinatevon, Saeulen[pnachIndex].getY());

        Saeule temp = Saeulen[pvonIndex]; //tausch in der Datenstruktur 
        Saeulen[pvonIndex] = Saeulen[pnachIndex];
        Saeulen[pnachIndex] = temp;
    }
}
     