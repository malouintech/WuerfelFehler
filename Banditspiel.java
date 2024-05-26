/**
 * Banditspielklasse erstellt Objekt Banditspiel mit welcher die relativen Haeufigkeiten, Wahrscheinlichkeiten und Fehler berechnet werden
 * @author MalouEichhorn on 05.05.22
 */
public class Banditspiel {
    /**
     * Attribut wuerfel des Objekts Wuerfel
     * countzwei und countdrei sind zaehler die erhoeht werden, wenn zwei oder drei gleiche Zahlen gewuerfelt werden
     */
    private Wuerfel wuerfel;
    private int countzwei;
    private int countdrei;
    private int anzahlWuerfe;

    /**
     * Objektmethode erstellt ein Objekt der Klasse Banditspiel mit einem Wuerfel mit dem Intervall 0,9 und setzt die Zaehler auf 0
     */
    public Banditspiel(){
        wuerfel = new Wuerfel(0,9);
        countzwei = 0;
        countdrei = 0;
    }

    /**
     * spielen fuehrt die wuerfe aus für die drei Wuerfel und vergleicht diese miteinander, wenn sie gleich sind werden die jeweiligen Zaehler erhoeht
     * @param runden uebergibt die anzahl wie oft gewuerfelt wird, anzahlWuerfe wird auf runden gesetzt
     */
    public void spielen (int runden) {
        anzahlWuerfe = runden;
        for (int i = 0; i < runden; i++) {
            int ersterWurf = wuerfel.wuerfeln();
            int zweiterWurf = wuerfel.wuerfeln();
            int dritterWurf = wuerfel.wuerfeln();

            if ((ersterWurf == zweiterWurf) && (ersterWurf == dritterWurf)) {
                countdrei++;
            } else if (ersterWurf == zweiterWurf || zweiterWurf == dritterWurf || ersterWurf == dritterWurf) {
                countzwei++;
            }
        }
    }

    /**
     * Methode aufgaben fuehrt die gegebenen rechnungen für die Haeufigkeiten und Fehler aus
     * relative Haeufigkeit wird berechnet und * 100 gerechnet für die Prozentangabe
     */
    public void aufgaben(){
        double relativeHaufigkeitZweier = this.countzwei  / (double) this.anzahlWuerfe * 100;
        double relativeHaeufigkeitDreier = this.countdrei / (double) this.anzahlWuerfe * 100;
        System.out.println("Von " + this.anzahlWuerfe + " Würfen waren " + relativeHaufigkeitZweier + " % Zweier und " +
                relativeHaeufigkeitDreier + " % Dreier.");
    /**
     * die berechnete Wahrscheinlichkeit ergibt sich aus den moeglichen Kombinationen geteilt durch die gesamten Kombinationen
     */
        int KombinationenIngsesamt = 10 * 10 * 10;
        int KombinationenZweier = KombinationenIngsesamt - (10 * 9 * 8);
        int KombinationenDreier = 10;
        double erwartungsWertZweier = ((double) KombinationenZweier/KombinationenIngsesamt * 100);
        double erwartungsWertDreier = ((double) KombinationenDreier/KombinationenIngsesamt * 100);
        System.out.println("Der mathematische Erwartungswert für Zweier ist " + erwartungsWertZweier + " % und für Dreier " +
                erwartungsWertDreier + " %.");
     /**
      * die Fehler werden wie vorgegeben berechnet
      * Math.abs für Betrag der relativen Fehler
      */
        double absoluterFehlerZweier = relativeHaufigkeitZweier - erwartungsWertZweier;
        double absoluterFehlerDreier = relativeHaeufigkeitDreier - erwartungsWertDreier;
        double relativerFehlerZweier = Math.abs(absoluterFehlerZweier/erwartungsWertZweier);
        double relativerFehlerDreier = Math.abs(absoluterFehlerDreier/erwartungsWertDreier);
        System.out.println("Der absolute Fehler ist für Zweier " + absoluterFehlerZweier + " und für Dreier " + absoluterFehlerDreier);
        System.out.println("Der relative Fehler ist für Zweier " + relativerFehlerZweier + " und für Dreier " + relativerFehlerDreier);


    }

    /**
     * Methode reset setzt die Zaehler und die Wuerfe wieder auf 0
     */
    public void reset(){
        countzwei = 0;
        countdrei = 0;
        anzahlWuerfe = 0;
    }
}
