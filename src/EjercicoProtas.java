import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjercicoProtas {
    final static Scanner SC = new Scanner(System.in);

public static void main(String[] args) {
    ArrayList<Protagonista> protas = new ArrayList<>();
    String ruta = "src/protagonista.txt";   
    File file = new File(ruta);
    
    boolean ok = true;
    while (ok) {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║              Protagonistas              ║");
        System.out.println("╠═════════════════════════════════════════╣");
        System.out.println("║   [1] Cargar Protagonistas              ║");
        System.out.println("║   [2] Ver Protagonistas                 ║");
        System.out.println("║   [3] Agregar Protagonista              ║");
        System.out.println("║   [4] Guardar Protagonistas             ║");
        System.out.println("╚═════════════════════════════════════════╝\n");
        boolean repetir = true;
        int opcion = 0;
        while (repetir){
            try {
                opcion = SC.nextInt();
                repetir = false;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
            finally{
                SC.nextLine();
            }
        }
        switch (opcion) {
            case 1:
                try {
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    while (true){
                        String linea = bufferedReader.readLine();
                        if (linea == null){
                            break;
                        }
                        else {
                            String[] datos = linea.split(";");
                            String nombre = datos[0];
                            String atk = datos[1];
                            String hp = datos[2];
                            String oro = datos[3];
                            Protagonista p = new Protagonista(nombre, atk, hp, oro, null);
                            protas.add(p);
                           
                        } 
                        
                    }
                        bufferedReader.close();
                        fileReader.close();
                } catch (IOException e) {
                    System.out.println("Error: leyendo el archivo");
                        }
                catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Error: Linea mal escrita.");
                    }
                catch (NumberFormatException e) {
                    System.out.println("Error: Atributo invalido");
                    }
                break;
            case 2:
                for (int i = 0; i <protas.size() ; i++) {
                    System.out.println(protas.get(i));
                }
                break;
            case 3:
                System.out.println("Ingrese el nombre del protagonista");
                String nombre = SC.nextLine();
                System.out.println("Ingrese el ataque del protagonista");
                String atk = SC.nextLine();
                System.out.println("Ingrese la vida del protagonista");
                String hp = SC.nextLine();
                System.out.println("Ingrese el oro del protagonista");
                String oro = SC.nextLine();
                Protagonista p1 = new Protagonista(nombre, atk, hp, oro, null);
                protas.add(p1);
                System.out.println("Creando protagonista...");

                break;
            case 4:
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    for (int i = 0; i < protas.size(); i++) {
                       System.out.println(protas.get(i));
                        bufferedWriter.write(protas.get(i).toFile(";"));
                    }
                    System.out.println("Se han guardado los protaginistas :D");
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println("Error escribiendo el archivo");
                }

                break;
            default:
                ok = false;
                System.out.println("Saliendo del programa...");
                break;
        }

    }
    
}
}
