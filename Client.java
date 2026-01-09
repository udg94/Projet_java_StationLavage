/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StationLavage;
import java.time.LocalDate;

/*
 *
 *
 * @author atton
 */

public class Client {
    
    private static int nbClient = 0; // Initialiser compteur clients
    
    private String nom;
    private String numeroTel;
    private int IdClient;
    private String email;
        
  public Client(String nom, String numeroTel) {
    nbClient++;
    this.IdClient = nbClient;
    this.nom = nom;
    this.numeroTel = numeroTel;
    this.email = null;
}

public Client(String nom, String numeroTel, String email) {
    this(nom, numeroTel); // appelle le premier constructeur
    this.email = email;
}
// Documenter l'erreur dans le rapport
    
    public String getNom() {
        return this.nom;
}
    public void setNom(String nom) {
        this.nom = nom;
}
    // Pour les noms
   
    public int getIdClient() {
        return this.IdClient;
}
    public void setIdClient(int IdClient) {
        this.IdClient = IdClient;
}
    // Pour les IDClients
    
    public String getNumeroTel() {
        return this.numeroTel;
}
    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
}
    // Pour les numero de tel
    
    public String getEmail() {
        return this.email;
}
    public void setEmail(String email) {
        this.email = email;
}
    // Pour les email
    
/*    public boolean placerApres(Client autre) {
        return this.getIdClient().compareTo(autre.getIdClient()) > 0;
} // ça marche pas parce que getID est deja un int */
    
    public boolean placerApres(Client autre) {
        int cmp = this.nom.compareToIgnoreCase(autre.nom);
        if (cmp != 0) return cmp > 0;
        return this.numeroTel.compareTo(autre.numeroTel) > 0;
} 
// Si on comprend bien il faut classer par nom pour l'ordre lexicographique
// NB: Les clients peuvent avoir le même nom, on rajoute la comparaison du numéro de tel au cas où

@Override  // à vérifier
public String toString() {
    if (email == null) {
        return IdClient + " : " + nom + " : " + numeroTel;
    }
    return IdClient + " : " + nom + " : " + numeroTel + " : " + email;
} // Ici le toString sert à afficher un client, on a le cas avec et sans mail

}
