/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rania;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import match.up.MatchUp;

import matchup.entities.Categorie;
import matchup.entities.Produit;
import matchup.servies.ServiceCategorie;
import matchup.servies.ServiceProduit;
import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import matchup.entities.user;
import matchup.servies.Data;
import matchup.servies.utilisateurCRUD;
import services.MyListener;

public class MarketController implements Initializable {
    private VBox chosenProductCard;

    private Label productNameLable;

   

    private ImageView productImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private List<Produit> produits = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    private Label productPriceLabel;
   
    @FXML
    private HBox parent;
    @FXML
    private Label name;

  

    private void setChosenProduit(Produit produit) {
       /* FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("itemm.fxml"));*/
        //Node postbox = loader.load();
        //ItemmController pc = loader.getController();
       // pc.setData(produit, myListener);
        productNameLable.setText(produit.getNom_produit());
        productPriceLabel.setText(produit.getPrix()+MatchUp.CURRENCY );
        //image = new Image(getClass().getResourceAsStream(produit.getPhoto()));
        image = new Image(produit.getPhoto());
        productImg.setImage(image);
        chosenProductCard.setStyle("-fx-background-color: red" + produit.getDescription() + ";\n" +
                "    -fx-background-radius: 30;");
 
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         utilisateurCRUD cs = new utilisateurCRUD();
        try {
            user c = cs.findByUserIdPopulated(Data.user.getId());

            this.name.setText(c.getPrenom());
        } catch (SQLException ex) {
           
        }
//        Image image = new Image("/image/buy.gif");
//        buygif.setImage(image);
        
        
      //qty.setText("1");
        // products.addAll(getData());
        if (produits.size() > 0) {
            
            setChosenProduit(produits.get(0));
            
            myListener = new MyListener() {
                

                @Override
                public void onClickListener(Produit produit) {
                     setChosenProduit(produit);
                    
                }
            };
        }

        grid.getChildren().clear();
        ServiceProduit sp = new ServiceProduit();
        List<Produit> l = sp.getProduitList();
        int row = 1, cl =0;
            try{
                for(Produit produit : l){
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("itemm.fxml"));
                    Node postbox = loader.load();
                    ItemmController pc = loader.getController();
                    pc.setData(produit, myListener);
                    if(cl== 3){
                         cl= 0;
                         row++;
                    }
                    this.grid.add(postbox, cl++, row);
                }
            }catch(IOException e){
                System.out.println("no load for product in client");
                   e.printStackTrace();
            }
    }
        /*int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < products.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(products.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    private void det(ActionEvent event) {
        //nizd details mta3 produit fi fxml akher
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLdetails.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void xprofile(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("/match/up/FXMLprofileuser.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xmatch(MouseEvent event) throws IOException {
             Parent d_page = FXMLLoader.load(getClass().getResource("/hajer/Matchprop.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xterrain(MouseEvent event) throws IOException {
        Parent d_page = FXMLLoader.load(getClass().getResource("/badis/ResterInterface.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xparking(MouseEvent event) throws IOException {
             Parent d_page = FXMLLoader.load(getClass().getResource("/yossra/Reservation.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
        
        
    }

    @FXML
    private void xtournoi(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("/hajer/ListeTournoi.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
        
    }

    @FXML
    private void xproduit(MouseEvent event) throws IOException {
        
        Parent d_page = FXMLLoader.load(getClass().getResource("/rania/market.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xpanier(MouseEvent event) throws IOException {
       
         Parent d_page = FXMLLoader.load(getClass().getResource("/match/up/FXMLpanier.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xlog(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("/match/up/FXMLlogin.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void xe(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void AddToCart(ActionEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("/match/up/FXMLpanier.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }
   

  

}