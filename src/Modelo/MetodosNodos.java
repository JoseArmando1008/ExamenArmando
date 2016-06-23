/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Hogar
 */
public class MetodosNodos {

    Nodo principal;

    public MetodosNodos() {

    }

    public void crear(int cedula, String nombre, int edad, String fechaCita) {
        if (principal == null) {
            principal = new Nodo(cedula, nombre, edad, fechaCita, principal);
        } else {
            {
                Nodo aux;
                aux = new Nodo(cedula, nombre, edad, fechaCita, null);
                aux.siguiente = principal;
                principal = aux;
            }
        }
    }

    public String imprimir() {
        String valores = "";
        Nodo temporal = principal;
        while (temporal != null) {
            valores += "" + temporal.getDato() + "\n";
            temporal = temporal.getSiguiente();
        }
//        valores += "" + temporal.getDato() + "\n";
        return valores;
    }

    public void agregarAlFinal(int cedula, String nombre, int edad, String fechaCita, Nodo siguiente) {
        Nodo auxiliar;
        if (principal == null) {
            principal = new Nodo(cedula, nombre, edad, fechaCita, principal);

        } else {
            auxiliar = devolverUltimoNodo();
            auxiliar.siguiente = new Nodo(cedula, nombre, edad, fechaCita, null);

        }

    }

    public Nodo devolverUltimoNodo() {
        Nodo temporal = principal;

        while (temporal.getSiguiente() != null) {
            temporal = temporal.getSiguiente();
        }
        return temporal;
    }

    /*public void modificar(String[] arreglo) {
        Nodo temporal = principal;
        while (!temporal.getDato().equals(arreglo[0])) {
            temporal = temporal.getSiguiente();
        }
        temporal.setDato(arreglo[1]);
    }*/

    public String imprimirCliente() {
        String valores = "";
        String cedula = "";
        String edad = "";
        String nombre = "";
        String fechaCita = "";
        int contador = 0;
        Nodo temporal = principal;
        while (temporal != null && contador != 1) {
            contador = 1;
            cedula += "" + temporal.getDato() + "\n";
            nombre += "" + temporal.getNombre() + "\n";
            edad += "" + temporal.getEdad() + "\n";
            fechaCita += "" + temporal.getFechaCita() + "\n";
            valores = cedula + nombre + edad + fechaCita;
            temporal = temporal.getSiguiente();
        }
        return valores;
    }

    public void eliminarPrimero() {
        Nodo auxiliar = principal.getSiguiente();
        principal = auxiliar;
    }

    public void ordenarMayorAMenor() {
        int cantidadNodos = devolverCantidadNodos();
        int edadTemporal;
        String nombreTemporal;
        String fechaCitaTempotal;
        int cedulaTemporal;
        Nodo auxiliar = principal;
        for (int contador = 0; contador < cantidadNodos; contador++) {
            auxiliar = principal;
            while (auxiliar.siguiente != null) {
                if (auxiliar.getEdad() < auxiliar.siguiente.getEdad()) {
                    edadTemporal = auxiliar.edad;
                    nombreTemporal = auxiliar.nombre;
                    fechaCitaTempotal = auxiliar.fechaCita;
                    cedulaTemporal = auxiliar.cedula;
                    auxiliar.edad = auxiliar.siguiente.edad;
                    auxiliar.nombre = auxiliar.siguiente.nombre;
                    auxiliar.fechaCita = auxiliar.siguiente.fechaCita;
                    auxiliar.cedula = auxiliar.siguiente.cedula;
                    auxiliar.siguiente = new Nodo(cedulaTemporal, nombreTemporal, contador, fechaCitaTempotal, auxiliar);

                }
                auxiliar = auxiliar.siguiente;
            }
        }
    }

    public void ordenarMenorAMayor() {
        int cantidadNodos = devolverCantidadNodos();
        int edadTemporal;
        String nombreTemporal;
        String fechaCitaTempotal;
        int cedulaTemporal;
        Nodo auxiliar = principal;
        for (int contador = 0; contador < cantidadNodos; contador++) {
            auxiliar = principal;
            while (auxiliar.siguiente != null) {
                if (auxiliar.getEdad() > auxiliar.siguiente.getEdad()) {
                    edadTemporal = auxiliar.edad;
                    nombreTemporal = auxiliar.nombre;
                    fechaCitaTempotal = auxiliar.fechaCita;
                    cedulaTemporal = auxiliar.cedula;
                    auxiliar.edad = auxiliar.siguiente.edad;
                    auxiliar.nombre = auxiliar.siguiente.nombre;
                    auxiliar.fechaCita = auxiliar.siguiente.fechaCita;
                    auxiliar.cedula = auxiliar.siguiente.cedula;
                    auxiliar.siguiente = new Nodo(cedulaTemporal, nombreTemporal, contador, fechaCitaTempotal, auxiliar);

                }
                auxiliar = auxiliar.siguiente;
            }
        }
    }
    
    

    public String devolverCantidadNodos() {
        int contador = 1;
        
        Nodo auxiliar = principal;
        while (auxiliar.siguiente != null) {
            contador++;
            auxiliar = auxiliar.siguiente;
        }
        String cantidad=""+contador;
        

        return cantidad;
    }
    
    public void eliminar(int cedula) {
         cedula = principal.edad;
        Nodo auxiliar = principal;
        boolean haEliminado = false;
        if (auxiliar.edad == cedula) {
            principal = principal.siguiente;
            haEliminado = true;
        } else {
            auxiliar = devolverUltimoNodo();
            if (auxiliar.edad == cedula) {
                auxiliar = devolverAntepenultimoNodo();
                auxiliar.siguiente = null;
                haEliminado = true;
            }
        }
        if (!haEliminado) {
            Nodo temporal;
            auxiliar = devolverNodoAnterior(cedula);
            temporal = auxiliar.siguiente.siguiente;
            auxiliar.siguiente = temporal;
        }
    }
    
   
    
    public void modificar(int cedula,String nombre, int edad, String fechaCita) {
         cedula = principal.edad;
         
        Nodo auxiliar = principal;
        boolean modifica = false;
        if (auxiliar.cedula == cedula) {
            principal = principal.siguiente;
            modifica = true;
        } else {
            auxiliar = devolverUltimoNodo();
            if (auxiliar.edad == cedula) {
                auxiliar = devolverAntepenultimoNodo();
                auxiliar.siguiente = new Nodo(cedula, nombre, edad, fechaCita,auxiliar);
                modifica = true;
            }
        }
        if (!modifica) {
            Nodo temporal;
            auxiliar = devolverNodoAnterior(cedula);
            temporal = auxiliar.siguiente.siguiente;
            auxiliar.siguiente = temporal;
        }
    }
    
    public Nodo devolverAntepenultimoNodo() {
        Nodo auxiliar = principal;
        while (auxiliar.siguiente.siguiente != null) {
            auxiliar = auxiliar.siguiente;
        }
        return auxiliar;
    }
    public Nodo devolverNodoAnterior(int datoBuscar) {
        Nodo auxiliar = principal;
        while (auxiliar.siguiente.edad != datoBuscar) {
            auxiliar = auxiliar.siguiente;
        }
        return auxiliar;
    }
}
