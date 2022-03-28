/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author tpc
 */
public interface IStatistique {
      public int getNombreutilisateur();
    public int getNombreproprietaire();
    public int getNombreAdministrateurs();
//    public List<Produit> getTopTenProduits();
//    public List<proprietaire> getTopTenBoutiques();
//    public List<Produit> getTopTenProduits(List<proprietaire> proprietaire);
    public int getNombreProduits();
    public int getNombreProduitsVendus();
//    public int getNombreProduits(List<Boutique> boutiques);
//    public int getNombreProduitsVendus(List<Boutique> boutiques);
//    public Float getQuantiteProduitsVendusParMois(String mois);
//    public Float getQuantiteProduitsVendusParMois(List<Boutique> boutiques,String mois);
}
