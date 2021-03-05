import java.lang.reflect.Array;

public class MatrixAPs1 {

    int[] key;
    char[][] encrypted;
    int z = 0;
    String cryptedpasswd = "";

    public MatrixAPs1(String key){

        String[] result = key.split("-");

        this.key = new int[result.length];

        for(int i=0; i<result.length; i++){
            this.key[i] = Integer.parseInt(result[i]);
        }


    }

    public String getEncryptedData(String passwd){
        int row = passwd.length()/this.key.length+1;
        encrypted = new char[row][this.key.length];

        for(int i=0; i<row; i++){
            for(int j=0; j<this.key.length; j++){
                if(passwd.length() > z){
                    encrypted[i][j] = passwd.charAt(z++);
                }
                else
                    encrypted[i][j] = ' ';
            }
        }

        for(int i=0; i<encrypted.length; i++){
            for(int j=0; j<this.key.length; j++){
                if(encrypted[i][this.key[j]-1] == ' ')
                    cryptedpasswd = cryptedpasswd + " ";
                else
                    cryptedpasswd = cryptedpasswd + encrypted[i][this.key[j]-1];
            }
        }
        return cryptedpasswd;
    }

    public String getDecryptedData(String passwd){
        int row = passwd.length()/this.key.length+1;
        encrypted = new char[row][this.key.length];

        for(int i=0; i<row; i++){
            for(int j=0; j<this.key.length; j++){
                if(passwd.length() > z){
                    encrypted[i][this.key[j]-1] = passwd.charAt(z++);
                }
            }
        }

        for(int i=0; i<encrypted.length; i++){
            for(int j=0; j<this.key.length; j++){
                    cryptedpasswd = cryptedpasswd + encrypted[i][j];
            }
        }

        return cryptedpasswd;
    }
}