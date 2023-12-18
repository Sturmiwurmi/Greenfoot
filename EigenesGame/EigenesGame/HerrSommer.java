import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HerrSommer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HerrSommer extends Personen
{
    static int Sommergesprochen = 0;
    boolean Gulligesprochen=false;
    static int Gefangen = 0;
    /**
     * Act - do whatever the HerrSommer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int Sommer() {
      return new Computerraum().Sommer();
     }  
     public int Sommergesprochen(){
     return Sommergesprochen;
    }
    public static int X() {
      return new Gulli().Xsetter();
     } 
      public static int Y() {
      return new Gulli().Ysetter();
     } 
     // Sommer = 1; -> true
    public void act()
    {
      /**  if(Gefangen == 1){
        System.out.println("ALAAAAAAAAAAAARM");
    }
    */
           if(this.isTouching(Gulli.class)){
            Gulligesprochen=true;
            Sommergesprochen =1;
            } 
            if(Gulligesprochen == true){
              if(Sommer()==1){
               setImage("images/SommerAxt.png");
               setLocation(X(), Y());
               
              if(this.isTouching(Gulli.class)){
                System.out.println("ALAAAAAAAAAAAARM");
                }
               
               /**
                * removeTouching(Makierung.class);
                if(this.getOneObjectAtOffset(0, -1,Makierung.class)!= null){
                setLocation(getX(), getY()-1);
                
                
                }
                if(this.getOneObjectAtOffset(0, 1,Makierung.class)!= null){
                setLocation(getX(), getY()+1);
                
                
                }
                
                if(this.getOneObjectAtOffset(-1, 0,Makierung.class)!= null){
                setLocation(getX()-1, getY());
                
                
                }
                
                if(this.getOneObjectAtOffset(1, 0,Makierung.class)!= null){
                setLocation(getX()+1, getY());
                
                
                }
                */
                
                }
            }
    }
}
