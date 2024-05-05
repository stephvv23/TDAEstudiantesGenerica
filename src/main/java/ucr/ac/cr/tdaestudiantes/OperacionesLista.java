/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tdaestudiantes;

/**
 *
 * @author Stephanie
 */
public class OperacionesLista {

    private ListaTDA<Estudiante> listaEstudiantes;
    private ListaTDA<Integer> listaEdades, listaCantidades;
    private int longitud = 0, longitudEdades = 0;

    public OperacionesLista() {
        this.listaEstudiantes = new ListaTDA<Estudiante>();
    }

    //1
    public void insertarEstudiante(String carnet, int edad, int posicion) {
        if (posicion >= 0 && edad >= 1) {
            longitud++;
            Estudiante estudiante = new Estudiante(carnet, edad);
            this.listaEstudiantes.insertar(estudiante, posicion);
        }
    }

    //2
    public String localizarEstudiante(String carnet) {

        if (this.listaEstudiantes.localiza(this.buscarEstudiante(carnet)) != null) {
            return "Si existe";
        }
        return "El estudiante no se encontro";
    }

    //Devuelve el Estudiante si lo encuentra, sino retorna null
    public Estudiante buscarEstudiante(String carnet) {
        for (int i = 0; i < longitud; i++) {
            if (this.listaEstudiantes.recupera(i) != null) {
                if (this.listaEstudiantes.recupera(i).getCarnet().equals(carnet)) {
                    return this.listaEstudiantes.recupera(i);
                }
            }

        }
        return null;
    }

    //4
    public int totalEstudiantes() {
        int indice = 0;
        while (this.listaEstudiantes.recupera(indice) != null) {

            indice++;
        }
        return indice;
    }

    //5
    public String imprimirLista() {
        return this.listaEstudiantes.imprimirLista();
    }

    //6
    public void eliminarLista() {
        this.listaEstudiantes.anula();
    }

    public String estudiantesMismaEdad() {

        if (!listaEstudiantes.esVacia()) {
            String mensaje = "";

            this.listaEdades = new ListaTDA<Integer>();
            this.longitudEdades = 0;
            for (int i = 0; i < longitud; i++) {
                if (listaEdades.localiza(listaEstudiantes.recupera(i).getEdad()) == null) {
                    listaEdades.insertar(listaEstudiantes.recupera(i).getEdad(), i);
                    longitudEdades++;
                }
            }

            System.out.print("ListaEdades: " + listaEdades.imprimirLista());
            System.out.print(longitud + "    " + longitudEdades + "\n");
            this.listaCantidades = new ListaTDA<Integer>();
            for (int i = 0; i < longitudEdades; i++) {
                int contador = 0;
                for (int j = 0; j < longitud; j++) {
                    if (listaEdades.recupera(i) == listaEstudiantes.recupera(j).getEdad()) {
                        contador++;
                    }
                }
                listaCantidades.insertar(contador, i);

            }
            System.out.print("ListaCantidades: " + listaCantidades.imprimirLista());

            for (int i = 0; i < longitudEdades; i++) {
                if (listaCantidades.recupera(i) > 1) {
                    mensaje += "La edad: " + listaEdades.recupera(i) + " se repite: " + listaCantidades.recupera(i) + " veces\n";
                }
            }
            return mensaje;

        } else {
            return "La lista esta vacia o ninguna edad se repite";
        }
    }
}
