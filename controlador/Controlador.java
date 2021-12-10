package controlador;
import modelo.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Controlador{
  public Controlador(){

  }

  //METODOS

  //Creador de Empleados
  public Trabajador[] creadorEmp(int empleados){
    if(empleados>0){
      ModuloGeneradorNombres genNom = new ModuloGeneradorNombres();
      ModuloGeneradorDatosPersonales genDatP = new ModuloGeneradorDatosPersonales();
      Trabajador arrayEmp[] = new Trabajador[empleados];
      
      String[] direcciones=direccRandom(empleados);

      for(int i=0; i<empleados;i++){
        String nom = genNom.nombreAleatorio();
        int edad = genDatP.edadRandom();
        String direcc = direcciones[i];
        String[] historicos=crearHist();
        String[] vigentes= crearVig();
        
        Trabajador aux = new Trabajador();
        
        aux = tokenizador(nom+","+direcc);
        aux.setEdad(edad);
        aux.setHH(historicos);
        aux.setHV(vigentes);
        
        arrayEmp[i]= aux;
      }
      return arrayEmp;
    }else
      return null;
  }

  //Cargar Direcciones
  public String[] cargarDirecc(){
    ModuloGeneradorDatosPersonales genDatos = new ModuloGeneradorDatosPersonales();
    String[] direcciones = genDatos.arrayArchivo("Direcciones",genDatos.tamañoArchivo("Direcciones"));
    return direcciones;
  }

  //Direccion Aleatoria
  public String[] direccRandom(int x){

    if(x!=0){
      String[] direcciones = cargarDirecc();
      String dirRan[] = new String[x];
      List<String> direcciones2 = new ArrayList<>();

      for(int i=0; i<direcciones.length;i++){
        direcciones2.add(direcciones[i]);
      }

      Random aux = new Random();

      for(int i=0;i<x;i++){
        int randomIndex = aux.nextInt(direcciones2.size());
        dirRan[i]=direcciones2.get(randomIndex);
        direcciones2.remove(randomIndex);
      }
    return dirRan;
    }else{
      System.out.println("Numero fuera del rango");
      return null;
    }
  }

  //Creador Proyectos Historicos
  public String[] crearHist(){
    ModuloGeneradorDatosPersonales conde = new ModuloGeneradorDatosPersonales();
    ModuloGeneradorProyectos aux = new ModuloGeneradorProyectos();
    
    int x=conde.tamañoArchivo("Historicos");
    String[] proyectosHistoricos;
    int[] numHistoricos;
    
    proyectosHistoricos=conde.arrayArchivo("Historicos",x);
    numHistoricos = aux.genHistRandom(proyectosHistoricos,x);

    String[] hist = aux.concatenaProyecto(numHistoricos, proyectosHistoricos, "Historicos");

    return hist;
  }

  //Creador Proyectos Vigentes
  public String[] crearVig(){
    ModuloGeneradorDatosPersonales conde = new ModuloGeneradorDatosPersonales();
    ModuloGeneradorProyectos aux = new ModuloGeneradorProyectos();
    
    int x=conde.tamañoArchivo("Vigentes");
    String[] proyectosVigentes;
    int[] numVigentes;
    
    proyectosVigentes=conde.arrayArchivo("Vigentes",x);
    numVigentes = aux.genVigRandom(proyectosVigentes,x,3);

    String[] vig = aux.concatenaProyecto(numVigentes, proyectosVigentes, "Vigentes");

    return vig;
  }
  
  //Tokenizer nombre
  public Trabajador tokenizador(String linea){
    StringTokenizer tokenizador = new StringTokenizer(linea,",");
    int count = 0;
    String nombre=null, apPaterno=null, apMaterno=null,colonia=null,calle=null;

    while(tokenizador.hasMoreTokens()){
      String aux = tokenizador.nextToken();
      if(count == 0)
        nombre = aux;
      else if(count==1)
        apPaterno = aux;
      else if(count==2)
        apMaterno = aux;
      else if(count==3)
        colonia=aux;
      else if (count==4)
        calle=aux;

      count++;
    }

    Trabajador trabajador=new Trabajador();
    trabajador.setNom(nombre);
    trabajador.setAP(apPaterno);
    trabajador.setAM(apMaterno);
    trabajador.setColonia(colonia);
    trabajador.setCalle(calle);

    return trabajador;
  }

  //IMPRIME Empleados
  public void printEmpl(Trabajador[] trabajador,int numEmp){
    int i=0;

    for(Trabajador elemento:trabajador){
      System.out.print("Trabajador: "+(i+1)+","+elemento.getNom()+","+elemento.getAP()+","+elemento.getAM()+","+String.valueOf(elemento.getEdad())+","+elemento.getColonia()+","+elemento.getCalle());
      System.out.println("\n");

      if(elemento.getHH()!=null){
        int aux1=elemento.getHH().length;
        System.out.println("Historicos: "+aux1);

        for(String histor:elemento.getHH()){
          System.out.println(histor);
        }
      }else{
        System.out.println("Sin registros históricos");
      }

      int aux2=elemento.getHV().length;

      System.out.println("\n");
      System.out.println("Vigentes: "+aux2);
      for(String vig:elemento.getHV()){
        System.out.println(vig);
      }

      System.out.println("\n");
      i++;
    }
  }
}