/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.entities;

/**
 *
 * @author Hajer 
 */
public class Matchs {
    private int id_match;
    private String type;
    private String date;
    private int nbjoueurs;
    private int id_terrain;
    private String nom_tournoi;
  private int id_tournoi;
    public Matchs(){
          
    }

    public Matchs(int id_match, String type, String date, int nbjoueurs, int id_terrain, String nom_tournoi) {
        this.id_match = id_match;
        this.type = type;
        this.date = date;
        this.nbjoueurs = nbjoueurs;
        this.id_terrain = id_terrain;
        this.nom_tournoi = nom_tournoi;
    }

    public Matchs(int id_match, String type, String date, int nbjoueurs, int id_terrain, String nom_tournoi, int id_tournoi) {
        this.id_match = id_match;
        this.type = type;
        this.date = date;
        this.nbjoueurs = nbjoueurs;
        this.id_terrain = id_terrain;
        this.nom_tournoi = nom_tournoi;
        this.id_tournoi = id_tournoi;
    }
    

    public Matchs(int id_match,int id_terrain,  String type, String date, int nbjoueurs) {
        this.id_match = id_match;
        this.id_terrain = id_terrain;
        this.type = type;
        this.date = date;
        this.nbjoueurs = nbjoueurs;
    }

    public Matchs(int id_match, String type, String date, int nbjoueurs) {
        this.id_match = id_match;
        this.type = type;
        this.date = date;
        this.nbjoueurs = nbjoueurs;
    }
   

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public int getId_match() {
        return id_match;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_tournoi() {
        return id_tournoi;
    }

    public void setId_tournoi(int id_tournoi) {
        this.id_tournoi = id_tournoi;
    }



    
    public void setNbjoueurs(int nbjoueurs) {
        this.nbjoueurs = nbjoueurs;
    }

   

    public void setType(String type) {
        this.type = type;
    }

    public int getNbjoueurs() {
        return nbjoueurs;
    }
     public String getNbjoueurs1() {
        return "nbjoueurs=" + nbjoueurs +"";
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getId_terrain() {
        return id_terrain;
    }

    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }

    public String getNom_tournoi() {
        return nom_tournoi;
    }

    public void setNom_tournoi(String nom_tournoi) {
        this.nom_tournoi = nom_tournoi;
    }
    

    @Override
    public String toString() {
        return "Match{" + "id_match=" + id_match + ", type=" + type + ", date=" + date + ", nbjoueurs=" + nbjoueurs + ", id_terrain=" + id_terrain + '}';
    }

   
    

   



  
   
  

    
    
}

    


