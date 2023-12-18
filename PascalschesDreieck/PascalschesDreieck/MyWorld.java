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

                    //System.out.println("X/Y: "+ b +"/"+ i+" ist null");

                    Y.get(i)[b] = new Feld(getDreieckXY(b, yminus1).getZahl()+getDreieckXY(b-1, yminus1).getZahl());

                    getDreieckXY(b,i).setSchicht(i); 
                    getDreieckXY(b,i).setSchichtX(b);
                } 
            }
        }

        Dreieckmalen();
    }

    public Feld getDreieckXY(int x, int y){
        if(x>=Y.get(y).length || x<0){
            return null;
        }
        return Y.get(y)[x];
    }

    public void markeirerekursiv(int x, int y){

        if(getDreieckXY(x,y).getZahl() == 1){
            getDreieckXY(x,y).ausgewählt();
        }else{  
            markeirerekursiv(x-1,y-1);    
            markeirerekursiv(x,y-1); 
            getDreieckXY(x,y).ausgewählt();   
            System.out.println(getDreieckXY(x,y).getZahl()+" = "+ getDreieckXY(x,y-1).getZahl()+" + "+getDreieckXY(x-1,y-1).getZahl());
            
            Greenfoot.delay(1);
        }

    }

    public int berechnerekursiv(int x, int y){
        int ergebnis = 0;
        if(getDreieckXY(x,y).getZahl() == 1){
            ergebnis = getDreieckXY(x,y).getZahl();
            getDreieckXY(x,y).ausgewählt();
        }else{        
            ergebnis = berechnerekursiv(x,y-1)+berechnerekursiv(x-1,y-1);
             getDreieckXY(x,y).ausgewählt();
             System.out.println(ergebnis+" = "+ getDreieckXY(x,y-1).getZahl()+" + "+getDreieckXY(x-1,y-1).getZahl());
                       
        }
        return ergebnis;
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

    

}
