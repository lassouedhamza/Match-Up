/*
 * Copyright (c) 2016, Codename One
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

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MediaPlayer;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;

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
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.matchup.Services.ServiceUtilisateur;
import com.sun.mail.smtp.SMTPTransport;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class email extends BaseForm {

      TextField email;
    public email() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }


    @Override
    protected boolean isCurrentInbox() {
        return true;
    }
    
  
        
    
        
    
     
    public email(com.codename1.ui.util.Resources resourceObjectInstance) {
          Style s = UIManager.getInstance().getComponentStyle("Title");
        
        FontImage exitVideo = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, s);
        getToolbar().addCommandToLeftBar(new Command("", exitVideo) {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                       System.out.println("tay...");
                     //  media.pause();
                       new SignInForm().show();
                    }
                
                });
     email= new TextField("", "saisir votre email");
       
         
        addAll(email);
                Button btnValider = new Button("Valider");
                    btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Resources res = null;
              
            sendMail(res);
            
                
                
            }
        });
                add(btnValider);
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Mot de passe oublié", "Title")
                )
        );
        
        //installSidemenu(resourceObjectInstance);
        
       // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});
        
       
          
       
    }
    
     public void sendMail(Resources  res){
        
    try{
      Properties props = new Properties();  
      
      props.put("mail.transport.protocol","smtp");
      props.put("mail.smtps.host","smtp.gmail.com");
      props.put("mail.smtps.auth","true"); 
      
      Session session =Session.getInstance(props,null);
      MimeMessage msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress("upmatch4@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO,email.getText().toString());
    msg.setSubject("mot de passe");
    msg.setSentDate(new Date(System.currentTimeMillis()));
    String mp =ServiceUtilisateur.getInstance().getPasswordByEmail(email.getText(),res) ;
    
    String txt = "Bienvenue sur Matchup: Tapez ce mot de passe:"+ mp +"dans le champs requis et appuiez sur confirmer";
     msg.setText(txt);
     SMTPTransport st  = (SMTPTransport) session.getTransport("smtps");
      
     st.connect("smtp.gmail.com",465,"upmatch4@gmail.com","matchup2021@");
     
     st.sendMessage(msg,msg.getAllRecipients());
     
        System.err.println("server response:" +st.getLastServerResponse());
     
    }catch(Exception e){
        e.printStackTrace();
    }
    } 
    
    
}


