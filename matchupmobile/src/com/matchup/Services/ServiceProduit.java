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
import com.matchup.entities.Produit;
import com.matchup.Utils.Statics;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Asus
 */
public class ServiceProduit {
    
   public ArrayList<Produit> prodList;
    //singleton 
   public static ServiceProduit instance=null;
   public boolean resultOK;
   public ConnectionRequest req;
  
  public ServiceProduit() {
         req = new ConnectionRequest();
    }
    public static ServiceProduit getInstance() {
        if (instance == null) {
            instance = new ServiceProduit();
        }
        return instance;
    }
 public ArrayList<Produit> parseProduits(String jsonText) throws Exception {  
    
      try {
            prodList = new ArrayList<>();
            
            JSONParser j = new JSONParser();      
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));          
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
           //System.out.println(prodList);
            for(Map<String,Object> obj : list){
                Produit p = new Produit();
                
                float id = Float.parseFloat(obj.get("idProduit").toString());
                p.setId_produit((int)id);
                String nom_produit = (String) obj.get("nom_produit");
                p.setNom_produit((String)nom_produit);
                
                try{
                   double prix= Double.parseDouble(obj.get("prix").toString());
                   int prix2 = (int) prix;
                   p.setPrix(prix2);
                   
                } catch (NumberFormatException ex){ 
                 System.out.println(ex);
                }
                
                try{
                   double quantite_total= Double.parseDouble(obj.get("quantite_total").toString());
                   int quantite_total2 = (int) quantite_total;
                   p.setQuantite_total(quantite_total2);
                   
                } catch (NumberFormatException ex){ 
                 //System.out.println(ex);
                }
                try{
                   double quantite_restant= Double.parseDouble(obj.get("quantite_restant").toString());
                   int quantite_restant2 = (int) quantite_restant;
                   p.setQuantite_restant(quantite_restant2);
                   
                } catch (NumberFormatException ex){ 
                 //System.out.println(ex);
                }
            
                String description = (String) obj.get("description");
                p.setDescription((String)description);
                
                String path = (String) obj.get("path");
                p.setPath((String)path);
                
                prodList.add(p);
            }
            
            
        } catch (IOException ex) {
            //System.out.println("ex");
       
       }
        return prodList;
        
        
    }
  
//    
    public ArrayList<Produit> getAllProduits(){
        String url = Statics.BASE_URL+"produit/getproduct";
        //System.out.println("*** "+url);
        req.setUrl(url);
        req.setPost(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
             @Override
            public void actionPerformed(NetworkEvent evt) {
              
                try {
                   // System.out.println("*** ...");
                    //System.out.println(req.getResponseData());
                    prodList = parseProduits(new String(req.getResponseData()));
                } catch (Exception ex) {
                    //System.out.println(ex);
                  //  Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return prodList;
    }
       

  
    
}


