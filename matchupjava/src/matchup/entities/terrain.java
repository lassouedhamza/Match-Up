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
public class terrain {
    private int id_terrain;
    private int id_propt;
    private String nom_terrain;
    private  String emplacement ;
    private  String type ;
    private  String etat ;
   
    
    public terrain() {
    }
    public terrain( String nom_terrain, String emplacement, String type , String etat ) {
        this.nom_terrain = nom_terrain;
        this.emplacement = emplacement;
        this.type = type;
        this.etat = etat ;
    }

    public int getId_terrain() {
        return id_terrain;
    }

    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }

    public int getId_propt() {
        return id_propt;
    }

    public void setId_propt(int id_propt) {
        this.id_propt = id_propt;
    }

    public String getNom_terrain() {
        return nom_terrain;
    }

    public void setNom_terrain(String nom_terrain) {
        this.nom_terrain = nom_terrain;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "terrain{" + "id_terrain=" + id_terrain + ", id_propt=" + id_propt + ", nom_terrain=" + nom_terrain + ", emplacement=" + emplacement + ", type=" + type + ", etat=" + etat + '}';
    }

}