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

    private TDAEstudiantes listaEstudiantes;
    private int longitud = 0;

    public OperacionesLista() {
        this.listaEstudiantes = new TDAEstudiantes();
    }
    //    + "3. Mostrar la cantidad de estudiantes que tengan la misma edad.\n"

    //1
    public void insertarEstudiante(String carnet, int edad, int posicion) {
        if ( posicion >= 0) {
            longitud++;
            Estudiante estudiante = new Estudiante(carnet, edad);
            this.listaEstudiantes.insertar(estudiante, posicion);
        }
    }

    //2
    public String localizarEstudiante(String carnet) {

        if (this.listaEstudiantes.localiza(this.buscarEstudiante(carnet)) != -1) {
            return "Si existe";
        }

        return "El estudiante no se encontro";
    }
    
    public Estudiante buscarEstudiante(String carnet){
        for (int i = 0; i < longitud; i++) {
            if(this.listaEstudiantes.recupera(i) != null){
                return this.listaEstudiantes.recupera(i);
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

}
