import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LFSR {

    private String reg;
    private int N;
    private JButton button;

    public LFSR(String seed, JButton button) {
        reg = seed;
        N = seed.length();
        this.button = button;
    }

    public static int ithConv(String str, int i) {
        return (int) (str.charAt(i) - '0');
    }

    public int step() {
        String oldReg = reg;
        int tapBit = ithConv(oldReg, N - 1);
        int fstBit = ithConv(oldReg, 0);
        int curLastBit = tapBit ^ fstBit;
        char lastChar;
        if (curLastBit == 0)
            lastChar = '0';
        else
            lastChar = '1';

        reg = lastChar + oldReg.substring(0, oldReg.length() - 1);
        return tapBit;
    }


    public String toString() {
        return reg;
    }

    public String generate() {
        String seed = "0110";
        String result = "";
        while (!button.getModel().isPressed()) {
            int bit = step();
            result += bit;
        }
        return result;
    }

    public static String convertPolynomial(String string) {
        String[] pom = string.split("(-|\\+)");
        int[] result = new int[pom.length];
        for (int i = 0; i < pom.length; i++) {
            String[] parts = pom[i].split("\\^");
            result[i] = (parts.length > 1 ? Integer.parseInt(parts[1]) : 1);
        }

        System.out.println(2);
        return "";
    }
}

