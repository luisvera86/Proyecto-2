package modelo;

public class Trabajador{

  //ATRIBUTOS
  public String nombre;
  public String apellidoP;
  public String apellidoM;
  public String colonia;
  public String calle;
  public int edad;
  public String[] hH;
  public String[] hV;
  
  //CONSTRUCTORES
  public Trabajador(){

  }

  public Trabajador(String nombre, String apellidoP, String apellidoM,String colonia, String calle ,int edad, String[] hH, String[] hV){
    this.nombre=nombre;
    this.apellidoP=apellidoP;
    this.apellidoM=apellidoM;
    this.apellidoM=apellidoM;
    this.colonia=colonia;
    this.calle=calle;
    this.edad=edad;
    this.hH=hH;
    this.hV=hV;
  }

  //GETTERS Y SETTERS
  public void setNom(String nombre){
    this.nombre=nombre;
  }
  
  public void setAP(String apellidoP){
    this.apellidoP=apellidoP;
  }

  public void setAM(String apellidoM){
    this.apellidoM=apellidoM;
  }
  
  public void setColonia(String colonia){
    this.colonia=colonia;
  }

  public void setCalle(String calle){
    this.calle=calle;
  }

  public void setEdad(int edad){
    this.edad=edad;
  }

  public void setHH(String[] hH){
    this.hH=hH;
  }

  public void setHV(String[] hV){
    this.hV=hV;
  }

  public String getNom(){
    return nombre;
  }

  public String getAP(){
    return apellidoP;
  }

  public String getAM(){
    return apellidoM;
  }

  public String getCalle(){
    return calle;
  }

  public String getColonia(){
    return colonia;
  }

  public int getEdad(){
    return edad;
  }

  public String[] getHH(){
    return hH;
  }

  public String[] getHV(){
    return hV;
  }

}