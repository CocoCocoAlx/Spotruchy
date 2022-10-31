package sistema;

import modelo.Spotruchy;
import vista.Principal;

public class Inicio {

    public static void main(String[] args) {
        Spotruchy s = (Spotruchy) Spotruchy.getPersistencia().buscar(Spotruchy.class, 1L);

        if (s == null) {
            s = new Spotruchy(1, "Spotruchy");
        }

        Principal ventana = new Principal(s);

        ventana.setVisible(true);
    }

}
