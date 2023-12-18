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
        
        Greenfoot.delay(1);
    }
    public void bubbleSort(){

        int n =Saeulen.length; 
        Saeule temp;;

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){ 
                if(Saeulen[j-1].getZahl() >Saeulen[j].getZahl()){
                    //swap elements 
                    tauschesauele(j-1,j);
                   
                }

            }
        }

    }
}
