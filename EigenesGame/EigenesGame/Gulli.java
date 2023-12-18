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
   public static int Ort2 = 420;
    
   static int X;
   static int Y;
  
    static boolean HerrHeimann = false;
    static boolean Sommergesprochen = false;
    
    int Heimann;
    int Schickertkreideholen;
    boolean Schickertkreide = false;
    static boolean Schickertreden = false; 
       
    static boolean KreideInv = false;
    static boolean KöhlerQuest = false;
    static boolean KöhlerAngesprochen = false;
     static boolean Kreideholen= false;
    
   String Spieler = "Gulli";
  
   
 
   public int Xsetter(){
     return X;
    }
   public int Ysetter(){
     return Y;
    }
   
    public static boolean HerrHeimannOHP() {
      return new HerrHeimann().HerrHeimannOHP();
     }  
      
   
     public static int Ort2() {
      return new Turm420().Ortsetter();
     }  
     public static int Ort3() {
      return new Turm410().Ortsetter();
     } 
 
      public static int Sommer() {
      return new Computerraum().Sommer();
     }  
     // Sommer = 1; -> true
     public static int Sommergesprochen() {
      return new HerrSommer().Sommergesprochen();
     } 
     
    /**
     * Act - do whatever the Gulli wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    { 
       
       /**
        * Um Heimann Quest Temporär zurück zusetzen
        */
       System.out.println(Schickertreden);
       
      
        
        
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
     * HerrHeimann Quest
     */
    if(Heimann ==1){
     setLocation(12,14); 
     Heimann = 0;
      getWorld().removeObjects(getWorld().getObjects(OHP.class));
      getWorld().addObject(new OHP(), 11, 14);
      
   }    
   if(Ort2 ==420){
    if(HerrHeimann == true){
    getWorld().addObject(new OHP(), 11, 14);
    }
    else
    {
    getWorld().addObject(new OHP(), 11, 3);
    }
     }
       if(HerrHeimannOHP()== true){
        
          HerrHeimann = true;
        } 
     
     /**
      * Herr Köhler Quest
      * 
      */  
     if(Ort2 == 310){
        if(KreideInv == true){
            getWorld().removeObjects(getWorld().getObjects(Kreide.class));
            if(this.isTouching(HerrKöhler.class)){
            
           }
            getWorld().removeObjects(getWorld().getObjects(Herrköhler.class));
     }
        if(KöhlerAngesprochen == true){ 
         if(KöhlerQuest== false){
         if(X ==8 && Y ==2){
        
           getWorld().addObject(new Herrköhler(), 12, 7);
        }
        else
        {
          getWorld().removeObjects(getWorld().getObjects(Herrköhler.class));
            
        }
      }
     }
    }
      /**
       * Schickertkriedeholen
       */ 
       if(Schickertkreide ==true){
     setLocation(8,2); 
     Schickertkreide = false;
    }
     /** 
         * Weltenwechsel
         * 
         * Treppen
         */
        
        /**
         * Sommerminigame
         */
        if(Sommergesprochen()==1){
        Minigame();
        }
        /**Turm4
         * 
         */
         if(this.isTouching(Treppe420zu410.class)){
         Greenfoot.setWorld(new Turm410());
         Ort2 = 410;
        }
         if(this.isTouching(Treppe410zu420.class)){
             
             
             Greenfoot.setWorld(new Turm420());
         
            Ort2 = 420;
             
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
          Ort2 = 310;
          
        }
        if(this.isTouching(Treppe310zuE.class)){
          Greenfoot.setWorld(new Erdgeschoss4());
          Ort2 = 0;
          
        }
        if(this.isTouching(Treppe310zu320.class)){
          Greenfoot.setWorld(new Turm320());
          Ort2 = 0;
          
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
       
        if(HerrHeimann == false){
            if(this.isTouching(HerrHeimann.class)){
             
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Herr.Heimann:");
            anzeige.anzeigenL2( "Hallo " + Spieler + " hol mal bitte den OHP aus Raum 424 ");
            anzeige.anzeigenL3( "gegenüber" );
        }
    }
    else
    {
       getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Herr.Heimann:");
            anzeige.anzeigenL2( "Hallo " + Spieler + ", ich habe momentan keine Aufgabe für dich.");
            anzeige.anzeigenL3( "kümmere dich erstmal um deine Hausaufgaben." );
            
    }
        if(KreideInv == false){
        if(this.isTouching(HerrSchickert.class)){
             
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Herr.Schickert:");
            anzeige.anzeigenL1( " EY " + Spieler + " spiel doch mal den Erklärbär ");
        
        }
    }
    else
    {
       
        
            if(Schickertreden == false){
        
          getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Herr.Schickert:");
            anzeige.anzeigenL2( " EY " + Spieler + " wer hat denn meine  ");
            anzeige.anzeigenL3( " Kreide geklaut?!... Könntest du mir neue Besorgen? ");
            anzeige.anzeigenL4( " Da könnte noch etwas in einem anderen Raum liegen ");
        }
        else
        {
        
           getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Herr.Schickert:");
            anzeige.anzeigenL2( " So " + Spieler + " Jetzt hast du ja Kreide in der Hand.");
            anzeige.anzeigenL3( "  Jetzt erklär dochmal der Klasse diese Aufgabe von der  ");
            anzeige.anzeigenL4( " ich genau weis, dass du sie nicht kannst und dass ");
            anzeige.anzeigenL5( " ich sie dir extra schlecht erklärt habe. Achja  "  );
            anzeige.anzeigenL6( "und vor dem Kurs sollst du dich ja auchnoch blamieren");
        }
    }
   
        if(KreideInv == false){
         if(this.isTouching(HerrKöhler.class)){
            KöhlerAngesprochen = true;
            getWorld().addObject(anzeige, 4, 12); 
            
            anzeige.anzeigenL1(" Herr.Köhler:");
            anzeige.anzeigenL2( "Hallo " + Spieler + " dieser Schickert ne? Der hat meinen ");
            anzeige.anzeigenL3( "Unterricht letztens 10 mal gestört... Wenn du ihm seine   " );
            anzeige.anzeigenL4( "'Männerkreide' klaust könnte man ihm eins Auswischen.     " );
            anzeige.anzeigenL5( " Was meinst du? Tipp: Er befindet sich in Raum 313.   " );
        }
       }
       if(KreideInv == true)
       {
           if(this.isTouching(HerrKöhler.class)){
                getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Herr.Köhler:");
            anzeige.anzeigenL2( "Danke " + Spieler + " !");
            
        }
       }
        
       if(this.isTouching(HerrSommer.class)){
             
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Herr.Sommer:");
            anzeige.anzeigenL2( Spieler+Spieler+Spieler+Spieler+" Aufgaben machen..." );
            anzeige.anzeigenL3( "String Char Intenger SwitchCase Schleifen GREENFOOT" );
            anzeige.anzeigenL4( "Was?! Hast du die Aufgaben noch nicht vertig???" );
            
            Sommergesprochen = true;
        }
        
        
        if(!this.isTouching(Personen.class)||!this.isTouching(Personen.class)){     
            getWorld().removeObject(anzeige); // Um Anzeige zu entfernen
        }
        
          
         /*
         * Schilder/Objekte
         */ 
        if(this.isTouching(Raum421.class)){     
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Raum: 421");
        }
        if(this.isTouching(Raum424.class)){     
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Raum: 424");
        }
        if(this.isTouching(Raum421.class)){     
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Raum: 414");
        }
        if(this.isTouching(Raum313.class)){     
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" Raum: 313");
        }
        if(this.isTouching(OHP.class)){     
            getWorld().addObject(anzeige, 4, 12); 
            anzeige.anzeigenL1(" OHP");
             if(HerrHeimann == false){
            getWorld().addObject(new OHPHeimann(), 12, 7);
        }
        }
        else
        {
          getWorld().removeObjects(getWorld().getObjects(OHPHeimann.class));
            
        }
          
        
        
        
        
        while(Schickertkreideholen == 1){
          setLocation(8, 2);
          Schickertkreideholen =0;
        
        }   
         if(Ort2 == 310){
             if(KreideInv == true){
        if(Kreideholen == false){
              
            if(getX() == 11 && getY() == 12){
                  getWorld().addObject(new SchickertKreide(), 12, 7);
                  Schickertkreideholen = 0;
                }
            else
        {
          getWorld().removeObjects(getWorld().getObjects(SchickertKreide.class));
            
            
        }
        }
    }
    }
    
    
    
    
    
 }
 public void Minigame(){
    System.out.println("mimimim");
    
    // getWorld().addObject(new Makierung(), getX(), getY());
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
    class OHPHeimann extends Actor 
    {
        GreenfootImage bild;
     
        public void act(){
        if(Greenfoot.mouseClicked(this)){
         
         
            
            Ort2 =410;
          
            Heimann =1; 
         
        
       }
       else
       {
        Heimann = 0;
        
        }
     }
      public OHPHeimann()
        {
          bild = getImage();
          setImage("images/OHPHeimann.png");

        }
    }
    class Herrköhler extends Actor 
    {
        GreenfootImage bild;
     
        public void act(){
        if(Greenfoot.mouseClicked(this)){
         
         
            KreideInv = true;
           
            KöhlerQuest = true;            
         
        
       }
       
     }
      public Herrköhler()
        {
          bild = getImage();
          setImage("images/Kreideklauen.png");

        }
    }
    class SchickertKreide extends Actor 
    {
        GreenfootImage bild;
     
        public void act(){
        if(Greenfoot.mouseClicked(this)){
         
         
            Schickertkreideholen = 1;          
            getWorld().removeObjects(getWorld().getObjects(Kreide2.class));
            Schickertreden = true; 
       }
       
     }
      public SchickertKreide()
        {
          bild = getImage();
          setImage("images/Kreideschickert.png");

        }
    }
 
 
 
 
 
 
 
 
 
 

 
 
 
 
 
 
 
 
}

    

