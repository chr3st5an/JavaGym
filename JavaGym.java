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
        return ~x + 1;
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
        return betrag(x) < 10;
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
        return betrag(x1 - x2)*betrag(y1 - y2);
    }

    public static boolean istZweistellig(int x) {
        // 9 < |x| && |x| < 100
        return (9 < betrag(x)) && (betrag(x) < 100);
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
        if (n > 1) {
            return ((n & 1) == 1 ? 0 : n) + summeGeradeZahlenBis(n - 1);
        }

        return 0;
    }

    public static int mittlerste(int a, int b, int c) {
        return (a > Math.max(b, c)) ? Math.max(b, c) : Math.max(a, Math.min(b, c));
    }

    /**
     * Hilfsmethode, da es in Java 8 noch nicht die
     * eingebaute `repeat` String methode gibt
     *
     * @param str der String, der wiederholt werden soll
     * @param n wie oft der String wiederholt werden soll
     * @return der wiederholte String
     */
    static String repeat(String str, int n) {
        return (n > 0) ? str + repeat(str, n - 1) : "";
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
