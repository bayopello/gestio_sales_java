package urgencies.llista;

/**
 * Excepció que es llança quan s'intenta afegir un pacient i la sala
 * d'espera ja és plena.
 *
 * @author Persona B
 */
public class SalaPlenaException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * @param missatge descripció de l'error
     */
    public SalaPlenaException(String missatge) {
        super(missatge);
    }
}
