import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gulli here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Gulli extends Actor
{
  
    private Display anzeige;
   public int Ort;
    
   static int X;
   static int Y;
   
   String Spieler = "Gulli";
   
   public int Xsetter(){
     return X;
    }
    public int Ysetter(){
     return Y;
    }
  
   
   
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
     X=getX();
     Y=getY();
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
        
        
        
        
        
        
        /*
         * Personenansprechen
         */
            if(this.isTouching(HerrHeimann.class)){
             
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Herr.Heimann:");
            anzeige.anzeigenL1( "Hallo " + Spieler + " hol mal bitte den OHP aus Raum 424 ");
            anzeige.anzeigenL2( "gegenüber" );
        }
        
        if(this.isTouching(HerrSchickert.class)){
             
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Herr.Schickert:");
            anzeige.anzeigenL1( " EY " + Spieler + " spiel doch mal den Erklärbär ");
            
        }
        
        
        
        
        
        if(!this.isTouching(Personen.class)||!this.isTouching(Personen.class)){     
            getWorld().removeObject(anzeige); // Um Anzeige zu entfernen
        }
        
          
         /*
         * Schilder
         */ 
        if(this.isTouching(Raum421.class)){     
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Raum: 421");
        }
        if(this.isTouching(Raum424.class)){     
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Raum: 424");
        }
       
 }

 protected void addedToWorld(World world)
    {
 
        world = getWorld();
        anzeige = new Display();
        anzeige.setImage("images/Questdisplay.png");
        

    }
 
 class Display extends Actor
    {
        GreenfootImage bild; 

        public Display()
        {
          bild = getImage();
        }

         
        
        /* 
         * Zeilen
         * 
         */
        public void anzeigenL1(String pText)
        {
           loeschen();
           getImage().drawImage(new GreenfootImage(pText, 20, Color.RED, new Color(0, 0, 0, 0)),10,10);

        }
        public void anzeigenL2(String pText)
        {
           
           getImage().drawImage(new GreenfootImage(pText, 20, Color.RED, new Color(0, 0, 0, 0)),10,30);

        }
        public void anzeigenL3(String pText)
        {
           
           getImage().drawImage(new GreenfootImage(pText, 20, Color.RED, new Color(0, 0, 0, 0)),10,50);

        }
        public void anzeigenL4(String pText)
        {
           
           getImage().drawImage(new GreenfootImage(pText, 20, Color.RED, new Color(0, 0, 0, 0)),10,70);

        }
        public void anzeigenL5(String pText)
        {
           
           getImage().drawImage(new GreenfootImage(pText, 20, Color.RED, new Color(0, 0, 0, 0)),10,90);

        }
        public void anzeigenL6(String pText)
        {
           
           getImage().drawImage(new GreenfootImage(pText, 20, Color.RED, new Color(0, 0, 0, 0)),10,110);

        }
        public void anzeigenL7(String pText)
        {
           
           getImage().drawImage(new GreenfootImage(pText, 20, Color.RED, new Color(0, 0, 0, 0)),10,130);

        }
        public void anzeigenL8(String pText)
        {
           
           getImage().drawImage(new GreenfootImage(pText, 20, Color.RED, new Color(0, 0, 0, 0)),10,150);

        }
        public void anzeigenL9(String pText)
        {
           
           getImage().drawImage(new GreenfootImage(pText, 20, Color.RED, new Color(0, 0, 0, 0)),10,170);

        }
        

        public void loeschen()
        {
            getImage().clear();
            setImage("images/Questdisplay.png");
        }
       
        

    }
 
 
 
 
 
 
 
 
 
 
 
 

 
 
 
 
 
 
 
 
}

    

