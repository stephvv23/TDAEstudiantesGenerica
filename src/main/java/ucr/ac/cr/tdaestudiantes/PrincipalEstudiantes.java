/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tdaestudiantes;

import javax.swing.JOptionPane;

/**
 *
 * @author Stephanie
 */
public class PrincipalEstudiantes {

    TDAEstudiantes listaEstudiantes;

    public PrincipalEstudiantes() {
        listaEstudiantes = new TDAEstudiantes();
        menu();
    }

    public void menu() {
        int opcion = 0, edad = 0, posicion = 0;
        String carnet = "";
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoja una opcion:\n"
                    + "1. Almacenar el carnet y la edad de un estudiante. \n"
                    + "2. Indicar si una estudiante determinada existe, buscando por el carnet. \n"
                    + "3. Mostrar la cantidad de estudiantes que tengan la misma edad.\n"
                    + "4. Mostrar la cantidad de estudiantes almacenadas. \n"
                    + "5. Imprimir todos los datos almacenados. \n"
                    + "6. Eliminar la lista.\n"
                    + "7. Salir.\n"));

            switch (opcion) {
                case 1: //Insertar
                    carnet = JOptionPane.showInputDialog("Digite el carnet del estudiante");
                    edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edaddel estudiante"));
                    posicion = Integer.parseInt(JOptionPane.showInputDialog("Digite la posicion donde desea almacenarlo"));

                    listaEstudiantes.insertar(listaEstudiantes.crearEstudiante(carnet, edad), posicion);
                    break;
                case 2: //Localiza
                    carnet = JOptionPane.showInputDialog("Digite el carnet del estudiante");
                    JOptionPane.showMessageDialog(null, listaEstudiantes.localiza(carnet));
                    break;
                case 3://Recupera

                    JOptionPane.showMessageDialog(null, listaEstudiantes.estudiantesMismaEdad());
                    break;
                case 4://Suprime
                    JOptionPane.showMessageDialog(null, "Actualmente hay " + listaEstudiantes.actualizarLongitud() + " estudiantes registrados.");

                    break;
                case 5://anula
                    JOptionPane.showMessageDialog(null, listaEstudiantes.imprimir());

                    break;
                case 6://primero
                    listaEstudiantes.vaciar();
                    break;

                case 7://Salir
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Numero incorrecto");
            }//Fin switch
        } while (opcion != 7);

    }//Fin del main

    public static void main(String arg[]) {
        PrincipalEstudiantes principal = new PrincipalEstudiantes();
    }//Fin del main
}