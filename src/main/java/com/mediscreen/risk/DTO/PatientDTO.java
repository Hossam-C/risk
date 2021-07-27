package com.mediscreen.risk.DTO;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.time.LocalDate;


@Component
public class PatientDTO {

    private Integer id;
    private String prenom;
    private String nom;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDeNaissance;
    private String genre;
    private String adressePostale;
    private String numeroDeTelephone;

    public PatientDTO() {
    }

    public PatientDTO(Integer id, String prenom, String nom, LocalDate dateDeNaissance, String genre, String adressePostale, String numeroDeTelephone) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.genre = genre;
        this.adressePostale = adressePostale;
        this.numeroDeTelephone = numeroDeTelephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAdressePostale() {
        return adressePostale;
    }

    public void setAdressePostale(String adressePostale) {
        this.adressePostale = adressePostale;
    }

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = numeroDeTelephone;
    }
}
