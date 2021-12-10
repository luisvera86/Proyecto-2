package modelo;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ModuloGeneradorProyectos{
  public ModuloGeneradorProyectos(){

  }

  //GENERADOR HISTORICOS ALEATORIOS
  public int[] genHistRandom(String[] nombres, int x){
    Random tP = new Random(); 
    int tPH = tP.nextInt((x+1));  

    if(tPH!=0){ 
      List<Integer> proyectosH = new ArrayList<>();
      int totHist[] = new int[tPH]; 

      for(int i=0;i<x;i++){
        proyectosH.add(i+1);
      }

      for(int i=0;i<tPH;i++){
        int randomIndex = tP.nextInt(proyectosH.size());
        totHist[i]=proyectosH.get(randomIndex);
        proyectosH.remove(randomIndex);
      }
      Arrays.sort(totHist);
      return totHist;
    }else{
      return null;
    } 
  }

  //GENERADOR VIGENTES ALEATORIOS
  public int[] genVigRandom(String[] nombres, int x, int max){
    Random tV = new Random();
    int tPV = tV.nextInt((max+1)-1)+1;
    
    List<Integer> proyectosV = new ArrayList<>();
    int totVig[] = new int[tPV];

    for(int i=0;i<x;i++){
        proyectosV.add(i+1);
    }

    for(int i=0; i<tPV;i++){
      int randomIndex=tV.nextInt(proyectosV.size());
      totVig[i]=proyectosV.get(randomIndex);
      proyectosV.remove(randomIndex);
    }

    Arrays.sort(totVig);
    return totVig;
  }

  //LEE TOTAL DE PROYECTOS, NUMERO DE PROYECTO Y NOMBRE
  public void leerProyecto(int[] proyectos, String[] nombre, String tipo){
    if(proyectos==null){
      System.out.println("No existen proyectos "+tipo+"s"+" registrados");
    }else{
      System.out.println(tipo+":"+proyectos.length);
      for (int proyecto : proyectos) {
        System.out.println(proyecto+". "+nombre[proyecto-1]);
      }
    }
  }

  //CONCATENAR PROYECTO
  public String[] concatenaProyecto(int[] proyectos, String[] nombre, String tipo){
      if(proyectos==null){
        return null;
      }else{
        String proyectosAux[]= new String[proyectos.length];
        for(int i=0;i<proyectos.length;i++){
          proyectosAux[i]=proyectos[i]+"."+nombre[(proyectos[i]-1)];
        }
        return proyectosAux;
      }
  }

}