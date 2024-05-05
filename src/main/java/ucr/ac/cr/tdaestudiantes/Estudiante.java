/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.tdaestudiantes;

/**
 *
 * @author Stephanie
 */
public class Estudiante {

    private String carnet;
    private int edad;

    public Estudiante() {
        this.carnet = "CXXXX";
        this.edad = -1;
    }

    public Estudiante(String carnet, int edad) {
        this.carnet = carnet;
        this.edad = edad;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "carnet=" + carnet + ", edad=" + edad + '}';
    }

}
