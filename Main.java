import controlador.Controlador;
import modelo.ModuloBaseDatos;
import modelo.ModuloGeneradorDatosPersonales;
import modelo.Trabajador;

public class Main{
  public static void main(String[] args) {

    int noE = 20;
    Controlador controlador = new Controlador();
    Trabajador[] empleados = new Trabajador[noE];
    ModuloBaseDatos base = new ModuloBaseDatos();
    ModuloGeneradorDatosPersonales datos = new ModuloGeneradorDatosPersonales();

    empleados=controlador.creadorEmp(noE);

    controlador.printEmpl(empleados, noE);
    
    base.escribirBase(empleados,noE);

    datos.leerArchivo("Base de Datos");


    
  }
}