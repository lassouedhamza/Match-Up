/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.matchup.GUI.HomeForm;
import com.matchup.GUI.ShopForm;
import com.matchup.GUI.SignInForm;
import com.matchup.GUI.SignUpForm;
import com.matchup.Utils.Statics;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author tpc
 */
public class ServiceUtilisateur {
   
    
    public static ServiceUtilisateur instance =null;
    public static boolean resultOK = true;
    public String json;
    
    private ConnectionRequest req;
    public static ServiceUtilisateur getInstance(){
        if(instance== null)
            instance = new ServiceUtilisateur();
        return instance;
    }
   
    
    public ServiceUtilisateur(){
        req = new ConnectionRequest();
    }
    
    //signup
    public void signup(TextField nom ,TextField prenom ,TextField email ,TextField mdp ,TextField age ,TextField adresse ,TextField genre ,Resources rs){
     
        Vector<String> vectorRole;
        vectorRole = new Vector();
        vectorRole.add("user");
        
        ComboBox<String>roles = new ComboBox<>(vectorRole);
        
        String url = Statics.BASE_URL+"api/signup?nom="+nom.getText()+"&email="+email.getText()+"&prenom="+prenom.getText()+"&mdp="+mdp.getText()+"&age="+age.getText()+"&adresse="+adresse.getText()+"&genre="+genre.getText();
        
     req.setUrl(url);
     
        if (nom.getText().equals("")){
            Dialog.show("erreur", "veuillez remplir les champs", "ok",null);
        }
        else{
        
        req.addResponseListener ((e)-> {
            byte[]data =(byte[]) e.getMetaData();
            String responseData = new String(data);
            System.out.println("data ===>"+responseData);
            new SignInForm(rs).show();
            
        }
        );
        
        
      NetworkManager.getInstance().addToQueueAndWait(req);
        
        
    }
    }
      private Resources theme;
 public void signin(TextField email ,TextField mdp ){
     String url = Statics.BASE_URL+"api/signin?email="+email.getText()+"&mdp="+mdp.getText();
     
     req=new ConnectionRequest(url, false);
     req.setUrl(url);
     req.addResponseListener((e) ->{
         JSONParser j = new JSONParser();
         
         String json = new String(req.getResponseData())+"";
         try{
             if(json.equals("failed")){
                 Dialog.show("Echec d'authentification","Username ou mot de passe éronné","ok",null);
             }
             else {
                 System.out.println("data =="+json);
                 Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
               theme = UIManager.initFirstTheme("/theme");
            
             //if(user.size()>0)
                 new ShopForm(theme).show();
             
             }
             
         }catch(Exception ex){
             ex.printStackTrace();
         }
     });
     NetworkManager.getInstance().addToQueueAndWait(req);
 }   
   
public String getPasswordByEmail(String email ,Resources res ){
   
   
     String url = Statics.BASE_URL+"api/getmdpByEmail?email="+email;
     System.err.println(email);
     req=new ConnectionRequest(url, false);
     req.setUrl(url);
     req.addResponseListener((e) ->{
         JSONParser j = new JSONParser();
         
        String json = new String(req.getResponseData())+"";
    
         try{
            
             if(json.equals("user not found")){
                 Dialog.show("Echec ","email non valide","ok",null);
             }
             else {
                 System.out.println("data =="+json);
                
//                Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
            
             //if(user.size()>0)
                 new SignInForm().show();
             }
             
             
         }catch(Exception ex){
             ex.printStackTrace();
         }
     });
   NetworkManager.getInstance().addToQueueAndWait(req);
   
     return json;
 }    
}
    
    
    
    
    
    
    

