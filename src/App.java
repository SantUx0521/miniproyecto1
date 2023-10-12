
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Candidato {
    String nombre;
    String ciudad;
    int cedula;
    String partido;
    ArrayList<String> propuestas;

    public Candidato(String nombre, String ciudad, int cedula, String partido, ArrayList<String> propuestas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.cedula = cedula;
        this.partido = partido;
        this.propuestas = propuestas;
    }

}

public class App {
    static ArrayList<Candidato> candidatos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }


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

            System.out.println("[4] Buscar Candidato por nombre");

            System.out.println("[4] Buscar Candidato por numero");

            System.out.println("[5] Listar todos los Candidatos");
            System.out.println("[6] Salir del Menu");
            System.out.println("Digite el número escogido: ");
            numero = entrada.nextByte();

            String partidoInsertar;
            switch (numero) {
                case 1:
                    System.out.print("Ingrese el nombre del candidato: ");
                    String nombreInsertar = scanner.nextLine();

                    System.out.print("Ingrese el número de cédula: ");
                    int cedulaInsertar = scanner.nextInt();
                    scanner.nextLine();

                    String ciudadInsertar;
                    do {
                        System.out.print("Ingrese la ciudad (debe ser del Valle del Cauca): ");
                        ciudadInsertar = scanner.nextLine();

                        if (!ciudadPerteneceAlValle(ciudadInsertar)) {
                            System.out.println("Ciudad no válida. Debe ser del Valle del Cauca.");
                        }
                    } while (!ciudadPerteneceAlValle(ciudadInsertar));

                    System.out.print("Ingrese el nombre del partido politico: ");
                    partidoInsertar = scanner.nextLine();

                    ArrayList<String> propuestasInsertar = new ArrayList<>();
                    System.out.print("Ingrese una propuesta (o 'fin' para terminar): ");
                    String propuestaInsertar = scanner.nextLine();
                    while (!propuestaInsertar.equals("fin")) {
                        propuestasInsertar.add(propuestaInsertar);
                        System.out.print("Ingrese otra propuesta (o 'fin' para terminar): ");
                        propuestaInsertar = scanner.nextLine();
                    }

                    Candidato nuevoCandidato = new Candidato(nombreInsertar, ciudadInsertar, cedulaInsertar, partidoInsertar, propuestasInsertar);
                    candidatos.add(nuevoCandidato);
                    System.out.println("Candidato ingresado exitosamente.");

                    System.out.println("Pulse 0 para volver al menú: ");
                    salida = salir.nextByte();
                    if (salida == 0) {
                        clearScreen();
                        menu();
                    } else {
                        break;
                    }


                case 2:
                    System.out.print("Ingrese el nombre del candidato a actualizar: ");
                    String nombreActualizar = scanner.nextLine();
                
                    for (Candidato candidato : candidatos) {
                        if (candidato.nombre.equals(nombreActualizar)) {
                            System.out.println("Candidato encontrado:");
                            System.out.println("Nombre: " + candidato.nombre);
                            System.out.println("Cédula: " + candidato.cedula);
                            System.out.println("Ciudad: " + candidato.ciudad);
                            System.out.println("Partido: " + candidato.partido);
                            System.out.println("Propuestas: " + candidato.propuestas);
                            
                            System.out.println("Seleccione el campo que desea actualizar:");
                            System.out.println("[1] Nombre");
                            System.out.println("[2] Cédula");
                            System.out.println("[3] Ciudad");
                            System.out.println("[4] Partido");
                            System.out.println("[5] Propuestas");
                            System.out.println("Digite el número del campo a actualizar: ");
                            
                            int opcion = scanner.nextInt();
                            scanner.nextLine(); // Consumir el salto de línea después de nextInt()
                
                            switch (opcion) {
                                case 1:
                                    System.out.print("Ingrese el nuevo nombre: ");
                                    candidato.nombre = scanner.nextLine();
                                    break;
                                case 2:
                                    System.out.print("Ingrese la nueva cédula: ");
                                    candidato.cedula = scanner.nextInt();
                                    scanner.nextLine(); // Consumir el salto de línea después de nextInt()
                                    break;
                                case 3:
                                    String nuevaCiudad;
                                    do {
                                        System.out.print("Ingrese la nueva ciudad (debe ser del Valle del Cauca): ");
                                        nuevaCiudad = scanner.nextLine();
                
                                        if (!ciudadPerteneceAlValle(nuevaCiudad)) {
                                            System.out.println("Ciudad no válida. Debe ser del Valle del Cauca.");
                                        }
                                    } while (!ciudadPerteneceAlValle(nuevaCiudad));
                
                                    candidato.ciudad = nuevaCiudad;
                                    break;
                                case 4:
                                    System.out.print("Ingrese el nuevo partido: ");
                                    candidato.partido = scanner.nextLine();
                                    break;
                                case 5:
                                    ArrayList<String> nuevasPropuestas = new ArrayList<>();
                                    System.out.print("Ingrese una nueva propuesta (o 'fin' para terminar): ");
                                    String nuevaPropuesta = scanner.nextLine();
                                    while (!nuevaPropuesta.equals("fin")) {
                                        nuevasPropuestas.add(nuevaPropuesta);
                                        System.out.print("Ingrese otra propuesta (o 'fin' para terminar): ");
                                        nuevaPropuesta = scanner.nextLine();
                                    }
                                    candidato.propuestas = nuevasPropuestas;
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                
                            System.out.println("Candidato actualizado exitosamente.");
                            
                        }else{
                            System.out.println("No se encontró ningún candidato con ese nombre.");
                        }

                    }

                    System.out.println("Pulse 0 para volver al menú: ");

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
                    System.out.print("Ingrese el nombre del candidato a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                
                    Iterator<Candidato> iterator = candidatos.iterator();
                    while (iterator.hasNext()) {
                        Candidato candidato = iterator.next();
                        if (candidato.nombre.equals(nombreEliminar)) {
                            iterator.remove();
                            System.out.println("Candidato eliminado exitosamente.");
                        }if (!candidato.nombre.equals(nombreEliminar)){
                            System.out.println("No se encontró ningún candidato con ese nombre.");
                        }
                    }
                
                    //System.out.println("No se encontró ningún candidato con ese nombre.");
                
                    System.out.println("Pulse 0 para volver al menú: ");
                    salida = salir.nextByte();
                    if (salida == 0) {
                        clearScreen();
                        menu();
                    } else {
                        break;
                    }
                

                case 4:
                    System.out.print("Ingrese el nombre del candidato a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                
                    boolean encontrado = false;
                
                    for (Candidato candidato : candidatos) {
                        if (candidato.nombre.equals(nombreBuscar)) {
                            System.out.println("Candidato encontrado:");
                            System.out.println("Nombre: " + candidato.nombre);
                            System.out.println("Cédula: " + candidato.cedula);
                            System.out.println("Ciudad: " + candidato.ciudad);
                            System.out.println("Propuestas: " + candidato.propuestas);
                            encontrado = true;
                            break; // Salir del bucle una vez que se encuentra el candidato.
                        }
                    }
                
                    if (!encontrado) {
                        System.out.println("No se encontró ningún candidato con ese nombre.");
                    }
                
                    System.out.println("Pulse 0 para volver al menú: ");
                    salida = salir.nextByte();
                    if (salida == 0) {
                        clearScreen();
                        menu();
                    } else {
                        break;
                    }

                case 5:
                    if (candidatos.isEmpty()) {
                        System.out.println("No hay candidatos ingresados.");
                    } else {
                        System.out.println("Lista de todos los candidatos:");
                        for (Candidato candidato : candidatos) {
                            System.out.println("Nombre: " + candidato.nombre);
                            System.out.println("Cédula: " + candidato.cedula);
                            System.out.println("Ciudad: " + candidato.ciudad);
                            System.out.println("Propuestas: " + candidato.propuestas);
                            System.out.println("--------------------");
                        }
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
                    clearScreen();
                    System.out.println("Opción no válida. Intente de nuevo.");
                    menu();
            }
        }
    }

    private static boolean ciudadPerteneceAlValle(String ciudad) {
        // Lista de ciudades del Valle del Cauca
        String[] ciudadesValle = {"cali", "buga", "palmira", "tulua", };/* Agrega otras ciudades según sea necesario */
    
        // Compara la ciudad ingresada con las ciudades del Valle del Cauca
        for (String ciudadValle : ciudadesValle) {
            if (ciudad.equalsIgnoreCase(ciudadValle)) {
                return true;  // La ciudad está en el Valle del Cauca
            }
        }
        return false;  // La ciudad no está en el Valle del Cauca

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

  
