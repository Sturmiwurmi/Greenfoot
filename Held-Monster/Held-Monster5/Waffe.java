import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Waffe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Waffe extends Actor
{
    private int bonus;
    private String Material;
    private int magie;
    
    public Waffe(String pMaterial, int pMagie){
    Material = pMaterial;
    magie = pMagie;
    }
    
    public int Bonus(){
        switch(Material){
        case "Holz":
            bonus = magie+2;
            break;
        
        case "Eisen":
            bonus = magie+4;
            break;
            
        case "Diamant":
            bonus = magie+10;
            break; 
            
        default:
            bonus = magie;
        }
        
        return bonus;
    }
}
