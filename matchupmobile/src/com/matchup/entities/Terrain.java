/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.entities;

/**
 *
 * @author Bedis
 */
public class Terrain {
    private int idTerrain;
    private String nomTerrain;
    private String emplacement;
    private String type;
    private String etat;
    private int id ;

    public Terrain() {
       
   }

    public Terrain(int idTerrain, String nomTerrain, String emplacement, String type, String etat, int id) {
        this.idTerrain = idTerrain;
        this.nomTerrain = nomTerrain;
        this.emplacement = emplacement;
        this.type = type;
        this.etat = etat;
        this.id = id;
    }

    public Terrain(String nomTerrain, String emplacement, String type, String etat) {
        this.nomTerrain = nomTerrain;
        this.emplacement = emplacement;
        this.type = type;
        this.etat = etat;
    }

    public int getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    public String getNomTerrain() {
        return nomTerrain;
    }

    public void setNomTerrain(String nomTerrain) {
        this.nomTerrain = nomTerrain;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
