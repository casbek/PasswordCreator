package com.casbek.passwordcreator;

public class Filimler {
    private  String eposta;
    private String sifre;
    private int sifre_id;


    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Filimler(int sifre_id,String eposta, String sifre) {
        this.eposta = eposta;
        this.sifre = sifre;
        this.sifre_id = sifre_id;
    }

    public int getSifre_id() {
        return sifre_id;
    }

    public void setSifre_id(int sifre_id) {
        this.sifre_id = sifre_id;
    }
}
