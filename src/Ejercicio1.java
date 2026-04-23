import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    final static Scanner SC = new Scanner(System.in);
public static void main(String[] args) {
System.out.println("Introduce ruta:");
    
    String ruta = SC.nextLine();
     String src= "src/"+ ruta;
    File archivo = new File(src);
    if (archivo.exists() == false) {
        System.out.println("El archivo no existe.");
    } else {
    leerFichero(archivo);
}
}
public static void leerFichero(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean ok = true;
            String linea;
            
            while (ok) {
                linea = bufferedReader.readLine();
                if (linea == null) {
                    break;
                }
                System.out.println(linea);
            }

            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo.");
        }
    }
}
