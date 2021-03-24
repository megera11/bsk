import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SynchronousStreamCipher {

    private String key;
    private String passwd;
    private List<Integer> keylist = new ArrayList<Integer>();
    private List<Integer> passwdlist = new ArrayList<Integer>();
    private LFSR lfsr;

    public SynchronousStreamCipher(String passwd, LFSR lfsr){
        //this.key = key;
        this.passwd = passwd;
        this.lfsr = lfsr;
    }

    public void keytolist(LFSR lfsr){
        key = lfsr.generate();
        for(int i = 0; i<key.length(); i++){
            keylist.add((int) key.charAt(i)-48);
        }
    }


    public String encrypt(){
        String result = "";
        String binary = "";

        for (int i =0;i<passwd.getBytes().length;i++){
            binary+= String.format("%8s", Integer.toBinaryString(passwd.getBytes()[i] & 0xFF)).replace(' ', '0');
        }
        for(int i = 0; i<binary.length(); i++){
            passwdlist.add((int) binary.charAt(i)-48);
        }

        for(int i = 0; i < passwdlist.size(); i++){
            result = result + (lfsr.step()^passwdlist.get(i));
        }

        return result;
    }

    public String decrypt(){
        String result = "";
        String result1 = "";
        for(int i = 0; i<passwd.length(); i++){
            passwdlist.add((int) passwd.charAt(i)-48);
        }

        for(int i = 0; i < passwdlist.size(); i++){
            result = result + (lfsr.step()^passwdlist.get(i));
        }

        for(int i = 0; i<=result.length() - 8; i+=8){
            int k = Integer.parseInt(result.substring(i, i+8), 2);
            result1 += (char)k;
        }

        return result1;
    }
}
