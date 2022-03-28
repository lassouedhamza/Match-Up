/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.entities;

/**
 *
 * @author Asus
 */
public class Categorie {
    private int id_categorie;
    private String nom_categorie;

    public Categorie() {
    }

    public Categorie(int id_categorie, String nom_categorie) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
    }
    

   public int getId_categorie() {
        return id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    @Override
    public String toString() {
        return "Categorie{" + ", nom_categorie=" + nom_categorie + '}';
    }
        @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id_categorie;
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
        final Categorie other = (Categorie) obj;
        if (this.id_categorie != other.id_categorie) {
            return false;
        }
        return true;
    }
    
    
}
    

