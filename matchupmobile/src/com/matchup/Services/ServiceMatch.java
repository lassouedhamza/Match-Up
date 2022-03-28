/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matchup.Services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;

import com.matchup.entities.Matchs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionListener;


import com.matchup.Utils.Statics;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hajer
 */
public class ServiceMatch {
      public ArrayList<Matchs> matchs;
    
    public static ServiceMatch instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceMatch() {
         req = new ConnectionRequest();
    }

    public static ServiceMatch getInstance() {
        if (instance == null) {
            instance = new ServiceMatch();
        }
        return instance;
    }
         
       public boolean addMatch(Matchs m) {
            DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
  
        String url = Statics.BASE_URL + "matchs/addMatchsJSON?nbjoueurs=" +  m.getNbjoueurs() + "&date=" +  d.format(m.getDate())+ "&type=" +  m.getType(); //création de l'URL
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
public ArrayList<Matchs> parseMatchs(String jsonText){
        try {
            matchs=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> matchsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
              
            List<Map<String,Object>> list = (List<Map<String,Object>>)matchsListJson.get("root");
            System.out.println(matchs);
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Matchs m = new Matchs();
                float IdMatch = Float.parseFloat(obj.get("idMatch").toString());
               
               m.setId_match((int)IdMatch);
               m.setNbjoueurs(((int)Float.parseFloat(obj.get("nbjoueurs").toString())));
               m.setType(obj.get("type").toString());
//               m.setDate((Date) obj.get("date"));


//                Ajouter la tâche extraite de la réponse Json à la liste
                matchs.add(m);
            } 
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return matchs;
    }
    public ArrayList<Matchs>  getAllMatchs() {
          String url = Statics.BASE_URL+"matchs/listmatchs";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                matchs = parseMatchs(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return matchs;
    }

    
}
