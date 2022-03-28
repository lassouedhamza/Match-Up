
package matchup.entities;


public class Parking {
    private  int id_parking ,id, nbdeplace ;
    private String adresse  ;
    public Parking(){

}

    public Parking(int id_parking, int id, int nbdeplace, String adresse) {
     this.id_parking = id_parking;
     this.id = id;
     this.nbdeplace = nbdeplace;
     this.adresse = adresse;
     //this.nom = nom;
    }

 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id_parking;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parking other = (Parking) obj;
        if (this.id_parking != other.id_parking) {
            return false;
        }
        return true;
    }

    public int getId_parking() {
        return id_parking;
    }

    public void setId_parking(int id_parking) {
        this.id_parking = id_parking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbdeplace() {
        return nbdeplace;
    }

    public void setNbdeplace(int nbdeplace) {
        this.nbdeplace = nbdeplace;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

  

    @Override
    public String toString() {
        return "Parking{" + "id_parking=" + id_parking + ", id=" + id + ", nbdeplace=" + nbdeplace + ", adresse=" + adresse +  '}';
    }
    

}



  


     

