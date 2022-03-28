    
package yossra;


import matchup.entities.Parking;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Event;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import matchup.servies.ServiceParking;
import connection.myconnection;
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
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import javafx.scene.layout.HBox;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import java.io.IOException;
import javafx.scene.input.MouseEvent;


public class FXMLDocumentController implements Initializable {
    
    private Label label;
    private TextField tfid;
    @FXML
    private TextField tfadresse; 
    @FXML
    private TextField tfplace;
    private TextField tfidparking;
    
    @FXML
    private TableColumn<Parking, Integer> colidp;
    @FXML
    private TableColumn<Parking, Integer> colid;
    @FXML
    private TableColumn<Parking, String> coladr;
    @FXML
    private TableColumn<Parking, Integer> colnb;
    
    ServiceParking ps = new ServiceParking();
    ObservableList<Parking> list = ps.getParkingList();
    
   
    @FXML
    private Label ladr;
    @FXML
    private Label lnb;
 
    
    myconnection con;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnajouter;
    @FXML
    private TableView<Parking> tvfox;
   
    @FXML
    private TextField tfrecherche;
    @FXML
    private AnchorPane table;
    
    Parking p; 
    @FXML
    private Button tfimprimer;
    @FXML
    private Button tfchart;
    @FXML
    private HBox parent;
    @FXML
    private Label name;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
//        try{
//            this.AfficherParking();
//        }catch(SQLException ex){
//            System.out.println(ex.getMessage());
        
        
        
        // TODO
ShowParking();

    }    
    

    @FXML
    private void AjouterParking(ActionEvent event)  {
        if(((tfadresse.getText().isEmpty() || tfplace.getText()== null)))
         {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             
             alert.showAndWait();
         }
         
         
          else{
        
        ServiceParking serviceParking=new ServiceParking();
        Parking p = new Parking();
      //  p.setNom(tfnom.getText());
//        p.setId_Parking(parseInt(tfidparking.getText()));
        p.setAdresse(tfadresse.getText());
        p.setNbdeplace(parseInt(tfplace.getText()));
        serviceParking.AddParking(p);
         ShowParking();
        tfadresse.clear();
         tfplace.clear();
         // tfnom.clear();
    }
    }


    @FXML
    private void ModifierParking(ActionEvent event) {
        

         if(((tfadresse.getText().isEmpty() || tfplace.getText()== null)))
         {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("data invalide");
             alert.setHeaderText("Erreur de saisie");
             alert.setContentText("Verifier les champs vides");
             alert.showAndWait();
         }
            
         
          else{
              
        
        ServiceParking s= new ServiceParking();
        Parking selected = tvfox.getSelectionModel().getSelectedItem();
        Parking p = new Parking();
        p.setNbdeplace(parseInt(tfplace.getText()));
        p.setAdresse(tfadresse.getText());
        //p.setNom(tfnom.getText());
        p.setId_parking(selected.getId_parking());
        p.setId(selected.getId());
        s.ModifierParking(p);
        this.tvfox.refresh();
         ShowParking();
        tfadresse.clear();
         tfplace.clear();
         // tfnom.clear();

    }
    
     }   
      

     
    @FXML
    private void SupprimerParking(ActionEvent event) throws SQLException {
        Parking p= tvfox.getSelectionModel().getSelectedItem();
        if(p==null){
        
           System.out.println("Veillez choisir une Parking");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir une Parking");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir une Parking à supprimer !");

            alert.showAndWait();
     
        }else{
          ServiceParking ServiceParking = new ServiceParking();
          int id_parking = p.getId_parking();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Supprimer Parking ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez supprimer! " + p.getId_parking());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                  
                    ServiceParking.SupprimerParking(p);
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
         ShowParking();
      
         
        tfadresse.clear();
         tfplace.clear();
         // tfnom.clear();
    }



    

private void ShowParking() {
        ServiceParking ServiceParking = new ServiceParking();
        ObservableList<Parking> list  = ServiceParking.getParkingList();
        System.out.println(list);
        coladr.setCellValueFactory(new PropertyValueFactory<Parking,String>("adresse"));
      //  colnom.setCellValueFactory(new PropertyValueFactory<Parking,String>("nom"));
        colnb.setCellValueFactory(new PropertyValueFactory<Parking,Integer>("nbdeplace"));
        colid.setCellValueFactory(new PropertyValueFactory<Parking,Integer>("id"));
        colidp.setCellValueFactory(new PropertyValueFactory<Parking,Integer>("id_parking"));

        
        
        tvfox.setItems(list);
        FilteredList<Parking> filteredData = new FilteredList<>(list, b -> true);
       
        tfrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Parking adresse) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (adresse.getAdresse().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
                }
               
                else {
                    return false; 
                }
            });
        });
        

        tvfox.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
    if (newSelection != null) {
//        System.out.println("340 "+ newSelection );
 System.out.println( newSelection );
      // tfid.setText(String.valueOf(newSelection.getId()));
       //tfnom.setText(newSelection.getNom());
       tfadresse.setText(newSelection.getAdresse());
       tfplace.setText(String.valueOf(newSelection.getNbdeplace()));
    
//       tfidparking.setText(String.valueOf(newSelection.getId_parking()));
       
       this.p = newSelection;            
    }
});
        SortedList<Parking> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvfox.comparatorProperty());
        tvfox.setItems(sortedData);
        
        
        
    }

   public void reload() throws IOException{

       FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("Gestion_parking/FXMLDocument.fxml"));
       Parent root = fxmlloader.load();
       Stage stage = (Stage)  tvfox.getScene().getWindow(); 
       stage.getScene().setRoot(root); 
   }
   

   private void addListenerToTable(){
        ServiceParking p = new ServiceParking();
        //ObservableList<Parking> list = p.getParkingList();
        //System.out.println(tvfox.getSelectionModel().selectedItemProperty());
         tvfox.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            if(newSelection!=null){
                btnmodifier.setDisable(false);
                btnsupprimer.setDisable(false); 
             
            }else{
                tfidparking.setText("");
                btnmodifier.setDisable(false);
                btnsupprimer.setDisable(false);
                
            }
    
    
      });  
    }


    private void retour(ActionEvent event) {
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

    @FXML
    private void ImprimerParking(ActionEvent event) throws ClassNotFoundException, ClassNotFoundException, SQLException, DocumentException,BadElementException, IOException, URISyntaxException {
        try {
              Class.forName("com.mysql.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/match-up", "root", "");
      PreparedStatement pt = con.prepareStatement("select * from parking");
            ResultSet rs = pt.executeQuery();
            
                       /* Step-2: Initialize PDF documents - logical objects */

                       Document my_pdf_report = new Document();

                       PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
                       
                        my_pdf_report.open();  
//                       my_pdf_report.add(new Paragraph(new Date().toString()));
//                            Image img = Image.getInstance("c:/6.png");
//                            my_pdf_report.add(img);
                             my_pdf_report.add(new Paragraph("Listes des parking"));
                       my_pdf_report.addCreationDate();
              
                       
                       //we have four columns in our table
                       PdfPTable my_report_table = new PdfPTable(7);
                             
                       //create a cell object
                       PdfPCell table_cell;
                       
                       
                                       table_cell=new PdfPCell(new Phrase(" id_parking"));
                                      table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("id"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("adresse"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("nbdeplace"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       
                                       

                                      while(rs.next()){
                                      
                                       String idRdv= rs.getString("id_parking");
                                       table_cell=new PdfPCell(new Phrase(idRdv));
                                       my_report_table.addCell(table_cell);
                                       String type=rs.getString("id");
                                       table_cell=new PdfPCell(new Phrase(type));
                                       my_report_table.addCell(table_cell);
                                       String ds=rs.getString("adresse");
                                       table_cell=new PdfPCell(new Phrase(ds));
                                       my_report_table.addCell(table_cell);
                                       String dd=rs.getString("nbdeplace");
                                       table_cell=new PdfPCell(new Phrase(dd));
                                       my_report_table.addCell(table_cell);
                                        
                       }
                       /* Attach report table to PDF */
                       
                       my_pdf_report.add(my_report_table); 
                       
             System.out.println(my_pdf_report);
                       my_pdf_report.close();
                       JOptionPane.showMessageDialog(null, "imprimer avec succes");

                       /* Close all DB related objects */
                       rs.close();
                       pt.close(); 
                       con.close();               


       } catch (FileNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
       }
        
    }

    @FXML
    private void chartparking(ActionEvent event) {
   try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLchart.fxml"));
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



 


