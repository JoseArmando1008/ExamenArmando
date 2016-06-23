
package Modelo;


public class Nodo {
    int cedula;
    int edad; 
    Nodo siguiente;
    String nombre;
    String fechaCita;

    public Nodo(int cedula,String nombre, int edad, String fechaCita,Nodo siguiente) {
        this.cedula = cedula;
        this.nombre=nombre;
        this.edad=edad;
        this.fechaCita=fechaCita;
        this.siguiente = siguiente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public int getDato() {
        return cedula;
    }

    public void setDato(int cedula) {
        this.cedula = cedula;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
