package urgencies.model;

/**
 * Pacient de ginecologia: dona que està de part.
 *
 * @author Persona A
 */
public class Ginecologia extends Pacient {

    private static final long serialVersionUID = 1L;

    /** Cert si és el primer fill. */
    private boolean primerFill;
    /** Cert si té diabetis gestacional. */
    private boolean diabetisGestacional;

    /**
     * @param codi                codi identificador
     * @param nom                 nom de la pacient
     * @param edat                edat en anys
     * @param alergia             cert si té al·lèrgia a algun medicament
     * @param primerFill          cert si és el primer fill
     * @param diabetisGestacional cert si té diabetis gestacional
     */
    public Ginecologia(String codi, String nom, int edat, boolean alergia,
                       boolean primerFill, boolean diabetisGestacional) {
        super(codi, nom, edat, alergia);
        this.primerFill = primerFill;
        this.diabetisGestacional = diabetisGestacional;
    }

    /** @return cert si és el primer fill */
    public boolean esPrimerFill() {
        return primerFill;
    }

    /** @return cert si té diabetis gestacional */
    public boolean teDiabetisGestacional() {
        return diabetisGestacional;
    }

    /**
     * Grau base + 0.3 si és el primer fill + 0.5 si té diabetis gestacional.
     *
     * @return grau d'urgència calculat
     */
    @Override
    public double calcularGrau() {
        // TODO Persona A
        return 0;
    }

    /** @return {@link Especialitat#GINECOLOGIA} */
    @Override
    public Especialitat getEspecialitat() {
        return Especialitat.GINECOLOGIA;
    }

    @Override
    public String toString() {
        // TODO Persona A
        return super.toString();
    }
}
