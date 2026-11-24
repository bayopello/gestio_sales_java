package urgencies.fitxers;

import java.io.IOException;

import urgencies.llista.LlistaPacients;
import urgencies.llista.SalaPlenaException;
import urgencies.model.Pacient;

/**
 * Lectura i escriptura dels fitxers de l'aplicació.
 *
 * <p>Format del fitxer de text: una línia per pacient, amb els camps separats
 * per ';'. El primer camp és l'especialitat:</p>
 * <pre>
 * CARDIOLOGIA;codi;nom;edat;alergia;minuts
 * TRAUMATOLOGIA;codi;nom;edat;alergia;zona
 * GINECOLOGIA;codi;nom;edat;alergia;primerFill;diabetis
 * ALTRES;codi;nom;edat;alergia;descripcio
 * </pre>
 *
 * @author Persona A
 */
public class GestorFitxers {

    /** Separador de camps al fitxer de text. */
    public static final String SEPARADOR = ";";

    /**
     * Llegeix els pacients d'un fitxer de text i els afegeix a la llista.
     *
     * @param l         llista on s'afegeixen
     * @param nomFitxer ruta del fitxer
     * @return quants pacients s'han afegit
     * @throws IOException        si hi ha un error de lectura
     * @throws SalaPlenaException si la sala s'omple abans d'acabar el fitxer
     */
    public static int carregarText(LlistaPacients l, String nomFitxer)
            throws IOException, SalaPlenaException {
        // TODO Persona A
        return 0;
    }

    /**
     * Afegeix les dades d'un pacient al final d'un fitxer de text.
     *
     * @param p         pacient que entra a tractament
     * @param nomFitxer ruta del fitxer
     * @throws IOException si hi ha un error d'escriptura
     */
    public static void guardarPacientText(Pacient p, String nomFitxer) throws IOException {
        // TODO Persona A
    }

    /**
     * Guarda tota la llista en un fitxer serialitzat.
     *
     * @param l         llista a guardar
     * @param nomFitxer ruta del fitxer
     * @throws IOException si hi ha un error d'escriptura
     */
    public static void guardarSerialitzat(LlistaPacients l, String nomFitxer) throws IOException {
        // TODO Persona A
    }

    /**
     * Carrega una llista des d'un fitxer serialitzat.
     *
     * @param nomFitxer ruta del fitxer
     * @return la llista carregada
     * @throws IOException            si hi ha un error de lectura
     * @throws ClassNotFoundException si el fitxer no conté una llista vàlida
     */
    public static LlistaPacients carregarSerialitzat(String nomFitxer)
            throws IOException, ClassNotFoundException {
        // TODO Persona A
        return new LlistaPacients();
    }
}
