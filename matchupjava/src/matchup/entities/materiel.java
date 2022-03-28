/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.entities;

/**
 *
 * @author Bedis
 */
public class materiel {
 
    private int id_materiel;
    private String nom_terrain;
    private String type_mat;
    private  int quant_mat ;
    private  int id_terrain ;



public materiel() {
}
    
    public materiel( int id_materiel, String nom_terrin, String type_mat , int quant_mat,int id_terrin ) {
        this.id_materiel = id_materiel;
        this.id_terrain = id_terrin;
        this.quant_mat = quant_mat;
        this.type_mat = type_mat ;
        this.nom_terrain = nom_terrain;
    
    }

    public int getId_materiel() {
        return id_materiel;
    }

    public String getNom_terrain() {
        return nom_terrain;
    }

    public String getType_mat() {
        return type_mat;
    }

    public int getQuant_mat() {
        return quant_mat;
    }

    public int getId_terrain() {
        return id_terrain;
    }

    public void setId_materiel(int id_materiel) {
        this.id_materiel = id_materiel;
    }

    public void setNom_terrain(String nom_terrain) {
        this.nom_terrain = nom_terrain;
    }

    public void setType_mat(String type_mat) {
        this.type_mat = type_mat;
    }

    public void setQuant_mat(int quant_mat) {
        this.quant_mat = quant_mat;
    }

    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }

    public void getId_terrain(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}