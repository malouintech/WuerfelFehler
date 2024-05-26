/**
 * Klasse Wuerfel erstellt Objekte Wuerfel für Klasse Banditspiel
 * @author MalouEichhorn on 05.05.22
 */
public class Wuerfel {
    /**
     * Attribut zahlen sind die Wuerfelaugen, die ausgegeben werden koennen
     * min und max für Intervallgrenzen des Wuerfels
     */
    private int zahlen;
    private int min;
    private int max;

    /**
     * Objektmethode erstellt ein Objekt der Klasse Wuerfel
     * @param var1,var2 uebergibt das Intervall des Wuerfels
     * Methode setzt Intervallgrenzen auf min und max für wuerfeln Methode
     */
        public Wuerfel(int var1, int var2){
            if (var2 < var1) {
                this.min = var2;
                this.max = var1;
            } else {
                this.min = var1;
                this.max = var2;
            }

            this.wuerfeln();
        }

    /**
     * @return zahlen welche gewuerfelt wurden
     */
        public int getZahlen() {
            return this.zahlen;
        }

    /**
     * erstellt random zahlen zwischen min und max
     * @return zahlen, gewuerfelte Zahl wird zurueckgegeben
     */
        public int wuerfeln() {
            this.zahlen = (int) (Math.random() * (double) (this.max - this.min + 1)) + this.min;
            return this.zahlen;

        }
}
