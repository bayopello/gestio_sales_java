package urgencies.llista;

import java.io.Serializable;

import urgencies.model.Pacient;

/**
 * Llista de pacients de la sala d'espera d'urgències, implementada amb un
 * array de mida fixa (sense ArrayList).
 *
 * <p>Les consultes són a {@code urgencies.consultes.ConsultesSala}.</p>
 *
 * @author Persona B
 */
public class LlistaPacients implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Capacitat màxima de la sala d'espera. */
    public static final int CAPACITAT = 30;

    /** Pacients guardats a les posicions 0..nElem-1. */
    private Pacient[] llista;
    /** Nombre de pacients que hi ha a la llista. */
    private int nElem;

    /** Crea una llista buida. */
    public LlistaPacients() {
        llista = new Pacient[CAPACITAT];
        nElem = 0;
    }

    /** @return nombre de pacients a la sala */
    public int getNElem() {
        return nElem;
    }

    /**
     * @param i posició (0..nElem-1)
     * @return el pacient de la posició i
     */
    public Pacient getPacient(int i) {
        // TODO Persona B
        return null;
    }

    /** @return cert si la sala és plena */
    public boolean esPlena() {
        // TODO Persona B
        return false;
    }

    /**
     * Afegeix un pacient al final de la llista.
     *
     * @param p pacient que arriba
     * @throws SalaPlenaException si ja hi ha CAPACITAT pacients
     */
    public void afegir(Pacient p) throws SalaPlenaException {
        // TODO Persona B
    }

    /**
     * Cerca un pacient pel seu codi.
     *
     * @param codi codi del pacient
     * @return el pacient, o null si no hi és
     */
    public Pacient buscar(String codi) {
        // TODO Persona B
        return null;
    }

    /**
     * Fa el cribratge del pacient amb aquest codi (li assigna el grau).
     *
     * @param codi codi del pacient
     * @return false si no hi ha cap pacient amb aquest codi
     */
    public boolean assignarGrau(String codi) {
        // TODO Persona B
        return false;
    }

    /**
     * Suma punts al grau de tots els pacients cribrats.
     *
     * @param punts punts a sumar
     */
    public void incrementarGrau(double punts) {
        // TODO Persona B
    }

    /**
     * Treu de la llista el pacient cribrat amb el grau més alt.
     *
     * @return el pacient tret, o null si no hi ha cap pacient cribrat
     */
    public Pacient treureMesUrgent() {
        // TODO Persona B
        return null;
    }
}
