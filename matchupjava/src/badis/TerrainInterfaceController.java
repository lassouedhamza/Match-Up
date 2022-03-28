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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import matchup.servies.terrainCRUD;

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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
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
import javafx.util.Duration;
import matchup.entities.terrain;
import matchup.entities.user;
import matchup.servies.Data;

import matchup.servies.resterCRUD;
import matchup.servies.utilisateurCRUD;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Bedis
 */
public class TerrainInterfaceController implements Initializable {
    ObservableList<ObservableList> data = FXCollections.observableArrayList();
     public static String selectedname="";
     public static Integer selectedid;

    @FXML
    private ImageView homeImg;
    @FXML
    private Button homeBtn;
    @FXML
    private Button ret4;
    @FXML
    private Button ajouter;
    @FXML
    private TextField nomt;
    @FXML
    private TextField etat;
    @FXML
    private TableView<terrain> tableGestionDesTerrains;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button rechercher;
    @FXML
    private TextField rech;
    @FXML
    private TextField typt;
    @FXML
    private TextField empt;
    @FXML
    private TableColumn<terrain,Integer> colid;
    @FXML
    private TableColumn<terrain,String> colnom;
    @FXML
    private TableColumn<terrain,String> coleml;
    @FXML
    private TableColumn<terrain,String> coltyp;
    @FXML
    private TableColumn<terrain,String> coleta;
    @FXML
    private TextField idt;
    @FXML
    private Button reser;
    @FXML
    private HBox parent;
    @FXML
    private Label name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       afficherter();
    }    

    @FXML
    private void LoginActionReturn(ActionEvent event) {
        
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
         utilisateurCRUD cs = new utilisateurCRUD();
        try {
            user c = cs.findByUserIdPopulated(Data.user.getId());

        } catch (SQLException ex) {
           
        }
        
            terrainCRUD tc = new terrainCRUD();
            terrain t = new terrain();
            
            
            t.setNom_terrain(nomt.getText());
            t.setEmplacement(empt.getText());
            t.setType(typt.getText());
            t.setEtat(etat.getText());
            
            tc.Addterrain(t,Data.user.getId());
            Notifications notificationBuilder = Notifications.create()
                .title("Terrain ajouter avec succes")
                .text("terrain ajouter : "+t.getNom_terrain())
                .graphic(null)
                .hideAfter(Duration.seconds(4))
                .position(Pos.BOTTOM_RIGHT);
            notificationBuilder.showInformation();
            
            afficherter();
      
            
        
        
    }

    @FXML
    private void ModifierOnAction(ActionEvent event) {
        terrainCRUD tc = new terrainCRUD();
        terrain t = new terrain();
        int id = Integer.parseInt(idt.getText());
        t.setId_terrain(id);
        t.setEmplacement(empt.getText());
        t.setEtat(etat.getText());
        t.setNom_terrain(nomt.getText());
        t.setType(typt.getText());
        tc.modifierterrain(t);
        afficherter();
        
        Notifications notificationBuilder = Notifications.create()
                .title("Terrain modifier avec succes")
                .text("Terrain modifier : "+t.getNom_terrain())
                .graphic(null)
                .hideAfter(Duration.seconds(4))
                .position(Pos.BOTTOM_RIGHT);
            notificationBuilder.showInformation();
    }

    @FXML
    private void SupprimerOnAction(ActionEvent event) {
        terrainCRUD tc = new terrainCRUD();
        terrain t = new terrain();
        int id = Integer.parseInt(idt.getText());
        t.setId_terrain(id);
        tc.supprimerterrain(t);
        afficherter();
        
        Notifications notificationBuilder = Notifications.create()
                .title("Terrain supprimer avec succes")
                .text("Terrain supprimer  : "+t.getNom_terrain())
                .graphic(null)
                .hideAfter(Duration.seconds(4))
                .position(Pos.BOTTOM_RIGHT);
            notificationBuilder.showInformation();
    }

    @FXML
    private void RechercherOnAction(ActionEvent event) {
        try {
             terrain t = new terrain();
            selectedid = Integer.parseInt(idt.getText());
            selectedname = (nomt.getText());
            Stage logp = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("MatterInterface.fxml"));
            Scene scene = new Scene(root);
            logp.setScene(scene);
            logp.show();
            logp.setResizable(false);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
        
         
       
    
public void afficherter(){
       terrainCRUD tc = new terrainCRUD();
       ObservableList<terrain> list  = tc.getterList();
        colid.setCellValueFactory(new PropertyValueFactory<terrain,Integer>("id_terrain"));
       
        colnom.setCellValueFactory(new PropertyValueFactory<terrain,String>("nom_terrain"));
        coltyp.setCellValueFactory(new PropertyValueFactory<terrain,String>("type"));
        coleta.setCellValueFactory(new PropertyValueFactory<terrain,String>("etat"));
        coleml.setCellValueFactory(new PropertyValueFactory<terrain,String>("emplacement"));
        tableGestionDesTerrains.setItems(list);
   }    

    @FXML
    private void selectedl(MouseEvent event) {
        terrain evt = tableGestionDesTerrains.getSelectionModel().getSelectedItem();
        nomt.setText(evt.getNom_terrain());
       empt.setText(evt.getEmplacement());
        etat.setText(evt.getEtat());
        typt.setText(evt.getType());
        String a = Integer.toString(evt.getId_terrain());
        idt.setText(a);
       
    }

    @FXML
    private void search(KeyEvent event) {
         terrain l = new terrain();
         colnom.setCellValueFactory(new PropertyValueFactory<terrain,String>("nom_terrain"));
        coltyp.setCellValueFactory(new PropertyValueFactory<terrain,String>("type"));
        coleta.setCellValueFactory(new PropertyValueFactory<terrain,String>("etat"));
        coleml.setCellValueFactory(new PropertyValueFactory<terrain,String>("emplacement"));
        ObservableList<terrain> dataList;
        terrainCRUD se = new terrainCRUD();
        dataList = se.getterList();
       
        tableGestionDesTerrains.setItems(dataList);
       
        FilteredList<terrain> filteredData = new FilteredList<>(dataList, b -> true);
       
        rech.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((terrain person) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getEmplacement().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
               
                } else if (person.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                        }else if (person.getEtat().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                        }else if (person.getNom_terrain().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                        }
               
                else {
                    return false; 
                }
            });
        });
        SortedList<terrain> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableGestionDesTerrains.comparatorProperty());
        tableGestionDesTerrains.setItems(sortedData);
        
        
        
   }  
    

    @FXML
    private void ReserOnAction(ActionEvent event) {
         try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("sho.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
         
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

