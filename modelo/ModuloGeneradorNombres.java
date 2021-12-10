package modelo;

import java.util.Random;

public class ModuloGeneradorNombres{

  public ModuloGeneradorNombres(){
    
  }

  //Arreglo de Nombres
    private String[] nombres ={"Edith","Luis","Diego","Juan","Maria","Monica","Nohemi","Erendina","Patricia","Jaime","Javier","Imelda","Maricela","Sebastian","Edwin","Monserrat","Melissa","Paula","Hipolito","Victor"};

    //Arreglo de apellidos
    private String[] apellido={"Lopez","Hernandez","Rodriguez","Perez","Cruz","Martinez","Colmenares","Marquez","Rivas","Cervera","FLores","Reyes","Rivera","Castro","Zuñiga","Montoya","Aguilera","Velazquez","Zamora","Vera"};

    //Método que genera un nombre aleatorio
    public String nombreAleatorio(){
        Random y = new Random();
       
        return this.nombres[y.nextInt(nombres.length-1)+1]+","+this.apellido[y.nextInt(apellido.length-1)+1]+","+this.apellido[y.nextInt(y.nextInt(apellido.length-1)+1)];
    }

    //Método que genera "x" nombres creados por el usuario
    public String[] generarNombres(int x){
      if(x<=0){
        System.out.println("Dato Incorrecto, ingrese nuevamente");
        return null;
      }else{
        String arrayNombres[] = new String[x];
          for (int i=0; i<x; i++) {
            arrayNombres[i] = nombreAleatorio();
          }
        return arrayNombres;
      }
    }

    //Método que lee un String
    public void leerNombre(String arrayNombres){
        System.out.println(arrayNombres);
    }
}