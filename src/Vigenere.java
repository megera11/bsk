public class Vigenere {

    String str;
    String key;

    public Vigenere(String key, String str){

        this.str = str;

        int x = str.length();

        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key+=(key.charAt(i));
        }
        this.key = key;
    }

    public String encrypt(String str)
    {
        String cipher_text="";

        for (int i = 0; i < str.length(); i++)
        {
            int x = (str.charAt(i) + key.charAt(i)) %26;

            x += 'A';

            cipher_text+=(char)(x);
        }
        return cipher_text;
    }

    public String decrypt(String str)
    {
        String orig_text="";

        for (int i = 0 ; i < str.length() &&
                i < key.length(); i++)
        {
            int x = (str.charAt(i) -
                    key.charAt(i) + 26) %26;

            x += 'A';
            orig_text+=(char)(x);
        }
        return orig_text;
    }

}
