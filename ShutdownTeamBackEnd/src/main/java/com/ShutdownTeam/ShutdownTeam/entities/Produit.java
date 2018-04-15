package com.ShutdownTeam.ShutdownTeam.entities;

import javax.persistence.*;

/**
 * Created by amino on 14/04/2018
 */

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String typeProduit;
    private String domaineMetier;
    private String motCles;
    private String produitCommun;
    private String categorie;

    public Produit(){}

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
    }

    public String getDomaineMetier() {
        return domaineMetier;
    }

    public void setDomaineMetier(String domaineMetier) {
        this.domaineMetier = domaineMetier;
    }

    public String getMotCles() {
        return motCles;
    }

    public void setMotCles(String motCles) {
        this.motCles = motCles;
    }

    public String getProduitCommun() {
        return produitCommun;
    }

    public void setProduitCommun(String produitCommun) {
        this.produitCommun = produitCommun;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
