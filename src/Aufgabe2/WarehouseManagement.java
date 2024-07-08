package Aufgabe2;

/*
Schreiben Sie ein Programm zur Lagerverwaltung. Wir wollen hierzu ein struct verwenden,
das die folgenden Komponenten hat:

char artikel[laengeArtikel];
int anzahl;

Das Array lager[anzahlEintraege] enthält dann als Array-Elemente die Informationen zu
Artikeln gemäß der obigen Struktur.

Folgende Funktionen sollen geschrieben werden:

▪ Artikel hinzufügen.
Ein Artikel mit Anzahl soll in die Lagerliste eingetragen werden, falls noch Platz ist
und falls der Artikel noch nicht existiert. Falls der Artikel bereits vorhanden ist, soll
die Anzahl entsprechend erhöht werden.

▪ Artikel entnehmen.
Geben Sie einen Artikel ein und geben Sie an, wie viele Exemplare aus dem Lager
entnommen werden. Aktualisieren Sie die Anzahl. Beachten Sie den Fall, dass der
Artikel nicht existiert, und den Fall, wo nicht genügend Exemplare auf Lager sind.
Erzeugen Sie dann entsprechende Meldungen für den Anwender.

▪ Eintrag suchen.
Für einen Artikel soll ausgegeben werden, welche Anzahl noch im Lager ist.
Formulieren Sie auch hier alle möglichen Meldungen an den Anwender.

▪ Lager als Tabelle ausgeben.
Hier soll eine Tabelle mit den Spalten Artikel und Anzahl ausgegeben werden. Am
Ende der Tabelle sollen die Anzahlen addiert werden, damit man weiß, wie viele
Artikel insgesamt im Lager sind.

▪ Schreiben Sie eine Menüsteuerung, durch die sich die einzelnen Funktionen aufrufen
lassen.

Hinweise:

▪ Sie werden in der Aufgabe Zeichenketten vergleichen müssen. Verwenden Sie hierzu
die Bibliotheksfunktion int strcmp(const char *s1, const char *s2).
▪ Schreiben Sie alle Funktionen in das main-Programm. Sie sollen für dieses Beispiel
kein make und keine separate Übersetzung verwenden.
(Alles in Java ! )
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WarehouseManagement {
    // Innerhalb der Klasse definieren wir eine Artikelklasse
    private static class Artikel {
        String name;
        int anzahl;

        Artikel(String name, int anzahl) {
            this.name = name;
            this.anzahl = anzahl;
        }

        @Override
        public String toString() {
            return "Artikel{" +
                    "name='" + name + '\'' +
                    ", anzahl=" + anzahl +
                    '}';
        }
    }

    private List<Artikel> lager;
    private static final int MAX_EINTRAEGE = 100;

    public WarehouseManagement() {
        lager = new ArrayList<>();
    }

    // Artikel hinzufügen
    public void artikelHinzufuegen(String name, int anzahl) {
        for (Artikel artikel : lager) {
            if (artikel.name.equals(name)) {
                artikel.anzahl += anzahl;
                System.out.println("Artikel bereits vorhanden. Anzahl erhöht auf: " + artikel.anzahl);
                return;
            }
        }
        if (lager.size() < MAX_EINTRAEGE) {
            lager.add(new Artikel(name, anzahl));
            System.out.println("Neuer Artikel hinzugefügt: " + name + " mit Anzahl: " + anzahl);
        } else {
            System.out.println("Kein Platz mehr im Lager.");
        }
    }

    // Artikel entnehmen
    public void artikelEntnehmen(String name, int anzahl) {
        for (Artikel artikel : lager) {
            if (artikel.name.equals(name)) {
                if (artikel.anzahl >= anzahl) {
                    artikel.anzahl -= anzahl;
                    System.out.println("Artikel entnommen. Neue Anzahl von " + name + ": " + artikel.anzahl);
                } else {
                    System.out.println("Nicht genügend Exemplare auf Lager.");
                }
                return;
            }
        }
        System.out.println("Artikel nicht gefunden.");
    }

    // Eintrag suchen
    public void eintragSuchen(String name) {
        for (Artikel artikel : lager) {
            if (artikel.name.equals(name)) {
                System.out.println("Artikel: " + name + ", Anzahl: " + artikel.anzahl);
                return;
            }
        }
        System.out.println("Artikel nicht gefunden.");
    }

    // Lager als Tabelle ausgeben
    public void lagerAusgeben() {
        int gesamtAnzahl = 0;
        System.out.println("Lagerbestand:");
        System.out.println("Artikel\t\tAnzahl");
        for (Artikel artikel : lager) {
            System.out.println(artikel.name + "\t\t" + artikel.anzahl);
            gesamtAnzahl += artikel.anzahl;
        }
        System.out.println("Gesamtanzahl aller Artikel: " + gesamtAnzahl);
    }

    // Menüsteuerung
    public void menue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Artikel hinzufügen");
            System.out.println("2. Artikel entnehmen");
            System.out.println("3. Eintrag suchen");
            System.out.println("4. Lager ausgeben");
            System.out.println("5. Beenden");
            System.out.print("Wählen Sie eine Option: ");
            int wahl = scanner.nextInt();
            scanner.nextLine(); // Leeren des Puffers nach nextInt

            switch (wahl) {
                case 1:
                    System.out.print("Artikelname: ");
                    String nameHinzufuegen = scanner.nextLine();
                    System.out.print("Anzahl: ");
                    int anzahlHinzufuegen = scanner.nextInt();
                    artikelHinzufuegen(nameHinzufuegen, anzahlHinzufuegen);
                    break;
                case 2:
                    System.out.print("Artikelname: ");
                    String nameEntnehmen = scanner.nextLine();
                    System.out.print("Anzahl: ");
                    int anzahlEntnehmen = scanner.nextInt();
                    artikelEntnehmen(nameEntnehmen, anzahlEntnehmen);
                    break;
                case 3:
                    System.out.print("Artikelname: ");
                    String nameSuchen = scanner.nextLine();
                    eintragSuchen(nameSuchen);
                    break;
                case 4:
                    lagerAusgeben();
                    break;
                case 5:
                    System.out.println("Programm beendet.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ungültige Option.");
            }
        }
    }

    public static void main(String[] args) {
        WarehouseManagement warehouseManagement = new WarehouseManagement();
        warehouseManagement.menue();
    }
}
