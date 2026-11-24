package urgencies.consultes;

import urgencies.llista.LlistaPacients;
import urgencies.model.Especialitat;

/**
 * Consultes sobre els pacients de la sala d'espera. Cada mètode recorre la
 * llista amb {@link LlistaPacients#getNElem()} i
 * {@link LlistaPacients#getPacient(int)} i retorna un valor numèric.
 *
 * @author Persona A
 */
public class ConsultesSala {

    /**
     * @param sala llista de pacients
     * @param e    especialitat
     * @return quants pacients hi ha d'aquesta especialitat
     */
    public static int comptarEspecialitat(LlistaPacients sala, Especialitat e) {
        // TODO Persona A
        return 0;
    }

    /**
     * @param sala llista de pacients
     * @param e    especialitat
     * @return el grau més alt d'aquesta especialitat, o -1 si no n'hi ha cap
     */
    public static double grauMaximEspecialitat(LlistaPacients sala, Especialitat e) {
        // TODO Persona A
        return -1;
    }

    /**
     * @param sala llista de pacients
     * @return quants pacients tenen al·lèrgies
     */
    public static int comptarAlergics(LlistaPacients sala) {
        // TODO Persona A
        return 0;
    }

    /**
     * @param sala llista de pacients
     * @return quantes dones tenen diabetis gestacional
     */
    public static int comptarDiabetisGestacional(LlistaPacients sala) {
        // TODO Persona A
        return 0;
    }

    /**
     * @param sala   llista de pacients
     * @param minuts límit de minuts
     * @return quants pacients de cardiologia porten més d'aquests minuts amb símptomes
     */
    public static int comptarCardiologiaMesDe(LlistaPacients sala, int minuts) {
        // TODO Persona A
        return 0;
    }
}
