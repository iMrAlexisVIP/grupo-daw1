import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class App {
    public static void main(String[] args) throws Exception {
        String ruta = "src/prueba.txt";
        File archivo = new File(ruta);
        if(archivo.exists()==false){
            
        archivo.createNewFile();       
        }
        boolean seguir = true;
        while (seguir) {
            System.out.println("introduce el nombre del archivo a leer");
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
