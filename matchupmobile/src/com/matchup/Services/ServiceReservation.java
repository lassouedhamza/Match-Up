/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.Services;

import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionListener;

import com.matchup.entities.Reservation;
import com.matchup.Utils.Statics;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Asus
 */
public class ServiceReservation {
    
    private ArrayList<Reservation> resvList;
    //singleton 
  public static ServiceReservation instance=null;
  public boolean resultOK;
  private ConnectionRequest req;
  
  private ServiceReservation() {
         req = new ConnectionRequest();
         this.resvList = new ArrayList<Reservation>();
    }
    public static ServiceReservation getInstance() {
        if (instance == null) {
            instance = new ServiceReservation();
        }
        return instance;
    }
    
        public boolean addReservation(Reservation r) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
        String url = Statics.BASE_URL + "reservationparking/addReservationJSON??Dated=" +  df.format(r.getDate_d()) + "&Datef=" +  df.format(r.getDate_f()); //création de l'URL
        System.out.println("^^^^ ===> " + url);
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
  public ArrayList<Reservation> parseReservations(String jsonText) {  
    
      try {
          
          String cleaned_json = jsonText.substring(jsonText.indexOf("["));
          System.out.println(cleaned_json);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
            Date date_d, date_f;
//            java.sql.Date date_d_sql = null;
//            java.sql.Date date_f_sql = null;
            JSONParser j = new JSONParser();      
            Map<String,Object> reservationListJson = j.parseJSON(new CharArrayReader(cleaned_json.toCharArray()));          
            System.out.println("---------------");
            System.out.println(reservationListJson.get("root"));
            System.out.println("---------------");
            List<Map<String,Object>> list = (List<Map<String,Object>>)reservationListJson.get("root");
            System.out.println(list);

            for(Map<String,Object> obj : list){
                System.out.println(obj);
                System.out.println(obj.get("idrsvpark"));
                String dated = obj.get("Dated").toString().substring(6,obj.get("Dated").toString().indexOf(" "));
                String datef = obj.get("Datef").toString().substring(6,obj.get("Datef").toString().indexOf(" "));
                System.out.println(obj.get("Email"));
                Reservation R = new Reservation();
                float idrsvparking = Float.parseFloat(obj.get("idrsvpark").toString());  
                R.setIdrsvparking((int)idrsvparking); 
//                
//               float id_parking = Float.parseFloat(obj.get("id_parking").toString());
//                R.setId_parking((int)id_parking);
//                
//                float id = Float.parseFloat(obj.get("id").toString());
//                R.setId((int)id);
//                R.setEmail(obj.get("email").toString());
                date_d = df.parse(dated);
                date_f = df.parse(datef);
//                Date date_d  = Date.parseDate(obj.get("date_d").toString());
//                date_d_sql = new java.sql.Date(date_d.getTime());
//                date_f_sql = new java.sql.Date(date_f.getTime());
                R.setDate_d(date_d);
                   
//                Date date_f  = Date.parseDate(obj.get("date_f").toString());
                R.setDate_f(date_f);
               this.resvList.add(R);                
////                }
            if (this.resvList == null){System.out.println("****55");}else{System.out.println("****66655");
                System.out.println(this.resvList);}
            }
            
        } catch (Exception ex) {
            System.out.println("114===> " + ex);
       
       }
        return this.resvList;
    }
  
//    
    public ArrayList<Reservation> getAllReservations(){
        String url = Statics.BASE_URL+"reservationparking/getReservation";
       System.out.println("*** "+url);
        req.setUrl(url);
        req.setPost(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
             @Override
            public void actionPerformed(NetworkEvent evt) {
              
                try {
                    System.out.println("*** ...");
                    System.out.println(new String(req.getResponseData()));
                                        System.out.println("*** ...");

                    resvList = parseReservations(new String(req.getResponseData()));
                } catch (Exception ex) {
                    System.out.println("Exception in Parsing");
                  //  Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resvList;
    }
    
    }    
  
    
  