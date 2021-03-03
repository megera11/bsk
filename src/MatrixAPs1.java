import java.lang.reflect.Array;

public class MatrixAPs1 {

    int[] key;
    char[][] encrypted;
    int z = 0;
    String cryptedpasswd = "";

    public MatrixAPs1(/*String key, String passwd*/){

        String key= "3-1-4-2";
        String[] result = key.split("-");

        this.key = new int[result.length];

        for(int i=0; i<result.length; i++){
            this.key[i] = Integer.parseInt(result[i]);
        }


    }

    public String getEncryptedData(){
        String passwd = "CRYPTOGRAPHYOSA";
        int cos = passwd.length()/this.key.length+1;
        encrypted = new char[this.key.length][cos];

        for(int i=0; i<this.key.length; i++){
            for(int j=0; j<cos; j++){
                if(passwd.length() > z){
                    encrypted[i][j] = passwd.charAt(z++);
                }
            }
        }

        for(int i=0; i<encrypted.length; i++){
            for(int j=0; j<this.key.length; j++){
                if(encrypted[i][this.key[j]-1] != 0)
                    cryptedpasswd = cryptedpasswd + encrypted[i][this.key[j]-1];
            }
        }
        return cryptedpasswd;
    }

    public String getDecryptedData(){
        String passwd = "YCPRGTROHAYPAOS";
        int cos = passwd.length()/this.key.length+1;
        encrypted = new char[this.key.length][cos];

        for(int i=0; i<this.key.length; i++){
            for(int j=0; j<cos; j++){
                if(passwd.length() > z){
                    encrypted[i][this.key[j]-1] = passwd.charAt(z++);
                }
            }
        }

        for(int i=0; i<encrypted.length; i++){
            for(int j=0; j<this.key.length; j++){
                if(encrypted[i][this.key[j]-1] != 0)
                    cryptedpasswd = cryptedpasswd + encrypted[i][j];
            }
        }
        System.out.println();
        return cryptedpasswd;
    }
}
