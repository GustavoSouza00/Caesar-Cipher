import edu.duke.*;

public class TestCaesarEncrypt {
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private int[] countLetters(String words) {
        int[] letterQtd = new int[26];
        String wordUpeer = words.toUpperCase();

        for (int l=0; l<words.length(); l++) {
            char letter = wordUpeer.charAt(l);
            int letterPositionAlphabet = alphabet.indexOf(letter);

            if(letterPositionAlphabet != -1){
                letterQtd[letterPositionAlphabet] += 1;
            }
        }

        //System.out.println(letterQtd);
        return letterQtd;
    }

    private char maxIndex(int[] qtdLetters) {
        int positionLetter = -1;
        Character letter = null;

        for (int i = 0; i < qtdLetters.length; i++) {
            if (qtdLetters[i] > positionLetter) {
                positionLetter = qtdLetters[i];
                letter = alphabet.charAt(i);
            }
        }

        //System.out.println(letter);
        return letter;
    }

    public void simpleTests() {
        FileResource fr = new FileResource();
        String words = fr.asString();

        CaesarEncrypt ce = new CaesarEncrypt(18);
        String encryptedMessage = ce.encrypt(words);
        ce.decrypt(encryptedMessage);
    }

    public int breakCaesarCipher(String input){
        int key = 0;

        for(int i=1; i<=26; i++){
            CaesarEncrypt ce = new CaesarEncrypt(i);
            
            String wordsEncrypted = ce.decrypt(input);
            int[] numberLetters = countLetters(wordsEncrypted);
            char maxIndexLetter = maxIndex(numberLetters);

            if(maxIndexLetter == 'E'){
                key = i;
            }else if(maxIndexLetter == 'T' & key == 0){
                key = i;
            }
        }

        System.out.println(key);
        return key;
    }
}
