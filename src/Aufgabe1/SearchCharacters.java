package Aufgabe1;

/*
▪ Schreiben Sie eine Funktion int sucheZeichen(const char s[], char c), wobei der
Rückgabewert der Häufigkeit des Characters c im Char-Array s entspricht.


▪ Schreiben Sie eine Funktion int laengeZeichenkette(const char s[]), die die Anzahl
der Zeichen (die Länge der Zeichenkette) als Rückgabewert liefert.


▪ Schreiben Sie dann ein Hauptprogramm, das eine kleine Menüsteuerung enthält, um nach
einem Buchstaben in einem Namen zu suchen.


Der Ablauf soll dann so aussehen:


Bitte Namen eingeben: Isabella


Isabella hat 8 Zeichen.


Möchtest Du nach einem Buchstaben in Isabella suchen (j / n)? j


Bitte Buchstaben eingeben: a


Der Buchstabe a kommt 2-mal vor.


Möchtest Du nach einem Buchstaben in Isabella suchen (j / n)? j


Bitte Buchstaben eingeben: k


Der Buchstabe k kommt 0-mal vor.


Möchtest Du nach einem Buchstaben in Isabella suchen (j / n)? n


Auf Wiedersehen!


Hinweise:
▪ Verwenden Sie aus Übungsgründen im Menü die switch Anweisung, die in den Case
Labels die Character j und n auswertet.
▪ Verwenden Sie fflush(stdin) aus der Bibliothek <stdio.h>, um Probleme mit dem
Tastaturpuffer bei der Eingabe zu umgehen.
(Alles in Java ! )

*/




import java.util.Scanner;


public class SearchCharacters {


    // Funktion zur Suche nach einem Zeichen
    public static int sucheZeichen(char[] s, char c) {
        int count = 0;
        for (char ch : s) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }


    // Funktion zur Ermittlung der Länge der Zeichenkette
    public static int laengeZeichenkette(char[] s) {
        return s.length;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte Namen eingeben: ");
        String name = scanner.nextLine();
        char[] nameArray = name.toCharArray();


        System.out.println(name + " hat " +
                laengeZeichenkette(nameArray) + " Zeichen.");
        while (true) {
            System.out.print("Möchtest Du nach einem Buchstaben in " +
                    name + " suchen (j / n)? ");
            char choice = scanner.next().charAt(0);


            switch (choice) {
                case 'j':
                    System.out.print("Bitte Buchstaben eingeben: ");
                    char buchstabe = scanner.next().charAt(0);
                    int count = sucheZeichen(nameArray, buchstabe);
                    System.out.println("Der Buchstabe " + buchstabe + " kommt " + count + "-mal vor.");
                    break;


                case 'n':
                    System.out.println("Auf Wiedersehen!");
                    scanner.close();
                    return;


                default:
                    System.out.println("Ungültige Eingabe. Bitte 'j' oder 'n' eingeben.");
                    break;
            }
        }
    }
}

