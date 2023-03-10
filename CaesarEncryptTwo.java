import edu.duke.*;

public class CaesarEncryptTwo {
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedAlphabet1 = null;
    private String shiftedAlphabet2 = null;
    private int key1 = 0;
    private int key2 = 0;

    public CaesarEncryptTwo(int key1, int key2) {
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        this.key1 = key1;
        this.key2 = key2;
    }

    public String encrypt(String text) {
        String textHandle = text.toUpperCase();
        String result = "";

        for (int l = 0; l < text.length(); l++) {
            char currentLetter = textHandle.charAt(l);
            int indexLetter = alphabet.indexOf(currentLetter);
            String encryptedWord = "";

            if (indexLetter != -1) {
                char firstLetter = shiftedAlphabet1.charAt(indexLetter);
                char secondtLetter = shiftedAlphabet2.charAt(indexLetter);
                if (l % 2 == 0) {
                    if (Character.isUpperCase(text.charAt(l))) {
                        encryptedWord = Character.toString(firstLetter);
                    } else {
                        encryptedWord = Character.toString(firstLetter).toLowerCase();
                    }
                } else {
                    if (Character.isUpperCase(text.charAt(l))) {
                        encryptedWord = Character.toString(secondtLetter);
                    } else {
                        encryptedWord = Character.toString(secondtLetter).toLowerCase();
                    }
                }
            } else {
                encryptedWord = Character.toString(currentLetter);
            }
            result += encryptedWord;
        }

        System.out.println(result);
        return result;
    }

    public String decrypt(String input) {
        String inputUpper = input.toUpperCase();
        String result = "";

        String alphabet1 = alphabet.substring(26 - key1) + alphabet.substring(0, 26 - key1);
        String alphabet2 = alphabet.substring(26 - key2) + alphabet.substring(0, 26 - key2);

        for (int i = 0; i < input.length(); i++) {
            char letter = inputUpper.charAt(i);
            int indexLetter = alphabet.indexOf(letter);
            String decryptedWord = "";

            if (indexLetter != -1) {
                char firstLetter = alphabet1.charAt(indexLetter);
                char secondtLetter = alphabet2.charAt(indexLetter);
                if (i % 2 == 0) {
                    if (Character.isUpperCase(input.charAt(i))) {
                        decryptedWord = Character.toString(firstLetter);
                    } else {
                        decryptedWord = Character.toString(firstLetter).toLowerCase();
                    }
                } else {
                    if (Character.isUpperCase(input.charAt(i))) {
                        decryptedWord = Character.toString(secondtLetter);
                    } else {
                        decryptedWord = Character.toString(secondtLetter).toLowerCase();
                    }
                }
            } else {
                decryptedWord = Character.toString(letter);
            }
            result += decryptedWord;
        }
        System.out.println(result);
        return result;
    }

}
