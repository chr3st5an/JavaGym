import java.util.Arrays;
import java.util.Collections;


/**
 * Lösungen zum JavaGym des Informatik Vorkurs WS 22
 *
 * @author chr3st5an
 */
public class JavaGym {
    public static int vierundzwanzig() {
        return 24;
    }

    public static int plus1(int x) {
        return x + 1;
    }

    public static int aendereVorzeichen(int x) {
        return x*(-1);
    }

    public static double dollar(double betragEuro) {
        final double wechselkurs = 1.19;

        return betragEuro*wechselkurs;
    }

    public static double wechselgeld(double preis, double bezahlt) {
        return bezahlt - preis;
    }

    public static int betrag(int x) {
        // |x|
        return Math.abs(x);
    }

    public static boolean istEinstellig(int x) {
        // |x| < 10
        return Math.abs(x) < 10;
    }

    public static double celsius(double fahrenheit) {
        return 5*(fahrenheit - 32)/9;
    }

    public static double bmi(double kg, double groesse) {
        return kg/Math.pow(groesse, 2);
    }

    public static int montagekosten(int arbeitsstunden) {
        final int kostenAnfahrt = 40;
        final int stundensatz = 50;

        return stundensatz*arbeitsstunden + kostenAnfahrt;
    }

    public static String preisstufe(int stationen) {
        if (stationen < 5) {
            return "A";
        } else if (stationen < 10) {
            return "B";
        } else if (stationen < 15) {
            return "C";
        } else {
            return "D";
        }
    }

    public static double kassenzettel(int anzahlPaketeNudeln, int anzahlPaketeButter, int anzahlPaketeEier) {
        final double preisNudeln = 0.49;
        final double preisButter = 1.79;
        final double preisEier = 1.55;

        return (preisNudeln*anzahlPaketeNudeln
              + preisButter*anzahlPaketeButter
              + preisEier*anzahlPaketeEier);
    }

    public static int flaecheninhalt(int x1, int x2, int y1, int y2) {
        // |x1 - x2| * |y1 - y2|
        return Math.abs(x1 - x2)*Math.abs(y1 - y2);
    }

    public static boolean istZweistellig(int x) {
        // 9 < |x| && |x| < 100
        return (9 < Math.abs(x)) && (Math.abs(x) < 100);
    }

    public static int wartezeit(int stunden, int minuten) {
        return (((minuten > 30) ? 60 : 30) - minuten)*(minuten > 0 ? 1 : 0);
    }

    public static int summeBis(int n) {
        return (n*(n + 1))/2;
    }

    public static int summeAbisB(int a, int b) {
        return summeBis(b) - summeBis(a - 1);
    }

    public static int summeGeradeZahlenBis(int n) {
        int sum = 0;

        // Zwei ist die erste gerade natürliche Zahl
        for (int i = 2; i <= n; i++) {
            // (i & 1) <=> i % 2
            sum += ((i & 1) == 1) ? 0 : i;
        }

        return sum;
    }

    public static int mittlerste(int a, int b, int c) {
        // Die Parameter werden in ein Array gepackt
        int[] arr = {a, b, c};

        // Das Package "Arrays" sortiert das Array
        Arrays.sort(arr);

        // Das mittlerste Item wird zurückgegeben
        return arr[1];
    }

    /**
     * Hilfsmethode, da es in Java 8 noch nicht die
     * eingebaute `repeat` String methode gibt
     *
     * @param str der String, der wiederholt werden soll
     * @param n wie oft der String wiederholt werden soll
     * @return der wiederholte String
     */
    public static String repeat(String str, int n) {
        return String.join("", Collections.nCopies(n, str));
    }

    public static String glockenschlag(int stunden, int minuten) {
        // Lokale Variablen
        String bim = "",
               bam = "";

        /*
         * Erst wenn der Rest der Division "minuten / 15" Null ist,
         * besteht die Möglichkeit, dass es gerade eine Viertelstunde
         * oder eine ganze Stunde ist
         *
         * Notiz: 0 % 15 = 0
         */
        if (minuten % 15 == 0) {
            bim = repeat("Bim", minuten / 15);

            // Wenn die Minuten gleich Null sind => Ganze Stunde
            if (minuten == 0) {
                bim = repeat("Bim", 4);

                if (stunden == 0) {
                    stunden = 12;
                }

                if (stunden > 12) {
                    stunden -= 12;
                }

                bam = repeat("Bam", stunden);
            }
        }

        return bim + bam;
    }
}
