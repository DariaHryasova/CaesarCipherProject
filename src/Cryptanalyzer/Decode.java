package Cryptanalyzer;

import static Cryptanalyzer.Alphabet.*;

public class Decode {


    public static String decode(String inputText, int key) {

        String decryptedText = "";
        for (int i = 0; i < inputText.length(); i++) {
            char currentChar = inputText.charAt(i);
            if (!Character.isAlphabetic(currentChar)) {
                decryptedText = decryptedText + currentChar;
                continue;
            }

            if (Character.isLowerCase(currentChar)) {
                int charIndex = ALPHABET_LOWER.indexOf(currentChar);
                int shiftIndex = (charIndex - key) % LATIN_SIZE;
                if (shiftIndex < 0) {
                    shiftIndex = LATIN_SIZE + shiftIndex;
                }
                char cipherChar = ALPHABET_LOWER.charAt(shiftIndex);
                decryptedText = decryptedText + cipherChar;
            } else {
                int charIndex = ALPHABET_UPPER.indexOf(currentChar);
                int shiftIndex = (charIndex - key) % LATIN_SIZE;
                if (shiftIndex < 0) {
                    shiftIndex = LATIN_SIZE + shiftIndex;
                }
                char cipherChar = ALPHABET_UPPER.charAt(shiftIndex);
                decryptedText = decryptedText + cipherChar;
            }
        }
        return decryptedText;
    }
}
