public class CaesarEncrypt{
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedAlphabet = null;
    private int key = 0;

    public CaesarEncrypt(int key){
        this.key = key;
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }

    public String encrypt(String input){
        String inputUpper = input.toUpperCase();
        String encryptWord = "";

        for(int i=0; i<input.length(); i++){
            char letter = inputUpper.charAt(i);
            int letterPosition = alphabet.indexOf(letter);

            if(Character.isLetter(letter)){
                if(Character.isUpperCase(input.charAt(i))){
                    encryptWord += Character.toString(shiftedAlphabet.charAt(letterPosition));
                }else{
                    encryptWord += Character.toString(shiftedAlphabet.charAt(letterPosition)).toLowerCase();
                }
            }else{
                encryptWord += Character.toString(input.charAt(i));
            }
            
        }

        System.out.println(encryptWord);
        return encryptWord;
    }

    public String decrypt(String input){
        String decryptAlphabet = alphabet.substring(26 - key) + alphabet.substring(0, 26 - key);
        String inputUpper = input.toUpperCase();
        String dencryptWord = "";

        for(int i=0; i<input.length(); i++){
            char letter = inputUpper.charAt(i);
            int letterPosition = alphabet.indexOf(letter);

            if(Character.isLetter(letter)){
                if(Character.isUpperCase(input.charAt(i))){
                    dencryptWord += Character.toString(decryptAlphabet.charAt(letterPosition));
                }else{
                    dencryptWord += Character.toString(decryptAlphabet.charAt(letterPosition)).toLowerCase();
                }
            }else{
                dencryptWord += Character.toString(input.charAt(i));
            }
            
        }

        System.out.println(dencryptWord);
        return dencryptWord;
    }
}