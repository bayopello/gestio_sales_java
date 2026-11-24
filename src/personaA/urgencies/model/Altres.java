package urgencies.model;

/**
 * Pacient d'altres especialitats.
 *
 * @author Persona A
 */
public class Altres extends Pacient {

    private static final long serialVersionUID = 1L;

    /** Breu explicació que dona el pacient. */
    private String descripcio;

    /**
     * @param codi       codi identificador
     * @param nom        nom del pacient
     * @param edat       edat en anys
     * @param alergia    cert si té al·lèrgia a algun medicament
     * @param descripcio breu explicació del pacient
     */
    public Altres(String codi, String nom, int edat, boolean alergia, String descripcio) {
        super(codi, nom, edat, alergia);
        this.descripcio = descripcio;
    }

    /** @return la descripció */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Només el grau base, sense punts extra.
     *
     * @return grau d'urgència calculat
     */
    @Override
    public double calcularGrau() {
        // TODO Persona A
        return 0;
    }

    /** @return {@link Especialitat#ALTRES} */
    @Override
    public Especialitat getEspecialitat() {
        return Especialitat.ALTRES;
    }

    @Override
    public String toString() {
        // TODO Persona A
        return super.toString();
    }
}
