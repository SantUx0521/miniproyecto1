import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;


public class App {
    private static ArrayList<String> nombre = new ArrayList<>();
    public static void main(String[] args){
        menu();
    }
    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } 
    }//Utilizado para limpiar la entrada previa

    public static void menu() {
        try (Scanner entrada = new Scanner(System.in)) {
            byte numero;
            byte salida;
            Scanner salir = new Scanner(System.in);

            System.out.println("---------- MENU -----------");
            System.out.println("[1] Insertar Candidato");
            System.out.println("[2] Actualizar Candidato");
            System.out.println("[3] Eliminar Candidato");
            System.out.println("[4] Buscar Candidato por numero");
            System.out.println("[5] Listar todos los Candidatos");
            System.out.println("[6] Salir del Menu");
            System.out.println("Digite el número escogido: ");
            numero = entrada.nextByte();

            switch (numero) {
                case 1:
                    System.out.println("Ingrese un candidato: ");
                    Scanner candidatos = new Scanner(System.in);
                    String nombre_candidato = candidatos.nextLine();
                    nombre.add(nombre_candidato);
                    System.out.println("Pulse 0 para volver al menú: ");
                    salida = salir.nextByte();
                    if(salida == 0){
                        clearScreen();
                        menu();
                    }else{
                        break;
                    }

                    
                    
                case 2:
                    System.out.println("Ingrese el nombre del candidato que desea actualizar:");
                    String candidatoAntiguo = entrada.next();

                    if (nombre.contains(candidatoAntiguo)) {
                        System.out.println("Ingrese el nuevo nombre del candidato:");
                        String nuevoNombre = entrada.next();
                    
                    
                        int indice = nombre.indexOf(candidatoAntiguo);
                        nombre.set(indice, nuevoNombre);

                        System.out.println("Candidato actualizado correctamente.");
                    } else {
                        System.out.println("El candidato no se encontró en la lista.");
                }
                
                System.out.println("Pulse 0 para volver al menú: ");
                    salida = salir.nextByte();
                    if(salida == 0){
                        clearScreen();
                        menu();
                    }else{
                        break;
                    }
                case 3:
                    System.out.println("Eliminar Candidato");
                    // Lógica para eliminar candidato
                    break;
                case 4:
                    System.out.println("Buscar Candidato por nombre");
                    // Lógica para buscar candidato por nombre
                    break;
                case 5:
                    if (nombre.isEmpty()) {
                        System.out.println("No hay ningun candidato registrado.");
                    } else {
                        System.out.println("Los candidatos registrados son:");
                        for (int i = 0; i < nombre.size(); i++) {
                            System.out.println((i + 1) + ". " + nombre.get(i));
                        }
                    }
                    System.out.println("Pulse 0 para volver al menú: ");
                    salida = salir.nextByte();
                    if(salida == 0){
                        clearScreen();
                        menu();
                    }else{
                        break;
                    }
                case 6:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    menu(); // Llamada recursiva si la opción no es válida
                    break;
                }
        }
    }
}
