public class MatrixBPs1 {

    String key;


    public MatrixBPs1(String key) {
        this.key = key;
    }

    public String encryption(String password) {
        String psswd = "";
        String[] result = password.split(" ");
        for (int i = 0; i < result.length; i++) {
            psswd = psswd + result[i];
        }
        StringBuilder msg = new StringBuilder(psswd);

        int[] kywrdNumList = keywordNumAssign(key);

        int numOfRows = msg.length() / key.length() + 1;

        char[][] arr = new char[numOfRows][key.length()];

        int z = 0;
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (msg.length() > z) {
                    arr[i][j] = msg.charAt(z++);
                }
            }
        }
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0, k = 0; i < key.length(); i++, k++) {
            int d;
            if (k > key.length()) {
                break;
            } else {
                d = getNumberLocation(k, kywrdNumList);
            }
            for (int j = 0; j < numOfRows; j++) {
                cipherText.append(arr[j][d]);
            }
            cipherText.append(" ");
        }
        return cipherText.toString();
    }

    public String decryption(String password) {
        String pom = password.replaceAll("^[ \t]+|[ \t]+$", "");
        String[] result = pom.split(" ");
        int numOfRows = pom.length() / key.length() ;

        char[][] arr = new char[numOfRows][key.length()];

        int[] kywrdNumList = keywordNumAssign(key);

        int d=0;
        for (int k = 0,i = 0; i < result.length; i++,k++) {
            d=kywrdNumList[i]-1;
            for (int j = 0; j < result[d].length() ; j++) {
                    arr[j][k] = result[d].charAt(j);
            }
        }

        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (arr[i][j] == ' ') {
                    plainText.append(arr[++i][j] + " ");
                    i--;
                } else
                    plainText.append(arr[i][j] + " ");
            }

        }

        return plainText.toString();

    }

    private int getNumberLocation(int number, int[] kywrdNumList) {
        int position = 0;
        for (int j = 0; j < key.length(); j++) {
            if (kywrdNumList[j] == number + 1) {
                position = j;
            }
        }
        return position;
    }

    private static int[] keywordNumAssign(String keyword) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] kywrdNumList = new int[keyword.length()];

        int init = 0;
        for (int i = 0; i < alpha.length(); i++) {
            for (int j = 0; j < keyword.length(); j++) {
                if (alpha.charAt(i) == keyword.charAt(j)) {
                    init++;
                    kywrdNumList[j] = init;
                }
            }
        }
        return kywrdNumList;
    }

}
