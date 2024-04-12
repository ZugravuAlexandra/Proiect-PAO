package entitati;

public class Evenimente {
    private String titlu;
    private String data;
    private String ora;
    private Adresa adresa;
    private int pret;

    public Evenimente() {}
    public Evenimente(String titlu, String data, String ora, Adresa adresa, int pret) {
        this.titlu = titlu;
        this.data = data;
        this.ora = ora;
        this.adresa = adresa;
        this.pret = pret;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Evenimente: " + "\n" +
                " titlu: " + "\n" +
                " data: " + "\n" +
                " ora: " + "\n" +
                " locatia: " + adresa + "\n" +
                " pret: " + pret;
    }
}
