public class Ciudadano {
    
    public String nombre;
    public String ciudad_o;
    protected int cedula;

    public Ciudadano(String nombre, String ciudad_o, int cedula) {
        this.nombre = nombre;
        this.ciudad_o = ciudad_o;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad_o() {
        return ciudad_o;
    }

    public void setCiudad_o(String ciudad_o) {
        this.ciudad_o = ciudad_o;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
}
