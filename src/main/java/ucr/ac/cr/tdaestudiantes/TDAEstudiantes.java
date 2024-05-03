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

    public TDAEstudiantes() {
        primero = null;
        ultimo = null;
    }

    public void insertar(Estudiante dato, int posicion) {
        NodoEstudiante nuevo = new NodoEstudiante(dato);
        if (this.esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else if (posicion == 0) {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        } else {

            NodoEstudiante aux = null;
            NodoEstudiante indice = primero;
            int contador = 0;

            while (indice != null) {

                

                if (posicion == contador) {
                    System.out.println("B");
                    nuevo.setSiguiente(indice);
                    aux.setSiguiente(nuevo);
                    break;
                }else if (indice == ultimo) {
                    System.out.println("A");
                    this.ultimo.setSiguiente(nuevo);
                    this.ultimo = nuevo;
                    break;
                }
                
                contador++;
                aux = indice;
                indice = indice.getSiguiente();
            }

        }
    }

    public void suprime(int posicion) {
        if (!esVacia()) {

            if (posicion == 0) {

                // Eliminar el primer nod0
                if (primero.getSiguiente() != null) {
                    this.primero = primero.getSiguiente();
                } else {
                    this.anula();
                }

            } else {
                // Eliminar un nodo en medio de la lista
                NodoEstudiante indice = primero;
                NodoEstudiante anterior = null;
                int contador = 0;

                while (indice != null) {
                    if (posicion == contador) {

                        if (indice == ultimo) {
                            ultimo = anterior;
                        } else {
                            anterior.setSiguiente(indice.getSiguiente());
                        }
                    }

                    contador++;
                    anterior = indice;
                    indice = indice.getSiguiente();
                }

            }

        }

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
    public int localiza(Estudiante dato) {
        NodoEstudiante nodoIndice = primero;
        int indice = 0;
        while (nodoIndice != null) {

            if (nodoIndice.getDato().equals(dato)) {
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
