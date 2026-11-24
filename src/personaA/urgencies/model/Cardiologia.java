package urgencies.model;

/**
 * Pacient de cardiologia.
 *
 * @author Persona A
 */
public class Cardiologia extends Pacient {

    private static final long serialVersionUID = 1L;

    /** Minuts des de l'inici dels símptomes. */
    private int minutsSimptomes;

    /**
     * @param codi            codi identificador
     * @param nom             nom del pacient
     * @param edat            edat en anys
     * @param alergia         cert si té al·lèrgia a algun medicament
     * @param minutsSimptomes minuts des de l'inici dels símptomes
     */
    public Cardiologia(String codi, String nom, int edat, boolean alergia, int minutsSimptomes) {
        super(codi, nom, edat, alergia);
        this.minutsSimptomes = minutsSimptomes;
    }

    /** @return els minuts des de l'inici dels símptomes */
    public int getMinutsSimptomes() {
        return minutsSimptomes;
    }

    /**
     * Grau base + 0.1 per cada 5 minuts complets des de l'inici dels
     * símptomes (divisió entera: 22 minuts = 0.4).
     *
     * @return grau d'urgència calculat
     */
    @Override
    public double calcularGrau() {
        // TODO Persona A
        return 0;
    }

    /** @return {@link Especialitat#CARDIOLOGIA} */
    @Override
    public Especialitat getEspecialitat() {
        return Especialitat.CARDIOLOGIA;
    }

    @Override
    public String toString() {
        // TODO Persona A
        return super.toString();
    }
}
