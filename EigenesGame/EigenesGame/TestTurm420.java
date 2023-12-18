import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TestTurm420 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestTurm420 extends World
{
    private static int zellenGroesse = 50;
    /**
     * Constructor for objects of class TestTurm420.
     * 
     */
    public TestTurm420()
    {    
        
         super(20, 15, zellenGroesse);
        setBackground("images/Schuleboden.png");
        setPaintOrder(String.class, Rover.class, Marke.class, Gestein.class, Huegel.class);
        Greenfoot.setSpeed(35);
 
        DrawMap420();
    }
    
    public void Reset(){
    removeObjects(this.getObjects(WaendeHindernisse.class));
    removeObjects(this.getObjects(Möbel.class));
    removeObjects(this.getObjects(Personen.class));
    removeObjects(this.getObjects(Schilder.class));   
    removeObjects(this.getObjects(Treppe.class)); 
    }
    public void DrawMap420(){
        
         //https://www.youtube.com/watch?v=XiX959mRkaw
         String[] Turm420 = {
         "---------LR---------",
         "-T-T-T---LR---t-t-t-",
         "---------LR---------",
         "-T-T-T---LR---t-t-t-",
         "xxxxxx-xxmnxx-xxxxxx",
         "XXXXXX-XXXXXX-XXXXXX",
         "--------------------",
         "-------------------r",
         "--------------------",
         "xxxxxx-xxxxxx-Sxxxxx",
         "XXXXXX-XXbvXX-XXXXXX",
         "---------LR---------",
         "-T-T-T---aA---t-t-t-",
         "---------LR1--------",
         "-T-T-T---LR---t-t-t-",
          };
         for (int i = 0; i < Turm420.length; i++) {
             String mapLine = Turm420[i];
             for(int j = 0; j<mapLine.length(); j=+2){
                char mapChar = mapLine.charAt(j);
                int y = i;
                int x = j;
                switch(mapChar){
                 case 'X':
                    addObject(new WandO(), x, y);
                    break;
                 case 'x':
                    addObject(new WandU(), x, y);
                    break;
                 case 'R':
                    addObject(new WandR(), x, y);
                    break; 
                 case 'L':
                    addObject(new WandL(), x, y);
                    break; 
                case 'm':
                    addObject(new EckeOL(), x, y);
                    break; 
                case 'n':
                    addObject(new EckeOR(), x, y);
                    break;
                case 'b':
                    addObject(new EckeUL(), x, y);
                    break;
                case 'v':
                    addObject(new EckeUR(), x, y);
                    break;
                case 'T':
                    addObject(new Tisch(), x, y);
                    break;
                case 't':
                    addObject(new Tisch2(), x, y);
                    break;
                case '1':
                    addObject(new HerrHeimann(), x, y);
                    break;
                case '2':
                    addObject(new HerrSchickert(), x, y);
                    break;
                case 'r':
                    addObject(new Treppe(), x, y);
                    break;
                case 'A':
                    
                    addObject(new WandR(), x, y);
                    addObject(new Tafel2(), x, y);
                    
                    break; 
                    case 'a':
                    addObject(new WandL(), x, y);
                    addObject(new Tafel(), x, y);
                    
                    break; 
                case 'S':
                    addObject(new WandU(), x, y);
                    addObject(new Raum421(), x, y);
                    
                    break;
                 case '-':  
                    break; 
                
                }
                }
        }
        
        
    }
}
