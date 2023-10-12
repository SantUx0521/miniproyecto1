import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class App {
    static ArrayList<Candidato> candidatos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


private static boolean existeCedula(ArrayList<Candidato> candidatos, int cedula) {
        for (Candidato candidato : candidatos) {
            if (candidato.getCedula() == cedula) {
                return true;
            }
        }
        return false;
    }

private static boolean existeNombre(ArrayList<Candidato> candidatos, String nombre) {
        for (Candidato candidato : candidatos) {
            if (candidato.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
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
            System.out.println("[5] Listar todos los Candidatos");
            System.out.println("[6] Finalizar el CRUD");
            System.out.println("[7] Salir ");
            System.out.println("Digite el número escogido: ");
            numero = entrada.nextByte();

            String partidoInsertar;
            switch (numero) {
                case 1:
                    System.out.print("Ingrese el nombre del candidato: ");
                    String name = scanner.nextLine();
                    while(existeNombre(candidatos, name)){
                        if(candidatos.isEmpty())break;
                        for (Candidato candidato : candidatos) {
                        if (candidato.getNombre().equals(name)){
                            System.out.println("El nombre no puede ser igual, ingrese uno distinto: ");
                            name = scanner.nextLine();
                        }}};                  
                    String nombreInsertar = name;

                    System.out.print("Ingrese el número de cédula: ");
                    int identificacion = scanner.nextInt();
                    while(existeCedula(candidatos, identificacion)){
                        if(candidatos.isEmpty())break;
                        for (Candidato candidato : candidatos) {
                        if (candidato.getCedula() == identificacion){
                            System.out.println("La cedula no puede ser igual, ingrese una distinta: ");
                            identificacion = scanner.nextInt();
                        }}};                  
                    int cedulaInsertar = identificacion;
                    scanner.nextLine();

                    String ciudadInsertar;
                    do {
                        System.out.print("Ingrese la ciudad (debe ser del Valle del Cauca): ");
                        ciudadInsertar = scanner.nextLine();

                        if (!ciudadPerteneceAlValle(ciudadInsertar)) {
                            System.out.println("Ciudad no válida. Debe ser del Valle del Cauca.");
                        }
                    } while (!ciudadPerteneceAlValle(ciudadInsertar));
                    
                    do{
                        System.out.print("Ingrese el nombre del partido politico (debe ser de colombia): ");
                        partidoInsertar = scanner.nextLine();

                        if (!partidoPerteneceAColombia(partidoInsertar)) {
                            System.out.println("El partido no pertenece a Colombia, por favor ingrese uno correcto. ");
                        }
                    } while (!partidoPerteneceAColombia(partidoInsertar));

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
                            scanner.nextLine(); 
                
                            switch (opcion) {
                                case 1:
                                    System.out.print("Ingrese el nuevo nombre: ");
                                    System.out.print("Ingrese el nombre del candidato: ");
                                    name = scanner.nextLine();
                                    while(existeNombre(candidatos, name)){
                                    if(candidatos.isEmpty())break;
                                    for (Candidato candidat : candidatos) {
                                    if (candidat.getNombre().equals(name)){
                                    System.out.println("El nombre no puede ser igual, ingrese uno distinto: ");
                                    name = scanner.nextLine();
                                    }}};
                                    candidato.nombre = name;
                                    break;
                                case 2:
                                    System.out.print("Ingrese la nueva cédula: ");
                                    identificacion = scanner.nextInt();
                                    while(existeCedula(candidatos, identificacion)){
                                    if(candidatos.isEmpty())break;
                                    for (Candidato candida : candidatos) {
                                    if (candida.getCedula() == identificacion){
                                    System.out.println("La cedula no puede ser igual, ingrese una distinta: ");
                                    identificacion = scanner.nextInt();
                                    }}};                  
                                    candidato.cedula = identificacion;
                                    scanner.nextLine(); 
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
                                    String nuevoPartido;
                                    do{
                                        System.out.print("Ingrese el nombre del partido politico (debe ser de colombia): ");
                                        nuevoPartido = scanner.nextLine();

                                        if (!partidoPerteneceAColombia(nuevoPartido)) {
                                            System.out.println("El partido no pertenece a Colombia, por favor ingrese uno correcto. ");
                                         }
                                    } while (!partidoPerteneceAColombia(nuevoPartido));

                                    candidato.partido = nuevoPartido;
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
                            break; 
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
                            System.out.println("Partido: " + candidato.partido);
                            System.out.println("Propuestas: " + candidato.propuestas);
                            System.out.println("--------------------");
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
                    ingresarVotos();
                    break;
                case 7:
                    System.out.println("Adios");
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
        String[] ciudadesValle = {"Cali", "Buga", "Palmira", "Tulua", "Cartago","Bugalagrande", "Buenaventura","Yumbo"};
    
        for (String ciudadValle : ciudadesValle) {
            if (ciudad.equalsIgnoreCase(ciudadValle)) {
                return true;  // La ciudad está en el Valle del Cauca
            }
        }
        return false;
    }

    private static boolean partidoPerteneceAColombia(String partido) {
        String[] partidos_col = {"partido liberal","liberal","partido conservador","conservador","liga", "aico","partido verde","union patriotica","up",
                                "partido alianza social", "centro democratico", "partido de la u", "polo","mira", "cambio radical"};
    
        for (String partidos_pol : partidos_col) {
            if (partido.equalsIgnoreCase(partidos_pol)) {
                return true;  
            }
        }
        return false; 
    }

    public static void ingresarVotos() {
        for (Candidato candidato : candidatos) {
            System.out.print("Ingrese la cantidad de votos para " + candidato.nombre + ": ");
            Byte votosIngresar = scanner.nextByte();
            candidato.votos = votosIngresar;
        }
        System.out.println("Votos ingresados exitosamente.");
        clearScreen();

        System.out.println("Pulse 1 para ver los resultados: ");
        Byte resultados = scanner.nextByte();
        if (resultados == 1){
            mostrarResultados();
        }
        scanner.nextLine();
        }

    public static void mostrarResultados() {

        ArrayList<Candidato> candidatosOrdenados = new ArrayList<>(candidatos);
        candidatosOrdenados.sort((c1, c2) -> Integer.compare(c2.votos, c1.votos));

        System.out.println("Resultados de las Elecciones (de mayor a menor número de votos):");
        byte contador = 1;
        for (Candidato candidato : candidatosOrdenados) {
            System.out.println("Posicion: " + "#" + contador);
            System.out.println("Nombre: " + candidato.nombre);
            System.out.println("Cédula: " + candidato.cedula);
            System.out.println("Ciudad: " + candidato.ciudad);
            System.out.println("Partido: " + candidato.partido);
            System.out.println("Propuestas: " + candidato.propuestas);
            System.out.println("Votos: " + candidato.votos);
            System.out.println("--------------------");
            contador++;
        }
        System.out.println("pulsa 1 para ver más detalles o cualquier otro número para volver al menú: ");
        byte detalles = scanner.nextByte();
        if (detalles == 1) {
            mostrarPropuestasGanador(candidatosOrdenados);
        } else {
            System.out.println("Volviendo al menú");
            clearScreen();
            menu();
        }
    }

    public static void mostrarPropuestasGanador(ArrayList<Candidato> candidatosOrdenados) {
        scanner.nextLine();
        if (!candidatosOrdenados.isEmpty()) {
            Candidato ganador = candidatosOrdenados.get(0);
            System.out.println("Propuestas del ganador: " + ganador.nombre);
            System.out.println("Cedula del ganador: " + ganador.cedula);
            System.out.println("\n");
            for (String propuesta : ganador.propuestas) {
                System.out.println(propuesta);
                System.out.println("\n");
            }
        } else{
            System.out.println("no hay candidatos para mostrar.");
        }
        mostrarPartidoConMasCandidatos();
    }

    public static void mostrarPartidoConMasCandidatos() {
        Map<String, Integer> partidoCandidatosCount = new HashMap<>();
        for (Candidato candidato : candidatos) {
            partidoCandidatosCount.put(candidato.partido, partidoCandidatosCount.getOrDefault(candidato.partido, 0) + 1);
        }
        String partidoMasCandidatos = partidoCandidatosCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No hay datos");
        System.out.println("Partido con más candidatos inscritos: " + partidoMasCandidatos);
        System.out.println("\n");


        Map<String, Integer> ciudadCandidatosCount = new HashMap<>();
        for (Candidato candidato : candidatos) {
            ciudadCandidatosCount.put(candidato.ciudad, ciudadCandidatosCount.getOrDefault(candidato.ciudad, 0) + 1);
        }
        List<Map.Entry<String, Integer>> ciudadesMenosCandidatos = ciudadCandidatosCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("3 Ciudades con menos candidatos:");
        System.out.println("\n");
        for (Map.Entry<String, Integer> entry : ciudadesMenosCandidatos) {
            System.out.println(entry.getKey() + " - Candidatos: " + entry.getValue());
        }
        System.out.println("\n");
        System.out.println("Pulse 0 para volver al menú: ");
                    Byte salida = scanner.nextByte();
                    if (salida == 0) {
                        clearScreen();
                        menu();
                    }

    }


}



>>>>>>> c6a36d0 (Añado la funcionalidad para verificar que la cedula no se repita)
}
