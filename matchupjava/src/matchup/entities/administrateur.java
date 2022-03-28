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
public class administrateur extends user {

    public administrateur() {
    }

    public administrateur(String nom, String prenom, String email, String mdp, String adresse, int age, String genre) {
        super(nom, prenom, email, mdp, adresse, age, genre);
    }

    public administrateur(int id, String nom, String prenom, String email, String mdp, String adresse, int age, String genre, String role) {
        super(id, nom, prenom, email, mdp, adresse, age, genre, role);
    }

    public administrateur(int id, String nom, String prenom) {
        super(id, nom, prenom);
    }

 
    
    
}
