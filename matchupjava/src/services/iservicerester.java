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
import matchup.entities.rester;
public interface iservicerester {
    public void Addrester(rester r,int id);
    public List<rester> afficherrester () throws SQLException;
    public void modifierrester(rester r);
    public void supprimerrester(rester r);
    public ObservableList<rester> getresList();
    public boolean verif(rester r);
    
}
