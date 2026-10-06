package practica1_eda;

import java.io.FileNotFoundException;

public class Practica1_EDa {

    public static void main(String[] args) throws FileNotFoundException {
        JuegoDeCartas j = new JuegoDeCartas();
        
        FicheroSecuencial <Accion> acciones = new FicheroSecuencial<>("acciones.csv", ",");
        
        Accion a = new Accion();
        
        while (acciones.finalDeArchivo()){
            acciones.leer(a);
            switch (a.getTipo()) {
                case "ROBAR":
                    j.robar(a.getJugador());
                    break;
                case "JUGAR":
                    {
                        Carta c = Carta.valueOf(a.getCarta());
                        j.jugar(c, a.getJugador());
                        break;
                    }
                case "DESCARTAR":
                    {
                        Carta c = Carta.valueOf(a.getCarta());
                        j.descartar(c, a.getJugador());
                        break;
                    }
                case "RESOLVER":
                    j.resolver();
                    break;
                default:
                    break;
            }
            
            System.out.println("Mazo de robo: " + j.getMazoDeRobo());
            System.out.println("Mazo de descartes: " + j.getMazoDeDescartes());
            System.out.println("Pila de efectos: " + j.getPilaDeEfectos());
        }
        
        System.out.println("\n[ESTADO FINAL DE LAS PILAS]\n");
        
        System.out.println("Mazo de robo: " + j.getMazoDeRobo());
        System.out.println("Mazo de descartes: " + j.getMazoDeDescartes());
        System.out.println("Pila de efectos: " + j.getPilaDeEfectos());
        
        acciones.cerrar();
    }
}
