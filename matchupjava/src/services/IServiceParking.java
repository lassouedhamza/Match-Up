/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import matchup.entities.Parking;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yousra
 */
public interface IServiceParking {
    public void AddParking (Parking p);
    public List<Parking> AfficherParking()  ;
    public void ModifierParking(Parking p);
    public void SupprimerParking(Parking p);
}
