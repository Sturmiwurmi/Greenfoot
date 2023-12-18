import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   private  String name; 
   private  int staerke;
   private  int lebenspunkte; 
   private boolean monsterlebt;
    
    
     public Monster(String pName, int pStaerke, int pLebenspunkte, boolean pMonsterlebt){
        name = pName; 
        staerke = pStaerke; 
        lebenspunkte =pLebenspunkte; 
        monsterlebt = pMonsterlebt; 
        }
}
