/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rania;

 import matchup.entities.Categorie;
import matchup.servies.ServiceCategorie;
import connection.myconnection;
import java.awt.AWTException;
import java.awt.TrayIcon;
import java.awt.event.MouseEvent;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.System.load;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import static javafx.fxml.FXMLLoader.load;
import static javafx.fxml.FXMLLoader.load;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.management.Notification;
import javax.swing.JOptionPane;
import matchup.entities.proprietaire;
import matchup.entities.user;
import matchup.servies.Data;
import matchup.servies.proprietaireCRUD;
import matchup.servies.utilisateurCRUD;

/**
 *
 * @author Asus
 */
public class FXMLDocumentController1 implements Initializable {
     public Connection cnx;
    public PreparedStatement ste;
    private Label label;
    //private TextField tfidcat;
    @FXML
    private TextField tfnomcat;
    @FXML
    private Button bntajouter;
    @FXML
    private TableView<Categorie> tvcat;
    @FXML
    private TableColumn<Categorie, Integer> colid;
    @FXML
    private TableColumn<Categorie, String> colnom;
   
    @FXML
    private Button bntsupprimer;
    @FXML
    private Button btnmodifier;
    @FXML
    private TextField tfrecherche;
    
    ServiceCategorie cs=new ServiceCategorie();
    ObservableList<Categorie> list = cs.getCategorieList();
    Categorie c;
    @FXML
    private Button bntproduit;
    @FXML
    private HBox parent;
    @FXML
    private Label name;
  
   
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    //myconnection cnx;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //tvcat.setEditable(true);
                proprietaireCRUD css = new proprietaireCRUD();
        try {
            proprietaire c = css.findByUserIdPopulated(Data.user.getId());
            this.name.setText(c.getPrenom());
        } catch (SQLException ex) { }
        ServiceCategorie cs = new ServiceCategorie();
        Categorie CategorySelected = tvcat.getSelectionModel().getSelectedItem();
        addListenerToTable();
        ShowCategorie();
         
    } 
    public boolean checkIfNumber(String num){
        try{
            int rt = Integer.parseInt(num);
            return true;
        }catch(NumberFormatException e){
            return false;
            
        }
    }
    public boolean checkIfStringContainsNumber(String str){
        for(int i=0;i<str.length();i++){
            if(str.contains("0")|| str.contains("l")||str.contains("2")||str.contains("3")||str.contains("4")||str.contains("5")||str.contains("6")||str.contains("7") || str.contains("8")||str.contains("9")){
                return true;
            }
        }
         return false;
    }
    public boolean conntroleSaisie(){
         Alert alert=new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Erreur");
             alert.setHeaderText("Erreur de saisie");
             if(checkIfStringContainsNumber(tfnomcat.getText())){
                 alert.setContentText("Le ne doit pas contenir des chiffres !");
                 alert.showAndWait();
                 return false;
                 
             }
             return true;
    }

    @FXML
    private boolean AjouterCategorie(ActionEvent event) throws SQLException, IOException {
       
        ServiceCategorie serviceCategorie=new ServiceCategorie();
        Categorie c = new Categorie();
        if (verifierchamps ()==true  ){
            
        c.setNom_categorie((tfnomcat.getText()));
           Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("confirmation add");
             alert.setHeaderText("this confirmation about add");
             alert.setContentText("are you sure to add??");
             Optional<ButtonType> result=alert.showAndWait();
             if(result.get()==ButtonType.OK){
       
              serviceCategorie.AddCategorie(c);
              alert.setContentText("succeed");
              System.out.println("Je suis une nouvelle catégorie Merci ! ");
             }else{
                     System.out.println("Cancel");
                  }
        
            ShowCategorie();
        
        } 
        return false;
    }
     public void ShowCategorie() {
       ServiceCategorie cs = new ServiceCategorie();
       ObservableList<Categorie> list = cs.getCategorieList();
       colid.setCellValueFactory(new PropertyValueFactory<Categorie, Integer>("id_categorie"));
       colnom.setCellValueFactory(new PropertyValueFactory<Categorie, String>("nom_categorie"));
       tvcat.setItems(list);
       FilteredList<Categorie> filteredData = new FilteredList<>(list,b-> true);
       tfrecherche.textProperty().addListener((observable,oldvalue,newvalue) -> {
       filteredData.setPredicate(Categorie -> {
            if (newvalue==null || newvalue.isEmpty()){
                return true;
            }
            String lowerCaseFilter = newvalue.toLowerCase();
                
            if (Categorie.getNom_categorie().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
            return true; 
            } else if (String.valueOf(Categorie.getId_categorie()).indexOf(lowerCaseFilter)!=-1) {
            return true; 
            }else  
             return false; 
            });
            
        SortedList<Categorie> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvcat.comparatorProperty());
        tvcat.setItems(sortedData); 
        }); 
       
     }
      public void reload() throws IOException{
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocument.fxml"));
       Parent root = fxmlloader.load();
       Stage stage = (Stage) tvcat.getScene().getWindow(); 
       stage.getScene().setRoot(root); 
       ShowCategorie();
   }
      
  
     private void selectedl(javafx.scene.input.MouseEvent event) {
        Categorie c = tvcat.getSelectionModel().getSelectedItem();
      
        tfnomcat.setText(c.getNom_categorie());
        String a = Integer.toString(c.getId_categorie());
        
       
    }
    private void addListenerToTable(){
        ServiceCategorie cs = new ServiceCategorie();
        ObservableList<Categorie> list = cs.getCategorieList();
        tvcat.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            if(newSelection!=null){
                btnmodifier.setDisable(false);
                bntsupprimer.setDisable(false); 
                tfnomcat.setText(newSelection.getNom_categorie());
                //tfid.setText(newSelection.getId_categorie());
            }else{
                tfnomcat.setText("");
                btnmodifier.setDisable(false);
                bntsupprimer.setDisable(false);
                
            }
    
    
      });  
    }
    public boolean verifierchamps ()
    {
        String nom_categorie = tfnomcat.getText ();
   
                // vérifie les champs vides
                if (nom_categorie.equals(""))
                {
                    JOptionPane.showMessageDialog (null, "Le champs est vide ", "Champs Vide", 2);
                    return false;
                }else 
                {
                 return true;
                }

    }
    

    @FXML
    private void SupprimerCategorie(ActionEvent event) {
        Categorie c=tvcat.getSelectionModel().getSelectedItem();
        if(c==null){
        
           System.out.println("Veillez choisir une Catégorie");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir une categorie");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir une Catégorie à supprimer !");

            alert.showAndWait();
     
        }else{
          ServiceCategorie sc = new ServiceCategorie();
          String nom_categorie = c.getNom_categorie();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Supprimer Categorie ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez supprimer! " + c.getNom_categorie());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    // System.out.println("sup1");
                    sc.SupprimerCategorie(c);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("SUPPRIMER Categorie");
                    alert1.setHeaderText(null);
                    alert1.setContentText("la catégorie est supprimée");

                    alert1.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
             ShowCategorie();
    
        
    }

    private void retour(ActionEvent event) {
          try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Entrer.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void Modifier(ActionEvent event) {
        Categorie c =tvcat.getSelectionModel().getSelectedItem();
        if(c==null){
        
           System.out.println("Veillez choisir un Tournoi");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir Tournoi");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir le Tournoi à modifier !");

            alert.showAndWait();
     
        }else{
          ServiceCategorie sc = new ServiceCategorie();
          String nom_categorie = c.getNom_categorie();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Modifier Tournoi ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez modifier! " + c.getNom_categorie());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    // System.out.println("sup1");
                    c.setNom_categorie(tfnomcat.getText());
                    sc.ModifierCategorie(c);        
                }
            } catch (Exception e) {
                e.printStackTrace();
            }           
        }
         ShowCategorie();
        
    }

    @FXML
    private void loadProduct(ActionEvent event) {
          try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLProduit.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
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
       
        
    

        
          




   

 
    
   

    

