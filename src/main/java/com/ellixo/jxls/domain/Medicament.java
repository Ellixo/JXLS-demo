package com.ellixo.jxls.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"codeCIS", "denomination", "formePharmaceutique", "voiesAdministration", "statutAdministratifAMM", "typeProcedureAMM", "etatCommercialisation", "dateAMM", "statutBDM", "numeroAutorisationEuropeenne", "titulaires", "surveillanceRenforcee"})
public class Medicament {

    private String codeCIS;
    private String denomination;
    private String formePharmaceutique;
    private List<String> voiesAdministration = new ArrayList<>();
    private String statutAdministratifAMM;
    private String typeProcedureAMM;
    private String etatCommercialisation;
    private String dateAMM;
    private String statutBDM;
    private String numeroAutorisationEuropeenne;
    private List<String> titulaires = new ArrayList<>();
    private String surveillanceRenforcee;

    public String getCodeCIS() {
        return codeCIS;
    }

    public void setCodeCIS(String codeCIS) {
        this.codeCIS = codeCIS;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getFormePharmaceutique() {
        return formePharmaceutique;
    }

    public void setFormePharmaceutique(String formePharmaceutique) {
        this.formePharmaceutique = formePharmaceutique;
    }

    public List<String> getVoiesAdministration() {
        return voiesAdministration;
    }

    public void setVoiesAdministration(List<String> voiesAdministration) {
        this.voiesAdministration = voiesAdministration;
    }

    public String getStatutAdministratifAMM() {
        return statutAdministratifAMM;
    }

    public void setStatutAdministratifAMM(String statutAdministratifAMM) {
        this.statutAdministratifAMM = statutAdministratifAMM;
    }

    public String getTypeProcedureAMM() {
        return typeProcedureAMM;
    }

    public void setTypeProcedureAMM(String typeProcedureAMM) {
        this.typeProcedureAMM = typeProcedureAMM;
    }

    public String getEtatCommercialisation() {
        return etatCommercialisation;
    }

    public void setEtatCommercialisation(String etatCommercialisation) {
        this.etatCommercialisation = etatCommercialisation;
    }

    public String getDateAMM() {
        return dateAMM;
    }

    public void setDateAMM(String dateAMM) {
        this.dateAMM = dateAMM;
    }

    public String getStatutBDM() {
        return statutBDM;
    }

    public void setStatutBDM(String statutBDM) {
        this.statutBDM = statutBDM;
    }

    public String getNumeroAutorisationEuropeenne() {
        return numeroAutorisationEuropeenne;
    }

    public void setNumeroAutorisationEuropeenne(String numeroAutorisationEuropeenne) {
        this.numeroAutorisationEuropeenne = numeroAutorisationEuropeenne;
    }

    public List<String> getTitulaires() {
        return titulaires;
    }

    public void setTitulaires(List<String> titulaires) {
        this.titulaires = titulaires;
    }

    public String getSurveillanceRenforcee() {
        return surveillanceRenforcee;
    }

    public void setSurveillanceRenforcee(String surveillanceRenforcee) {
        this.surveillanceRenforcee = surveillanceRenforcee;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "codeCIS='" + codeCIS + '\'' +
                ", denomination='" + denomination + '\'' +
                ", formePharmaceutique='" + formePharmaceutique + '\'' +
                ", voiesAdministration=" + voiesAdministration +
                ", statutAdministratifAMM='" + statutAdministratifAMM + '\'' +
                ", typeProcedureAMM='" + typeProcedureAMM + '\'' +
                ", etatCommercialisation='" + etatCommercialisation + '\'' +
                ", dateAMM='" + dateAMM + '\'' +
                ", statutBDM='" + statutBDM + '\'' +
                ", numeroAutorisationEuropeenne='" + numeroAutorisationEuropeenne + '\'' +
                ", titulaires=" + titulaires +
                ", surveillanceRenforcee='" + surveillanceRenforcee + '\'' +
                '}';
    }
}
