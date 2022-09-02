import javax.swing.*;

public class Cifrado {

    private char[] abecedario  = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','A'};
    private char [][] cuadro = new char[26][26];
    private int pos = 0;
    private char [] plainText;
    private char [] key;
    private char cipherText[];
    private char deCipherText[];

    Cifrado(){
        for (int i = 0; i <= 25; i++){
            pos = i;
            for (int j = 0; j <= 25; j++){
                cuadro[i][j] = abecedario[pos++];
                if (pos > 25){
                    pos = 0;
                }
            }

        }
    }

    void displaying(){
        for (int i = 0; i < 26; i++){
            for (int j = 0; j < 26; j++){
                System.out.print(cuadro[i][j] + "   ");
            }
            System.out.print("\n");
        }
    }

    void plainText(String sentplainText){
        plainText = new char[sentplainText.length()];
        for (int i = 0; i < sentplainText.length(); i++){
            plainText[i] = sentplainText.charAt(i);
        }

    }

    void saveKey(String sentKey){
        key = new char[sentKey.length()];
        for (int i = 0; i < sentKey.length(); i++){
            key[i] = sentKey.charAt(i);

        }

    }


    int posAbecedario(char letter){
        for (int i = 0; i <= 25; i++){
            if (abecedario[i] == letter){
                return i;
            }
        }
        return 1000;
    }

    void cipher(){
        cipherText = new char[plainText.length];
        int posVertical = 0;
        int posHorizontal = 0;
        int spaces = 0;
        pos = 0;

        for (int i = 0; i < plainText.length; i++){

            posVertical = posAbecedario(key[pos++]);
            posHorizontal = posAbecedario(plainText[i]);

            if(posHorizontal != 1000){
                cipherText[i] = cuadro[posVertical][posHorizontal];
            }else {
                cipherText[i] = ' ';
                pos--;
            }


            if (pos >= key.length){
                pos = 0;
            }

        }

    }

    int posDescrifrado(int posVertical, char letter){
        for (int i = 0; i < abecedario.length-1; i++){
            if(cuadro[posVertical][i] == letter){
                return i;
            }

        }
        return 1000;
    }

    void deCipher(){

        deCipherText = new char[plainText.length];
        int posVertical = 0;
        int posHorizontal = 0;
        int spaces = 0;
        pos = 0;

        for (int i = 0; i < plainText.length; i++){

            posVertical = posAbecedario(key[pos++]);
            posHorizontal = posDescrifrado(posVertical, plainText[i]);

            if(posHorizontal != 1000){
                deCipherText[i] = abecedario[posHorizontal];
            }else {
                deCipherText[i] = ' ';
                pos--;
            }


            if (pos >= key.length){
                pos = 0;
            }

        }


    }

    void displaycipherText(){
        cipher();
        for (int i = 0; i < cipherText.length; i++){
            System.out.print(cipherText[i]);
        }
        System.out.println();
        JOptionPane.showMessageDialog(null, "Imprimiendo resultado en la consola...");
    }




    void displayDecipherText(){
        deCipher();
        for (int i = 0; i < deCipherText.length; i++){
            System.out.print(deCipherText[i]);
        }
        System.out.println();
        JOptionPane.showMessageDialog(null, "Imprimiendo resultado en la consola...");
    }


}
