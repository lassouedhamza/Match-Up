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
import com.codename1.ui.events.ActionListener;
import com.matchup.entities.Terrain;
import com.matchup.Utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bedis
 */
public class ServiceTerrain {
    public static ServiceTerrain instance = null ;
    public ArrayList<Terrain> terrains;
    public Terrain terrain;
    
   
           
    private ConnectionRequest req;
    
    public  static ServiceTerrain getInstance(){
        if(instance == null)
            instance = new ServiceTerrain();
        return instance;
    }
    public ServiceTerrain(){
        req = new ConnectionRequest();
    }
    
    //ADD TERRAIN
    public void ajouterterrain(Terrain terrain){
    String url =Statics.BASE_URL+"terrain/addTerrainJSON?etat="+terrain.getEtat()+"&nomTerrain="+terrain.getNomTerrain()+"&type="+terrain.getType() ;
    req.setUrl(url);
    req.addResponseListener((e) ->{
        String str = new String(req.getResponseData());
        System.out.print("data == "+str);
    });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
//SHOW TERRAIN
    
      public ArrayList<Terrain> parseTasks(String jsonText) {
        try {
            terrains = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
             */
            Map<String, Object> entreprisesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
             */
            List<Map<String, Object>> list = (List<Map<String, Object>>) entreprisesListJson.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
         Terrain re = new Terrain();
                        float idTerrain = Float.parseFloat(obj.get("idTerrain").toString());
                               re.setIdTerrain((int) idTerrain);
                        String Nomter = obj.get("nomTerrain").toString();
                        String Emplacement = obj.get("emplacement").toString();
                        String Etat = obj.get("etat").toString();
                        String Type = obj.get("type").toString();
                        re.setNomTerrain(Nomter);
                        re.setEmplacement(Emplacement);
                        re.setEtat(Etat);
                        re.setType(Type);
                //Ajouter la tâche extraite de la réponse Json à la liste
                terrains.add(re);
               
            }

        } catch (IOException ex) {

        }
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        return terrains;
    }
      
         public ArrayList<Terrain> getAllTerrains() {
        String url = Statics.BASE_URL + "terrain/allterrain";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                terrains = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return terrains;
    }


    
}