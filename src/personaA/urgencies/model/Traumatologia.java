package urgencies.model;

/**
 * Pacient de traumatologia.
 *
 * @author Persona A
 */
public class Traumatologia extends Pacient {

    private static final long serialVersionUID = 1L;

    /** Zona del cos on té la lesió. */
    private String zonaLesio;

    /**
     * @param codi      codi identificador
     * @param nom       nom del pacient
     * @param edat      edat en anys
     * @param alergia   cert si té al·lèrgia a algun medicament
     * @param zonaLesio zona del cos on té la lesió
     */
    public Traumatologia(String codi, String nom, int edat, boolean alergia, String zonaLesio) {
        super(codi, nom, edat, alergia);
        this.zonaLesio = zonaLesio;
    }

    /** @return la zona de la lesió */
    public String getZonaLesio() {
        return zonaLesio;
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

    /** @return {@link Especialitat#TRAUMATOLOGIA} */
    @Override
    public Especialitat getEspecialitat() {
        return Especialitat.TRAUMATOLOGIA;
    }

    @Override
    public String toString() {
        // TODO Persona A
        return super.toString();
    }
}
