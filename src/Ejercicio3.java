import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        Protagonista protagonista1 = new Protagonista("Alexis", "10", "100", "50", null);
        Protagonista protagonista2 = new Protagonista("Vicente", "15", "80", "70", null);
        Protagonista protagonista3 = new Protagonista("Antonio", "20", "120", "30", null);
        List<Protagonista> protagonistas = new ArrayList<>();
        protagonistas.add(protagonista1);
        protagonistas.add(protagonista2);
        protagonistas.add(protagonista3);
        
        
        try {
            File file = new File("src/protagonista.txt");
            if (file.exists()== false ){
                System.out.println("Creando archivo");
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            // String linea= protagonista1.getNombre() + ";" + protagonSista1.getAtk() + ";" + protagonista1.getHp() + ";" + protagonista1.getOro();

            // imprimiendo protagonistas
            // String linea = protagonista1.toFile(";");
            // bw.write(linea);
            // String linea2 = protagonista2.toFile(";");
            // bw.write(linea2);
            // String linea3 = protagonista3.toFile(";");
            // bw.write(linea3);
            for (int i = 0; i < protagonistas.size(); i++) {
                String linea = protagonistas.get(i).toFile(";");
                bw.write(linea);
                
            }

            bw.close();
            fw.close();
             System.out.println("Protagonista creado con éxito.");
        } catch (IOException e) {
            System.out.println("Error creando el protagonista.");
        }
        for (int i = 0; i < protagonistas.size(); i++) {
            System.out.println(protagonistas.get(i));
        }
    }

}
