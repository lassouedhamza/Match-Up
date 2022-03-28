/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hajer;

import Entites.Tournoi;
import java.io.IOException;
import matchup.servies.ServiceTournoi;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import matchup.entities.user;
import matchup.servies.Data;
import matchup.servies.utilisateurCRUD;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class ListeTournoiController implements Initializable {

    @FXML
    private TableView<Tournoi> tableview;
   @FXML
    private TableColumn<Tournoi,Integer> colid;
 
    @FXML
    private TableColumn<Tournoi,String> colnom;
    @FXML
    private TableColumn<Tournoi,String> coltype;
    @FXML
    private TextField tfrechercher;
    @FXML
    private HBox parent;
    @FXML
    private Label name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         utilisateurCRUD cs = new utilisateurCRUD();
        try {
            user c = cs.findByUserIdPopulated(Data.user.getId());
            this.name.setText(c.getPrenom());
        } catch (SQLException ex) {
           
        }
          ShowTournoi();
    }    
  private void ShowTournoi() {
        ServiceTournoi ser = new ServiceTournoi();
       ObservableList<Tournoi> list  = ser.getterList();
       colid.setCellValueFactory(new PropertyValueFactory<Tournoi,Integer>("id_tournoi"));
        colnom.setCellValueFactory(new PropertyValueFactory<Tournoi,String>("nom_tournoi"));
         
        coltype.setCellValueFactory(new PropertyValueFactory<Tournoi,String>("type"));
        
        tableview.setItems(list);
        FilteredList<Tournoi> filteredData = new FilteredList<>(list, b -> true);
       
        tfrechercher.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Tournoi tournom) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (tournom.getNom_tournoi().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
                }
               
                else {
                    return false; 
                }
            });
        });
        SortedList<Tournoi> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData);
        
    }
    @FXML
    private void RetourOnClick(ActionEvent event) {
                      try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Tournoi.fxml"));
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
    
}
