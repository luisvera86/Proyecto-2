package modelo;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class ModuloGeneradorDatosPersonales{

  public ModuloGeneradorDatosPersonales(){
    
  }
  
  //Método que lee un archivo con nombre dado por el usuario
  public void leerArchivo(String fileName){
    File archivo = new File(fileName+".csv");

    if(archivo.exists()){
    try{
        FileReader fr = new FileReader(fileName+".csv");
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        while(linea != null){
          System.out.println(linea);
          linea = br.readLine();
        }
        br.close();
      }catch(FileNotFoundException ex){
        System.out.println(ex.getMessage());
      }catch(IOException ex){
        System.out.println(ex.getMessage());
      }
    }else{
      System.out.println("No se encontró el archivo");
    }
  }

  //Método que guarda las líneas de un archivo dentro de un array para iterarlo
  public String[] arrayArchivo(String fileName,int lineas){
    File archivo = new File(fileName+".csv");

    String datos[] = new String[lineas];
    
    if(archivo.exists()){
      try{
          FileReader fr = new FileReader(fileName+".csv");
          BufferedReader br = new BufferedReader(fr);
          String linea = br.readLine();
          int i=0;
          
          while(linea != null){
            datos[i]=linea;
            linea = br.readLine();
            i++;
          }
          br.close();
        }catch(FileNotFoundException ex){
          System.out.println(ex.getMessage());
        }catch(IOException ex){
          System.out.println(ex.getMessage());
        }
      return datos;
    }else{
      System.out.println("No se encontró el archivo");
      return null;
    }
  }

  //Método Tamaño archivo
  public int tamañoArchivo(String fileName){
    try{
          FileReader fr = new FileReader(fileName+".csv");
          BufferedReader bf = new BufferedReader(fr);
          int lNumeroLineas = 0;
          String sCadena;
          while ((sCadena = bf.readLine())!=null) {
            lNumeroLineas++;
          }
          return lNumeroLineas;
        } catch (FileNotFoundException fnfe){
          fnfe.printStackTrace();
        } catch (IOException ioe){
          ioe.printStackTrace();
        }
      return 0;
  }

  //Método edad aleatoria >18
  public int edadRandom(){
    Random ran = new Random();
    int edad = (ran.nextInt(51-18)+18);
    return edad;
  }
}