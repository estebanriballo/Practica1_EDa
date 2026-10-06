package practica1_eda;

public class Efecto {
    private String jugador;
    private Carta c;

    public Efecto(String jugador, Carta c) {
        this.jugador = jugador;
        this.c = c;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public Carta getC() {
        return c;
    }

    public void setC(Carta c) {
        this.c = c;
    }
    
    
}
