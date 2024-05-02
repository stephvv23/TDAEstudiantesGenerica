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
        primero = null;
        ultimo = null;
    }

    public void insertar(Estudiante dato, int posicion) {
        NodoEstudiante nuevo = new NodoEstudiante(dato);
        longitud++;
        if (this.esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else if (posicion == 0) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        } else if (posicion >= longitud) {
            this.ultimo.setSiguiente(nuevo);
            this.ultimo = nuevo;
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

    public void suprime(int posicion) {
        longitud--;
        if (!esVacia()) {
            if (posicion <= longitud) {

                if (posicion == 0) {
                    // Eliminar el primer nodo
                    if (longitud > 0) {
                        this.primero = primero.getSiguiente();
                    } else {
                        this.anula();
                    }
                } else if (posicion == longitud) {
                    // Eliminar el último nodo
                    NodoEstudiante indice = primero;
                    int contador = 0;
                    while (indice != null) {

                        if ((longitud - 1) == contador) {
                            indice.setSiguiente(null);
                            ultimo = indice;
                        }

                        contador++;
                        indice = indice.getSiguiente();
                    }

                } else {
                    // Eliminar un nodo en medio de la lista
                    NodoEstudiante indice = primero;
                    NodoEstudiante anterior = null;
                    int contador = 0;
                    while (indice != null) {
                        if (posicion == contador) {
                            anterior.setSiguiente(indice.getSiguiente());
                        }

                        contador++;
                        anterior = indice;
                        indice = indice.getSiguiente();
                    }

                }
            } else {
                longitud++;
            }
        }
        System.out.println("Posicion fuera del rango de la lista");
    }
    
    public Estudiante recupera(int posicion) {

        NodoEstudiante indice = this.primero;
        int contador = 0;
        while (indice != null) {

            if (contador == posicion) {
                return indice.getDato();
            }
            contador++;
            indice = indice.getSiguiente();
        }
        return null;
    }

    // DEBERIA SER CON DATO, no con carnet
    public int localiza(String carnet) {
        NodoEstudiante nodoIndice = primero;
        int indice=0;
        while (nodoIndice != null) {
            
            if (nodoIndice.getDato().getCarnet().equalsIgnoreCase(carnet)) {
                return indice;
            }
            nodoIndice = nodoIndice.getSiguiente();
            indice++;
        }
        return -1;
    }

//    public String estudiantesMismaEdad() {
//
//        int edad = 0, edadRepetida = 0;
//        int contador = 0, cantidadTotal = 0;
//        String mensaje = "No hay estudiantes con edades repetidas";
//        for (NodoEstudiante indiceEdad = primero; indiceEdad != null; indiceEdad = indiceEdad.getSiguiente()) {
//            contador = 0;
//            for (NodoEstudiante indice = primero; indice != null; indice = indice.getSiguiente()) {
//                if (indiceEdad.getDato().getEdad() == indice.getDato().getEdad()) {
//                    edad = indiceEdad.getDato().getEdad();
//                    contador++;
//                }
//            }
//
//            if (contador > cantidadTotal) {
//                edadRepetida = edad;
//                cantidadTotal = contador;
//            }
//        }
//        if (cantidadTotal != 1) {
//            return mensaje = "Edad: " + Integer.toString(edadRepetida) + " Cantidad total:" + Integer.toString(cantidadTotal);
//        }
//        return mensaje;
//    }
    public String imprimirLista() {
        NodoEstudiante indice = primero;
        int contador = 0;
        String mensaje = "Lista: \n";
        while (indice != null) {
            mensaje += contador + " Carnet:[" + indice.getDato().getCarnet() + ", Edad:" + indice.getDato().getEdad() + "]   ";
            contador++;
            indice = indice.getSiguiente();
        }
        return mensaje;
    }

    public boolean esVacia() {
        return primero == null;
    }

    public void anula() {
        primero = null;
        ultimo = null;
    }

}
