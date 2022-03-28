/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
import Entites.Tournoi;

/**
 *
 * @author Hajer
 */
public interface IServiceTournoi {
      public void AddTournoi(Tournoi t,int id);
    public List<Tournoi> affichertournoi () throws SQLException;
    public void modifierTournoi(Tournoi t);

    
    public void SupprimerOnClick(Tournoi t);
    public ObservableList<Tournoi> getterList();
    
}
