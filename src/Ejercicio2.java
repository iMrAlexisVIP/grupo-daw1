import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {
    final static Scanner SC = new Scanner(System.in);
    static Map<String, String> TEXTO = new HashMap<>();        
public static void main(String[] args) {
     boolean seguir= true;
        while (seguir) {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.println("║        Bienvenido a mi biblioteca       ║");
        System.out.println("╠═════════════════════════════════════════╣");
        System.out.println("║   [1] Leer libro.                       ║");
        System.out.println("║   [2] Escribir en un libro.             ║");
        System.out.println("║   [3] Salir.                            ║");
        System.out.println("╚═════════════════════════════════════════╝\n");
        int opcion = SC.nextInt();
        SC.nextLine(); 
        switch (opcion) {
            case 1:

                System.out.println("Introduce nombre del libro: \n");
                    String ruta = SC.nextLine();
                    File libro = new File(ruta);
                        if (libro.exists() == false) {
                            try {
                                libro.createNewFile();
                            } catch (Exception e) {
                                System.out.println("Error... creando el archivo.");
                            }
                            System.out.println("El archivo no existe :(");
                        } 
                        else {
                            System.out.println("El archivo existe, puedes leerlo.  \n");
                            leerFichero(libro);
                            
                        }
                    

        
                break;
            case 2:
                System.out.println("Introduce nombre del libro: \n");
                    String ruta2 = SC.nextLine();
                    File libro2 = new File(ruta2);
                    if (libro2.exists() == false) {
                        try {
                            libro2.createNewFile();
                        } catch (Exception e) {
                            System.out.println("Error... creando el archivo.");
                        }
                        System.out.println("El archivo no existe.\n");
                    } 
                    else {
                        System.out.println("El archivo existe, puedes escribir en él. \n");
                       escribirFichero(libro2);

                    }
                    escribirFichero(libro2);
                break;
            case 3:
                seguir = false;
                System.out.println("¡Hasta luego! :D");
                break;
            default:
                System.out.println("Opción no válida. Por favor, elige una opción del menú.\n");
            }
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
    public static void escribirFichero(File file) {
    try {
        FileWriter fileWriter = new FileWriter(file , true);
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
    public static void anadirlibro(){
        System.out.println("Introduce el nombre del libro a añadir: ");
        String nombreLibro = SC.nextLine();
        File  libro = new File(nombreLibro);
        if(libro.exists()==false){
            String contenido="";
            try {
            FileReader fileReader = new FileReader(nombreLibro);
            BufferedReader br = new BufferedReader(fileReader);
            boolean ok = true;
            while (ok) {
                String linea = br.readLine();
                if (linea == null) {
                    ok = false;
                    
                } 
                else {
                   contenido += linea + "\n";
                }
                TEXTO.put(nombreLibro, contenido);
                br.close();
                fileReader.close();
                
            }
        } catch (IOException e) {
            System.out.println("El archivo no existe.");
        } 
        }
    }
    public static void leerLibro(){
        System.out.println("Introduce el nombre del libro a leer: \n");
        String nombreLibro = SC.nextLine();
        if (TEXTO.containsKey(nombreLibro)) {
            System.out.println(TEXTO.get(nombreLibro));
        } else {
            System.out.println("El libro no existe en la biblioteca.");
        }   
    }
}

