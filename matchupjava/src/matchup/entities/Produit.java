/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.entities;

import java.sql.Blob;
import java.util.Objects;


/**
 *
 * @author Asus
 */
public class Produit {
    private int id_produit , id ,prix,quantite_total , quantite_restant , id_categorie ;
    private String nom_produit, description , photo;

    public Produit() {
    }

    public Produit(int id_produit, int id, int prix, int quantite_total, int quantite_restant, int id_categorie, String nom_produit, String description ,String photo) {
        this.id_produit = id_produit;
        this.id = id;
        this.prix = prix;
        this.quantite_total = quantite_total;
        this.quantite_restant = quantite_restant;
        this.id_categorie = id_categorie;
        this.nom_produit = nom_produit;
        this.description = description;
        this .photo=photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.id_produit != other.id_produit) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.prix != other.prix) {
            return false;
        }
        if (this.quantite_total != other.quantite_total) {
            return false;
        }
        if (this.quantite_restant != other.quantite_restant) {
            return false;
        }
        if (this.id_categorie != other.id_categorie) {
            return false;
        }
        if (!Objects.equals(this.nom_produit, other.nom_produit)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", id=" + id + ", prix=" + prix + ", quantite_total=" + quantite_total + ", quantite_restant=" + quantite_restant + ", id_categorie=" + id_categorie + ", nom_produit=" + nom_produit + ", description=" + description + ", photo=" + photo + '}';
    }

  
   


    
    
}
