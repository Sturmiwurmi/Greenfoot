import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WändeHindernisse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaendeHindernisse extends Actor
{
    private int steigung;
    /**
     * Act - do whatever the WändeHindernisse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        steigung = Greenfoot.getRandomNumber(30)+31;
    }
}
