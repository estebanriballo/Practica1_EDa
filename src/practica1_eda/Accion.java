package practica1_eda;

public class Accion implements SequentialFileReader{
    private String jugador;
    private String tipo;
    private String carta;

    @Override
    public void readData(String[] data) {
        this.jugador = data[0];
        this.tipo = data[1];
        if(data.length > 2){
            this.carta = data[2];
        }else{
            this.carta = null;
        }
    }

    public String getJugador() {
        return jugador;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCarta() {
        return carta;
    }
}
