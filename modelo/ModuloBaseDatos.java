package modelo;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class ModuloBaseDatos{

  //ATRIBUTOS
  private Trabajador[] empleados;
  private int numEmp;
  private String[] proHist;
  private String[] proVig;
  private int totalPro;

  //CONSTRUCTORES
  public ModuloBaseDatos(){

  }

  public ModuloBaseDatos(Trabajador[] empleados, int numEmp, String[] proHist, String[] proVig, int totalPro){
    this.empleados=empleados;
    this.numEmp=numEmp;
    this.proHist=proHist;
    this.proVig=proVig;
    this.totalPro=totalPro;
  }

  //GETTERS Y SETTERS
  public Trabajador[] getEmp(){
    return empleados;
  }
  
  public int getNumEmp(){
    return numEmp;
  }
  
  public String[] getPH(){
    return proHist;
  }
  
  public String[] getPV(){
    return proVig;
  }
  
  public int totalPro(){
    return totalPro;
  }

  public void setEmp(Trabajador[] empleados){
    this.empleados=empleados;
  }

  public void setNumEmp(int numEmp){
    this.numEmp=numEmp;
  }

  public void setPH(String[] proHist){
    this.proHist=proHist;
  }

  public void setPV(String[] proVig){
    this.proVig=proVig;
  }

  public void setTotP(int totalPro){
    this.totalPro=totalPro;
  }

  //METODOS

  //Crea Archivo Base de Datos
  public void crearBase(String nombre){
    File base = new File(nombre+".csv");

    if(!base.exists()){
      try{
        boolean seCreo = base.createNewFile();

      }catch(IOException ex){
        System.out.println(ex.getMessage());
      }
    }
  }

  //Escribe Archivo Base de Datos
  public void escribirBase(Trabajador[] trabajadores,int numEmp){
    try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escriba el nombre del archivo:");
        String archivo = br.readLine();
        
        FileWriter fw = new FileWriter(archivo+".csv");
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter salida = new PrintWriter(bw);
        
        for(int i=0; i<numEmp; i++){
          salida.println(/*(i+1)+","+*/trabajadores[i].getNom()+","+trabajadores[i].getAP()+","+trabajadores[i].getAM()+","+String.valueOf(trabajadores[i].getEdad())+","+trabajadores[i].getColonia()+","+trabajadores[i].getCalle());
          
          if(trabajadores[i].getHH()!=null){
            String acumulador="Historicos: ";
            for(int m=0;m<trabajadores[i].getHH().length;m++){
              acumulador=acumulador+","+trabajadores[i].getHH()[m];
            }
            salida.println(acumulador);
          }else{
            salida.println("Sin Registros Historicos");
          }

          String acumulador="Vigentes: ";
          for(int z=0; z<trabajadores[i].getHV().length;z++){
            acumulador=acumulador+","+trabajadores[i].getHV()[z];
          }
          
          salida.println(acumulador);
        }
        salida.close();
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }
  }

}