package urgencies.app;

import java.util.Scanner;

import urgencies.llista.LlistaPacients;

/**
 * Programa principal: menú i entrada/sortida amb l'usuari. Tota la lògica
 * és a les altres classes.
 *
 * @author Persona B
 */
public class Main {

    /** Fitxer de text amb els pacients de prova. */
    static final String FITXER_PROVES = "dades/pacients_prova.txt";
    /** Fitxer on es guarden els pacients que passen a tractament. */
    static final String FITXER_TRACTAMENT = "dades/pacients_tractament.txt";
    /** Fitxer serialitzat de la sala. */
    static final String FITXER_SERIALITZAT = "dades/sala.ser";

    static Scanner teclat = new Scanner(System.in);

    /**
     * Mostra el menú i executa l'opció triada fins que l'usuari surt.
     *
     * @param args no s'utilitza
     */
    public static void main(String[] args) {
        LlistaPacients sala = new LlistaPacients();
        int opcio;
        do {
            mostrarMenu();
            opcio = llegirEnter("Opció: ");
            switch (opcio) {
                case 1: /* TODO afegir un pacient per teclat */ break;
                case 2: /* TODO assignar el grau d'urgència (cribratge) */ break;
                case 3: /* TODO incrementar el grau de tots */ break;
                case 4: /* TODO treure el més urgent, mostrar-lo i guardar-lo */ break;
                case 5: /* TODO guardar en fitxer serialitzat */ break;
                case 6: /* TODO carregar des de fitxer serialitzat */ break;
                case 7: /* TODO carregar des de fitxer de text */ break;
                case 8: /* TODO mostrar tots els pacients */ break;
                case 9: /* TODO consultes */ break;
                case 0: System.out.println("Adéu!"); break;
                default: System.out.println("Opció no vàlida.");
            }
        } while (opcio != 0);
        teclat.close();
    }

    /** Escriu les opcions del menú. */
    static void mostrarMenu() {
        System.out.println();
        System.out.println("=== SALA D'ESPERA D'URGÈNCIES ===");
        System.out.println("1. Afegir un pacient");
        System.out.println("2. Assignar grau d'urgència (cribratge)");
        System.out.println("3. Incrementar el grau de tots els pacients");
        System.out.println("4. Treure el pacient més urgent");
        System.out.println("5. Guardar la sala (fitxer serialitzat)");
        System.out.println("6. Carregar la sala (fitxer serialitzat)");
        System.out.println("7. Carregar pacients des de fitxer de text");
        System.out.println("8. Mostrar tots els pacients");
        System.out.println("9. Consultes");
        System.out.println("0. Sortir");
    }

    /**
     * Llegeix un enter del teclat i torna a demanar-lo si no és vàlid.
     *
     * @param missatge text que es mostra a l'usuari
     * @return l'enter llegit
     */
    static int llegirEnter(String missatge) {
        // TODO Persona B: controlar NumberFormatException
        System.out.print(missatge);
        return Integer.parseInt(teclat.nextLine().trim());
    }
}
