package no.hvl.dat108.oblig4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Deltager {

    @Id
    private String mobil;

    private String fornavn;
    private String etternavn;
    private String hash;
    private String salt;
    private String kjonn;

    public Deltager() {}

    public Deltager(String fornavn, String etternavn, String mobil,
                    String hash, String salt, String kjonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobil = mobil;
        this.hash = hash;
        this.salt = salt;
        this.kjonn = kjonn;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }
}
