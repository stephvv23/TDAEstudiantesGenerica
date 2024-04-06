/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tdaestudiantes;

/**
 *
 * @author Stephanie
 */
public class NodoEstudiante {

    private Estudiante dato;
    private NodoEstudiante siguiente;

    public NodoEstudiante() {
    }

    public NodoEstudiante(Estudiante estudiante) {
        this.dato = estudiante;
    }

    public NodoEstudiante(Estudiante estudiante, NodoEstudiante nodo) {
        this.dato = estudiante;
        this.siguiente = nodo;
    }

    public Estudiante getDato() {
        return dato;
    }

    public void setDato(Estudiante dato) {
        this.dato = dato;
    }

    public NodoEstudiante getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEstudiante siguiente) {
        this.siguiente = siguiente;
    }

  
    
    
    
}
