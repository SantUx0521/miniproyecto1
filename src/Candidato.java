import java.util.ArrayList;

class Candidato {
    String nombre;
    String ciudad;
    int cedula;
    String partido;
    int votos;
    ArrayList<String> propuestas;

    public int getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public Candidato(String nombre, String ciudad, int cedula, String partido, ArrayList<String> propuestas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.cedula = cedula;
        this.partido = partido;
        this.propuestas = propuestas;
        this.votos = 0;
    }


}

=======
>>>>>>> c6a36d0 (Añado la funcionalidad para verificar que la cedula no se repita)
    
    

