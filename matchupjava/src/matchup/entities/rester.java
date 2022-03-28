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
public class rester {
 
    private int id_rester;
    private String date_res;
    private String nom_ter;
    private  int id_terrain ;



public rester() {
}
    
    public rester( int id_rester, String date_res, String nom_ter ,int id_terrin ) {
        this.id_rester = id_rester;
        this.date_res = date_res;
        this.nom_ter = nom_ter;
        this.id_terrain = id_terrain ;    
    }

        public rester(String nom_ter, String date_res) {
            
        this.date_res = date_res;
        this.nom_ter = nom_ter;
        
            
    }

    public int getId_rester() {
        return id_rester;
    }

    public void setId_rester(int id_rester) {
        this.id_rester = id_rester;
    }

    public String getDate_res() {
        return date_res;
    }

    public void setDate_res(String date_res) {
        this.date_res = date_res;
    }

    public String getNom_ter() {
        return nom_ter;
    }

    public void setNom_ter(String nom_ter) {
        this.nom_ter = nom_ter;
    }

    public int getId_terrain() {
        return id_terrain;
    }

    public void setId_terrain(int id_terrain) {
        this.id_terrain = id_terrain;
    }
}