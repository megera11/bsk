import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class LFSR {

    private String reg;
    private int N;

    public LFSR(String seed) {
        reg = seed;
        N = seed.length();
    }

    public static int ithConv(String str, int i) {
        return (int) (str.charAt(i) - '0');
    }

    public int step() {
        String oldReg = reg;
        int tapBit = ithConv(oldReg, N - 1);
        int fstBit = ithConv(oldReg, 0);
        int curLastBit = tapBit ^ fstBit;
        char firstChar;
        if (curLastBit == 0)
            firstChar = '0';
        else
            firstChar = '1';

        reg = firstChar + oldReg.substring(0, oldReg.length() - 1);
        return tapBit;
    }


    public String toString() {
        return reg;
    }

    public String generate(JToggleButton button, JTextPane jTextPane) {
        final String[] result = {""};
        Thread thread = new Thread(){
            public void run(){
                while(!button.isSelected()) {

                    int bit = step();
                    result[0] += bit;
                    System.out.println(result[0]);
                    jTextPane.setText(result[0]);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                button.setSelected(false);
            }
        };
        thread.start();
        if(button.getModel().isPressed()){
            thread.stop();
        }
        /*while (!button.getModel().isPressed()) {

        }*/
        return result[0];
    }

    public static String convertPolynomial(String string) {
        String[] pom = string.split("(-|\\+)");
        int size = string.charAt(string.length()-1)-'0';
        String[] pom1 = pom[pom.length-1].split("\\^");
        char seed[] = new char[Integer.parseInt(pom1[1])+1];

        for(int i =0; i<seed.length;i++){
            seed[i]='0';
        }

        for (int i = 0; i < pom.length; i++) {
            String[] parts = pom[i].split("\\^");
           if(parts[0].charAt(0)=='x' && parts.length==1){
             seed[1]='1';
           }else if(parts[0].charAt(0) == '1' && parts.length==1){
               seed[0]='1';
           }else if(parts.length>1){
               seed[Integer.parseInt(parts[1])] ='1';
           }

        }
        String result= "";
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<seed.length;i++){
           sb.append(seed[i]);
        }
        return sb.toString();
    }
}

