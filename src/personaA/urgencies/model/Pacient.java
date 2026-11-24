package urgencies.model;

import java.io.Serializable;

/**
 * Pacient que espera a la sala d'urgències. Classe base abstracta de les
 * quatre especialitats.
 *
 * @author Persona A
 */
public abstract class Pacient implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Codi identificador que li donen al mostrador. */
    protected String codi;
    /** Nom del pacient. */
    protected String nom;
    /** Edat en anys. */
    protected int edat;
    /** Cert si té al·lèrgia a algun medicament. */
    protected boolean alergia;
    /** Grau d'urgència; val 0 fins al cribratge. */
    protected double grauUrgencia;
    /** Cert quan ja se li ha assignat el grau d'urgència. */
    protected boolean cribrat;

    /**
     * Crea un pacient encara sense cribrar.
     *
     * @param codi    codi identificador
     * @param nom     nom del pacient
     * @param edat    edat en anys
     * @param alergia cert si té al·lèrgia a algun medicament
     */
    public Pacient(String codi, String nom, int edat, boolean alergia) {
        this.codi = codi;
        this.nom = nom;
        this.edat = edat;
        this.alergia = alergia;
        this.grauUrgencia = 0;
        this.cribrat = false;
    }

    /** @return el codi identificador */
    public String getCodi() {
        return codi;
    }

    /** @return el nom */
    public String getNom() {
        return nom;
    }

    /** @return l'edat */
    public int getEdat() {
        return edat;
    }

    /** @return cert si té al·lèrgia a algun medicament */
    public boolean teAlergia() {
        return alergia;
    }

    /** @return el grau d'urgència actual */
    public double getGrauUrgencia() {
        return grauUrgencia;
    }

    /** @return cert si ja s'ha fet el cribratge */
    public boolean estaCribrat() {
        return cribrat;
    }

    /**
     * Calcula la part del grau que depèn de l'edat (edat / 20).
     *
     * @return grau base
     */
    protected double calcularGrauBase() {
        // TODO Persona A
        return 0;
    }

    /**
     * Calcula el grau d'urgència complet: el grau base més els punts
     * extra de cada especialitat.
     *
     * @return grau d'urgència calculat
     */
    public abstract double calcularGrau();

    /**
     * @return l'especialitat del pacient
     */
    public abstract Especialitat getEspecialitat();

    /**
     * Fa el cribratge: calcula i desa el grau d'urgència i marca el
     * pacient com a cribrat.
     */
    public void assignarGrau() {
        // TODO Persona A
    }

    /**
     * Suma punts al grau d'urgència (simula el pas del temps).
     *
     * @param punts punts a sumar
     */
    public void incrementarGrau(double punts) {
        // TODO Persona A
    }

    /**
     * @return les dades comunes del pacient en format text
     */
    @Override
    public String toString() {
        // TODO Persona A: ajustar el format
        return codi + " - " + nom + " (" + edat + " anys)";
    }
}
