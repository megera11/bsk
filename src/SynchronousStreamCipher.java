import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SynchronousStreamCipher {

    private String passwd = "";
    private List<Integer> passwdlist = new ArrayList<Integer>();
    private LFSR lfsr;

    public SynchronousStreamCipher(String passwd, LFSR lfsr){
        this.passwd = passwd;
        this.lfsr = lfsr;
    }

    public SynchronousStreamCipher(File file, LFSR lfsr) throws IOException {
        byte[] filebytes = Files.readAllBytes(file.toPath());
        for (int i = 0;i < filebytes.length; i++){
            this.passwd += String.format("%8s", Integer.toBinaryString(filebytes[i] & 0xFF)).replace(' ', '0');
            System.out.println(passwd);
        }
        this.lfsr = lfsr;
    }

    public void encryptFile(){
        String result = "";
        for(int i = 0; i<passwd.length(); i++){
            passwdlist.add((int) passwd.charAt(i)-48);
        }

        for(int i = 0; i < passwdlist.size(); i++){
            result = result + (lfsr.step()^passwdlist.get(i));
        }

        byte[] bytes = new byte[result.length()/8];
        int j=0;
        for(String str : result.split("(?<=\\G.{8})")) {
            bytes[j] = (byte) Integer.parseInt(str, 2);
            j++;
        }

        try (FileOutputStream fos = new FileOutputStream("pathname.pdf")) {
            fos.write(bytes);
            //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
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
