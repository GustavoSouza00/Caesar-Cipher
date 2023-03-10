public class TestCaesarEncryptTwo {
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String halfOfString(String message, int start){
        String result = "";

        for(int i=0; i<message.length(); i++){
            char letter = message.charAt(i);

            if(start % 2 == 0 && i % 2 == 0){
                result += letter;
            }else if(start == 1 || i % 3 == 0){
                result += letter;
            }
        }

        System.out.println(result);
        return result;
    }

    public int[] countLetters(String words) {
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

    public char maxIndex(int[] qtdLetters) {
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

    public String breakCaesarCipher(String input){
        String inputUpper = input.toUpperCase();
        String currentWord = "";

        String finalWord = "";
        int key1 = 0;
        int key2 = 0;

        int maxLetter = 0;

        for(int i=1; i<alphabet.length(); i++){
            String alphabet1 = alphabet.substring(i) + alphabet.substring(0, i);

            for(int j=1; j<alphabet.length(); j++){
                String alphabet2 = alphabet.substring(j) + alphabet.substring(0, j);

                for(int l=0; l<input.length(); l++){
                    char curentLetter = inputUpper.charAt(l);
                    int indexLetter = alphabet.indexOf(curentLetter);
                    String word = "";

                    if(indexLetter != -1){
                        if(l % 2 == 0){
                            word += alphabet1.charAt(indexLetter);
                        } else{
                            word += alphabet2.charAt(indexLetter);
                        }
                    } else{
                        word += curentLetter;
                    }
                    currentWord += word;
                }
                //System.out.println(currentWord);
                int[] arrayLeters = countLetters(currentWord);
                char comunLetter = maxIndex(arrayLeters);
                if(comunLetter == 'E'){
                    if(arrayLeters[4] > maxLetter){
                        finalWord = currentWord;
                        key1 = i;
                        key2 = j;
                        maxLetter = arrayLeters[4];
                    }
                }else if(comunLetter == 'T' && finalWord == ""){
                    finalWord = currentWord;
                    key1 = i;
                    key2 = j;
                }
                currentWord = "";
            }
            currentWord = "";
        }
        System.out.println(finalWord);
        return finalWord;
    }
}
