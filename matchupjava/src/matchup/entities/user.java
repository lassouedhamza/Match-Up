/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchup.entities;

/**
 *
 * @author tpc
 */
public class user {
        private int id;
    private String nom;
    private String prenom;
    private  String email ;
    private  String mdp ;
    private  String adresse ;
    private  int age ;
    private  String genre ;
//    private String role;
    private String roles;
 private int  is_verified;
    public user() {
    }

    public user(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }
    
    public user( String nom, String prenom , String email , String mdp ,  String adresse ,  int age ,  String genre  ) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp ;
        this.adresse = adresse;
        this.age = age;
        this.genre = genre ;
//        this.role = role;
        
    }

    public user(int id, String nom, String prenom, String email, String mdp, String adresse, int age, String genre, String roles) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.age = age;
        this.genre = genre;
        this.roles = roles;
    }
 public user(int id, String nom, String prenom, String email, String mdp, String adresse, int age, String genre) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.age = age;
        this.genre = genre;
        
    }


//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
    

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }



    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getAge() {
        return age;
    }

    public String getGenre() {
        return genre;
    }



    public user(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getIs_verified() {
        return is_verified;
    }

    public void setIs_verified(int is_verified) {
        this.is_verified = is_verified;
    }



    @Override
    public String toString() {
        return "utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp + ", adresse=" + adresse + ", age=" + age + ", genre=" + genre + '}';
    }
    
}
