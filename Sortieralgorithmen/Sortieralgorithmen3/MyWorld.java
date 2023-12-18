import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private Saeule[] Saeulen;  
    Random random = new Random();

    public MyWorld()
    {    
        super(1000, 800, 1); 
        Saeulen = new Saeule[this.getWidth()/20];

        for(int i = 0; i<Saeulen.length;i++){
            Saeulen[i] = new Saeule(random.nextInt(79)+1);// +1 damit die höhe nicht 0 sein kann 

            this.addObject(Saeulen[i], i*20+6, 800);

        }

    }

    public void selectionsortArray(){

        for (int i = 0; i < Saeulen.length - 1; i++) {
            for (int j = i + 1; j < Saeulen.length; j++) {
                if (Saeulen[i].getZahl() > Saeulen[j].getZahl()) {
                    
                    tauschesauele(i,j);
                    
                   // Saeule temp = Saeulen[i];
                   // Saeulen[i] = Saeulen[j];
                   // Saeulen[j] = temp;
                   
                }
            }
        }

    } 

    public void quicksortstart(){
        //Array in Liste kopieren 
        List<Saeule> Saeulenlist = new List<Saeule>();        
        for(int i = 0; i<Saeulen.length; i++){
            Saeulenlist.append(Saeulen[i]);
        }
        // 

        quicksort(Saeulenlist);

        int Zähler = 0;
        Saeulenlist.toFirst();
        while(Saeulenlist.hasAccess()){
            Saeulen[Zähler] = Saeulenlist.getContent();
            Saeulenlist.next();

            Zähler++;
        }

    }

    private void quicksort(List<Saeule> liste){

        if (liste.size() > 1){
            List<Saeule>kleinere = new List<Saeule> ();
            List<Saeule>groessere = new List<Saeule> ();
            liste.toFirst ();

            Saeule pivot = liste.getContent();

            liste.remove () ;
            while (!liste.isEmpty ())
            {
                Saeule akt = liste.getContent();
                if (akt.getZahl() < pivot.getZahl())
                {
                    kleinere.append(akt);
                }
                else
                {
                    groessere.append(akt);
                }

                liste.remove () ;
            }
            quicksort (kleinere); 
            quicksort (groessere); 
            liste.concat (kleinere); 
            liste.append (pivot);
            liste.concat (groessere);

        }
        listeausgeben(liste);
        Greenfoot.delay(1);      

    }

    public void insertionSort(){
        //Array in Liste kopieren 
        List<Saeule> Saeulenlist = new List<Saeule>();        
        for(int i = 0; i<Saeulen.length; i++){
            Saeulenlist.append(Saeulen[i]);
        }
        // 

        List<Saeule> sortierteListe = new List<Saeule>();
        int Zähler; 
        while(!Saeulenlist.isEmpty()){
            Zähler =  0;
            Saeulenlist.toFirst();
            Saeule aktuelles = Saeulenlist.getContent();
            sortierteListe.toFirst();

            while(sortierteListe.hasAccess()&& sortierteListe.getContent().getZahl() < aktuelles.getZahl()){
                sortierteListe.next();
            }
            if(sortierteListe.hasAccess()){
                sortierteListe.insert(aktuelles);
            }
            else
            {
                sortierteListe.append(aktuelles);
            }
            Saeulenlist.remove();

            // jedes mal die sortierte Liste ausgeben
            listeausgeben(sortierteListe);
            Greenfoot.delay(1);
        }
        Saeulenlist = sortierteListe;

        //die jetzt sortierte Liste in das Array zurück kopieren 
        int Zähler2 = 0;
        Saeulenlist.toFirst();
        while(Saeulenlist.hasAccess()){
            Saeulen[Zähler2] = Saeulenlist.getContent();
            Saeulenlist.next();

            Zähler2++;
        }

    }

    private void listeausgeben(List<Saeule> pListe){
        pListe.toFirst();
        int Zähler = 0;
        while(pListe.hasAccess()){
            //Greenfoot.delay(1);
            pListe.getContent().setLocation(Zähler*20+6,800);                  
            pListe.next();
            Zähler++;

        } 
    }

    public void insertionSortArray()
    {
        int n = Saeulen.length;
        for (int i = 1; i < n; ++i) {
            Saeule key = Saeulen[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j >= 0 && Saeulen[j].getZahl() > key.getZahl()) {
                Saeulen[j + 1] = Saeulen[j];                
                j --;
                arrayausgeben(Saeulen);
                Greenfoot.delay(1);
            }

            Saeulen[j + 1] = key;
        }
        arrayausgeben(Saeulen);
        /* This code is contributed by Rajat Mishra. */
    }

    private void arrayausgeben(Saeule[] pArray){
        for(int i = 0; i<pArray.length;i++){
            pArray[i].setLocation( i*20+6, 800);       
        }       
    }

    public void bubbleSort(){
        int n =Saeulen.length; 
        Saeule temp;;

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){ 
                if(Saeulen[j-1].getZahl() >Saeulen[j].getZahl()){
                    //swap elements 
                    tauschesauele(j-1,j);

                }

            }
        }

    }

    private void tauschesauele(int pvonIndex, int pnachIndex){
        int XKoordinatevon = Saeulen[pvonIndex].getX();
        int XKoordinatenach = Saeulen[pnachIndex].getX();

        Saeulen[pvonIndex].setLocation(XKoordinatenach, Saeulen[pvonIndex].getY()); //Positionstausch 
        Saeulen[pnachIndex].setLocation(XKoordinatevon, Saeulen[pnachIndex].getY());

        Saeule temp = Saeulen[pvonIndex]; //tausch in der Datenstruktur 
        Saeulen[pvonIndex] = Saeulen[pnachIndex];
        Saeulen[pnachIndex] = temp;

        Greenfoot.delay(1);

    }

}
