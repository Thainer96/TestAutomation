
package Prueba.Automation;


public class Consumir extends Thread  {
    
    public void variableConsumir(boolean bandera){
        System.out.println("Imprimiento la variable vacio vlr Final -----> "  +bandera);
    }
    
    @Override
    public void run() {
    	 System.out.println("Se Inicio por primera vez la clase Consumir");
    }
}
