import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Escribir {
final static Scanner SC = new Scanner(System.in);
public static void main(String[] args) {
  System.out.println("Introduce nombre del archivo a escribir: ");
    String ruta = SC.nextLine();
    File archivo = new File(ruta);
    if (archivo.exists() == false) {
        try {
            archivo.createNewFile();
        } catch (Exception e) {
            System.out.println("Error creando el archivo.");
        }
        System.out.println("El archivo no existe.");
    } 
    try {
        FileWriter fileWriter = new FileWriter(archivo, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        boolean ok = true;
        while (ok) {
            String texto = SC.nextLine();
            if (texto.equals(".")) {
                ok = false;
            } else {
                bufferedWriter.write(texto + "\n");
            }
        }

       
        bufferedWriter.close();
        fileWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
