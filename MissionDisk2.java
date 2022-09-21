import java.util.*;


public class MissionDisk2 {
	public static int ggT(int a, int b) {
		int max  = Math.max(a, b);
		int min  = Math.min(a, b);
        int rest = max % min;

		while (rest != 0) {
			max  = min;
			min  = rest;
            rest = max % min;
		}

        return min;
	}

    public static int kgV(int a, int b) {
    	return (a*b)/ggT(a, b);
    }

    // Nicht Teil der MissionDisk2
	public static boolean istPrimzahl(int x) {
		for (int i = 2; i <= x/2; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
	}

	public static String primfaktoren(int x) {
        if (istPrimzahl(x)) {
            return String.valueOf(x);
        }

        int primzahl = 2;
        String primfaktoren = "";

        while (x != 1) {
            if (!istPrimzahl(primzahl) || x % primzahl != 0) {
                primzahl += 1;
                continue;
            }

            primfaktoren += String.format("%d ", primzahl);
            x /= primzahl;
        }

        return primfaktoren.strip();
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

		return (x > 9) && (str.matches(String.format("%s{%d}", str.substring(0, 1), str.length())));
	}

	public static boolean istSymmetrisch(int x) {
        StringBuilder str = new StringBuilder(String.valueOf(x));

        return String.valueOf(x).equals(str.reverse().toString());
	}

	public static int umkehren(int x) {
		String str = new StringBuilder(String.valueOf(x))
                            .reverse()
                            .toString()
                            .replaceAll("^0+(?=[1-9])", "");

        return Integer.valueOf(str);
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

        String roemisch = "";
        Object[] alleTeiler = roemischeZahlen.keySet().toArray();

        // {1000, 900, 500, ...}
        Arrays.sort(alleTeiler, Collections.reverseOrder());

        for (Object teiler : alleTeiler) {
            int res = x/((int) teiler);

            if (res >= 1) {
                roemisch += roemischeZahlen.get(teiler).repeat(res);
                x -= ((int) teiler)*res;
            }
        }

		return roemisch;
	}

	public static String zahlVorlesen(int x) {
        Map<Integer, String> einerAussprache = new HashMap<Integer, String>();

        einerAussprache.put(1, "eins");
        einerAussprache.put(2, "zwei");
        einerAussprache.put(3, "drei");
        einerAussprache.put(4, "vier");
        einerAussprache.put(5, "fuenf");
        einerAussprache.put(6, "sechs");
        einerAussprache.put(7, "sieben");
        einerAussprache.put(8, "acht");
        einerAussprache.put(9, "neun");

        if (x < 10) {
            return einerAussprache.get(x);
        }

        switch (x) {
            case 10:
                return "zehn";
            case 11:
                return "elf";
            case 12:
                return "zwoelf";
            case 16:
                return "sechzehn";
            case 17:
                return "siebzehn";
        }

        einerAussprache.put(1, "ein");

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

            return einerAussprache.get(zehner) + "zig";
        } else if (zehner == 1) {
            return einerAussprache.get(einser) + "zehn";
        }

        String zahl = einerAussprache.get(einser) + "und";

        if (zehnerAussprache.containsKey(zehner)) {
            zahl += zehnerAussprache.get(zehner);
        } else {
            zahl += einerAussprache.get(zehner) + "zig";
        }

        return zahl;
	}
}
