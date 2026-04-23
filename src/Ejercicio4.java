import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Ejercicio4 {
    
public static void main(String[] args) {
    List<Protagonista> protagonistas = new ArrayList<>();
     try {
        boolean ok = true;
        while (ok == false) {
            File file = new File("src/protagonista.txt");
            if (file.exists()== false ){
                System.out.println("Creando archivo");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String linea= br.readLine();
                String [] datos = linea.split(";"); 
                String nombre = datos[0];
                String atk = datos[1];
                String hp = datos[2];
                String oro = datos[3];
                Protagonista p1 = new Protagonista(nombre, atk, hp, oro, null);
                protagonistas.add(p1);
                System.out.print(linea);
                br.close();
                fr.close();

            }
            else {
                System.out.println("Archivo ya existe");
            }   
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.close();
            fw.close();
        }
             System.out.println("Protagonista creado con éxito.");
        } catch (IOException e) {
            System.out.println("Error creando el protagonista.");
        }
}
}

