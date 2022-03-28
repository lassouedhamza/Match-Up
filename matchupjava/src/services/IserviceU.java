/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;
import matchup.entities.proprietaire;
import matchup.entities.utilisateur;

/**
 *
 * @author tpc
 */
public interface IserviceU {
       public void ajouterPersonne(utilisateur p);
    public List<utilisateur> Afficherutilisateur()  throws SQLException;
     public void Supprimerutilisateur(utilisateur p);
      public void Modifierutilisateur(utilisateur p);
}
