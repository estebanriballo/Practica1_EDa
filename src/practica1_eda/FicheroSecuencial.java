package practica1_eda;

import java.io.*;
import java.util.*;

public class FicheroSecuencial<T extends SequentialFileReader> {
    private File fichero;
    private Scanner scan;
    private String separator;

    public FicheroSecuencial(String fileName, String separator) throws FileNotFoundException {
        this.fichero = new File(fileName);
        this.scan = new Scanner(fichero);
        this.separator = separator;
    }
    
    public void cerrar(){
        scan.close();
    }
    
    public void leer(T t){
        String[] data = scan.nextLine().split(separator);
        t.readData(data);
    }
    
    public void saltarUnaLinea(){
        scan.nextLine();
    }
    
    public boolean finalDeArchivo(){
        return scan.hasNextLine();
    }
}
