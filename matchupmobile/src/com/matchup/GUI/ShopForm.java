/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.matchup.Services.ServiceProduit;
import com.matchup.entities.Produit;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class ShopForm  extends BaseForm{ 
    
    @Override
    protected boolean isCurrentShop() {
        return true;
    }
   com.codename1.ui.Container gui_Container_star = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    com.codename1.ui.Label gui_Label_cart = new com.codename1.ui.Label();
    Produit c ;
    Image icon; 
    Produit c2 ;
    Image icon2 ;
    Resources theme = UIManager.initFirstTheme("/theme");
       public ShopForm(Resources res) {

        //icon = res.getImage("skate-park.jpg").scaled(90, 90);
        //icon2 = res.getImage("bridge.jpg").scaled(90, 90);
        initGuiBuilderComponents(res);       

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Produit", "Title") 
                        //new Label("de commande N: "+Integer.toString(id), "Title")
                )
        );
         installSidemenu(res);
       } 
        
      private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setTitle("Nos Produits5");
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        
        
        
        for(int i=0;i<ServiceProduit.getInstance().getAllProduits().size();i++){
      
            /*EncodedImage placehorlder = EncodedImage.createFromImage(resourceObjectInstance.getImage("contact-a.png"), true);
            URLImage background = URLImage.createToStorage(placehorlder ,"http://localhost/WebProjectSymfony/Baskel/web/uploads/images/"+ServiceCommande.getInstance().getAllProduits().get(i).getImage(),
                    "http://localhost/WebProjectSymfony/Baskel/web/uploads/images/"+ServiceCommande.getInstance().getAllProduits().get(i).getImage() );*/
            
            
            
            int ref=ServiceProduit.getInstance().getAllProduits().get(i).getId_produit();
            String nom=ServiceProduit.getInstance().getAllProduits().get(i).getNom_produit();
            String imgPath=ServiceProduit.getInstance().getAllProduits().get(i).getPath();
            double prix=ServiceProduit.getInstance().getAllProduits().get(i).getPrix();
            int quantite = ServiceProduit.getInstance().getAllProduits().get(i).getQuantite_total();
            
           // background.scale(i, RIGHT);
            //ImageViewer img = new ImageViewer(background.fill(resourceObjectInstance.getImage("contact-a.png").getWidth()*2, resourceObjectInstance.getImage("contact-a.png").getHeight()*2));
            
            com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
            com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
            com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
            com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
            com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
            com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
            com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
            com.codename1.ui.Label gui_Label_ID = new com.codename1.ui.Label();
            com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
            com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
            com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
            com.codename1.ui.Label gui_Label_img = new com.codename1.ui.Label();
            com.codename1.ui.Label gui_Label_prix = new com.codename1.ui.Label();
            

            gui_Label_img.setText(ServiceProduit.getInstance().getAllProduits().get(i).getPath());
            gui_Label_prix.setText(Double.toString(ServiceProduit.getInstance().getAllProduits().get(i).getPrix()));
           
            
            addComponent(gui_Container_1);

           /**********************MY IMAAAAAAAAGE***********************/
           try {
               Image placeholderImage = FontImage.createMaterial(FontImage.MATERIAL_PERSON,"label",28);
                
              //  img.fill(placeholderImage.getWidth(),placeholderImage.getHeight());
                ImageViewer iv = new ImageViewer();
                Image img;
                           
                img = Image.createImage("file:///C:/xampp/htdocs/matchup/public/images/products/"+imgPath);
                
             
                
                iv.setImage(img.fill(placeholderImage.getWidth(),placeholderImage.getHeight()));
                
               //iv.setHeight(10);
                //iv.setImage(img.fill(placeholderImage.getWidth(), placeholderImage.getHeight()));
                //iv.getUnselectedStyle().setBgImage(img.fill(placeholderImage.getWidth(),placeholderImage.getHeight()));
                
                //iv.setImageInitialPosition(IMAGE_FILL);
               
               
                
                gui_Container_4.addComponent(iv);
                
                
                
                 } catch (IOException ex) {
               
            }
           
           
           
           
         
         
            gui_Label_ID.setText(Integer.toString(ref));
            gui_Container_1.setName("Container_1");
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Container_2);
            gui_Container_2.setName("Container_2");
            gui_Container_2.addComponent(gui_Label_1);
            //System.out.println(ServiceCommande.getInstance().getAllCommandes().get(i).getDate());
           // gui_Label_1.setText(Integer.toString(ServiceCommande.getInstance().ReadDetailsCommande(50).get(i).getQteProduit()));
            gui_Label_1.setUIID("SmallFontLabel");
            gui_Label_1.setName("Label_1");
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Container_4);
            gui_Container_4.setName("Container_4");
            ((com.codename1.ui.layouts.FlowLayout) gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
            
            gui_Label_4.setUIID("Padding2");
            gui_Label_4.setName("Label_4");
            gui_Label_4.setText("produits");
            gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_3);
            gui_Container_3.setName("Container_3");
            gui_Container_3.addComponent(gui_Label_3);
            gui_Container_3.addComponent(gui_Label_2);
            gui_Container_3.addComponent(gui_Text_Area_1);
            gui_Label_3.setText(nom);
            
           
            
            gui_Label_3.setName("Label_3");
            //gui_Label_3.setUIID("BigFontLabel");
            gui_Label_2.setText(Double.toString(prix)+" DN" );
            //gui_Label_2.setSize(new Dimension(30, 30));
           
            //gui_Label_2.setUIID("SmallFontLabel");
            gui_Label_2.getAllStyles().setFgColor(0xFF0000);
            gui_Label_2.setName("Label_2");
            
             if(quantite==0){
             gui_Text_Area_1.setText("-Hors stock-");
             }
            else {
                gui_Text_Area_1.setText("-En stock-");
            }
             
            //Button btnValider = new Button("Details");
          //  gui_Text_Area_1.setUIID("SmallFontLabel");
            gui_Text_Area_1.setName("Text_Area_1");
            gui_Container_2.setName("Container_2");
            gui_Container_4.setName("Container_4");
            ((com.codename1.ui.layouts.FlowLayout) gui_Container_4.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
            gui_Container_3.setName("Container_3");
            addComponent(gui_Label_6);
            //addComponent(btnValider);

            gui_Container_1.setName("Container_1");
            gui_Label_6.setText("");
            gui_Label_6.setUIID("Separator");
            gui_Label_6.setName("Label_6");
  
       /**********************************SOME STYYYYLE********************************************/
         
            gui_Container_3.getAllStyles().setPaddingTop(27);
           
            gui_Container_1.getAllStyles().setPaddingTop(32);
            gui_Container_1.getAllStyles().setPaddingLeft(25);
            
            gui_Label_3.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_LARGE));
       
            Border border = Border.createCompoundBorder(null, null, null, null);
            gui_Text_Area_1.getAllStyles().setBgTransparency(0);
            gui_Text_Area_1.getAllStyles().setBorder(border);
            gui_Text_Area_1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
            gui_Text_Area_1.setEditable(false);
            
            
        /**********************************EEND STYYYYLE********************************************/
        }
      }
       
    
}
