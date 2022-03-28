/*
 * Copyright (c) 2021, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.matchup.GUI;


import com.codename1.capture.Capture;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.matchup.Services.ServiceMatch;
import com.matchup.entities.Matchs;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.BRB_OTHER;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.Date;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class AddMatch extends com.codename1.ui.Form {

    public AddMatch(Form previous) {
       
        setTitle("Ajouter un nouveau match");
        setLayout(BoxLayout.y());
         TextField tftype = new TextField("", "Type");
        TextField tfdate = new TextField("", "Date");
        TextField tfnbjoueurs = new TextField("", "Nombre de joueurs");
          Button btncapture= new Button("Ajouter Image");
         
      Button btnValider = new Button("Ajouter Match");


                  Label limage = new Label();
                         
btncapture.addActionListener((e)->{
       String path= Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
      
       if(path != null){
           try {
               Image img=Image.createImage(path);
               limage.setIcon(img);
               revalidate();
           } catch (IOException ex) {
             ex.printStackTrace();
           }
       }
        
    });
        
        
        btnValider.addActionListener(new ActionListener() {
            String type,date, nbjoueurs;
            Date d;
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tftype.getText().length()==0)||(tfdate.getText().length()==0)||(tfnbjoueurs.getText().length()==0))
                    Dialog.show("Alerte", "Veuillez remplir tous les champs", new Command("OK"));
                else
                {
                    try {
                        d = df.parse(tfdate.getText());
                        date = df.format(d);                       
//                        System.out.print(date);  
                        
                        type=tftype.getText();
//                        System.out.print(type); 
                        
                          nbjoueurs=tfnbjoueurs.getText();
                                              
                      
                      
                      Matchs m = new Matchs(type, d, BRB_OTHER);
                        if( ServiceMatch.getInstance().addMatch(m))
                            Dialog.show("Succès","Match ajouté avec succès",new Command("OK"));
                        else
                            Dialog.show("Erreur", "Erreur du serveur", new Command("OK"));
                    } catch (Exception e) {
                        System.out.print("*");
                        System.out.print(e);
                        Dialog.show("Erreur", "La date doit être écrit sous la forme DD-MM-YYYY", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tftype,tfdate,tfnbjoueurs,btncapture,limage,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
    }
  
}



   

   
    
    
    