import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die einzigen aktiven Akteure in der Roboterwelt sind die Roboter.
 * Die Welt besteht aus 14 * 10 Feldern.
 */

public class Turm410 extends World
{
    private static int zellenGroesse = 50;

    static int Ort = 410;

    public int Ortsetter(){
        return Ort;
    }

    /**
     * Erschaffe eine Welt mit 15 * 12 Zellen.
     */
    public Turm410()
    {
        super(20, 15, zellenGroesse);
        setBackground("images/Schuleboden.png");
        setPaintOrder(String.class, Rover.class, Marke.class, Gestein.class, Huegel.class);
        Greenfoot.setSpeed(35);

        
        this.addObject(new WandO(), 0, 5);
        this.addObject(new WandO(), 1, 5);
        this.addObject(new WandO(), 2, 5);
        this.addObject(new WandO(), 3, 5);
        this.addObject(new WandO(), 4, 5);
        this.addObject(new WandO(), 5, 5);

        this.addObject(new Treppe410zu420(), 19, 6);

        this.addObject(new Treppe410zuE(), 19, 8);

        this.addObject(new WandO(), 7, 5);
        this.addObject(new WandO(), 8, 5);
        this.addObject(new WandO(), 9, 5);
        this.addObject(new WandO(), 10, 5);
        this.addObject(new WandO(), 11, 5);
        this.addObject(new WandO(), 12, 5);
        
        this.addObject(new WandO(), 14, 5);
        this.addObject(new WandO(), 15, 5);
        this.addObject(new WandO(), 16, 5);

        this.addObject(new WandO(), 18, 5);
        this.addObject(new WandO(), 19, 5);

        this.addObject(new WandU(), 0, 9);
        this.addObject(new WandU(), 1, 9);
        this.addObject(new WandU(), 2, 9);
        this.addObject(new WandU(), 3, 9);
        this.addObject(new WandU(), 4, 9);
        this.addObject(new WandU(), 5, 9);

        this.addObject(new WandU(), 7, 9);
        this.addObject(new WandU(), 8, 9);
        this.addObject(new WandU(), 9, 9);
        this.addObject(new WandU(), 10, 9);
        this.addObject(new WandU(), 11, 9);
        this.addObject(new WandU(), 12, 9);
        
        this.addObject(new WandU(), 14, 9);
        this.addObject(new WandU(), 15, 9);
        this.addObject(new WandU(), 16, 9);

        this.addObject(new WandU(), 18, 9);
        this.addObject(new WandU(), 19, 9);

        this.addObject(new WandL(), 9, 14);
        this.addObject(new WandR(), 10, 14);
        this.addObject(new WandL(), 9, 13);
        this.addObject(new WandR(), 10, 13);
        this.addObject(new WandL(), 9, 12);
        this.addObject(new WandR(), 10, 12);
        this.addObject(new WandL(), 9, 11);
        this.addObject(new WandR(), 10, 11);
        this.addObject(new EckeUL(), 9, 10);
        this.addObject(new EckeUR(), 10, 10);

        this.addObject(new WandL(), 9, 0);
        this.addObject(new WandR(), 10, 0);
        this.addObject(new WandL(), 9, 1);
        this.addObject(new WandR(), 10, 1);
        this.addObject(new WandL(), 9, 2);
        this.addObject(new WandR(), 10, 2);
        this.addObject(new WandL(), 9, 3);
        this.addObject(new WandR(), 10, 3);
        this.addObject(new EckeOL(), 9, 4);
        this.addObject(new EckeOR(), 10, 4);
        this.addObject(new WandO(), 0, 10);
        this.addObject(new WandO(), 1, 10);
        this.addObject(new WandO(), 2, 10);
        this.addObject(new WandO(), 3, 10);
        this.addObject(new WandO(), 4, 10);
        this.addObject(new WandO(), 5, 10);
        this.addObject(new WandO(), 7, 10);
        this.addObject(new WandO(), 8, 10);

        this.addObject(new WandU(), 0, 4);
        this.addObject(new WandU(), 1, 4);
        this.addObject(new WandU(), 2, 4);
        this.addObject(new WandU(), 3, 4);
        this.addObject(new WandU(), 4, 4);
        this.addObject(new WandU(), 5, 4);
        this.addObject(new WandU(), 7, 4);
        this.addObject(new WandU(), 8, 4);

        this.addObject(new WandU(), 11, 4);
        this.addObject(new WandU(), 12, 4);
        
        this.addObject(new WandU(), 14, 4);
        this.addObject(new WandU(), 15, 4);
        this.addObject(new WandU(), 16, 4);
        this.addObject(new WandU(), 18, 4);
        this.addObject(new WandU(), 19, 4);

        this.addObject(new WandO(), 11, 10);
        this.addObject(new WandO(), 12, 10);
       
        this.addObject(new WandO(), 14, 10);
        this.addObject(new WandO(), 15, 10);
        this.addObject(new WandO(), 16, 10);
        this.addObject(new WandO(), 18, 10);
        this.addObject(new WandO(), 19, 10);

        
        this.addObject(new Gulli(), 18, 7); 
        prepare();
        
    }

    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        EckeUL eckeUL = new EckeUL();
        addObject(eckeUL,5,2);
        removeObject(eckeUL);
        Tisch tisch = new Tisch();
        addObject(tisch,1,3);
        Tisch tisch2 = new Tisch();
        addObject(tisch2,1,1);
        Tisch tisch3 = new Tisch();
        addObject(tisch3,3,3);
        Tisch tisch4 = new Tisch();
        addObject(tisch4,3,1);
        Tisch tisch5 = new Tisch();
        addObject(tisch5,5,3);
        Tisch tisch6 = new Tisch();
        addObject(tisch6,5,1);
        Tafel tafel = new Tafel();
        addObject(tafel,9,2);
        Tafel2 tafel2 = new Tafel2();
        addObject(tafel2,10,2);
        Tafel tafel3 = new Tafel();
        addObject(tafel3,9,12);
        Tafel2 tafel22 = new Tafel2();
        addObject(tafel22,10,12);
        Tisch tisch7 = new Tisch();
        addObject(tisch7,1,13);
        Tisch tisch8 = new Tisch();
        addObject(tisch8,1,11);
        Tisch tisch9 = new Tisch();
        addObject(tisch9,3,11);
        Tisch tisch10 = new Tisch();
        addObject(tisch10,3,13);
        Tisch tisch11 = new Tisch();
        addObject(tisch11,5,13);
        Tisch tisch12 = new Tisch();
        addObject(tisch12,5,11);
        Gulli gulli = new Gulli();
        addObject(gulli,705,614);
        removeObject(gulli);
        Tisch2 tisch22 = new Tisch2();
        addObject(tisch22,18,11);
        Tisch2 tisch23 = new Tisch2();
        addObject(tisch23,18,13);
        Tisch2 tisch24 = new Tisch2();
        addObject(tisch24,16,11);
        Tisch2 tisch25 = new Tisch2();
        addObject(tisch25,16,13);
        Tisch2 tisch26 = new Tisch2();
        addObject(tisch26,14,11);
        Tisch2 tisch27 = new Tisch2();
        addObject(tisch27,14,13);
        Tisch2 tisch28 = new Tisch2();
        addObject(tisch28,18,3);
        Tisch2 tisch29 = new Tisch2();
        addObject(tisch29,18,1);
        Tisch2 tisch210 = new Tisch2();
        addObject(tisch210,16,1);
        Tisch2 tisch211 = new Tisch2();
        addObject(tisch211,16,3);
        Tisch2 tisch212 = new Tisch2();
        addObject(tisch212,14,3);
        Tisch2 tisch213 = new Tisch2();
        addObject(tisch213,14,1);
        WandU wandU = new WandU();
        addObject(wandU,17,9);
        WandU wandU2 = new WandU();
        addObject(wandU2,17,4);
        WandO wandO = new WandO();
        addObject(wandO,17,10);
        WandO wandO2 = new WandO();
        addObject(wandO2,17,5);
    }
}