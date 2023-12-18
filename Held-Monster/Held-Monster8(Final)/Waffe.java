import greenfoot.*; 
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
                bonus = magie+4;
                break;

            case "Eisen":
                bonus = magie+6;
                break;

            case "Diamant":
                bonus = magie+12;
                break; 

            default:
                bonus = magie;
        }
        return bonus;
    }
}
