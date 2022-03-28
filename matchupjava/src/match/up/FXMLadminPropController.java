/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match.up;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import matchup.entities.proprietaire;
import matchup.servies.proprietaireCRUD;

/**
 * FXML Controller class
 *
 * @author tpc
 */
public class FXMLadminPropController implements Initializable {
    ObservableList <String> tftypeList =FXCollections.observableArrayList("Femme","Homme");


    
private Connection cnx;
    private PreparedStatement ste;
    @FXML
    private TableColumn<proprietaire, Integer> tfid;
    @FXML
    private TableColumn<proprietaire, String> tfnom;
    @FXML
    private TableColumn<proprietaire, String> tfprenom;
    @FXML
    private TableColumn<proprietaire, String> tfemail;
    @FXML
    private TableColumn<proprietaire, String> tfmdp;
    @FXML
    private TableColumn<proprietaire, String> tfadresse;
    @FXML
    private TableColumn<proprietaire, Integer> tfage;
    @FXML
    private TableColumn<proprietaire, String> tfgenre;
    @FXML
    private TableColumn<proprietaire, Integer> tfnb;
    @FXML
    private TableView<proprietaire> tftable;

 
    @FXML
    private JFXTextField iNom;
    @FXML
    private JFXTextField IPrenom;
    @FXML
    private JFXTextField IEamail;
    @FXML
    private JFXPasswordField IMdp;
    @FXML
    private JFXTextField IAdresse;
    @FXML
    private JFXTextField Iage;
    @FXML
    private AnchorPane Igenre;
    @FXML
    private JFXTextField INb;
    @FXML
    private TextField tfrechercher;
    @FXML
    private JFXButton MODIFIER;
    @FXML
    private ChoiceBox<String> tftype;
    @FXML
    private HBox parent;
    @FXML
    private Label name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tftype.setItems(tftypeList);
        addListenerToTable();
        ShowUser();
    }    

    @FXML
    private void ajouterp(ActionEvent event) throws IOException {
         if(((iNom.getText().isEmpty() || IPrenom.getText()== null|| IEamail.getText()== null|| IMdp.getText()== null)) || IAdresse.getText()== null|| Iage.getText()== null|| tftype.getValue()== null|| INb.getText()== null)
         { 
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }else{

        proprietaireCRUD sp = new proprietaireCRUD();
        proprietaire p = new proprietaire();
        p.setNom(iNom.getText());
        p.setPrenom(IPrenom.getText());
        p.setEmail(IEamail.getText());
        p.setMdp(IMdp.getText());
        p.setAdresse(IAdresse.getText());
        p.setAge(parseInt(Iage.getText()));
        p.setGenre(tftype.getValue());
        p.setNb_terrain(parseInt(INb.getText()));
        sp.ajouterPersonne(p);
//        Parent d_page = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        Scene s = new Scene(d_page);
//        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
// 
//                app_stage.hide(); //optional
//                app_stage.setScene(s);
//                app_stage.show(); 
ShowUser();
    }}
private void addListenerToTable(){
        proprietaireCRUD cs = new proprietaireCRUD();
        ObservableList<proprietaire> list = cs.getParkingList();
        tftable.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            if(newSelection!=null){
                MODIFIER.setDisable(false);
                
                
                
        iNom.setText(newSelection.getNom());
        IPrenom.setText(newSelection.getPrenom());
        IEamail.setText(newSelection.getEmail());
        IMdp.setText(newSelection.getMdp());
        IAdresse.setText(newSelection.getAdresse());
        Iage.setText(String.valueOf(newSelection.getAge()));
        tftype.setValue(newSelection.getGenre());
        INb.setText(String.valueOf(newSelection.getNb_terrain()));
                
            }else{
                tfid.setText("");
        iNom.setText("");
        IPrenom.setText("");
        IEamail.setText("");
        IMdp.setText("");
        IAdresse.setText("");
        Iage.setText("");
        tftype.setValue("");
        INb.setText("");
               
                MODIFIER.setDisable(false);
               
                
                
            }
    
    
      });  
    }

     public void ShowUser() {
         proprietaireCRUD tc = new proprietaireCRUD();
       ObservableList<proprietaire> list  = tc.getParkingList();
        tfid.setCellValueFactory(new PropertyValueFactory<proprietaire, Integer>("id"));
        tfnom.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("nom"));
        tfprenom.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("prenom"));
        tfemail.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("email"));
        tfmdp.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("mdp"));
        tfadresse.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("adresse"));
        tfage.setCellValueFactory(new PropertyValueFactory<proprietaire, Integer>("age"));
        tfgenre.setCellValueFactory(new PropertyValueFactory<proprietaire, String>("genre"));
        tfnb.setCellValueFactory(new PropertyValueFactory<proprietaire, Integer>("nb_terrain"));

        tftable.setItems(list);
        FilteredList<proprietaire> filteredData = new FilteredList<>(list, b -> true);
       
        tfrechercher.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((proprietaire prop) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (prop.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
                }
               
                else {
                    return false; 
                }
            });
        });
        SortedList<proprietaire> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tftable.comparatorProperty());
        tftable.setItems(sortedData);

    }

    @FXML
    private void d(ActionEvent event) {
      
        proprietaire c=tftable.getSelectionModel().getSelectedItem();
        if(c==null){
        
           System.out.println("Veillez choisir proprietaire");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir proprietaire");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir proprietaire à supprimer !");

            alert.showAndWait();
     
        }else{
          proprietaireCRUD sc = new proprietaireCRUD();
          String nom_categorie = c.getNom();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Supprimer proprietaire ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez supprimer! " + c.getNom());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    // System.out.println("sup1");
                    sc.Supprimerproprietaire(c);
//                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
//                    alert1.setTitle("SUPPRIMER Categorie");
//                    alert1.setHeaderText(null);
//                    alert1.setContentText("la catégorie est supprimée");

//                    alert1.showAndWait();
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
       ShowUser();
        
    }

    @FXML
    private void MODIFIER(ActionEvent event) {
         
         proprietaire c=tftable.getSelectionModel().getSelectedItem();
        if(c==null){
        
           System.out.println("Veillez choisir proprietaire");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir proprietaire");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir proprietaire à supprimer !");

            alert.showAndWait();
     
        }else{
          proprietaireCRUD sc = new proprietaireCRUD();
          String nom_categorie = c.getNom();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("modifier proprietaire ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez modifier! " + c.getNom());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    // System.out.println("sup1");
                    c.setNom(iNom.getText());
        c.setPrenom(IPrenom.getText());
        c.setEmail(IEamail.getText());
        c.setMdp(IMdp.getText());
        c.setAdresse(IAdresse.getText());
        c.setAge(parseInt(Iage.getText()));
        c.setGenre(tftype.getValue());
        c.setNb_terrain(parseInt(INb.getText()));
                    sc.Modifierproprietaire(c);
//                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
//                    alert1.setTitle("SUPPRIMER Categorie");
//                    alert1.setHeaderText(null);
//                    alert1.setContentText("la catégorie est supprimée");

//                    alert1.showAndWait();
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
       ShowUser();
        
    }

    private void retour(MouseEvent event) throws IOException {
                 Parent d_page = FXMLLoader.load(getClass().getResource("FXMLadmin.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void u(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("FXMLAdminuser.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void p(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("FXMLadminProp.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void s(MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("FXMLStatistique.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void l(MouseEvent event) throws IOException {
           Parent d_page = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void e(MouseEvent event) {
         System.exit(0);
    }

}

        

    



