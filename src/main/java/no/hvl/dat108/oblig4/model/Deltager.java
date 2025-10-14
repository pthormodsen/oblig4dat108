// src/main/java/no/hvl/dat108/model/Deltager.java
package no.hvl.dat108.oblig4.model;

public class Deltager {
    private String fornavn;
    private String etternavn;
    private String mobil;
    private String kjonn;

    public Deltager(String fornavn, String etternavn, String mobil, String kjonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobil = mobil;
        this.kjonn = kjonn;
    }

    public String getFornavn() { return fornavn; }
    public String getEtternavn() { return etternavn; }
    public String getMobil() { return mobil; }
    public String getKjonn() { return kjonn; }
}
