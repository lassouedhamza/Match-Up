

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hajer;
import java.util.ArrayList;
import java.util.List;
import matchup.entities.Matchs;
import java.io.IOException;
import matchup.servies.ServiceMatch;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
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
//import Service.EmailSend; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import static java.util.Collections.list;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.Action;
import java.util.Date;
import java.util.Locale;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import matchup.entities.proprietaire;
import matchup.entities.user;
import matchup.servies.Data;
import matchup.servies.proprietaireCRUD;
import matchup.servies.utilisateurCRUD;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class MatchpropController implements Initializable {
    ObservableList <String> tftypeList =FXCollections.observableArrayList("Football","Handball","Volleyball","Tennis");
public static String selectedmatch="";
     
    @FXML
    private ChoiceBox<String> tftype;
   
    @FXML
    private TextField tfnbjoueurs;
    @FXML
    private TableView<Matchs> tableview;
    @FXML
    private TableColumn<Matchs,String> coltype;
    @FXML
    private TableColumn<Matchs,String> coldate;
    @FXML
    private TableColumn<Matchs,Integer> colnbjoueurs;
    @FXML
    private Button ajouter;
    @FXML
    private TextField tfrechercher;
    @FXML
    private TextField datePicker;
    @FXML
    private Button sendmail;
    @FXML
    private Button ajouter1;
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
         Matchs m = tableview.getSelectionModel().getSelectedItem();

//            inviter.setOnAction(event->{SendMail.sendMail("hajer.hassine@esprit.tn", "sayi", m.getType()+" "+m.getDate()+"youp");
 
        tftype.setItems(tftypeList);
          ShowMatch();
    }    
//public static Date asDate(LocalDate localDate) {
//    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
//  }
   
      
       
    @FXML
    private void AjouterOnAction(ActionEvent event) {
       
          if(((tftype.getValue().isEmpty()  || tfnbjoueurs.getText().isEmpty())))
         {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Erreur");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Vérifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
         if((tftype.getValue().isEmpty() || tfnbjoueurs.getText().isEmpty()))
         {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Erreur");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Vérifier les champs vides");
             
             alert.showAndWait();
         }
          else{    
//             ZoneId defaultZoneId = ZoneId.systemDefault();
//                  LocalDate dd= datePicker.getValue();
//                    LocalDate localDate = tfDateD.getValue(); 
//        Date date = Date.from(dd.atStartOfDay(defaultZoneId).toInstant());
//        Date date2 = Date.from(df.atStartOfDay(defaultZoneId).toInstant());
            ServiceMatch ser = new ServiceMatch();
            Matchs m = new Matchs();
                    m.setType(tftype.getValue());
         m.setNbjoueurs(parseInt(tfnbjoueurs.getText()));
         m.setDate(datePicker.getText());
//    String d = datePicker.getLocalToParentTransform().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
         //String d = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
//                 
//         m.setDate(d);
//    m.setDate(datePicker.getValue());
           ser.AddMatch(m);
        ShowMatch();
          //  m.setType(tftype.getValue());
//                   int a= Integer.parseInt(tfnbjoueurs.getText());
//                   
//                  ZoneId defaultZoneId = ZoneId.systemDefault();
//                  LocalDate dd= datePicker.getValue();
//                      ServiceMatch ser = new ServiceMatch();
//                          Date date = Date.from(dd.atStartOfDay(defaultZoneId).toInstant());
//            Matchs m = new Matchs(); 
//                 m.setType(tftype.getValue());
//                  m.setType(datePicker.getValue());  
//       
//     
//ser.AddMatch(m);
//                ShowMatch();
    
          
         }     
        
    }}



   
//                private void addListenerToTable(){
//        ServiceMatch cs = new ServiceMatch();
//        ObservableList<Match> list = cs.getMatchList();
//        tableview.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
//            if(newSelection!=null){
//                ajouter.setDisable(false);
//                sendmail.setDisable(false); 
////                tfnbjoueurs.setText((parseInt(newSelection.getNbjoueurs()));
//                  tftype.setValue(newSelection.getType());
//                  
//            }else{
//                tfnbjoueurs.setText("");
//                tftype.setValue("");
//                ajouter.setDisable(false);
//                sendmail.setDisable(false);
//                
//                
//            }
//     
//    
//      });  
//    }  

public void ShowMatch(){
      
            ServiceMatch ser = new ServiceMatch();
       ObservableList<Matchs> list  = ser.getterList();
        coltype.setCellValueFactory(new PropertyValueFactory<Matchs,String>("type"));
       
        coldate.setCellValueFactory(new PropertyValueFactory<Matchs,String>("date"));
        colnbjoueurs.setCellValueFactory(new PropertyValueFactory<Matchs,Integer>("nbjoueurs"));
        tableview.setItems(list);
        FilteredList<Matchs> filteredData = new FilteredList<>(list, b -> true);
       
        tfrechercher.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            filteredData.setPredicate((Matchs cattype ) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (cattype.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
                }
               
                else {
                    return false; 
                }
            });
        });
        SortedList<Matchs> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedData);
        
        
   }    



//    private void selectedl(MouseEvent event) {
//       Matchs m = tableview.getSelectionModel().getSelectedItem();
//        tftype.setValue(m.getType());
////         java.sql.Date h = java.sql.Date.valueOf(datePicker.setValue());
////         m.getDate(h);
//        datePicker.setValue(m.getDate());
//       tfnbjoueurs.setText( m.getNbjoueurs1());
//          
//       
//       
//    }
    private void search(ActionEvent event) {
          Matchs m = new Matchs();
         coltype.setCellValueFactory(new PropertyValueFactory<Matchs,String>("type"));
         coldate.setCellValueFactory(new PropertyValueFactory<Matchs,String>("date"));
         colnbjoueurs.setCellValueFactory(new PropertyValueFactory<Matchs,Integer>("nbjoueurs"));
 
        ObservableList<Matchs> dataList;
   ServiceMatch ser = new ServiceMatch();
        dataList = ser.getterList();
       
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

    private void voirliste(ActionEvent event) {
                  try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ListeMatch.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void ListeOnAction(ActionEvent event) {
             try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ListeMatch.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

//    @FXML
//    private void DateOnClick(ActionEvent event) {
//          LocalDate Id=datePicker.getValue();
//        lb1.setText(Id.toString());
//        lb2.setText("Date du match");
//        lb3.setText("Time");
//        clock();
//    }

//    @FXML
//    private void DateOnClick(ActionEvent event) {
//    }
private void selectedl(javafx.scene.input.MouseEvent event) {
        Matchs m = tableview.getSelectionModel().getSelectedItem();
      
           tftype.setValue(m.getType());
           datePicker.setText(m.getType());
           
           
    }
    @FXML
    private void InviterOnAction(ActionEvent event) {
        
                try {
            selectedmatch = (datePicker.getText());
            Stage logp = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("InviterAmis.fxml"));
            Scene scene = new Scene(root);
            logp.setScene(scene);
            logp.show();
            logp.setResizable(false);
        }catch(Exception e) {
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



