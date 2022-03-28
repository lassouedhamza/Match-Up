/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hajer;


import connection.myconnection;
import Entites.Tournoi;
import matchup.servies.ServiceTournoi;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
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
import static javafx.fxml.FXMLLoader.load;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;;
import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javafx.print.PrinterJob;
import javafx.scene.layout.HBox;
import javafx.stage.Window;
import javax.swing.JOptionPane;
import matchup.entities.proprietaire;
import matchup.servies.Data;
import matchup.servies.proprietaireCRUD;
import static sun.management.ConnectorAddressLink.export;import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javafx.print.PrinterJob;
import javafx.stage.Window;
import javax.swing.JOptionPane;
import matchup.entities.proprietaire;
import matchup.servies.Data;
import matchup.servies.proprietaireCRUD;
import static sun.management.ConnectorAddressLink.export;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class TournoiController implements Initializable {
    ObservableList <String> tftypeList =FXCollections.observableArrayList("Football","Handball","Volleyball","Tennis");
    public static String selectedname="";
     public static Integer selectedid;
    private Label label;
    @FXML
    private TextField tfnomtournoi;
    @FXML
    private ChoiceBox<String> tftype;
    @FXML
    private TableView<Tournoi> tableview;
    
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
     @FXML
    private TableColumn<Tournoi,Integer> colid;
 
    @FXML
    private TableColumn<Tournoi,String> colnom;
    @FXML
    private TableColumn<Tournoi,String> coltype;
    @FXML
    private TextField tfrechercher;
    @FXML
    private ImageView image;
    Tournoi t;
    @FXML
    private Button imprimer;
    @FXML
    private Button liste;
    
    @FXML
    private Button Matchs;
    @FXML
    private HBox parent;
    @FXML
    private Label name;
 
    

    /**
     * Initializes the controller class.
     */
     private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    myconnection cnx;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        proprietaireCRUD cs = new proprietaireCRUD();
        try {
            proprietaire c = cs.findByUserIdPopulated(Data.user.getId());
            this.name.setText(c.getPrenom());
        } catch (SQLException ex) { }
        imprimer.setOnAction(event ->{ImprimerOnClick();});
            Tournoi t = tableview.getSelectionModel().getSelectedItem();
                tftype.setItems(tftypeList);
          addListenerToTable();
         ShowTournoi();
           
    }    

    @FXML
    private void AjouterOnClick(ActionEvent event) {
         proprietaireCRUD cs = new proprietaireCRUD();
        try {
            proprietaire c = cs.findByUserIdPopulated(Data.user.getId());

            
        } catch (SQLException ex) {
           
        }
        if(((tfnomtournoi.getText().isEmpty() || tftype.getValue()== null )))
         {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Erreur");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Vérifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
                    ServiceTournoi sc = new ServiceTournoi();
            Tournoi t = new Tournoi();
            
            
            t.setNom_tournoi((tfnomtournoi.getText()));
            t.setType((tftype.getValue()));
             
           sc.AddTournoi(t,Data.user.getId());
        ShowTournoi();}
          
    }
             private void addListenerToTable(){
        ServiceTournoi cs = new ServiceTournoi();
        ObservableList<Tournoi> list = cs.getTournoiList();
        tableview.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            if(newSelection!=null){
                modifier.setDisable(false);
                supprimer.setDisable(false); 
                tfnomtournoi.setText(newSelection.getNom_tournoi());
                  tftype.setValue(newSelection.getType());
                  
            }else{
                tfnomtournoi.setText("");
                tftype.setValue("");
                modifier.setDisable(false);
                supprimer.setDisable(false);
                
                
            }
     
    
      });  
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
                    public void reload() throws IOException{
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("Tournoi.fxml"));
       Parent root = fxmlloader.load();
       Stage stage = (Stage) tableview.getScene().getWindow(); 
       stage.getScene().setRoot(root); 
//       ShowTournoi();
   }

  private void selectedl(javafx.scene.input.MouseEvent event) {
        Tournoi t = tableview.getSelectionModel().getSelectedItem();
      tfnomtournoi.setText(t.getNom_tournoi());
           tftype.setValue(t.getType());

               
    }
  @FXML
   private void ModifierOnClick(ActionEvent event) {
         if(((tfnomtournoi.getText().isEmpty() || tftype.getValue()== null )))
         {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Erreur");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Vérifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
         Tournoi t =tableview.getSelectionModel().getSelectedItem();
        if(t==null){
        
           System.out.println("Veillez choisir un Tournoi");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir Tournoi");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir le Tournoi à modifier !");

            alert.showAndWait();
     
        }else{
          ServiceTournoi sc = new ServiceTournoi();
          String nom_tournoi = t.getNom_tournoi();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Modifier Tournoi ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez modifier! " + t.getNom_tournoi());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    // System.out.println("sup1");
                    t.setNom_tournoi(tfnomtournoi.getText());
        t.setType(tftype.getValue());
        
                    sc.modifierTournoi(t);

                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
       ShowTournoi();
         }
        
    }






  

     
     
     
    @FXML
    private void SupprimerOnClick(ActionEvent event) {
        
        Tournoi t = tableview.getSelectionModel().getSelectedItem();
        if(t==null){
        
           System.out.println("Veillez choisir un Tournoi");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir un Tournoi");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir un Tournoi à supprimer !");
 
            alert.showAndWait();
     
        }else{
          ServiceTournoi sc = new ServiceTournoi();
          Integer id_tournoi = t.getId_tournoi();
          String nom_tournoi = t.getNom_tournoi();
          String type = t.getType();
          try { 
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Supprimer Tournoi ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez supprimer! " +t.getNom_tournoi());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    sc.SupprimerOnClick(t);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Supprimer Tournoi");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Le Tournoi est supprimée");

                    alert1.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        ShowTournoi();
        
    }
 private void rechercher(ActionEvent event) {
        Tournoi t = new Tournoi();
        colnom.setCellValueFactory(new PropertyValueFactory<Tournoi,String>("nom_tournoi"));
     
        ObservableList<Tournoi> dataList;
        ServiceTournoi sc = new ServiceTournoi();
        dataList = sc.getTournoiList();
       
        tableview.setItems(dataList); 
    }
    @FXML
    private void RetourOnClick(ActionEvent event) {
              try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Interface.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }
      @FXML
     void ImprimerOnClick(){
         System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
    Window primaryStage = null;
           job.showPrintDialog(primaryStage); 
            
    Node root = this.tableview ;
   
           job.printPage(root);
           
           job.endJob();
            
       JOptionPane.showMessageDialog(null, "imprimer avec succés");

  }
    }



    @FXML
    private void ListeOnClick(ActionEvent event) {
             try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ListeTournoi.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void MatchOnAction(ActionEvent event) {
                try {
            selectedname = (tfnomtournoi.getText());
            Stage logp = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("matchtournoi.fxml"));
            Scene scene = new Scene(root);
            logp.setScene(scene);
            logp.show();
            logp.setResizable(false);
        }catch(Exception e) {
            System.out.println(e);
        }
    }

        @FXML
    private void pprofile(javafx.scene.input.MouseEvent event) throws IOException {
                      Parent d_page = FXMLLoader.load(getClass().getResource("/match/up/FXMLprofileprop.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pmatch(javafx.scene.input.MouseEvent event) throws IOException {
                  Parent d_page = FXMLLoader.load(getClass().getResource("/hajer/Match.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pterrain(javafx.scene.input.MouseEvent event) throws IOException {
            Parent d_page = FXMLLoader.load(getClass().getResource("/badis/TerrainInterface.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pmatriel(javafx.scene.input.MouseEvent event) throws IOException {
            Parent d_page = FXMLLoader.load(getClass().getResource("/badis/MaterielInterface.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pparking(javafx.scene.input.MouseEvent event) throws IOException {
          Parent d_page = FXMLLoader.load(getClass().getResource("/yossra/FXMLDocument.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
        
    }

    @FXML
    private void ptournoi(javafx.scene.input.MouseEvent event) throws IOException {
           Parent d_page = FXMLLoader.load(getClass().getResource("/hajer/Tournoi.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pproduit(javafx.scene.input.MouseEvent event) throws IOException {
        Parent d_page = FXMLLoader.load(getClass().getResource("/rania/FXMLProduit.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pctegorie(javafx.scene.input.MouseEvent event) throws IOException {
        
        Parent d_page = FXMLLoader.load(getClass().getResource("/rania/FXMLDocument1.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void plog(javafx.scene.input.MouseEvent event) throws IOException {
         Parent d_page = FXMLLoader.load(getClass().getResource("/match/up/FXMLlogin.fxml"));
        Scene s = new Scene(d_page);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
 
                app_stage.hide(); //optional
                app_stage.setScene(s);
                app_stage.show(); 
    }

    @FXML
    private void pe(javafx.scene.input.MouseEvent event) {
        System.exit(0);
    }
    
}


