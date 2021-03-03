import java.lang.reflect.Array;

public class MatrixAPs1 {

    int[] key;
    char[][] encrypted;
    int z = 0;

    public MatrixAPs1(/*String key, String passwd*/){
        String passwd = "CRYPTOGRAPHYOSA";
        String key= "3-1-4-2";
        String[] result = key.split("-");

        this.key = new int[result.length];

        for(int i=0; i<result.length; i++){
            this.key[i] = Integer.parseInt(result[i]);
        }
        int cos = passwd.length()/this.key.length+1;
        encrypted = new char[this.key.length][cos];

        for(int i=0; i<this.key.length; i++){
            for(int j=0; j<cos; j++){
                if(passwd.length() > z){
                    encrypted[i][j] = passwd.charAt(z);
                    z++;
                }
            }
        }

        for(int i=0; i<encrypted.length; i++){
            for(int j=0; j<this.key.length; j++){
                if(encrypted[i][this.key[j]-1] != 0)
                System.out.println(encrypted[i][this.key[j]-1]);
            }
        }

    }
}
