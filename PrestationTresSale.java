/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StationLavage;

/**
 *
 * @author atton
 */
public class PrestationTresSale extends PrestationSale {

    private String salissure;

    public PrestationTresSale(char classeVehicule, String salissure) {
        super(classeVehicule);
        this.salissure = salissure;
}

    // Surcoût selon le type de salissure
    private double surcout() {
        if (salissure.equalsIgnoreCase("poils de chien")) {
            return 10;
        } 
        else if (salissure.equalsIgnoreCase("goudron")) {
            return 15;
        } 
        else if (salissure.equalsIgnoreCase("moustiques")) {
            return 20;
        }
        return 0;
}
// On est passé par une fonction parce que le dictionnaire c'était compliqué

/*    switch (salissure.toLowerCase()) {
    case "poils de chien":
        return 10;
    case "goudron":
        return 15;
    case "moustiques":
        return 20;
    default:
        return 0;
} On a le choix avec un switch case mais on part sur un If */

    public double nettoyage() {
        return super.nettoyage() + surcout();
}
    
    
    @Override
    public String toString() {
        return super.toString() +"-"+ String.valueOf(salissure);
    }
    
}
