/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;
import matchup.entities.proprietaire;

/**
 *
 * @author tpc
 */
public interface Iservies {
        public void ajouterPersonne(proprietaire p);
    public List<proprietaire> Afficherproprietaire()  throws SQLException;
 public void Modifierproprietaire(proprietaire p);
  public void Supprimerproprietaire(proprietaire p);
}
