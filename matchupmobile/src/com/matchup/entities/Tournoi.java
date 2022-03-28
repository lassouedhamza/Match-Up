/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.entities;

/**
 *
 * @author Hajer
 */
public class Tournoi {
      private int id_tournoi;
    private int id;
    private String nom_tournoi;
    private String type;

    public Tournoi() {
    }

    public Tournoi(int id_tournoi, int id, String nom_tournoi, String type) {
        this.id_tournoi = id_tournoi;
        this.id = id;
        this.nom_tournoi = nom_tournoi;
        this.type = type;
    }
     public Tournoi(int id_tournoi, String nom_tournoi, String type) {
        this.id_tournoi = id_tournoi;
        this.nom_tournoi = nom_tournoi;
        this.type = type;
    }

    public Tournoi(int parseInt, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_tournoi() {
        return id_tournoi;
    }

    public int getId() {
        return id;
    }

    public String getNom_tournoi() {
        return nom_tournoi;
    }

    public String getType() {
        return type;
    }

    public void setId_tournoi(int id_tournoi) {
        this.id_tournoi = id_tournoi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_tournoi(String nom_tournoi) {
        this.nom_tournoi = nom_tournoi;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tournoi{" + "id_tournoi=" + id_tournoi + ", id=" + id + ", nom_tournoi=" + nom_tournoi + ", type=" + type + '}';
    }
    
}
