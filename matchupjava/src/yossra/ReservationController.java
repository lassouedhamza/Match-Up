/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yossra;



import matchup.entities.Reservation;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import matchup.servies.ServiceReservation;
import connection.myconnection;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author yousra
 */
public class ReservationController implements Initializable {
    public PreparedStatement ste;
    private Label label;
    Reservation r;
    @FXML
    private Label tfdate;
    @FXML
    private Label tfdateff;
    @FXML
    private TextField tfdated;
    @FXML
    private TextField tfdatef;
    @FXML
    private TableView<Reservation> tablersv;
    @FXML
    private TableColumn<Reservation, Integer> colidrsv;
    @FXML
    private TableColumn<Reservation, Integer> colid;
    @FXML
    private TableColumn<Reservation, Integer> colidprk;
    @FXML
    private TableColumn<Reservation, String> coldated;
    @FXML
    private TableColumn<Reservation, String> coldatef;
      @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    
   
    private TextField tfidrsv;
    // Instancation of Connection
     myconnection con;
    @FXML
    private Button tfemail;
    @FXML
    private TextField tfrecherche;
    @FXML
    private HBox parent;
    @FXML
    private Label name;
    @FXML
    private TableColumn<?, ?> coldated1;
   
    
    /**
     * Initializes the controller class.
     */
    private void handleButtonAction(ActionEvent event) throws SQLException {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
        if (event.getSource()==btnajouter){
            AjouterReservation();
            
        } else if(event.getSource()==btnmodifier){
            ModifierReservation();
        }
        else if(event.getSource()==btnsupprimer){
            SupprimerReservation();
    }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {


showReservation();
 
        } catch (SQLException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    
    private void RetourReservation(ActionEvent event) {
     try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLHome.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

       public void reload() throws IOException{

       FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("Gestion_parking/Reservation.fxml"));
       Parent root = fxmlloader.load();
       Stage stage = (Stage)  tablersv.getScene().getWindow(); 
       stage.getScene().setRoot(root); 
   }
       
      private void addListenerToTable(){
        ServiceReservation s = new ServiceReservation();
        ObservableList<Reservation> list = s.getReservationList();
         tablersv.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            if(newSelection!=null){
                btnmodifier.setDisable(false);
                btnsupprimer.setDisable(false); 
             
            }else{
                tfidrsv.setText("");
                btnmodifier.setDisable(false);
                btnsupprimer.setDisable(false);
                
            }
    
    
      });  
    }
              
public ObservableList<Reservation> getReservationList() throws SQLException{
    ObservableList<Reservation> reservationList = FXCollections.observableArrayList();    
    String query="SELECT * FROM `reservationparking`";
    Statement st;
    ResultSet rs;
    Connection conn =  myconnection.getInstance().getConnection();
    try{
        st= conn.createStatement();
        rs= st.executeQuery(query);
        System.out.print(rs);
        Reservation reservat;
        while(rs.next()){
           reservat = new Reservation(rs.getInt("idrsvparking"),rs.getInt("id"),rs.getInt("id_parking"),rs.getDate("date_d"),rs.getDate("date_f") ) ;
           System.out.print((reservat));
           System.out.println("--^ "+ rs.next()); 
           reservationList.add(reservat);
        }
    } catch(Exception ex){
        System.out.println("Something went wrong, Exception: " + ex);
        return null;
                }
    return reservationList;

}    

   


    
   public void  showReservation() throws SQLException{
          
        ServiceReservation ServiceReservation = new ServiceReservation();
       ObservableList<Reservation> list  = ServiceReservation.getReservationList();
       colidrsv.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("idrsvparking"));
        colid.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("id"));
         
        colidprk.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("id_parking"));
         coldated.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_d"));
        coldatef.setCellValueFactory(new PropertyValueFactory<Reservation,String>("date_f"));
        
        tablersv.setItems(list);
        FilteredList<Reservation> filteredData = new FilteredList<>(list, b -> true);
       
        tfrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Reservation date_d) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (date_d.getDate_d().toString().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
                }
               
                else {
                    return false; 
                }
            });
        });
        SortedList<Reservation> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablersv.comparatorProperty());
        tablersv.setItems(sortedData);
   }
   
    @FXML
      public void AjouterReservation() throws SQLException{        
        
       
          if((( tfdated.getText().isEmpty() || tfdatef.getText().isEmpty())))
         {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
            ServiceReservation ServiceReservation = new ServiceReservation();
            Reservation r = new Reservation();
            System.out.println("260===> " + tfdated.getText());
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
            Date date_d, date_f;
            java.sql.Date date_d_sql = null;
            java.sql.Date date_f_sql = null;

            try{
             date_d = df.parse(tfdated.getText());
             System.out.println("267===> " + date_d);
             date_d_sql = new java.sql.Date(date_d.getTime());
             date_f = df.parse(tfdatef.getText());
             date_f_sql = new java.sql.Date(date_f.getTime());
             System.out.println("date_d_sql is " + date_d_sql +"\n date_f_sql is " + date_f_sql);
            }
            catch(Exception e){
            }
            r.setDate_d(date_d_sql);
            r.setDate_f(date_f_sql);
            System.out.println(r);
            ServiceReservation.AjouterReservation(r);
            showReservation();
            tfdated.clear();
            tfdatef.clear(); 
    }}
    
    @FXML
     public void  ModifierReservation() throws SQLException {
      

         if((( tfdated.getText().isEmpty() || tfdatef.getText().isEmpty())))
         {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
        
        ServiceReservation ServiceReservation=new ServiceReservation();
        Reservation selected = tablersv.getSelectionModel().getSelectedItem();
        Reservation r = new Reservation();
        r.setDate_d(selected.getDate_d());
        r.setDate_f(selected.getDate_f());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
        Date date_d, date_f;
        java.sql.Date date_d_sql = null;
        java.sql.Date date_f_sql = null;
         try{
             date_d = df.parse(tfdated.getText());
             date_d_sql = new java.sql.Date(date_d.getTime());
             date_f = df.parse(tfdatef.getText());
             date_f_sql = new java.sql.Date(date_f.getTime());
            }
            catch(Exception e){
            }
        r.setId_parking(selected.getId_parking());
        r.setId(selected.getId());
        r.setIdrsvparking(selected.getIdrsvparking());
        r.setDate_d(date_d_sql);
        r.setDate_f(date_f_sql);

        ServiceReservation.ModifierReservation(r);
          this.tablersv.refresh();
          this.showReservation();
          tfdated.clear();
          tfdatef.clear();
   
    }
    
     }
    @FXML
    public void SupprimerReservation() throws SQLException{
    
             Reservation r= tablersv.getSelectionModel().getSelectedItem();
           if((( tfdated.getText().isEmpty() || tfdatef.getText().isEmpty())))
         {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
       ServiceReservation ServiceReservation = new ServiceReservation();
          int idrsvparking= r.getIdrsvparking();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Supprimer Reservation ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez supprimer! " + r.getIdrsvparking());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                  
                    ServiceReservation.SupprimerReservation(r);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("SUPPRIMER Parking");
                    alert1.setHeaderText(null);
                    alert1.setContentText("la parking est supprimée");

                    alert1.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
         showReservation();

    }

    private void executeQuery(String query){
        try{
            Connection con = myconnection.getInstance().getConnection();
            System.out.println("con is " + con);
            Statement ste;
            ste=con.createStatement();
            ste.executeUpdate(query);
        } catch (Exception ex){
            ex.printStackTrace();
        }
 }
        @FXML
    private void EmailReservation(ActionEvent event) {
      
    try {
            
            Stage logp = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("Email.fxml"));
            Scene scene = new Scene(root);
            logp.setScene(scene);
            logp.show();
            logp.setResizable(false);
        }catch(Exception e) {
            System.out.println(e);
        }

    
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        Reservation reservat =tablersv.getSelectionModel().getSelectedItem();
        System.out.print("reservat =" + reservat);
        tfdated.setText(reservat.getDate_d().toString());
        tfdatef.setText(reservat.getDate_f().toString());
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

           

        


 
        
        


      
          
          
          
       

   




       
     
  


    

    
