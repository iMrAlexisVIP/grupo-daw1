import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5 {
    final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        List<Protagonista> protagonistas = new ArrayList<>();
        String ruta = "src/protagonista.txt";
        File file = new File(ruta);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //leer items
                String contador_item = bufferedReader.readLine();
                int contador_items= Integer.parseInt(contador_item);
                for (int j = 0; j < contador_items; j++) {
                    String linea = bufferedReader.readLine();
                    String[] datos = linea.split(";");
                    String nombre = datos[0];
                    String tipo = datos[1];
                    int precio = Integer.parseInt(datos[2]);
                    Item i = new Item(nombre, tipo, precio);
                    items.add(i);
                }
                //leer protagonistas
                String contador_protas = bufferedReader.readLine();
                int contador_protagonistas = Integer.parseInt(contador_protas);
                for (int j = 0; j < contador_protagonistas; j++) {
                String linea = bufferedReader.readLine();
                    String[] datos = linea.split(";");
                    String nombre = datos[0];
                    String atk = datos[1];
                    String hp = datos[2];
                    String oro = datos[3];
                    String item = datos[4];
                    Item item_prota = null;
                    for (int k= 0; k<items.size(); k++){
                        if(items.get(k).getNombre().equals(item)){
                            item_prota = items.get(k);
                            break;

                        }
                    }
                    Protagonista p = new Protagonista(nombre, atk, hp, oro, item_prota);
                    protagonistas.add(p);
                }
                bufferedReader.close();
                fileReader.close();
            }
            
         catch (FileNotFoundException e) {
            System.out.println("Error leyendo el archivo");
        } catch (IOException e) {
            System.out.println("Error: NO SE PUEDE LEER EL ARCHIVO");
        }
        
    }
}
