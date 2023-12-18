------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Turm von Hanoi
PURPOSE OF PROJECT: Facharbeit
VERSION or DATE: 06.12.2022
HOW TO START THIS PROJECT:

AUTHORS: Marc Seilz

CPU: 11th Gen Intel(R) Core(TM) i5-11600K @ 3.90GHz

Arbeitsspeicher
16,0 GB

Geschwindigkeit: 3200 MHz
Steckplätze verwendet: 2 von 4
Formfaktor: DIMM
Für Hardware reserviert: 163 MB

Verfügbar 8,3 GB
Im Cache 4,3 GB
Zugesichert 12,1/23,1 GB
Ausgelagerter Pool 887 MB
Nicht ausgelagerter Pool 748 MB
In Verwendung (komprimiert) 7,5 GB (535 MB)

---> MAX 23 Steine

2^23 -1 = 8.338.607 Züge





USER INSTRUCTIONS:
-um ein Spielfeld zu erzeugen oder zu resetten muss es mit Rechtsklick "new Spielfeld(...)" erzeugt werden
-dabei müssen folgende Parameter angegeben werden:
-die Anzahl der gestapelten Steine (int : z.B 15)
-der Turm (A oder B oder C) von dem angefangen werden soll (char : z. B. 'A')
-der Turm (A oder B oder C) auf den der „anfangs-Turm“ sortiert werden soll (char : z. B. 'C')
(bei der Eingabe des Chars ist es wichtig auf die Großschreibung des Turmbezeichners zu achten)

-die Methode "Sortieren" provoziert auch überflüssige (nicht mögliche Steinverschiebungen),
die durch If-Abfragen in der Methode "XzuX" abgefangen werden
-> um eine korrekte Ausgabe von Verschiebungen zu erhalten
muss "System.out.println(X1+"->"+X2+" nicht möglich");" in dem unteren Teil der Methode "XzuX" gelöscht
werden

-die Methode "XzuX" hat unter anderem ein Delay (letzte Zeile: " Greenfoot.delay(1); "). Dieses ist 
wichtig, damit die Steine verschoben werden. Ab einer gewissen Anzahl von Steinen wird nur noch 
die Konsolenausgabe durchgeführt und der Turm wird am Ende auf einmal verschoben