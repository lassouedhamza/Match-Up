/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import javafx.scene.image.Image;
import matchup.entities.Produit;


/**
 *
 * @author Asus
 */
public interface IServicesProduit {
    public void AddProduit (Produit p,int id);
    public List<Produit> AfficherProduit()  throws SQLException;
    public void ModifierProduit(Produit p);
    public void SupprimerProduit(Produit p);
    public InputStream getPhotoProduit(int idP);
    public Image getPhoto(int idP);

    
}
