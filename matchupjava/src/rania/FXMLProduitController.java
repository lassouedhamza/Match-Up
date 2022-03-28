/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rania;

import matchup.entities.Categorie;
import matchup.entities.Produit;
import matchup.servies.ServiceCategorie;
import matchup.servies.ServiceProduit;
import connection.myconnection;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;;
import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.util.Date;
import javafx.print.PrinterJob;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Window;import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.util.Date;
import javafx.print.PrinterJob;
import javafx.scene.chart.XYChart;
import javafx.stage.Window;import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.util.Date;
import javafx.print.PrinterJob;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Window;
import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.util.Date;
import java.util.regex.Pattern;
import javafx.embed.swing.SwingFXUtils;
import javafx.print.PrinterJob;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import matchup.entities.user;
import matchup.servies.Data;
import matchup.servies.utilisateurCRUD;
import org.controlsfx.control.Notifications;import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.util.Date;
import javafx.print.PrinterJob;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Window;import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.util.Date;
import javafx.print.PrinterJob;
import javafx.scene.chart.XYChart;
import javafx.stage.Window;import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.util.Date;
import javafx.print.PrinterJob;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Window;
import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.util.Date;
import java.util.regex.Pattern;
import javafx.embed.swing.SwingFXUtils;
import javafx.print.PrinterJob;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import matchup.entities.user;
import matchup.servies.Data;
import matchup.servies.utilisateurCRUD;
import org.controlsfx.control.Notifications;
//import mail.SendMail;
//import org.jcp.xml.dsig.internal.dom.Utils;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLProduitController implements Initializable {
    private Label label;
    @FXML
    private TextField tfnomprod;
    @FXML
    private TextField tfprixprod;
    @FXML
    private TextField tfdesc;
    @FXML
    private TableView<Produit> tvprod;
    
    @FXML
    private Button bntAjouter;
    @FXML
    private Button bntmodifier;
    @FXML
    private Button bntsupprimer;
    
    ServiceProduit cp = new ServiceProduit();
    ObservableList<Produit> list = cp.getProduitList();
    ObservableList<Categorie> CategorieList = FXCollections.observableArrayList();
   
    private Connection cnx;
    private PreparedStatement ste;
   
       
    @FXML
    private TextField tfquantite_total;
     @FXML
     private TableColumn<Produit, Integer> colidprod;
    @FXML
    private TableColumn<Produit,Integer> coldquantitetot;
    @FXML
    private TableColumn<Produit, Integer> coldquantiterest;
    @FXML
    private TableColumn<Produit, String> colddesc;
    @FXML
    private TextField tfquantite_total1;
    @FXML
    private AnchorPane tfquantite_restant;
    @FXML
    private TableColumn<Produit,Integer> colidprop;
    @FXML
    private TableColumn<Produit,String> colcat;
    @FXML
    private TableColumn<Produit, String> colnom;
    @FXML
    private TableColumn<Produit, Integer> coldprix;
     @FXML
    private ChoiceBox<Categorie> nom_categorie;
    
    ObservableList<Categorie> options;
    @FXML
    private Button export;

    
    @FXML
    private TextField tfchercher;
    ServiceProduit sp = new ServiceProduit();
    @FXML
    private Button bntchart;
    @FXML
    private Button AjouterPhoto;
    @FXML
    private ImageView photo;
    private String photoProduit = null;
    //private TableColumn<Produit , String> colphoto;
    @FXML
    private TableColumn<Produit,String> colpath;
    
    public static boolean testProd=true;
     static public int index;
    @FXML
    private HBox parent;
    @FXML
    private Label name;

     private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
     //myconnection cnx;
      public void  listcategorie() throws SQLException    {
        ServiceCategorie  sc = new ServiceCategorie();
        ServiceProduit  sp = new ServiceProduit();  
        List<Categorie> c = sc.getCategorieList();
         for(int i=0;i< c.size();i++) 
         {
             options= FXCollections.observableArrayList(c).sorted(); 
         } 
   
             nom_categorie.setItems(options);
      }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        // TODO
        
                     utilisateurCRUD cs = new utilisateurCRUD();
        try {
            user c = cs.findByUserIdPopulated(Data.user.getId());

            this.name.setText(c.getPrenom());
        } catch (SQLException ex) {
           
        }
           
             try {
            listcategorie();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
             //export.setOnAction(event ->{pdf();});
             Produit productselected = tvprod.getSelectionModel().getSelectedItem();
              addListenerToTable();
              ShowProduit();

            
    } 
//     void pdf() {
// System.out.println("To Printer!");
//         PrinterJob job = PrinterJob.createPrinterJob();
//           if(job != null){
//    Window primaryStage = null;
//           job.showPrintDialog(primaryStage); 
//            
//    Node root = this.tvprod ;    
//           job.printPage(root);
//           job.endJob();
//            
//       
//
//  }}
    
        private void selectedl(javafx.scene.input.MouseEvent event) {
           Produit p = tvprod.getSelectionModel().getSelectedItem();
           tfnomprod.setText(p.getNom_produit());
           String a = Integer.toString(p.getPrix());
           tfprixprod.setText(a);
           String b = Integer.toString(p.getQuantite_total());
           tfquantite_total.setText(b);
           String c = Integer.toString(p.getQuantite_restant());
           tfquantite_total1.setText(c);
           tfdesc.setText(p.getDescription());
        }
        private void addListenerToTable(){
          ServiceProduit cp = new ServiceProduit();
          ObservableList<Produit> list = cp.getProduitList();
          tvprod.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            if(newSelection!=null){
                bntmodifier.setDisable(false);
                bntsupprimer.setDisable(false); 
                tfnomprod.setText(newSelection.getNom_produit());
                tfprixprod.setText(String.valueOf(newSelection.getPrix()));
                tfquantite_total.setText(String.valueOf(newSelection.getQuantite_total()));
                tfquantite_total1.setText(String.valueOf(newSelection.getQuantite_restant()));
                tfdesc.setText(newSelection.getDescription());
    
            }else{
                tfnomprod.setText("");
                tfprixprod.setText("");
                tfquantite_total.setText("");
                tfquantite_total1.setText("");
                tfdesc.setText("");
                bntmodifier.setDisable(false);
                bntsupprimer.setDisable(false);      
            }
    
    
      });  
    }
         public boolean verifierchamps ()
    {
        String nom_categorie = tfnomprod.getText ();
   
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
    private void AjouterProduit(ActionEvent event) {
         utilisateurCRUD cs = new utilisateurCRUD();
        try {
            user c = cs.findByUserIdPopulated(Data.user.getId());

        } catch (SQLException ex) {
           
        }
        ServiceProduit serviceProduit=new ServiceProduit();
        Categorie b = new Categorie();
        if (controleDeSaisi()) {
            if (tfnomprod.getText().isEmpty()) {
                tfnomprod.setText("");
            }
            if (tfprixprod.getText().isEmpty()) {
                tfprixprod.setText("");
            }
            if (tfquantite_total.getText().isEmpty()) {
                tfquantite_total.setText("");
            }
            if (tfquantite_total1.getText().isEmpty()) {
                tfquantite_total1.setText("0.0");
            }
            String t = tfprixprod.getText();
            Produit p = new Produit();
             p.setNom_produit((tfnomprod.getText()));
             p.setPrix(parseInt(tfprixprod.getText()));
             p.setQuantite_total(parseInt(tfquantite_total.getText()));
             p.setPrix(parseInt(tfquantite_total1.getText()));
             p.setDescription((tfdesc.getText()));
             p.setPhoto(photoProduit);
             serviceProduit.AddProduit(p,Data.user.getId());
            ShowProduit();
            notificationadd();

        }

        
    
    }
    public void ShowProduit() {
        
        colidprod.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("id_produit"));
        colidprop.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("id"));
        colcat.setCellValueFactory(new PropertyValueFactory<Produit, String>("id_categorie"));
        colnom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom_produit"));
        coldprix.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("prix"));
        coldquantitetot.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite_total"));
        coldquantiterest.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite_restant"));
        colddesc.setCellValueFactory(new PropertyValueFactory<Produit, String>("description"));
        colpath.setCellValueFactory(new PropertyValueFactory<Produit, String>("path"));
        tvprod.setItems(list);
        FilteredList<Produit> filteredData = new FilteredList<>(list,b-> true);
        tfchercher.textProperty().addListener((observable,oldvalue,newvalue) -> {
        filteredData.setPredicate(Produit -> {
            if (newvalue==null || newvalue.isEmpty()){
                return true;
            }
            String lowerCaseFilter = newvalue.toLowerCase();
                
            if (Produit.getNom_produit().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
            return true; 
            } else if (String.valueOf(Produit.getId_produit()).indexOf(lowerCaseFilter)!=-1) {
            return true; 
            }else  
             return false; 
            });
            
        SortedList<Produit> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tvprod.comparatorProperty());
        tvprod.setItems(sortedData); 
        });
    }
     public void reload() throws IOException{
       FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("/rania/FXMLProduitController.fxml"));
       Parent root = fxmlloader.load();
       Stage stage = (Stage) tvprod.getScene().getWindow(); 
       stage.getScene().setRoot(root); 
       ShowProduit();
     }

    @FXML
    private void ModifierProduit(ActionEvent event) {
       Produit p =tvprod.getSelectionModel().getSelectedItem();
        if(p==null){
        
           System.out.println("Veillez choisir un Produit ");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir Produit");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir le Produit à modifier !");

            alert.showAndWait();
     
        }else{
          ServiceProduit sp = new ServiceProduit();
          String nom_produit = p.getNom_produit();
          Integer prix = p.getPrix();
          Integer qunatite_total = p.getQuantite_total();
          Integer quantite_restant= p.getQuantite_restant();
          String description = p.getDescription();
          
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Modifier Produit ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez modifier! " + p.getNom_produit());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    // System.out.println("sup1");
                   p.setNom_produit(tfnomprod.getText());
                   p.setPrix(parseInt(tfprixprod.getText()));
                   p.setQuantite_total(parseInt(tfquantite_total.getText()));
                   p.setQuantite_restant(parseInt(tfquantite_total1.getText()));
                   p.setDescription(tfdesc.getText());
                   sp.ModifierProduit(p);  
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
         ShowProduit();
    }

    @FXML
    private void SupprimerProduit(ActionEvent event) {
        
        Produit p=tvprod.getSelectionModel().getSelectedItem();
        if(p==null){
        
           System.out.println("Veillez choisir un Produit");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("choisir un produit");
            alert.setHeaderText(null);
            alert.setContentText("Veillez choisir un produit à supprimer !");

            alert.showAndWait();
     
        }else{
          ServiceProduit sp = new ServiceProduit();
          String nom_produit = p.getNom_produit();
          try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Supprimer Categorie ..");
                alert.setHeaderText(null);
                alert.setContentText("Etes-vous sûr que vous voulez supprimer! " + p.getNom_produit());
                Optional<ButtonType> action = alert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    // System.out.println("sup1");
                    sp.SupprimerProduit(p);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("SUPPRIMER Produit");
                    alert1.setHeaderText(null);
                    alert1.setContentText("le produit est supprimée");

                    alert1.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        ShowProduit();
        
    
    }

    private void AfficherProduit(ActionEvent event) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLProduit.fxml"));
        Parent root = fxmlloader.load();
        Stage stage = (Stage) tvprod.getScene().getWindow(); 
        stage.getScene().setRoot(root);
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
    private void Imprimer(ActionEvent event) throws ClassNotFoundException, SQLException, FileNotFoundException, DocumentException {
         try {
       Class.forName("com.mysql.jdbc.Driver");
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/match-up", "root", "");
      PreparedStatement pt = con.prepareStatement("select * from produit");
            ResultSet rs = pt.executeQuery();
            
                       /* Step-2: Initialize PDF documents - logical objects */

                       Document my_pdf_report = new Document();
                       //OutputStream file = new FileOutputStream(new File("ProductReport.pdf"));
                    
                       my_pdf_report.open();  
                       my_pdf_report.add(new Paragraph(new Date().toString())); 
                       my_pdf_report.add(new Paragraph("Match Up"));
                       my_pdf_report.add(new Paragraph("Listes des produits"));

                       PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
                       
                        my_pdf_report.open();  
                       my_pdf_report.add(new Paragraph(new Date().toString()));
//                            Image img = Image.getInstance("c:/6.png");
//                            my_pdf_report.add(img);
                       my_pdf_report.add(new Paragraph("Listes des Produits"));
                             //Add Image
//		       Image image1 = Image.getInstance("filmouk.png");
//                       image1.scaleAbsolute(210, 210);
//                       my_pdf_report.add(image1);
                       my_pdf_report.addCreationDate();
              
                       
                       //we have four columns in our table
                       PdfPTable my_report_table = new PdfPTable(7);
                       my_report_table.setWidthPercentage(100); //Width 100%
			my_report_table.setSpacingBefore(10f); //Space before table
			my_report_table.setSpacingAfter(10f); //Space after table
                             
                       //create a cell object
                       PdfPCell table_cell;
                       
                       
                                       table_cell=new PdfPCell(new Phrase(" id_produit"));
                                      table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("id"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("id_categorie"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("nom_produit"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("prix"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("quantite_total"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("quantite_restant"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       table_cell=new PdfPCell(new Phrase("description"));
                                       table_cell.setBackgroundColor(BaseColor.PINK);
                                       my_report_table.addCell(table_cell);
                                       

                                      while(rs.next()){
                                      
                                       String id_produit= rs.getString("id_produit");
                                       table_cell=new PdfPCell(new Phrase(id_produit));
                                       my_report_table.addCell(table_cell);
                                       
                                       String id=rs.getString("id");
                                       table_cell=new PdfPCell(new Phrase(id));
                                       my_report_table.addCell(table_cell);
                                       
                                       String id_categorie=rs.getString("id_categorie");
                                       table_cell=new PdfPCell(new Phrase(id_categorie));
                                       my_report_table.addCell(table_cell);
                                       
                                       String nom_produit=rs.getString("nom_produit");
                                       table_cell=new PdfPCell(new Phrase(nom_produit));
                                       my_report_table.addCell(table_cell);
                                       
                                        String prix = rs.getString("prix");
                                       table_cell=new PdfPCell(new Phrase(prix ));
                                       my_report_table.addCell(table_cell);
                                       
                                       String quantite_total = rs.getString("quantite_total");
                                       table_cell=new PdfPCell(new Phrase(quantite_total));
                                       my_report_table.addCell(table_cell); 
                                       
                                       String quantite_restant  = rs.getString("quantite_restant");
                                       table_cell=new PdfPCell(new Phrase(quantite_restant));
                                       my_report_table.addCell(table_cell); 
                                       
                                       String description = rs.getString("description");
                                       table_cell=new PdfPCell(new Phrase(description));
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
    private void ChargerChart(ActionEvent event) {
        try{
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLBarchart.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);        
            ((Stage)((Node)event.getTarget()).getScene().getWindow()).setScene(scene);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void uploadPhoto(ActionEvent event) throws IOException  {
        FileChooser fileChooser = new FileChooser(); //pour choisir la photo
        //fileChooser.setInitialDirectory(new File("c:\\Users\\pc"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.bmp"));
        fileChooser.setTitle("Choisir une photo du produit");
        File selected_photo = fileChooser.showOpenDialog((Stage) bntAjouter.getScene().getWindow());
        if (selected_photo != null) {
            if ((selected_photo.length() / 1024) / 1024 < 2.0) {
                photoProduit = selected_photo.getAbsolutePath();
                BufferedImage bufferedImage = ImageIO.read(selected_photo);
                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
                photo.setImage(image);
            } else {
                System.out.println("Veuillez choisir une photo de profil avec une taille < 2 Mo");
            }
        }
    }
      private boolean controleDeSaisi() {

        if (tfnomprod.getText().isEmpty() || tfprixprod.getText().isEmpty() || tfquantite_total.getText().isEmpty()
                || tfquantite_total1.getText().isEmpty() || tfdesc.getText().isEmpty() ) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("SUPPRIMER Produit");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Veuillez bien remplir tous les champs !");
                    alert1.showAndWait();
           
            return false;
        } else {

            if (!Pattern.matches("^[a-zA-Z0-9]*$", tfprixprod.getText())) {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("SUPPRIMER Produit");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Veuillez bien remplir tous les champs !");
                    alert1.showAndWait();
                tfprixprod.requestFocus();
                tfprixprod.selectEnd();
                return false;
            }

              if (!Pattern.matches("^[a-zA-Z0-9]*$", tfnomprod.getText())) {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("SUPPRIMER Produit");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Veuillez bien remplir tous les champs !");
                    alert1.showAndWait();
                tfnomprod.requestFocus();
                tfnomprod.selectEnd();
                return false;
            }

        }
        return true;
    }
    
    public void notificationadd(){
      // Image image;
       // image = new Image("/image/tik.png");
        Notifications notifications=Notifications.create();
        //notifications.graphic(new ImageView(image));
        notifications.text("Add succsesfully");
        notifications.title("Success message");
        notifications.hideAfter(Duration.seconds(10));
        notifications.show();
        
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

    

