package no.hvl.dat108.oblig4.model;

public class Deltager {

    private String fornavn;
    private String etternavn;
    private String mobil;
    private String passord;
    private String kjonn;

    public Deltager(String fornavn, String etternavn, String mobil, String passord, String kjonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobil = mobil;
        this.passord = passord;
        this.kjonn = kjonn;
    }

    public String getFornavn() { return fornavn; }
    public String getEtternavn() { return etternavn; }
    public String getMobil() { return mobil; }
    public String getPassord() { return passord; }
    public String getKjonn() { return kjonn; }

    @Override
    public String toString() {
        return fornavn + " " + etternavn + " (" + mobil + ")";
    }
}
