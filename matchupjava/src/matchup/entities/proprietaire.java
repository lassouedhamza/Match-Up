/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.entities;

/**
 *
 * @author tpc
 */

public class proprietaire extends user {
   
    private int nb_terrain ;

    public proprietaire() {
    }

    public proprietaire(int nb_terrain) {
        this.nb_terrain = nb_terrain;
    }

    public proprietaire(String nom, String prenom, String email, String mdp, String adresse, int age, String genre ,String roles ,int nb_terrain) {
        super(nom, prenom, email, mdp, adresse, age, genre);
        this.nb_terrain = nb_terrain;
    }

    public proprietaire( int id, String nom, String prenom, String email, String mdp, String adresse, int age, String genre,String roles,int nb_terrain) {
        super(id, nom, prenom, email, mdp, adresse, age, genre , roles);
        this.nb_terrain = nb_terrain;
    }
     public proprietaire( int id, String nom, String prenom, String email, String mdp, String adresse, int age, String genre,int nb_terrain) {
        super(id, nom, prenom, email, mdp, adresse, age, genre );
        this.nb_terrain = nb_terrain;
    }

    public proprietaire( int id, String nom, String prenom,int nb_terrain) {
        super(id, nom, prenom);
        this.nb_terrain = nb_terrain;
    }
    
    


    public int getNb_terrain() {
        return nb_terrain;
    }

    public void setNb_terrain(int nb_terrain) {
        this.nb_terrain = nb_terrain;
    }

    
    
 
    
}


