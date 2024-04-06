/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ucr.ac.cr.tdaestudiantes;

/**
 *
 * @author Stephanie
 */
public class TDAEstudiantes {

    private NodoEstudiante primero;
    private NodoEstudiante ultimo;
    private int longitud = 0;

    public TDAEstudiantes() {

    }

    public Estudiante crearEstudiante(String carnet, int edad) {
        Estudiante estudiante = new Estudiante(carnet, edad);
        return estudiante;
    }

    public void agregarInicio(Estudiante dato) {
        NodoEstudiante nuevo = new NodoEstudiante(dato);
        primero = nuevo;
        ultimo = nuevo;

    }

    public void agregarFinal(Estudiante dato) {
        NodoEstudiante nuevo = new NodoEstudiante(dato);
        this.ultimo.setSiguiente(nuevo);
        this.ultimo = nuevo;

    }

    public int actualizarLongitud() {
        NodoEstudiante indice = primero;
        int contador = 0;
        while (indice != null) {
            contador++;
            indice = indice.getSiguiente();
        }
        longitud = contador;
        return longitud;
    }

    public void insertar(Estudiante dato, int posicion) {
        NodoEstudiante nuevo = new NodoEstudiante(dato);
        this.actualizarLongitud();
        if (this.esVacio()) {
            this.agregarInicio(dato);
        } else if (posicion == 0) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        } else if (posicion >= longitud) {
            this.agregarFinal(dato);
        } else {
            NodoEstudiante aux = null;
            NodoEstudiante indice = primero;
            int contador = 0;
            while (indice != null) {
                if (posicion == contador) {

                    nuevo.setSiguiente(indice);
                    aux.setSiguiente(nuevo);
                    break;
                }
                contador++;
                aux = indice;
                indice = indice.getSiguiente();
            }

        }
    }

    public String localiza(String carnet) {
        NodoEstudiante indice = primero;

        while (indice != null) {
            if (indice.getDato().getCarnet().equalsIgnoreCase(carnet)) {
                return "Si existe";
            }
            indice = indice.getSiguiente();
        }
        return "No se encontro";
    }

    public String estudiantesMismaEdad() {

        int edad = 0, edadRepetida = 0;
        int contador = 0, cantidadTotal = 0;
        String mensaje="No hay estudiantes con edades repetidas";
        for (NodoEstudiante indiceEdad = primero; indiceEdad != null; indiceEdad = indiceEdad.getSiguiente()) {
            contador = 0;
            for (NodoEstudiante indice = primero; indice != null; indice = indice.getSiguiente()) {
                if (indiceEdad.getDato().getEdad() == indice.getDato().getEdad()) {
                    edad = indiceEdad.getDato().getEdad();
                    contador++;
                }
            }
            
            if( contador > cantidadTotal){
                edadRepetida = edad;
                cantidadTotal = contador;
            }
        }
        if(cantidadTotal !=1){
            return mensaje= "Edad: "+Integer.toString(edadRepetida)+" Cantidad total:"+ Integer.toString(cantidadTotal);
        }
         return mensaje;
    }

    public String imprimir() {
        NodoEstudiante indice = primero;
        int contador = 0;
        String mensaje = "Lista: ";
        while (indice != null) {
            mensaje += contador + "-[" + indice.getDato().getCarnet() + ", " + indice.getDato().getEdad() + "]  ";
            contador++;
            indice = indice.getSiguiente();
        }
        return mensaje+"\n";
    }

    public boolean esVacio() {
        return primero == null;
    }
    
    public void vaciar(){
     primero = null;
     ultimo = null;
    }

    
}
