/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocamiones;

import java.util.Scanner;

//// Proyecto Camiones Version 1.0 ////

public class RepositorioCamion {

    private Camion c = new Camion();
    Scanner sc = new Scanner(System.in);
    private String[] matricula;
    private double[] capacidad;
    private double[] carga_ac;
    private double[] gasolina;
    private double carga;
    private double[] cap;
    private final int n = 4; // numero de Camiones //
    private final int[] posicion = new int[n]; // vector de posicion //
     
   public RepositorioCamion(){

       this.posicion[0] = 5;// valor de posicion 0 = 5  por defecto//
       this.posicion[1] = 5;// valor de posicion 1 = 5  por defecto//
       this.posicion[2] = 5;// valor de posicion 2 = 5  por defecto//
       this.posicion[3] = 5;// valor de posicion 3 = 5  por defecto//
   
   }
    
    public void camion() {
         
        matricula = new String[n];
        capacidad = new double[n];
        carga_ac = new double[n];
        gasolina = new double[n];
        
        //--------- valores de prueba -------------//
      
        
/*        matricula[0]= "x1";
        matricula[1]= "x4";
        matricula[2]= "x3";
        matricula[3]= "x8";
        
        capacidad[0] = 20;
        capacidad[1] = 200;
        capacidad[2] = 50;
        capacidad[3] = 100;
        
        gasolina[0] = 50;
        gasolina[1] = 70;
        gasolina[2] = 20;
        gasolina[3] = 30;
  */
        //------------------------------------------//
        
        cap = new double[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese la matricula del camion numero " + (i + 1) + ":");
            matricula[i] = sc.nextLine();
            c.setMatricula(matricula);
            
            System.out.println("Ingrese la capacidad del camion de matricula " + (matricula[i]).toUpperCase());
            System.out.println("Nota: en Kilogramos (Kg):");
            capacidad[i] = sc.nextDouble();
            c.setCapacidad(capacidad);
            
            
           System.out.println("Ingrese el consumo de gasolina. galones/kilómetro (gal/km)");
           gasolina[i] = sc.nextDouble();
           c.setGasolina(gasolina);
            
            sc.nextLine();
            System.out.println("¿el camion de placa "+(matricula[i]).toUpperCase()+" posee una carga actual?(si/no)");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("si")) {
                
                System.out.println("¿Cuanto es el peso de la carga actual?");
                carga_ac[i] = sc.nextDouble();
                c.setCarga_Ac(carga_ac);
                sc.nextLine();
                
            } else {
                carga_ac[i] = 0;
                c.setCarga_Ac(carga_ac);
            } 
        }   
    }
    
    public void carga_camion(){
        
        cap = c.getCapacidad(); //--> capacidad del camion //
        carga_ac = c.getCarga_Ac(); // --> Carga acumulada en el camion //
        matricula =c.getMatricula();
        gasolina = c.getGasolina();
                
        double[] capTotal = new double[n];
        
        for (int i = 0; i < n; i++) {
            
         capTotal[i] =(cap[i]) - (carga_ac[i]);  // restamos la capacidad por la carga ya existente //
     
        }
        capacidad = capTotal; // la resta da como resultado el espacio disponible en el camion //
        
        System.out.println("Ingrese el peso de la carga(kg):"); // se ingresa la carga //
        carga = sc.nextDouble();// capturamos el valor de la carga//
        
        int j = 0;// contador j
        int k = 0;// contador k
        int m = 0; // posicionador m
        
         System.out.println("la carga puede ir en el/los camion(es) de matricula:");
          
        for (int i = 0; i < n; i++) { // Muestra las matriculas de los camiones con disponibilidad de carga//
      
            if (carga <= capacidad[i]) { 
                j++; // --> suma 1 a j cada vez que se encuentra un camion //
                System.out.println(matricula[i].toUpperCase());
                posicion[k] = i; /* --> adquirimos la posicion en que se encuentra las matriculas dentro del vector
                y metemos las posiciones dentro de un vector llamado posicion */
                k++; // --> Este contador se le sumara 1 a K cada vez que el condicional se efectue.       
            }
        }if(posicion[0] != 5 || posicion[1] != 5 || posicion[2] != 5 || posicion[3] != 5){ //--> si el vector de posicion tiene datos, quiere decir que es diferente de 0 y ejecuta este bloque //
           
   
            double iposicion = gasolina[posicion[0]]; // --> variable auxiliar que ayuda en cada vuelta del loop guardando valores si el condicional es ejecutado. //
            for (int i = 0; i < j; i++) {

            if (gasolina[posicion[i]] <= iposicion){ // comparamos los valores dentro del vector gasolina hallando el menor cosumo // 
                
                iposicion = gasolina[posicion[i]];
                m = posicion[i];
            }   
        }
            System.out.println("El mejor camion para transportar la carga es el de matricula: "+ matricula[m].toUpperCase() +" Consumo: "+iposicion+" gal/km"); 
        
        }else if(j == 0){
            
            // si no existen camiones disponibles, se muestra el siguiente mensaje: //
            System.out.println("--Ningun camion disponible para esta carga.--");
            
        }
    }
}
