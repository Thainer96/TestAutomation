
public class Main {

    public static void main(String[] args) {
        Limpiar limpiar = new Limpiar();
        limpiar.start();
        
        Generar generar = new Generar();
        generar.start();
        
        Consumir consumir = new Consumir();
        consumir.start();
        
        
    }
    
}
