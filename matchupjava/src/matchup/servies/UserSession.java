/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.servies;

/**
 *
 * @author tpc
 */

public class UserSession {
     private static UserSession instance;

    private int id;
    private String email;
    private String mdp;
    private String role;

    public UserSession(int id, String email, String mdp, String role) {
        this.id = id;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
    }

    public UserSession(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }


   

   

    public static UserSession getInstace( String email, String mdp) {
        if(instance == null) {
            instance = new UserSession(email, mdp);
        }
        return instance;
    }

    public static UserSession getInstance() {
        return instance;
    }
    public static void getInstance2() {
instance=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
    

 


    


