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

public class utilisateur extends user {

    public utilisateur() {
    }

    public utilisateur(String nom, String prenom, String email, String mdp, String adresse, int age, String genre) {
        super(nom, prenom, email, mdp, adresse, age, genre);
    }

    public utilisateur(int id, String nom, String prenom, String email, String mdp, String adresse, int age, String genre, String roles) {
        super(id, nom, prenom, email, mdp, adresse, age, genre, roles);
    }

    public utilisateur(int id, String nom, String prenom) {
        super(id, nom, prenom);
    }

   


 
    
}


