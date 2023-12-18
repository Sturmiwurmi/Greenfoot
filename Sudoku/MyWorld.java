import greenfoot.*;  
import java.util.Random;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Random random = new Random();
    private int fehlerpunkte;
    private Feld[][] felder = new Feld[9][9];
    public MyWorld()
    {    

        super(579, 579, 1);
        setBackground("images/Sudoku.png");

        int ZählerY = 45;
        for(int b = 0; b<9; b++){  
            int ZählerX = 45;
            for(int i = 0; i<9; i++){          
                felder[b][i] = new Feld(i+1,b+1,this);
                addObject(felder[b][i], ZählerX , ZählerY); 

                ZählerX += 60;
                if(ZählerX  == 165){ZählerX+= 1;}
                if(ZählerX == 346){ZählerX += 1;}
            }
            ZählerY +=60;
            if(ZählerY == 165){ZählerY+= 1;}
            if(ZählerY == 346){ZählerY+= 1;}
        }        

    }

    public void fehler(){
        fehlerpunkte++;
    }

    public boolean Nummermoeglich(int pNummer, int positionX, int positionY){

        if(NummerinReiheX(positionY,pNummer)||NummerinReiheY(positionX,pNummer)||Nummerin3x3(pNummer,positionX,positionY)){
            return false;
        }

        return true;
    }

    private boolean Nummerin3x3(int pNummer, int positionX, int positionY){
        if(positionX>9 ||positionY>9){
            return false;
        }

        Integer[] Xfelderabzusuchen = new Integer[3];
        Integer[] Yfelderabzusuchen = new Integer[3];

        if(positionX<4){
            Xfelderabzusuchen[0] = 0;
            Xfelderabzusuchen[1] = 1;
            Xfelderabzusuchen[2] = 2;
        }else if(positionX<7){
            Xfelderabzusuchen[0] = 3;
            Xfelderabzusuchen[1] = 4;
            Xfelderabzusuchen[2] = 5; 
        }else{
            Xfelderabzusuchen[0] = 6;
            Xfelderabzusuchen[1] = 7;
            Xfelderabzusuchen[2] = 8; 
        }

        if(positionY<4){
            Yfelderabzusuchen[0] = 0;
            Yfelderabzusuchen[1] = 1;
            Yfelderabzusuchen[2] = 2;
        }else if(positionY<7){
            Yfelderabzusuchen[0] = 3;
            Yfelderabzusuchen[1] = 4;
            Yfelderabzusuchen[2] = 5; 
        }else{
            Yfelderabzusuchen[0] = 6;
            Yfelderabzusuchen[1] = 7;
            Yfelderabzusuchen[2] = 8; 
        }

        for(int i = 0; i<Xfelderabzusuchen.length; i++){
            for(int b = 0; b<Yfelderabzusuchen.length; b++){
                if(pNummer == felder[Yfelderabzusuchen[b]][Xfelderabzusuchen[i]].getNummer()){
                    return true;
                }
            }    
        }

        return false;
    }

    private boolean NummerinReiheX(int pReihe, int pNummer){ 
        pReihe-= 1;     

        for(int i = 0; i<felder[pReihe].length; i++){
            //System.out.print(felder[pReihe][i].getNummer());
            if(felder[pReihe][i].getNummer() == pNummer){
                return true;
            }
        }
        //System.out.println();

        return false;
    }

    private boolean NummerinReiheY(int pReihe, int pNummer){ 
        pReihe-= 1;

        for(int i = 0; i<felder[pReihe].length; i++){
            //System.out.println(felder[i][pReihe].getNummer());
            if(felder[i][pReihe].getNummer() == pNummer){
                return true;
            }
        }

        return false;        

    }

    public boolean geloestboolean(){
        for(int i = 0; i<felder[1].length; i++){
            for(int b = 0; b<felder[1].length; b++){
                if(felder[i][b].getNummer() == 0){
                    return false;
                }
            }
        }
        return true;    
    }

    private String geloeststring(){
        for(int i = 0; i<felder[1].length; i++){
            for(int b = 0; b<felder[1].length; b++){
                if(felder[i][b].getNummer() == 0){
                    return "Nein";
                }
            }
        }
        return "Ja";    
    }

    public void loesen(boolean pdelay){
        //Nicht jedes Sudoku ist mit diesem Algorithmus lösbar. 
        
        List<Integer> moeglichkeiten = new List<Integer>();
        int zaehler = 0;
        while(!geloestboolean()&&zaehler<100){ // damit das Ganze nicht in einer Endlosschleife enden kann 
            for(int i = 0; i<felder[1].length; i++){
                for(int b = 0; b<felder[1].length; b++){
                    if(felder[i][b].getNummer() == 0){
                        for(int c = 1; c<10; c++){
                            if(Nummermoeglich(c, b+1, i+1)){ // Nummer Nummermoeglich subtrahiert schon 1 für Arrayindex. Die for-Schleifen geben aber den Index wieder also +1 eins weil x+1-1=x  
                                moeglichkeiten.append(c);
                                //System.out.println("Nummermoeglich: " + c);
                            }                       
                        }
                        moeglichkeiten.toFirst();
                        if(moeglichkeiten.size() == 1){ // wenn es nur eine Möglichkeit gibt kann diese in das Sudoku eingesetzt werdeb 
                            felder[i][b].setNummer(moeglichkeiten.getContent());
                            if(pdelay){
                                Greenfoot.delay(1); // "Animation" 
                            }          
                        }
                        for(int d = 0; d<moeglichkeiten.size()+1; d++){ // Liste muss für das nächste Feld geleert werden (+1 damit es funktioniert)
                            moeglichkeiten.remove();                        
                        }                   
                        //System.out.println("X: " + b+" Y: " + i);
                    }

                }
            }
            zaehler ++;
        }
        if(zaehler>99){
            this.showText("!Unlösbar!", 500,7);
        }    
    }

    public boolean loesesbar(boolean löschen){
        //Es gibt auch Sudokus, die lösbar sind, auch wenn dieser Algorithmus sie als unlösbar sieht.
        
        Stack<Integer> stackx = new Stack<Integer>();
        Stack<Integer> stacky = new Stack<Integer>();

        List<Integer> moeglichkeiten = new List<Integer>();
        int zaehler = 0;
        while(!geloestboolean()&&zaehler<100){ // damit das Ganze nicht in einer Endlosschleife enden kann 
            for(int i = 0; i<felder[1].length; i++){
                for(int b = 0; b<felder[1].length; b++){
                    if(felder[i][b].getNummer() == 0){
                        for(int c = 1; c<10; c++){
                            if(Nummermoeglich(c, b+1, i+1)){ // Nummer Nummermoeglich subtrahiert schon 1 für Arrayindex. Die for-Schleifen geben aber den Index wieder also +1 eins weil x+1-1=x  
                                moeglichkeiten.append(c);
                                //System.out.println("Nummermoeglich: " + c);
                            }                       
                        }
                        moeglichkeiten.toFirst();
                        if(moeglichkeiten.size() == 1){ // wenn es nur eine Möglichkeit gibt kann diese in das Sudoku eingesetzt werdeb 
                            felder[i][b].setNummer(moeglichkeiten.getContent());
                            stacky.push(i);  
                            stackx.push(b);
                        }
                        for(int d = 0; d<moeglichkeiten.size()+1; d++){ // Liste muss für das nächste Feld geleert werden (+1 damit es funktioniert)
                            moeglichkeiten.remove();                        
                        }                   
                        //System.out.println("X: " + b+" Y: " + i);
                    }

                }
            }
            zaehler ++;
        }

        while(!stacky.isEmpty()&&!stackx.isEmpty()&&löschen){
            felder[stacky.top()][stackx.top()].entferneNummer();
            stacky.pop();
            stackx.pop();
        }

        if(zaehler>99){
            return false;
        }    
        return true;
    }

    public void sudoku1(){
        felder[0][1].setNummer(9);
        felder[0][2].setNummer(2);
        felder[0][3].setNummer(6);
        felder[0][5].setNummer(7);
        felder[0][6].setNummer(4);
        felder[0][8].setNummer(5);

        felder[1][0].setNummer(5);
        felder[1][2].setNummer(8);
        felder[1][5].setNummer(4);
        felder[1][6].setNummer(2);

        felder[2][1].setNummer(3);
        felder[2][3].setNummer(9);
        felder[2][5].setNummer(5);
        felder[2][7].setNummer(7);
        felder[2][8].setNummer(8);

        felder[3][1].setNummer(1);
        felder[3][2].setNummer(9);
        felder[3][4].setNummer(4);
        felder[3][5].setNummer(3);
        felder[3][6].setNummer(5);

        felder[4][0].setNummer(7);
        felder[4][1].setNummer(2);
        felder[4][3].setNummer(5);
        felder[4][4].setNummer(6);
        felder[4][7].setNummer(1);
        felder[4][8].setNummer(3);

        felder[5][2].setNummer(3);
        felder[5][3].setNummer(2);
        felder[5][4].setNummer(1);
        felder[5][6].setNummer(9);
        felder[5][7].setNummer(4);

        felder[6][1].setNummer(8);
        felder[6][2].setNummer(1);
        felder[6][5].setNummer(6);
        felder[6][6].setNummer(7);
        felder[6][8].setNummer(4);

        felder[7][0].setNummer(9);
        felder[7][2].setNummer(7);
        felder[7][3].setNummer(4);
        felder[7][4].setNummer(5);
        felder[7][7].setNummer(8);
        felder[7][8].setNummer(2);

        felder[8][0].setNummer(3);
        felder[8][2].setNummer(5);
        felder[8][3].setNummer(8);
        felder[8][4].setNummer(7);
        felder[8][5].setNummer(2);
        felder[8][7].setNummer(9);
        felder[8][8].setNummer(1);

        for(int i = 0; i<felder[1].length; i++){
            for(int b = 0; b<felder[1].length; b++){
                if(felder[i][b].getNummer() != 0){
                    felder[i][b].getImage().setTransparency(150);
                }
            }
        }
    }    

    public void sudokugeneriern2(int schwierigkeit){
        /*
         * "Es kann maximal 6,670,903,752,021,072,936 (6,67 Trillion) verschiedene Sudokus geben. Dies ist die Anzahl der möglichen 
         * Lösungen für ein standardisiertes 9x9-Sudoku-Raster. Es gibt jedoch wahrscheinlich weniger als diese maximale Anzahl,
         * da einige Lösungen durch symmetrische oder ähnliche Muster dupliziert werden können."
         * 
         * 6,67 Trillion wären zwar theoretisch möglich, allerdings nicht um bedingt mit dieser Generierung
         */
        int Zaehler = 0;
        int Reihe = Zaehler+1;
        int[] linearray = zufallarray();

        while(Zaehler<8){ 

            while(!reihemoeglich(Zaehler,linearray)){ 
                linearray = zufallarray();    
                System.out.println("Reihe: "+ Reihe+" /8" +reihemoeglich(Zaehler,linearray));               
            }  
            
            for(int i = 0; i<felder.length; i++){
                felder[Zaehler][i].setNummer(linearray[i]);       
            }        
            Zaehler++;     
            Reihe = Zaehler+1;
            
        }
        loesen(false);
        
        for(int i = 0; i<schwierigkeit; i++){
            int xgeloescht = random.nextInt(9);
            int ygeloescht = random.nextInt(9); 
            int geloescht = felder[ygeloescht][xgeloescht].getNummer();
            while(loesesbar(true)){
                xgeloescht = random.nextInt(9);
                ygeloescht = random.nextInt(9);
                geloescht = felder[ygeloescht][xgeloescht].getNummer();
                felder[ygeloescht][xgeloescht].entferneNummer();
            }

            // wieder lösbar machen 
            felder[ygeloescht][xgeloescht].setNummer(geloescht);
        } 

        for(int e = 0; e<felder[1].length; e++){
            for(int b = 0; b<felder[1].length; b++){
                if(felder[e][b].getNummer() != 0){
                    felder[e][b].getImage().setTransparency(150);
                }
            }

        } 
    }

    private boolean reihemoeglich(int reihe,int[] array){
        for(int i = 0; i<felder[1].length; i++){
            if(!Nummermoeglich(array[i], i+1, reihe+1)){
                return false;
            }
        }               
        return true;
    }

    private int[] zufallarray(){
        // 9 unterschiedliche Zahlen generieren:
        int[] linearray = new int[9];

        for(int i = 0; i<linearray.length; i++){
            int zufall = random.nextInt(9)+1;
            while(xinarray(zufall,linearray)){
                zufall = random.nextInt(9)+1;
            }
            linearray[i] = zufall;
        }
        return linearray;
    }

    private void reihereset(int preihe){
        for(int i = 0; i<felder.length; i++){
            felder[preihe][i].entferneNummer();
        }
    }

    private boolean xinarray(int x, int[] pArray){
        for(int i = 0; i<pArray.length; i++){
            if(pArray[i] == x){return true;}
        }
        return false;

    }

    public void sudokugeneriern(){ // quasi unmöglich
        while(!loesesbar(false)){
            // Array zurücksetzten 
            for(int i = 0; i<felder.length; i++){
                for(int b = 0; b<felder.length; b++){
                    felder[i][b].entferneNummer();
                }
            }

            for(int c = 0; c<9*9; c++){
                int x = random.nextInt(felder.length); // Zufallszahl ziwschen 0 und 8 (Index)
                int y = random.nextInt(felder.length);       

                for(int i = 0; i<felder.length; i++){
                    for(int b = 0; b<felder.length; b++){
                        int zufall = random.nextInt(10)+1;
                        if(felder[i][b].getNummer() == 0 && Nummermoeglich(zufall, x+1, y+1)){
                            felder[i][b].setNummer(zufall);
                        }
                    }
                    //Greenfoot.delay(1);
                }

            }
            Greenfoot.delay(1);
        }

        for(int i = 0; i<felder[1].length; i++){
            for(int b = 0; b<felder[1].length; b++){
                if(felder[i][b].getNummer() != 0){
                    felder[i][b].getImage().setTransparency(150);
                }
            }
        }

    }

    public void act(){
        this.showText("Fehler: "+ String.valueOf(fehlerpunkte), 100,7);
        this.showText("Gelöst: "+ geloeststring(), 300,7);
        if ("l".equals(Greenfoot.getKey())){
            loesen(true);            
        }
    }
}
