package com.matchup.GUI;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.matchup.Services.ServiceUtilisateur;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class SignUpForm extends BaseForm {

    
    
    
    public SignUpForm(Resources res) {
           Style s = UIManager.getInstance().getComponentStyle("Title");
        
        FontImage exitVideo = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, s);
     TextField nom = new TextField("","nom");
        TextField email = new TextField("","email");
        TextField mdp = new TextField("","mot de passe");
        TextField prenom = new TextField("","prenom");
        TextField age = new TextField("","age");
        TextField adresse = new TextField("","adresse");
        TextField genre = new TextField("","genre");
        addAll(nom, email, prenom, age, adresse, genre);
                Button btnValider = new Button("Valider");
               
//                    btnValider.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//              //  Product p = new Product(tfLibelle.getText(), tfMarque.getText(),
//            //             Float.valueOf(tfPrix.getText()));
//            //    addProduct(p);
//            //    System.out.println("*****************************\n");
//            //    for (Product produit : getAllProducts())
//            //        System.out.println(produit);
//                
//                
//            }
//        });
btnValider.addActionListener(e -> {
    ServiceUtilisateur.getInstance().signup(nom, prenom,email,mdp,age,adresse,genre, res);
});




                add(btnValider);
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Singup", "Title")
                )
        );
       getToolbar().addCommandToLeftBar(new Command("", exitVideo) {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                       System.out.println("tay...");
                     //  media.pause();
                       new SignInForm().show();
                    }
                
                });
        
//        installSidemenu(resourceObjectInstance);
//        
//        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        
       
        
       
    }

    SignUpForm() {
      
    }



}