/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.GUI;

import com.codename1.components.InfiniteProgress;
import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.matchup.Services.ServiceTerrain;
import com.matchup.entities.Terrain;
import com.sun.mail.smtp.SMTPTransport;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Bedis
 */
public class ajouterterrainForm extends BaseForm {

       @Override
    protected boolean isCurrentterrain() {
        return true;
    }
    private Resources theme;
    
    TextField email;
    Form current;
    public ajouterterrainForm(Resources res){
        Toolbar tb =new Toolbar(true);
        current = this;
        setToolBar(tb);
        getTitle();
        getTitleArea().setUIID("Container");
        setTitle("Ajout terrain");
        getContentPane().setScrollVisible(false);
        
        
        TextField nomterrain = new TextField("", "nom terrain :");
        nomterrain.setUIID("Textfieldlack");
        addStringValue("nomTerrain",nomterrain);
      
        TextField emplacement = new TextField("", "emplacement :");
        emplacement.setUIID("Textfieldlack");
        addStringValue("emplacement",emplacement);
        
        TextField type = new TextField("", "type :");
        type.setUIID("Textfieldlack");
        addStringValue("type",type);
        
        TextField etat = new TextField("", "etat :");
        etat.setUIID("etat");
        addStringValue("etat",etat);
        
        email = new TextField("","entrez votre email",20,TextField.ANY);
        email.setSingleLineTextArea(false);
        email.setUIID("TextFieldBlack");
        addStringValue("email",email);
        
        Button btnAjouter = new Button("ajouter");
        addStringValue("", btnAjouter);
        btnAjouter.addActionListener((e) -> {
                try{
                    if(nomterrain.getText()=="" && etat.getText()=="non disponible"){
                        Dialog.show("Verifiez les données!","","Anuuler","Ok");
                    }
                    else {
                        InfiniteProgress ip = new InfiniteProgress();;
                        final Dialog iDialog = ip.showInfiniteBlocking();
                        Terrain t = new Terrain(String.valueOf(nomterrain.getText()
                        ).toString(),
                        String.valueOf(emplacement.getText()).toString(),
                        String.valueOf(type.getText()).toString(),
                        String.valueOf(etat.getText()).toString()
                        
                        );
                        System.out.println("data terrain =="+t);
                        ServiceTerrain.getInstance().ajouterterrain(t);
                        iDialog.dispose();
                        refreshTheme();
                        sendmail();
                        new ajouterterrainForm(theme).show();
                    }
                    
                }catch(Exception ex) {
                    ex.printStackTrace();
                }
                
        });
                
        
      installSidemenu(res);   
        
        
    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
        //add(createLineSeparator(0xeeeeee));
    }
    
    
    
    public void sendmail(){

    try{

        Properties props = new Properties();
                props.put("mail.transport.protocol", "smtp"); //SMTP protocol
        props.put("mail.smtps.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtps.auth", "true"); //enable authentication

                Session session = Session.getInstance(props,null);

                MimeMessage msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress("workit.noreplay2021@gmail.com"));
                msg.setRecipients(Message.RecipientType.TO, email.getText().toString());
                msg.setSubject("Terrain ajouté");
                //msg.setSentDate(new date(System.currentTimeMillis()));
                String txt =" votre terrain a éte ajouté avec succes";
                msg.setText(txt);


                SMTPTransport st = (SMTPTransport)session.getTransport("smtps");
                //st.connect("smtp.gmail",465,"workit.noreplay2021@gmail.com","workit.noreplay2021@gmail.com w");
                st.connect("smtp.gmail.com", 465, "work.itpidev@gmail.com", "Workit2021");
                st.sendMessage(msg, msg.getAllRecipients());
                System.out.println("server response"+st.getLastServerResponse());


    }catch(Exception e) {
        e.printStackTrace();

      }
    
}}
