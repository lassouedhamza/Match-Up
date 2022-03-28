/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.entities;

/**
 *
 * @author Asus
 */

public class Produit {
    public int id_produit;
    public String nom_produit;
    public int prix;
    public int quantite_total ;
    public int quantite_restant ;
    public String description;
    public String path;
    public int id;
    public int id_categorie;
    
    

    public Produit(int id_produit, int id, int prix, int quantite_total, int quantite_restant, int id_categorie, String nom_produit, String description, String path) {
        this.id_produit = id_produit;
        this.id = id;
        this.prix = prix;
        this.quantite_total = quantite_total;
        this.quantite_restant = quantite_restant;
        this.id_categorie = id_categorie;
        this.nom_produit = nom_produit;
        this.description = description;
        this.path = path;
    }

    public Produit(int id_produit, String nom_produit, int prix, int quantite_total, int quantite_restant, String description, String path) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.prix = prix;
        this.quantite_total = quantite_total;
        this.quantite_restant = quantite_restant;    
        this.description = description;
        this.path = path;
    }
      public Produit() {
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantite_total() {
        return quantite_total;
    }

    public void setQuantite_total(int quantite_total) {
        this.quantite_total = quantite_total;
    }

    public int getQuantite_restant() {
        return quantite_restant;
    }

    public void setQuantite_restant(int quantite_restant) {
        this.quantite_restant = quantite_restant;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", id=" + id + ", prix=" + prix + ", quantite_total=" + quantite_total + ", quantite_restant=" + quantite_restant + ", id_categorie=" + id_categorie + ", nom_produit=" + nom_produit + ", description=" + description + ", path=" + path + '}';
    }


      
    
}
