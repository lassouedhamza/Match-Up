/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badis;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import matchup.entities.rester;

import matchup.servies.resterCRUD;
import matchup.servies.terrainCRUD;

/**
 * FXML Controller class
 *
 * @author Bedis
 */
public class ShoController implements Initializable {

    @FXML
    private ImageView homeImg;
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret4;
    @FXML
    private TextField idt;
    @FXML
    private Button rechercher;
    @FXML
    private TextField rech;
    @FXML
    private TableView<rester> tableGestionDesTerrains;
    @FXML
    private TableColumn<rester, String> colid;
    @FXML
    private TableColumn<rester, String> colnom;
    private TableColumn<rester, String> coleml;
    @FXML
    private TableColumn<rester, String> nomrester;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoginActionReturn(ActionEvent event) {
    }

    @FXML
    private void HomeActionReturn4(ActionEvent event) {
         try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TerrainInterface.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void RechercherOnAction(ActionEvent event) {
        afficherrester();
    }

    @FXML
    private void search(KeyEvent event) {
    }

    @FXML
    private void selectedl(MouseEvent event) {
    }
    
    public void afficherrester(){
       resterCRUD rc = new resterCRUD();
       ObservableList<rester> list  = rc.getresList();
     
       
        colnom.setCellValueFactory(new PropertyValueFactory<>("date_res"));
        nomrester.setCellValueFactory(new PropertyValueFactory<>("nom_ter"));
        tableGestionDesTerrains.setItems(list);
   }   
    
}
