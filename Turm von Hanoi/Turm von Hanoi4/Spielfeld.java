import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Spielfeld extends World
{
    private int anzahlSteine; 
    private boolean Turmbewegt; 

    private Turm turmA = new Turm(); // x = 200
    private Turm turmB = new Turm(); // x = 500
    private Turm turmC = new Turm(); // x = 800

    private Knopf AzuB = new Knopf('A','B',this);
    private Knopf AzuC = new Knopf('A','C',this);
    private Knopf BzuA = new Knopf('B','A',this);
    private Knopf BzuC = new Knopf('B','C',this);
    private Knopf CzuA = new Knopf('C','A',this);
    private Knopf CzuB = new Knopf('C','B',this);
    private Knopf sortieren = new Knopf('/','/',this);

    private char startturm;
    private char zielturm;

    /**
     * 
     * 
     */
    public Spielfeld(int pAnzahlsteine, char pStartturm ,char pZielturm)
    {    
        super(1000, 600, 1);

        anzahlSteine =pAnzahlsteine; 
        startturm = pStartturm;
        zielturm =pZielturm;

        prepare();
        
        int yZähler = 0;         
        Turm turmstart = turmvonchar(startturm); // Steine werden auf den eingegebenen Start-Turm gesetzt 
        for(int i = 0; i< anzahlSteine; i++){
            turmstart.Steine.push(new Stein(anzahlSteine-i)); //Steine werden mit höchster Nummer zuerst einsortiert, damit sie in richtiger Reihe gestapelt werden
            addObject(turmstart.Steine.top(),turmstart.getX(),turmstart.Ywert); 
            turmstart.Ywert -= turmstart.Steine.top().getImage().getHeight();        

        }

        
    }

    public Turm turmvonchar(char pchar){
        switch (pchar){
            case 'A':
                return turmA;

            
            case 'B':
                return turmB;

           
            case 'C':
                return turmC;

            
            default: 
                return turmA; // sollte nicht ausgeführt werden  
        }

    }

    
    public char getstartturm(){
        return startturm;
    }

    public char getzielturm(){
        return zielturm;
    }

    public boolean getTurmbewegt(){
        if(turmA.Steine.isEmpty()&& (turmB.Steine.isEmpty() || turmC.Steine.isEmpty())){
            Turmbewegt = true;
        }

        return Turmbewegt;
    }

    public void sortieren(char vonturm, char Zielturm, int anzahlsteine){

        int restturm = anzahlsteine-1;

        if(anzahlsteine <= 1){

        }
        else{
            //zuerst wird der Turm über der untersten Scheibe auf den „nicht-ziel-Ort“ gesetzt
            sortieren(vonturm,Zielturmungleich(vonturm,Zielturm),restturm);
            XzuX(vonturm, Zielturmungleich(vonturm,Zielturm)); 

            //jetzt kann die unterste Scheibe auf den Zielort bewegt werden, weil sich der restliche Turm auf dem „nicht-ziel-Ort“ befindet
            XzuX(vonturm, Zielturm);

            // jetzt muss dieser restliche Turm auf die Hauptscheibe drauf gesetzt werden
            sortieren(Zielturmungleich(vonturm,Zielturm),Zielturm,restturm);
            XzuX(Zielturmungleich(vonturm,Zielturm),Zielturm);   
        }

    }

    public char Zielturmungleich(char vonturm,char Zielturm){
        if(vonturm == 'A' && Zielturm == 'C'){
            return 'B';
        }
        else if(vonturm == 'A' && Zielturm == 'B'){
            return 'C';
        }
        else if(vonturm == 'B' && Zielturm == 'A'){
            return 'C';
        }
        else if(vonturm == 'B' && Zielturm == 'C'){
            return 'A';
        }
        else if(vonturm == 'C' && Zielturm == 'A'){
            return 'B';
        }
        else if(vonturm == 'C' && Zielturm == 'B'){
            return 'A';
        }
        else{
            System.out.println("FEHLER!");
            return Zielturm; //sollte nicht ausgeführt werden 
        }
    }

    public int getanzahlSteine(){
        return anzahlSteine;
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
            case 'A' :
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
                    System.out.println(X1+"->"+X2);
                } 
                else
                {
                    System.out.println(X1+"->"+X2+" nicht möglich"); // löschen, um eine korrekte Ausgabe zu erhalten
                }
            }
            else
            {

                x1.Ywert += x1.Steine.top().getImage().getHeight(); // ändert Position des Steins 
                x1.Steine.top().setLocation(x2.getX(),x2.Ywert );
                x2.Ywert -= x1.Steine.top().getImage().getHeight();

                x2.Steine.push(x1.Steine.top()); // wechsel zwischen Datenstruktur 
                x1.Steine.pop();
                System.out.println(X1+"->"+X2);
            }
        }
        Greenfoot.delay(1); // es empfiehlt sich ab 15+ Steinen rauszunehmen
    }

    public void AzuB(){ XzuX('A','B');}

    public void AzuC(){ XzuX('A','C');}

    public void BzuA(){ XzuX('B','A');}

    public void BzuC(){ XzuX('B','C');}

    public void CzuA(){ XzuX('C','A');}

    public void CzuB(){ XzuX('C','B');}

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
