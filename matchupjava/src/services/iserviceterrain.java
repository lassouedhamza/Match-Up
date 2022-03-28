/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Bedis
 */
import javafx.collections.ObservableList;
import matchup.entities.terrain;
public interface iserviceterrain {
    public void Addterrain(terrain t, int id);
    public List<terrain> afficherterrain () throws SQLException;
    public void modifierterrain(terrain t);
    public void supprimerterrain(terrain t);
    public ObservableList<terrain> getterList();
    
}
