<<<<<<< HEAD
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
import java.util.ArrayList;

public class Candidato extends Ciudadano {

    private String espectro_pol;
    private String partido_pol;
    public String ciudad;
    public String propuestas;

    public Candidato(String nombre, String ciudad_o, int cedula, String espectro_pol, String partido_pol) {
        super(nombre, ciudad_o, cedula);
        this.espectro_pol = espectro_pol;
        this.partido_pol = partido_pol;
    }
    public void Candidaton (String nombre, byte cedula, String ciudad, ArrayList<String> propuestas) {
    }
    public String getEspectro_pol() {
        return espectro_pol;
    }

    public void setEspectropol(String espectro_pol) {
        this.espectro_pol = espectro_pol;
    }

    public String getPartido_pol() {
        return partido_pol;
    }

    public void setPartido_pol(String partido_pol) {
        this.partido_pol = partido_pol;
    }
    




    
    

>>>>>>> main
