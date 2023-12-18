import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spielfeld extends World
{
    int anzahlSteine; 

    Turm turmA = new Turm(); // x = 200
    Turm turmB = new Turm(); // x = 500
    Turm turmC = new Turm(); // x = 800
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Spielfeld()//int Anzahlsteine)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(1000, 600, 1); 
        int yZähler = 0; 
        anzahlSteine =10; 
        prepare();
        
        /*
        for(int i = 0; i< anzahlSteine; i++){
            turmA.Steine.add(new Stein(anzahlSteine-i)); // Steine werden mit höchster Nummer zu erst einsortiert, damit sie in richitiger Reihe gestapelt werden 
            //addObject(turmA.Steine.get(i),200,570-i*40);
            addObject(turmA.Steine.get(i),200,570-yZähler ); // y = 590-yZähler für anzahlSteine = 100
            
            yZähler += turmA.Steine.get(i).getImage().getHeight(); 

            System.out.println(turmA.Steine.get(i).Nummer);
            //addObject(turmA.Steine.get(i),200,210+i*40); // Startet mit Stein 10 (210 muss aber je nach Nummer angepasst werden )

        }
        */
       
       
        for(int i = 0; i< anzahlSteine; i++){
            turmA.Steine.push(new Stein(anzahlSteine-i)); // Steine werden mit höchster Nummer zu erst einsortiert, damit sie in richitiger Reihe gestapelt werden 
            //addObject(turmA.Steine.get(i),200,570-i*40);
            addObject(turmA.Steine.top(),200,570-yZähler ); // y = 590-yZähler für anzahlSteine = 100
            
            yZähler += turmA.Steine.top().getImage().getHeight(); 
            
            System.out.println(turmA.Steine.top().Nummer);
            //addObject(turmA.Steine.get(i),200,210+i*40); // Startet mit Stein 10 (210 muss aber je nach Nummer angepasst werden )

        }

    }
    public int Test(int n){
        if(n <= 1){
            if(n==0){
                return 0; 

            }else{
                return 1;
            }
           }
            else
            {
                System.out.println(n);
            return Test(n-1)+(n-2);
            }

        
    }
    
    public void Test2(int x){
    for(int i = 0; i<x; i++){
    System.out.println(i); 
    
    }
    
    }
    public void AzuB(){}
    public void AzuC(){}
    public void BzuA(){}
    public void BzuC(){}
    public void CzuA(){}
    public void CzuB(){}
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        turmA.getImage().scale(300, 300);
        turmA.getImage().drawImage(new GreenfootImage("A", 25, Color.BLACK, new Color(0, 0, 0, 0)),145,272);
        addObject(turmA,200,460);

        turmB.getImage().scale(300, 300);
        turmB.getImage().drawImage(new GreenfootImage("B", 25, Color.BLACK, new Color(0, 0, 0, 0)),145,272);
        addObject(turmB,500,460);

        turmC.getImage().scale(300, 300);
        turmC.getImage().drawImage(new GreenfootImage("C", 25, Color.BLACK, new Color(0,0, 0, 0)),145,272);
        addObject(turmC,800,460);

        
    }
}
