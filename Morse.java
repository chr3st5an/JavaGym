public class Morse {
    static final String alleZeichen = "**ETIANMSURWDKGOHVF*L*PJBXCYZQ**";

	/**
	 * Reverse the given string
	 *
	 * @return the reversed string
	 */
	static String reverse(String str) {
		return (new StringBuilder(str)).reverse().toString();
	}

	public static String encodeMorse(String str) {
        String morseCode = "";

		for (String chr : str.split("")) {
			if (chr.equals(" ")) {
				// Nur ein Whitespace, weil wegen der vorherigen Iteration
				// schon ein Whitespace am Ende ist
				morseCode += " ";
				continue;
			}

            int index = alleZeichen.indexOf(chr);
			String characters = "";

			while (index != 1) {
                if ((index & 1) == 0) {
                    characters += ".";
                    index /= 2;
                } else {
                    characters += "-";
                    index = (index - 1)/2;
                }
            }

            morseCode += String.format("%s ", reverse(characters));
        }

        return morseCode;
	}

	public static String decodeMorse(String str) {
		String decodedMorseCode = "";
		String[] groups = str.replaceAll("\\s{2}", " * ").split(" ");

		// "*" als Signalzeichen für ein whitespace
        for (String group : groups) {
            if (group.equals("*")) {
                decodedMorseCode += " ";
                continue;
            }

            int targetIndex = 1;

            for (String morseCharacter : group.split("")) {
                targetIndex = targetIndex*2 + (morseCharacter.equals("-") ? 1 : 0);
            }

            decodedMorseCode += alleZeichen.charAt(targetIndex);
        }

        return decodedMorseCode;
	}
}
