public class Cuidadano {
    
    public String nombre;
    public String cuidad_o;
    private int cedula;

    public Cuidadano(String nombre, String cuidad_o, int cedula) {
        this.nombre = nombre;
        this.cuidad_o = cuidad_o;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuidad_o() {
        return cuidad_o;
    }

    public void setCuidad_o(String cuidad_o) {
        this.cuidad_o = cuidad_o;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
}
