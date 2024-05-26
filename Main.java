/**
 * Main Klasse zum ausführen des Banditspiels
 * @author MalouEichhorn on 05.05.22
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        /**
         * Objekt der Klasse Banditspiel wird erstellt
         * Attribut weiterspielen wird als boolean festgelegt
         * Scanner zur Eingabe der Wuerfe
         */

        Banditspiel spiel = new Banditspiel();
        boolean weiterspielen;
        Scanner scanner = new Scanner(System.in);

        /**
         * solange weiterspielen false ist scannt Scanner die Eingabe
         * anzahl wird auf die gescannte Eingabe gesetzt und bei negativer Eingabe wird die anzahl auf den Betrag gesetzt
         */
        do {
            weiterspielen = false;
            System.out.print("Geben Sie die Anzahl der Wuerfe ein: ");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            int anzahl = scanner.nextInt();
            if (anzahl < 0) {
                anzahl = -anzahl;
            }
            /**
             * spielen wird ausgefuehrt
             * @param anzahl Runden die gespielt werden
             * spiel wird wieder auf 0 gesetzt
              */
        spiel.spielen(anzahl);
        spiel.aufgaben();
        spiel.reset();

        System.out.print("Wollen Sie weiterspielen (j): ");
        if (scanner.next().equals("j")) {
            weiterspielen = true;
        }

    } while (weiterspielen);
    }

}
