import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Spielfeld extends World
{
    int anzahlSteine; 
    boolean Turmbewegt = false; 
    
    Turm turmA = new Turm(); // x = 200
    Turm turmB = new Turm(); // x = 500
    Turm turmC = new Turm(); // x = 800
    
    Knopf AzuB = new Knopf('A','B',this);
    Knopf AzuC = new Knopf('A','C',this);
    Knopf BzuA = new Knopf('B','A',this);
    Knopf BzuC = new Knopf('B','C',this);
    Knopf CzuA = new Knopf('C','A',this);
    Knopf CzuB = new Knopf('C','B',this);
    Knopf sortieren = new Knopf('/','/',this);
    

    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Spielfeld()//int Anzahlsteine)
    {    
       super(1000, 600, 1);
        
        int yZähler = 0; 
        anzahlSteine =10; 
        prepare();       

        for(int i = 0; i< anzahlSteine; i++){
            turmA.Steine.push(new Stein(anzahlSteine-i)); // Steine werden mit höchster Nummer zu erst einsortiert, damit sie in richitiger Reihe gestapelt werden 
            addObject(turmA.Steine.top(),turmA.getX(),turmA.Ywert); 
            turmA.Ywert -= turmA.Steine.top().getImage().getHeight();        

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
    
    public boolean getTurmbewegt(){
    
        if(turmA.Steine.isEmpty()&& (turmB.Steine.isEmpty() || turmB.Steine.isEmpty())){
        Turmbewegt = true;
        }
        
    return Turmbewegt;
    }
    
    public void sortieren(){
    
        
        
        
        
        
        
        
        
        
    }
    
    public void XzuX(char X1, char X2){
        Turm x1 = null;
        Turm x2= null;

        switch (X1){
            case 'A':
                x1 = turmA;
                break; 
            case 'a':
                x1 = turmA;
                break;

            case 'B':
                x1 = turmB;
                break; 

            case 'b':
                x1 = turmB;
                break; 

            case 'C':
                x1 = turmC;
                break; 

            case 'c':
                x1 = turmC;
                break; 

        }
        switch (X2){
            case 'A':
                x2 = turmA;
                break; 
            case 'a':
                x2 = turmA;
                break;

            case 'B':
                x2 = turmB;
                break; 

            case 'b':
                x2 = turmB;
                break; 

            case 'C':
                x2 = turmC;
                break; 

            case 'c':
                x2 = turmC;
                break;        

        }

        if(!x1.Steine.isEmpty()){
            if(!x2.Steine.isEmpty()){
                if(x1.Steine.top().getNummer()<x2.Steine.top().getNummer()){
                    x1.Ywert += x1.Steine.top().getImage().getHeight(); // ändert Position des Steins 
                    x1.Steine.top().setLocation(x2.getX(),x2.Ywert );
                    x2.Ywert -= x1.Steine.top().getImage().getHeight();

                    x2.Steine.push(x1.Steine.top()); // wechsel zwischen Datenstruktur 
                    x1.Steine.pop();
                } 
            }
            else
            {

                x1.Ywert += x1.Steine.top().getImage().getHeight(); // ändert Position des Steins 
                x1.Steine.top().setLocation(x2.getX(),x2.Ywert );
                x2.Ywert -= x1.Steine.top().getImage().getHeight();

                x2.Steine.push(x1.Steine.top()); // wechsel zwischen Datenstruktur 
                x1.Steine.pop();

            }
        }
    }

    public void AzuB(){ XzuX('A','B');}

    public void AzuC(){ XzuX('A','C');}

    public void BzuA(){ XzuX('B','A');}

    public void BzuC(){ XzuX('B','C');}

    public void CzuA(){ XzuX('C','A');}

    public void CzuB(){ XzuX('C','B');}

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
        
        addObject(AzuB, this.getWidth()/2-110,20);
        addObject(BzuA, this.getWidth()/2,20);
        addObject(CzuA, this.getWidth()/2+110,20);
        
        addObject(AzuC, this.getWidth()/2-110,60);
        addObject(BzuC, this.getWidth()/2,60);
        addObject(CzuB, this.getWidth()/2+110,60);
        
        addObject(sortieren,this.getWidth()/2,100);
    }
}
