/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import matchup.entities.Reservation;
import java.util.List;

/**
 *
 * @author yousra
 */
public interface IServiceReservation {
     public void AjouterReservation (Reservation r);
   
    public void ModifierReservation(Reservation r);
    public void SupprimerReservation(Reservation r);
}
