import javax.swing.*;
import java.util.Scanner;

public class probando {
    public static void main(String[] args) {
        Cifrado c = new Cifrado();
        String opc = "1";


        while (!opc.equals("0")){
            opc = JOptionPane.showInputDialog(null,"************************\nSELECCIONA UNA OPCION:\n" +
                    "1.- Cifrar texto" +
                    "\n2.- Descrifrar texto\n" +
                    "0.- Salir\n************************");
            if(opc.equals("0") || opc.equals("1") || opc.equals("2")){
                switch (opc){
                    case "1":
                        String texto = JOptionPane.showInputDialog("Indique el texto que desea cifrar: ");
                        String key = JOptionPane.showInputDialog("Indique la llave del cifrado: ");
                        c.plainText(texto.toUpperCase());
                        c.saveKey(key.toUpperCase());
                        c.displaycipherText(); break;

                    case "2":
                        texto = JOptionPane.showInputDialog("Indique el texto que desea descifrar: ");
                        key = JOptionPane.showInputDialog("Indique la llave del descifrado: ");
                        c.plainText(texto.toUpperCase());
                        c.saveKey(key.toUpperCase());
                        c.displayDecipherText(); break;

                    case "0":
                        JOptionPane.showMessageDialog(null, "MUCHAS GRACIAS");

                }
            }else{
                JOptionPane.showMessageDialog(null, "OPCION INCORRECTA", "Title",  JOptionPane.WARNING_MESSAGE);
            }



        }

        
    }
}
