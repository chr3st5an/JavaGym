import java.util.*;


public class MissionDisk2 {
    // Nicht Teil der MissionDisk2
    static String repeat(String str, int n) {
        return (n > 0) ? str + repeat(str, n - 1) : "";
    }

    // Nicht Teil der MissionDisk2
    static String reverse(String str) {
        return (new StringBuilder(str)).reverse().toString();
    }

	public static int ggT(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
        int rest = max % min;

		while (rest != 0) {
			max = min;
			min = rest;
            rest = max % min;
		}

        return min;
	}

    public static int kgV(int a, int b) {
    	return (a*b)/ggT(a, b);
    }

    // Nicht Teil der MissionDisk2
	static boolean istPrimzahl(int x) {
		for (int i = 2; i <= x/2; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return x != 1;
	}

	public static String primfaktoren(int x) {
        if (istPrimzahl(x)) {
            return String.valueOf(x);
        }

        int jetzigePrimzahl = 2;
        String primfaktoren = "";

        while (x != 1) {
            if (!istPrimzahl(jetzigePrimzahl) || x % jetzigePrimzahl != 0) {
                jetzigePrimzahl++;
                continue;
            }

            primfaktoren += String.format("%d ", jetzigePrimzahl);
            x /= jetzigePrimzahl;
        }

        return primfaktoren.trim();
	}

	public static int anzahlStellen(int x) {
		return String.valueOf(x).length();
	}

	public static int stelle(int x, int s) {
        try {
		    return Integer.parseInt(String.valueOf(x).substring(s - 1, s));
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
	}

	public static boolean schnapszahl(int x) {
        String str = String.valueOf(x);

		return str.matches(String.format("^%s{2,}$", str.substring(0, 1)));
	}

	public static boolean istSymmetrisch(int x) {
        String str = String.valueOf(x);

        return str.equals(reverse(str));
	}

	public static int umkehren(int x) {
        return Integer.valueOf(
            reverse(String.valueOf(x)).replaceAll("^0+", "")
        );
	}

	public static String roemisch(int x) {
        Map<Integer, String> roemischeZahlen = new HashMap<Integer, String>();

        roemischeZahlen.put(1_000, "M");
        roemischeZahlen.put(900, "CM");
        roemischeZahlen.put(500, "D");
        roemischeZahlen.put(400, "CD");
        roemischeZahlen.put(100, "C");
        roemischeZahlen.put(90, "XC");
        roemischeZahlen.put(50, "L");
        roemischeZahlen.put(40, "XL");
        roemischeZahlen.put(10, "X");
        roemischeZahlen.put(9, "IX");
        roemischeZahlen.put(5, "V");
        roemischeZahlen.put(4, "IV");
        roemischeZahlen.put(1, "I");

        String roemischeZahl = "";
        Object[] alleTeiler = roemischeZahlen.keySet().toArray();

        // {1000, 900, 500, ...}
        Arrays.sort(alleTeiler, Collections.reverseOrder());

        for (Object teiler : alleTeiler) {
            int res = x/((int) (teiler));

            if (res >= 1) {
                roemischeZahl += repeat(roemischeZahlen.get(teiler), res);
                x -= ((int) (teiler))*res;
            }
        }

		return roemischeZahl;
	}

	public static String zahlVorlesen(int x) {
        Map<Integer, String> aussprache = new HashMap<Integer, String>();

        aussprache.put(1, "eins");
        aussprache.put(2, "zwei");
        aussprache.put(3, "drei");
        aussprache.put(4, "vier");
        aussprache.put(5, "fuenf");
        aussprache.put(6, "sechs");
        aussprache.put(7, "sieben");
        aussprache.put(8, "acht");
        aussprache.put(9, "neun");
        aussprache.put(10, "zehn");
        aussprache.put(11, "elf");
        aussprache.put(12, "zwoelf");
        aussprache.put(16, "sechzehn");
        aussprache.put(17, "siebzehn");

        if (aussprache.containsKey(x)) {
            return aussprache.get(x);
        }

        aussprache.put(1, "ein");

        Map<Integer, String> zehnerAussprache = new HashMap<Integer, String>();

        zehnerAussprache.put(2, "zwanzig");
        zehnerAussprache.put(3, "dreissig");
        zehnerAussprache.put(6, "sechzig");
        zehnerAussprache.put(7, "siebzig");

        int einser = Integer.parseInt(String.valueOf(x).substring(1, 2));
        int zehner = Integer.parseInt(String.valueOf(x).substring(0, 1));

        if (einser == 0) {
            if (zehnerAussprache.containsKey(zehner)) {
                return zehnerAussprache.get(zehner);
            }

            return aussprache.get(zehner) + "zig";
        } else if (zehner == 1) {
            return aussprache.get(einser) + "zehn";
        }

        String zahl = aussprache.get(einser) + "und";

        if (zehnerAussprache.containsKey(zehner)) {
            zahl += zehnerAussprache.get(zehner);
        } else {
            zahl += aussprache.get(zehner) + "zig";
        }

        return zahl;
	}
}
