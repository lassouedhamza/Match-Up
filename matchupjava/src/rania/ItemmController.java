/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rania;

import matchup.entities.Produit;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import match.up.MatchUp;
import services.MyListener;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ItemmController implements Initializable {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;
    @FXML
    private Label id;
   
    private AnchorPane parent;
   
  

    private Produit produit;
    private MyListener myListener;
   
    private void update(){
        //parent.getChildren().get(0)
        
    }
    @FXML
    private void onclick(MouseEvent event) {
        myListener.onClickListener(produit);
    }
    public void setData(Produit produit, MyListener myListener) {
        /*this.product = product;
        this.myListener = myListener;
        nameLabel.setText(product.getName());
        priceLable.setText(product.getPrice()+ Gestion_store.CURRENCY );
        Image image = new Image(getClass().getResourceAsStream(product.getPhoto()));
        img.setImage(image);*/
       
        this.myListener = myListener;
        this.id.setText(String.valueOf(produit.getId_produit()));
        this.nameLabel.setText(produit.getNom_produit());
        priceLable.setText(produit.getPrix()+ MatchUp.CURRENCY );
        File file = new File(produit.getPhoto().replace('/' , '\\'));
        Image im = null;
        if(file.exists()){
                 im = new Image(file.toURI().toString());
        }else{
            im = new Image("gestion/balon3.jpg"); // this is the defualt photo of the product
        }
         this.img.setImage(im);
        
       /* Image image = new Image(getClass().getResourceAsStream(produit.getPhoto()));
        img.setImage(image);*/    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    @FXML
    private void click(MouseEvent event) {
    }
    
}
