/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badis;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import matchup.servies.materielCRUD;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.management.Notification;
import matchup.entities.materiel;

import matchup.servies.terrainCRUD;
import org.controlsfx.control.Notifications;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Bedis
 */
public class MaterielInterfaceController implements Initializable {
 ObservableList<ObservableList> data = FXCollections.observableArrayList();
    @FXML
    private ImageView homeImg;
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret4;
    @FXML
    private Button ajouter;
    private TextField empt;
    private TextField nomt;
    private TextField etat;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button rechercher;
    @FXML
    private TextField rech;
    private TableView<materiel> tableGestionDesTerrains;
    private TableColumn<materiel, Integer> colid;
    private TableColumn<materiel, String> colnom;
    private TableColumn<materiel, Integer> coleml;
    private TableColumn<materiel, Integer> coltyp;
    private TableColumn<materiel,String> coleta;
    @FXML
    private TextField nomtmat;
    @FXML
    private TextField qumat;
    @FXML
    private TextField tyepmat;
    @FXML
    private TextField idtmat;
    @FXML
    private TextField idm;
    @FXML
    private TableColumn<materiel, Integer> colidmat;
    @FXML
    private TableColumn<materiel, String> coltypemat;
    @FXML
    private TableColumn<materiel, Integer> colqumat;
    @FXML
    private TableColumn<materiel, String> colta;
    @FXML
    private TableColumn<materiel, Integer> colidtas;
    @FXML
    private TableView<materiel> tableGestionDesMat;
    @FXML
    private HBox parent;
    @FXML
    private Label name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affichermat();
    }    

    @FXML
    private void LoginActionReturn(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void HomeActionReturn4(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void AjouterOnAction(ActionEvent event) {
try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TerrainInterface.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
            affichermat();
    }

    @FXML
    private void ModifierOnAction(ActionEvent event) {
        
    }

    @FXML
    private void SupprimerOnAction(ActionEvent event) {
        
        materielCRUD mc = new materielCRUD();
        materiel m = new materiel();
        int id = Integer.parseInt(idm.getText());
        m.setId_materiel(id);
        mc.supprimermateriel(m);
        affichermat();
        
    }

    @FXML
    private void RechercherOnAction(ActionEvent event) {
    }

    @FXML
    private void selectedl(MouseEvent event) {
        materiel evt = tableGestionDesMat.getSelectionModel().getSelectedItem();
        String b = Integer.toString(evt.getId_materiel());
       tyepmat.setText(evt.getType_mat());
        String c = Integer.toString(evt.getQuant_mat());
        nomtmat.setText(evt.getNom_terrain());
        String a = Integer.toString(evt.getId_terrain());
        
        idtmat.setText(a);
        idm.setText(b);
        qumat.setText(c);
    }
    
    public void affichermat(){
       materielCRUD mc = new materielCRUD();
       ObservableList<materiel> list  = mc.getmatList();
        colidmat.setCellValueFactory(new PropertyValueFactory<materiel,Integer>("id_materiel"));
       
        coltypemat.setCellValueFactory(new PropertyValueFactory<materiel,String>("type_mat"));
        colqumat.setCellValueFactory(new PropertyValueFactory<materiel,Integer>("quant_mat"));
        colta.setCellValueFactory(new PropertyValueFactory<materiel,String>("nom_terrain"));
        colidmat.setCellValueFactory(new PropertyValueFactory<materiel,Integer>("id_terrain"));
        tableGestionDesMat.setItems(list);
   }   

        @FXML
    private void pprofile(MouseEvent event) throws IOException {
                      Parent d_page = FXMLLoader.load(getClass().getResource("/match/up/FXMLprofileprop.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pmatch(MouseEvent event) throws IOException {
                  Parent d_page = FXMLLoader.load(getClass().getResource("/hajer/Match.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pterrain(MouseEvent event) throws IOException {
            Parent d_page = FXMLLoader.load(getClass().getResource("/badis/TerrainInterface.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pmatriel(MouseEvent event) throws IOException {
            Parent d_page = FXMLLoader.load(getClass().getResource("/badis/MaterielInterface.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pparking(MouseEvent event) throws IOException {
          Parent d_page = FXMLLoader.load(getClass().getResource("/yossra/FXMLDocument.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
        
    }

    @FXML
    private void ptournoi(MouseEvent event) throws IOException {
           Parent d_page = FXMLLoader.load(getClass().getResource("/hajer/Tournoi.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pproduit(MouseEvent event) throws IOException {
        Parent d_page = FXMLLoader.load(getClass().getResource("/rania/FXMLProduit.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pctegorie(MouseEvent event) throws IOException {
        
        Parent d_page = FXMLLoader.load(getClass().getResource("/rania/FXMLDocument1.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void plog(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("/match/up/FXMLlogin.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pe(MouseEvent event) {
        System.exit(0);
    }
}
