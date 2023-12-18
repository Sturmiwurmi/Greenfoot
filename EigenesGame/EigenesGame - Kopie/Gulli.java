import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gulli here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Gulli extends Actor
{
   public int Ort;
   
      public static int Ort2() {
      return new Turm420().Ortsetter();
     }  
     
     public static int Ort3() {
      return new Turm410().Ortsetter();
     } 

    /**
     * Act - do whatever the Gulli wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    { 
        /** 
         * Steuerung
         */
   if(this.getOneObjectAtOffset(1, 0, WaendeHindernisse.class)== null){
         if(Greenfoot.isKeyDown("d")){
         
         setLocation(getX()+1,getY()); 
         
        }
       }    
        if(this.getOneObjectAtOffset(-1, 0, WaendeHindernisse.class)== null){
          if(Greenfoot.isKeyDown("a")){
         
           setLocation(getX()-1,getY()); 
         
        
        }
    }
         if(this.getOneObjectAtOffset(0, -1, WaendeHindernisse.class)== null){
        if(Greenfoot.isKeyDown("w")){
         
           setLocation(getX(),getY()-1); 
         
        }
    }
       if(this.getOneObjectAtOffset(0, 1,WaendeHindernisse.class)== null){
        if(Greenfoot.isKeyDown("s")){
            
           setLocation(getX(),getY()+1); 
         
        }
    }
    
    
        /** 
         * Wandprüfung
         */
      
        /** 
         * Weltenwechsel
         * 
         * Treppen
         */
        /**Turm4
         * 
         */
         if(this.isTouching(Treppe420zu410.class)){
         Greenfoot.setWorld(new Turm410());
        }
         if(this.isTouching(Treppe410zu420.class)){
         Greenfoot.setWorld(new Turm420());
        }
          if(this.isTouching(Treppe410zuE.class)){
          Greenfoot.setWorld(new Erdgeschoss4());
        }
         if(this.isTouching(TreppeEzu410.class)){
          Greenfoot.setWorld(new Turm410());
        }
        /**Turm3
         * 
         */     
        if(this.isTouching(TreppeEzu310.class)){
          Greenfoot.setWorld(new Turm310());
        }
        if(this.isTouching(Treppe310zuE.class)){
          Greenfoot.setWorld(new Erdgeschoss4());
        }
        if(this.isTouching(Treppe310zu320.class)){
          Greenfoot.setWorld(new Turm320());
        }
        if(this.isTouching(Treppe320zu310.class)){
          Greenfoot.setWorld(new Turm310());
        }
        /**Turm2
         * 
         */ 
        if(this.isTouching(TreppeEzu210.class)){
          Greenfoot.setWorld(new Turm210());
        }
        if(this.isTouching(Treppe210zuE.class)){
          Greenfoot.setWorld(new Erdgeschoss1u2());
        }
        if(this.isTouching(Treppe210zu220.class)){
          Greenfoot.setWorld(new Turm220());
        }
        if(this.isTouching(Treppe220zu210.class)){
          Greenfoot.setWorld(new Turm210());
        }
        /**Turm1
         * 
         */ 
        if(this.isTouching(TreppeEzu110.class)){
          Greenfoot.setWorld(new Turm110());
        }
        if(this.isTouching(Treppe110zuE.class)){
          Greenfoot.setWorld(new Erdgeschoss1u2());
        }
        if(this.isTouching(Treppe110zu120.class)){
          Greenfoot.setWorld(new Turm120());
        }
        if(this.isTouching(Treppe120zu110.class)){
          Greenfoot.setWorld(new Turm110());
        }
        
        
        
        
        /**
         * Dummys
         */
        if(this.isTouching(Dummy1.class)){
         Greenfoot.setWorld(new Haupteingang());
        }
        if(this.isTouching(Dummy2.class)){
         Greenfoot.setWorld(new Erdgeschoss4());
        }
       
        if(this.isTouching(Dummy3.class)){
         Greenfoot.setWorld(new Erdgeschoss1u2());
        }
        if(this.isTouching(Dummy4.class)){
         Greenfoot.setWorld(new Haupteingang());
        }
 }

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

 
 
 
 
 
 
 
 
 /**
     * Etagenwechsel in TURM4
     * für obere Etage    "3"
     * für mittlere Etage "2"
     * für Erdgeschoss    "1"
     * für Fahrradkeller  "0"
     */
     public void Etagenwechsel(String richtung)
    {
        if(richtung=="3")
        {
            Greenfoot.setWorld(new Turm420());
        }
        else if (richtung=="2")
        {
            Greenfoot.setWorld(new Turm410());
        }
        else if (richtung=="1")
        {
           // Greenfoot.setWorld(new Turm400());
        }
        else if (richtung=="0")
        {
           // Greenfoot.setWorld(new Fahrradkeller());
        }
        
    }
}

    

