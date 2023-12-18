import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Computerraum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computerraum extends World
{
     static int Sommer = 0; 
    public static int X() {
      return new Gulli().Xsetter();
     } 
      public static int Y() {
      return new Gulli().Ysetter();
     } 
     public int Sommer(){
     return Sommer;
    }
    public static int Sommergesprochen() {
      return new HerrSommer().Sommergesprochen();
     } 
    private static int zellenGroesse = 50;
    /**
     * Constructor for objects of class Erdgeschoss4.
     * 
     */
    public Computerraum()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(21, 17, zellenGroesse);
        setBackground("images/Teppich.png");
        setPaintOrder(String.class, Rover.class, Marke.class, Gestein.class, Huegel.class);
        Greenfoot.setSpeed(35);
        prepare();
        this.addObject(new Gulli(), 18, 15);
        this.addObject(new HerrSommer(), 16, 1);
        
    }
    public void act(){
    
      if(Y() == 16 && X() == 20){
            Greenfoot.setWorld(new Turm210());
        }
        
      if(Y() == 15 && X() == 20){
            Greenfoot.setWorld(new Turm210());
        }
        
      if(Y() == 14 && X() == 20){
            Greenfoot.setWorld(new Turm210());
        }
       
        if(Y() == 16 && X() == 0){
            Greenfoot.setWorld(new Mogelpalast());
        }
        
      if(Y() == 15 && X() == 0){
            Greenfoot.setWorld(new Mogelpalast());
        }
        
      if(Y() == 14 && X() == 0){
            Greenfoot.setWorld(new Mogelpalast());
        }
        System.out.println(Y()); 
        System.out.println(X()); 
      if(Y() == 4 && X() == 15){
             if(Sommergesprochen()==1){
            Sommer = 1; 
           } 
        }
        if(Y() == 4 && X() == 16){
            if(Sommergesprochen()==1){
            Sommer = 1; 
           }
        }
        if(Y() == 4 && X() == 17){
            if(Sommergesprochen()==1){
            Sommer = 1; 
           } 
        }
        if(Y() == 4 && X() == 18){
            if(Sommergesprochen()==1){
            Sommer = 1; 
           }
        }
        if(Y() == 4 && X() == 19){
             if(Sommergesprochen()==1){
            Sommer = 1; 
           }
        }
        if(Y() == 4 && X() == 20){
            if(Sommergesprochen()==1){
            Sommer = 1; 
           }
        }
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        PCTisch pCTisch = new PCTisch();
        addObject(pCTisch,11,0);
        PCTisch pCTisch2 = new PCTisch();
        addObject(pCTisch2,11,1);
        PCTisch pCTisch3 = new PCTisch();
        addObject(pCTisch3,11,3);
        PCTisch pCTisch4 = new PCTisch();
        addObject(pCTisch4,11,4);
        PCTisch pCTisch5 = new PCTisch();
        addObject(pCTisch5,11,6);
        PCTisch pCTisch6 = new PCTisch();
        addObject(pCTisch6,11,7);
        PCTisch pCTisch7 = new PCTisch();
        addObject(pCTisch7,11,9);
        PCTisch pCTisch8 = new PCTisch();
        addObject(pCTisch8,11,10);
        PCTisch pCTisch9 = new PCTisch();
        addObject(pCTisch9,11,12);
        TischPC tischPC = new TischPC();
        addObject(tischPC,11,11);
        TischPC tischPC2 = new TischPC();
        addObject(tischPC2,11,8);
        TischPC tischPC3 = new TischPC();
        addObject(tischPC3,11,5);
        TischPC tischPC4 = new TischPC();
        addObject(tischPC4,11,2);
        TischPC tischPC5 = new TischPC();
        addObject(tischPC5,8,2);
        TischPC tischPC6 = new TischPC();
        addObject(tischPC6,8,5);
        TischPC tischPC7 = new TischPC();
        addObject(tischPC7,8,8);
        TischPC tischPC8 = new TischPC();
        addObject(tischPC8,8,11);
        TischPC tischPC9 = new TischPC();
        addObject(tischPC9,5,11);
        TischPC tischPC10 = new TischPC();
        addObject(tischPC10,5,8);
        TischPC tischPC11 = new TischPC();
        addObject(tischPC11,5,5);
        TischPC tischPC12 = new TischPC();
        addObject(tischPC12,5,2);
        TischPC tischPC13 = new TischPC();
        addObject(tischPC13,2,2);
        TischPC tischPC14 = new TischPC();
        addObject(tischPC14,2,5);
        TischPC tischPC15 = new TischPC();
        addObject(tischPC15,2,8);
        TischPC tischPC16 = new TischPC();
        addObject(tischPC16,2,11);
        PCTisch pCTisch10 = new PCTisch();
        addObject(pCTisch10,8,12);
        PCTisch pCTisch11 = new PCTisch();
        addObject(pCTisch11,5,12);
        PCTisch pCTisch12 = new PCTisch();
        addObject(pCTisch12,2,12);
        PCTisch pCTisch13 = new PCTisch();
        addObject(pCTisch13,2,10);
        PCTisch pCTisch14 = new PCTisch();
        addObject(pCTisch14,2,9);
        PCTisch pCTisch15 = new PCTisch();
        addObject(pCTisch15,2,7);
        PCTisch pCTisch16 = new PCTisch();
        addObject(pCTisch16,2,6);
        PCTisch pCTisch17 = new PCTisch();
        addObject(pCTisch17,2,4);
        PCTisch pCTisch18 = new PCTisch();
        addObject(pCTisch18,2,3);
        PCTisch pCTisch19 = new PCTisch();
        addObject(pCTisch19,5,3);
        PCTisch pCTisch20 = new PCTisch();
        addObject(pCTisch20,5,4);
        PCTisch pCTisch21 = new PCTisch();
        addObject(pCTisch21,5,6);
        PCTisch pCTisch22 = new PCTisch();
        addObject(pCTisch22,5,7);
        PCTisch pCTisch23 = new PCTisch();
        addObject(pCTisch23,5,9);
        PCTisch pCTisch24 = new PCTisch();
        addObject(pCTisch24,5,10);
        PCTisch pCTisch25 = new PCTisch();
        addObject(pCTisch25,8,10);
        PCTisch pCTisch26 = new PCTisch();
        addObject(pCTisch26,8,9);
        PCTisch pCTisch27 = new PCTisch();
        addObject(pCTisch27,8,7);
        PCTisch pCTisch28 = new PCTisch();
        addObject(pCTisch28,8,6);
        PCTisch pCTisch29 = new PCTisch();
        addObject(pCTisch29,8,4);
        PCTisch pCTisch30 = new PCTisch();
        addObject(pCTisch30,8,3);
        PCTisch pCTisch31 = new PCTisch();
        addObject(pCTisch31,8,1);
        PCTisch pCTisch32 = new PCTisch();
        addObject(pCTisch32,8,0);
        PCTisch pCTisch33 = new PCTisch();
        addObject(pCTisch33,5,0);
        PCTisch pCTisch34 = new PCTisch();
        addObject(pCTisch34,5,1);
        PCTisch pCTisch35 = new PCTisch();
        addObject(pCTisch35,2,1);
        PCTisch pCTisch36 = new PCTisch();
        addObject(pCTisch36,2,0);
        PCTisch pCTisch37 = new PCTisch();
        addObject(pCTisch37,11,13);
        PCTisch pCTisch38 = new PCTisch();
        addObject(pCTisch38,8,13);
        PCTisch pCTisch39 = new PCTisch();
        addObject(pCTisch39,5,13);
        PCTisch pCTisch40 = new PCTisch();
        addObject(pCTisch40,2,13);
        PCTisch pCTisch41 = new PCTisch();
        addObject(pCTisch41,15,0);
        TischPC tischPC17 = new TischPC();
        addObject(tischPC17,15,1);
        PCTisch pCTisch42 = new PCTisch();
        addObject(pCTisch42,15,2);
        tischPC17.turn(180);
        pCTisch42.turn(180);
        pCTisch41.turn(180);
    }
}
