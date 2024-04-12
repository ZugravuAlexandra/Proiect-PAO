package entitati;

public class Cititor extends Utilizator{
    private boolean elev;
    // sa fac si un istoric de imprumuturi

    public Cititor () {}

    public Cititor(int id, String nume, String prenume, String email, String telefon, boolean elev) {
        super(id, nume, prenume, email, telefon);
        this.elev = elev;
    }

    public boolean isElev() {
        return elev;
    }

    public void setElev(boolean elev) {
        this.elev = elev;
    }

    @Override
    public String toString() {
        return "Cititor: " +
                "id = " + getId() + "\n" +
                " nume = " + getNume() + "\n" +
                " prenume = " + getPrenume() + "\n" +
                " elev = " + elev;
    }
}
