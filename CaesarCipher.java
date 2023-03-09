public class CaesarCipher{
    public static void main(String[] args){
        CaesarEncrypt ce = new CaesarEncrypt(10);
        String g = ce.encrypt("The Godfather Part 2 is eeeeEVEN BETTER THAN PART ONE!! | Canadians First Time Watching | Movie Reaction");
        //ce.decrypt(g);

        TestCaesarEncrypt tce = new TestCaesarEncrypt();
        int x = tce.breakCaesarCipher(g);

        CaesarEncrypt ce1 = new CaesarEncrypt(x);
        //String f = ce.encrypt(g);
        //ce.decrypt(g);

    }
}