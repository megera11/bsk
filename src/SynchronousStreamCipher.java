import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class SynchronousStreamCipher {

    private String passwd ;
    private List<Integer> passwdlist = new ArrayList<Integer>();
    private LFSR lfsr;
    private String fileFormat[] ;
    private byte[] filebytes;

    public SynchronousStreamCipher(String passwd, LFSR lfsr){
        this.passwd = passwd;
        this.lfsr = lfsr;
    }

    public SynchronousStreamCipher(File file, LFSR lfsr) throws IOException {
        filebytes = Files.readAllBytes(file.toPath());
        fileFormat = file.getName().split("\\.");
        this.lfsr = lfsr;
    }

    public void encryptFile(){
       BitSet bitset = BitSet.valueOf(filebytes);
       BitSet random  = new BitSet();
       for(int i = 0; i < bitset.length(); i++){
            if(lfsr.step()==1){
                random.set(i);
            }
        }
        bitset.xor(random);


        try (FileOutputStream fos = new FileOutputStream("szyfrowany." + fileFormat[fileFormat.length-1])) {
            fos.write(bitset.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(){
        String result = "";
        String binary = "";
        for (int i = 0; i < passwd.getBytes().length; i++){
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