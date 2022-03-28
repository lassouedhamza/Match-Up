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
import matchup.entities.materiel;
public interface iservicemateriel {
    public void Addmateriel(materiel t);
    public List<materiel> affichermateriel () throws SQLException;
    public void modifiermateriel(materiel t);
    public void supprimermateriel(materiel t);
    public ObservableList<materiel> getmatList();
    
}