package practica1_eda;

import java.util.*;

public class JuegoDeCartas {
    private Stack<Carta> MazoDeRobo;
    private Stack<Carta> MazoDeDescartes;
    private Stack<Efecto> PilaDeEfectos;

    public JuegoDeCartas() {
        this.MazoDeRobo = new Stack<>();
        this.MazoDeDescartes = new Stack<>();
        this.PilaDeEfectos = new Stack<>();
        this.MazoDeRobo.push(Carta.GOLPE_CRITICO);
        this.MazoDeRobo.push(Carta.RAYO_CONGELANTE);
        this.MazoDeRobo.push(Carta.BARRERA_DE_HIELO);
        this.MazoDeRobo.push(Carta.POCION_DE_VIDA);
        this.MazoDeRobo.push(Carta.CONTRAHECHIZO);
        this.MazoDeRobo.push(Carta.ESCUDO_MAGICO);
        this.MazoDeRobo.push(Carta.BOLA_DE_FUEGO);
    }

    public Stack<Carta> getMazoDeRobo() {
        return MazoDeRobo;
    }

    public Stack<Carta> getMazoDeDescartes() {
        return MazoDeDescartes;
    }

    public Stack<Efecto> getPilaDeEfectos() {
        return PilaDeEfectos;
    }
    
    public void robar(String jugador){
        if(this.MazoDeRobo.isEmpty() && this.MazoDeDescartes.isEmpty()){
            System.out.println("Ambos mazos están vacíos");
        }
        else if (this.MazoDeRobo.isEmpty()){
            for(; !this.MazoDeDescartes.isEmpty();){
                Carta c = this.MazoDeDescartes.pop();
                this.MazoDeRobo.push(c);
            }
            Carta c = this.MazoDeRobo.pop();
            System.out.println("\n- " + jugador + " robó " + c.name() + "\n");
        }
        else{
            Carta c = this.MazoDeRobo.pop();
            System.out.println("\n- " + jugador + " robó " + c.name() + "\n");
        }
    }
    
    public void jugar(Carta c, String jugador){
        Efecto e = new Efecto(jugador, c);
        this.PilaDeEfectos.push(e);
        System.out.println("\n- " + jugador + " usó " + c.name() + "\n");
    }
    
    public void descartar(Carta c, String jugador){
        this.MazoDeDescartes.push(c);
        System.out.println("\n- " + jugador + " descartó " + c.name() + "\n");
    }
    
    public void resolver(){
        System.out.println("\n");
        for(; !this.PilaDeEfectos.isEmpty();){
            Efecto e = this.PilaDeEfectos.pop();
            this.MazoDeDescartes.add(e.getC());
            System.out.println("Carta: " + e.getC() + " Jugador: " + e.getJugador());
        }
        System.out.println("\n");
    }
}
