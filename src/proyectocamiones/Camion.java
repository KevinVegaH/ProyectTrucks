/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocamiones;

//// Proyecto Camiones Version 1.0 ////

public class Camion {
    
    public String[] matricula;
    public double[] carga;
    public double[] gasolina;
    public double[] carga_Ac;
    public double[] capacidad;

    public double[] getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double[] capacidad) {
        this.capacidad = capacidad;
    }
    
    public String[] getMatricula() {
        return matricula;
    }

    public void setMatricula(String[] matricula) {
        this.matricula = matricula;
    }

    public double[] getCarga() {
        return carga;
    }

    public void setCarga(double[] carga) {
        this.carga = carga;
    }

    public double[] getGasolina() {
        return gasolina;
    }

    public void setGasolina(double[] gasolina) {
        this.gasolina = gasolina;
    }

    public double[] getCarga_Ac() {
        return carga_Ac;
    }

    public void setCarga_Ac(double[] carga_Ac) {
        this.carga_Ac = carga_Ac;
    }
    
   
    public Camion(String[] matricula, double[] carga, double[] gasolina, double[] carga_Ac) {
        this.matricula = matricula;
        this.carga = carga;
        this.gasolina = gasolina;
        this.carga_Ac = carga_Ac;
    }
    
    public Camion() {
        
    }
   
    
    
}
