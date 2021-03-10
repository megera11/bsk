public class MatrixCPs2 {
    String key;

    public MatrixCPs2(String key) {
        this.key = key;
    }


    public String encryption(String password) {
        String pom = password.replaceAll("\\s", "");

        int len = 0;
        int len2=pom.length();
        int[] kywrdNumList = keywordNumAssign(key);
        for(int i =0;len2>0;i++){
            for(int j=0;j<kywrdNumList.length;j++){
                if(kywrdNumList[j]==i+1 ){
                    len2-=j+1;
                    len++;
                }
            }
            if(i>kywrdNumList.length){
                i=0;
            }
        }

        int numOfRows = len+1;
        char[][] arr = new char[numOfRows][key.length()];

        int d = 0;
        for (int i = 0; i<numOfRows; i++) {
            for (int j = 0; j < kywrdNumList.length; j++) {
                if (kywrdNumList[j] == i%kywrdNumList.length+1) {
                    for (int a = 0; a < j + 1; a++) {
                        if (d < pom.length()) {
                            arr[i][a] = pom.charAt(d++);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < key.length(); j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


        StringBuilder cipherText = new StringBuilder();
        for (int i = 0, k = 0; i < key.length(); i++, k++) {
            int g;
            if (k > key.length()) {
                break;
            } else {
                g = getNumberLocation(k, kywrdNumList);
            }
            for (int j = 0; j < numOfRows; j++) {
                    cipherText.append(arr[j][g]);
            }
            cipherText.append(" ");
        }
        return cipherText.toString();
    }



    public String decryption(String password) {
        String[] result = password.split(" ");
        String pom1 = password.replaceAll("\\s", "");

        int len = 0;
        int len2=pom1.length();
        int[] kywrdNumList = keywordNumAssign(key);
        for(int i =0;len2>0;i++){
            for(int j=0;j<kywrdNumList.length;j++){
                if(kywrdNumList[j]==i+1 ){
                    len2-=j+1;
                    len++;
                }
            }
            if(i>kywrdNumList.length){
                i=0;
            }
        }

        int numOfRows = len+1;
        char[][] arr = new char[numOfRows][key.length()];


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
                if(arr[i][j]!=(char)0) {
                    if (arr[i][j] == ' ') {
                        plainText.append(arr[++i][j] + " ");
                        i--;
                    } else
                        plainText.append(arr[i][j] + " ");
                }
            }

        }

        return plainText.toString();

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

    private int getNumberLocation(int number, int[] kywrdNumList) {
        int position = 0;
        for (int j = 0; j < key.length(); j++) {
            if (kywrdNumList[j] == number + 1) {
                position = j;
            }
        }
        return position;
    }
}
