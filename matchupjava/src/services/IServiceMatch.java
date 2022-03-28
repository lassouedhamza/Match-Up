/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import matchup.entities.Matchs;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Hajer
 */
public interface IServiceMatch {
    
    public void AddMatch(Matchs m);
    public List<Matchs> affichermatch () throws SQLException;
      public List<Matchs> AfficherMatchTournoi () throws SQLException; 
    public List<Matchs> trier(int i) throws SQLException;
    
    public ObservableList<Matchs> getterList();
    
}
