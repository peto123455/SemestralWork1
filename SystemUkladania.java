import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

public class SystemUkladania {

    private static SystemUkladania instancia = null;
    
    private static final String SUBOR = "save.txt";
    private LinkedHashMap<String, Integer> udaje;

    public static SystemUkladania dajInstanciu() {
        if (SystemUkladania.instancia == null) {
            SystemUkladania.instancia = new SystemUkladania();
        }
 
        return SystemUkladania.instancia;
    }

    private SystemUkladania() {
        this.udaje = new LinkedHashMap<String, Integer>();

        try {
            this.nacitajUdaje();
        } catch (IOException exception) {
            ExceptionHandler.handleException(exception, false);
        }
    }

    public int getUdaj(String udaj) {
        return this.udaje.get(udaj);
    }

    public void aktualizujUdaj(String udaj, int hodnota) {
        this.udaje.put(udaj, hodnota);
        try {
            this.ulozUdaje();
        } catch (IOException exception) {
            ExceptionHandler.handleException(exception, false);
        }
    }

    public void ulozUdaje() throws IOException {
        File subor = new File(SUBOR);
        PrintWriter zapisovac = new PrintWriter(subor);

        this.udaje.forEach((kluc, hodnota) -> {
            zapisovac.println(String.valueOf(hodnota));
        });

        zapisovac.close();
    }

    /* Private */

    private void inicializuj() {
        for (Udaje udaj : Udaje.values()) {
            this.udaje.put(udaj.getString(), udaj.getPociatocnaHodnota());
        }
    }

    private void nacitajUdaje() throws IOException {
        File subor = new File(SUBOR);

        if (!subor.exists()) {
            this.inicializuj();
        }
        Scanner skener = new Scanner(subor);

        for (Udaje udaj : Udaje.values()) {
            this.udaje.put(udaj.getString(), skener.nextInt());
        }

        skener.close();
    }
}
