import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HerrHeimann here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HerrHeimann extends Personen
{
    static boolean HerrHeimannOHP = false;
    public boolean HerrHeimannOHP(){
     return HerrHeimannOHP;
    }
    /**
     * Act - do whatever the HerrHeimann wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    if(this.getOneObjectAtOffset(0, 1, OHP.class)!=null){
     HerrHeimannOHP = true;
    
    
    }
}
}
