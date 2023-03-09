import edu.duke.*;

public class CaesarEncryptTwo {
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedAlphabet1 = null;
    private String shiftedAlphabet2 = null;

    //public CaesarEncryptTwo(int Key1)

    public void CaesarBreaker(String text) {
        String textHandle = text.toUpperCase();
        
        String result = "";

        for (int i = 1; i <= base.length(); i++) {
            String firstKey = base.substring(i) + base.substring(0, i);
            // System.out.printf("%nKey1 = %d -- %s", i, firstKey);
            for (int k = 1; k <= base.length(); k++) {
                String secondKey = base.substring(k) + base.substring(0, k);
                // System.out.printf("%n%nKey2 = %d -- %s", k, secondKey);
                for (int t = 0; t < text.length(); t++) {
                    char currentLetter = textHandle.charAt(t);
                    int indexLetter = base.indexOf(currentLetter);
                    String l = "";
                    if (indexLetter != -1) {
                        char firstLetter = firstKey.charAt(indexLetter);
                        char secondtLetter = secondKey.charAt(indexLetter);
                        if (t % 2 == 0) {
                            l = Character.toString(firstLetter);
                        } else {
                            l = Character.toString(secondtLetter);
                        }
                    } else {
                        l = Character.toString(currentLetter);
                    }
                    result += l;
                }
                System.out.printf("%nKey1 = %d - Key2 = %d -- %s", i, k, result);
                result = "";
            }
            result = "";
        }
    }

    public void testCaesarBreaker() {
        CaesarBreaker("Xifqvximt tsdtlxzrx iijirvtl ek Uybi");
    }
}
