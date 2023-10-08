//import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        menu();
    }

    public static void menu() {
        try (Scanner entrada = new Scanner(System.in)) {
            byte numero;

            System.out.println("---------- MENU -----------");
            System.out.println("[1] Insertar Candidato");
            System.out.println("[2] Actualizar Candidato");
            System.out.println("[3] Eliminar Candidato");
            System.out.println("[4] Buscar Candidato por nombre");
            System.out.println("[5] Listar todos los Candidatos");
            System.out.println("[6] Salir del Menu");
            System.out.println("Digite el número escogido: ");
            numero = entrada.nextByte();

            switch (numero) {
                case 1:
                    System.out.println("Insertar Candidato");
                    // Lógica para insertar candidato
                    break;
                case 2:
                    System.out.println("Actualizar Candidato");
                    // Lógica para actualizar candidato
                    break;
                case 3:
                    System.out.println("Eliminar Candidato");
                    // Lógica para eliminar candidato
                    break;
                case 4:
                    System.out.println("Buscar Candidato por nombre");
                    // Lógica para buscar candidato por nombre
                    break;
                case 5:
                    System.out.println("Listar todos los Candidatos");
                    // Lógica para listar todos los candidatos
                    break;
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
