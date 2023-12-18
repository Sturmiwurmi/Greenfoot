import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import java.util.Collections;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //bis 28 Felder
    private int Schichten = 28; 
    private List<Feld[]> Y = new ArrayList<Feld[]>();
    public MyWorld()
    {    

        super(1150, 800, 1); 

        for(int i = 0; i<Schichten;i++){
            Y.add(i,new Feld[i+1]);
        }
        for(int i = 0; i<Y.size();i++){
            Y.get(i)[0] = new Feld(1);

            getDreieckXY(0,i).setSchicht(i); 
            getDreieckXY(0,i).setSchichtX(0);

            Y.get(i)[Y.get(i).length-1] = new Feld(1);
            getDreieckXY(Y.get(i).length-1,i).setSchicht(i);
            getDreieckXY(0,i).setSchichtX(Y.get(i).length-1);
        }
        for(int i = 0; i<Y.size();i++){
            for(int b = 0; b<Y.get(i).length; b++){
                if(Y.get(i)[b]== null){  

                    int yminus1= i-1;


                    Y.get(i)[b] = new Feld(getDreieckXY(b, yminus1).getZahl()+getDreieckXY(b-1, yminus1).getZahl());

                    
                    getDreieckXY(b,i).setSchicht(i); 
                    getDreieckXY(b,i).setSchichtX(b);
                } 
            }
        }

        Dreieckmalen();
    }

    public void Dreieckmalen(){

        int XX = this.getWidth()/2; // getWidth()/2 -> Startwert /immer +Feldbreite in Pixeln 
        int YY = 22; // 22 -> Startwert/  immer +28 (28 = ausprobiert)

        int XXX = this.getWidth()/2; // ist die X-Position der Fläche, die auf der jeweils linken Seite ist 

        for(int i = 0; i<Y.size();i++){
            for(int b = 0; b<Y.get(i).length; b++){                
                addObject(getDreieckXY(b,i),XX,YY);
                XX +=getDreieckXY(0,0).getImage().getWidth(); // +Feldbreite in Pixeln
            }
            XXX -=getDreieckXY(0,0).getImage().getWidth()/2; // hälfte der Feldbreite in Pixeln 
            XX= XXX;
            YY +=28;
        }

    }

    public Feld getDreieckXY(int x, int y){
        if(x>=Y.get(y).length || x<0){
            return null;
        }
        return Y.get(y)[x];
    }

    public int berechnerekursiv(int k, int n){
        int ergebnis = 0;
        if(getDreieckXY(k,n).getZahl() == 1){
            ergebnis = 1;

        }else{        
            ergebnis = berechnerekursiv(k,n-1)+berechnerekursiv(k-1,n-1);          

        }
        return ergebnis;
    }

    public int berechnerekursivallgemein(int k, int n){
        int ergebnis = 0;       
        if(k == 0 || k == n){
            ergebnis = 1;            
        }else{        
            ergebnis = berechnerekursivallgemein(k,n-1)+berechnerekursivallgemein(k-1,n-1);         
        }
        return ergebnis;
    }

    public int Fakultaet(int n){// Integer zu groß für n = 13
        int Ergebniss = 1;
        if(n>0){
            Ergebniss = Fakultaet(n-1)*n;    
        }
        return Ergebniss;
    }

    public int formel(int k, int n){// Integer zu groß für n = 13
        int ergebnis = 0;

        ergebnis = Fakultaet(n)/(Fakultaet(k)*Fakultaet(n-k));

        return ergebnis;    
    }

    public void test(){// Integer zu groß für n = 13
        for(int n = 0; n<Y.size(); n++){
            for(int k = 0;k<Y.get(n).length;k++){
                if(berechnerekursivallgemein(k,n) == formel(k,n)){
                    System.out.println(n +"/"+k+"= TRUE");
                }
                else
                {
                    System.out.println(n +"/"+k+"= FALSE");    
                    System.out.println("FALSE");
                    Greenfoot.delay(1000);
                }
            }
        }      
    }
}
