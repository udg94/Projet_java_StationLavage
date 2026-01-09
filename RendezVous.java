/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StationLavage;

/**
 *
 * @author atton
 */

public class RendezVous {
    private Prestation prestation;
    private Client client;
    private double prix;

    public RendezVous(Client client, Prestation prestation) {
        this.client = client;
        this.prestation = prestation;
        this.prix = prestation.nettoyage();
}
    
    public double getPrix() {
        return prix;
}

    public void setPrix(double prix) {
        this.prix = prix;
} // Pour les prix
    
    public Client getClient() {
        return client;
}

    public void setClient(Client client) {
        this.client = client;
} // Pour les clients

    public Prestation getPrestation() {
        return prestation;
}
 
    public void setPrestation(Prestation prestation) {
        this.prestation = prestation;
} // Pour les prestas
    
}
