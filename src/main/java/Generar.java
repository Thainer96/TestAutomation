

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*Thainer Perez 14/12/2021 - V1.0,  1.	En el metodo generar se agrega una espera de 1000 milisegundos
 * 										antes de generar la nueva ejecucion del cambio del estado de la variable
 * 									2.	Se tiene un contador con limite 10 cuando este se cumpla se cambiara la variable a false
 * 									3.  Cuando la variable este en false, se consumira y se imprimira dando como finalizada la ejecucion*/
public class Generar extends Thread {

    @Override
    public void run() {
        boolean vacio = true;
        Consumir consumir = new Consumir();
        System.out.println("Imprimiento la variable vacio valor inicial ----> " + vacio);
        for (int i = 0; i <= 10; i++) {
        	if(i == 10){ 
                vacio = false;
            }
            try {
            	Generar.sleep(1000);
                if(vacio==false) {
                	consumir.variableConsumir(vacio);
                }else {
                	DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy/MMMM/dd HH:mm:ss");
                	System.out.println(" Esperando el cambio | " + dtf2.format(LocalDateTime.now()));
                }
                
            } catch (Exception e) {
                System.out.println("Error en la clase Generar " + e);
            }
        }

    }

}
