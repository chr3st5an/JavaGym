public class MissionDisk1 {
    public static String echo(String s, int anzahl) {
        return s.repeat(anzahl);
    }

    public static boolean genauEins(boolean a, boolean b) {
        return a ^ b;
    }

    public static boolean schaltjahr(int x) {
        return (x % 100 != 0) ? x % 4 == 0 : x % 400 == 0;
    }

    public static int fakultaet(int n) {
        return (n > 0) ? n * fakultaet(n - 1) : 1;
    }

    public static int millionaer(double i) {
        return (int) Math.ceil(Math.log(1_000_000) / Math.log(1+i));
    }

    public static int potenz(int basis, int exponent) {
        return (int) Math.pow(basis, exponent);
    }

    public static double ungefaehrPi(int anzahlSummanden) {
        double sum = 0;

        for (int n = 0; n < anzahlSummanden; n++) {
            sum += Math.pow(-1, n) / (2*n + 1);
        }

        return 4*sum;
    }

    public static boolean istPrimzahl(int x) {
        for (int i = 2; i <= x/2; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int abrunden(int x, int raster) {
        return x - (x % raster);
    }

    public static int quersumme(int x) {
        int sum = 0;

        for (String chr : String.valueOf(x).split("")) {
            sum += Integer.valueOf(chr);
        }

        return sum;
    }
}
