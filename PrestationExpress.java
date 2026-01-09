/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StationLavage;

/**
 *
 * @author atton
 */

public class PrestationExpress extends Prestation {
    
    private boolean lavageInterne;

    public PrestationExpress(char classeVehicule, boolean lavageInterne) {
    super(classeVehicule);
    this.lavageInterne = lavageInterne;
}

    @Override
    public double lavage() {
    double prix = 20;
    if (classeVehicule == 'B') prix *= 1.5;
    else if (classeVehicule == 'C') prix *= 1.75;
    return prix;
}

    @Override
    public double sechage() {
    double prix = 10;
    if (classeVehicule == 'B') prix *= 1.05;
    else if (classeVehicule == 'C') prix *= 1.10;
    return prix;
}

    @Override
    public double prelavage() {
    return 0;
}

    @Override
    public double nettoyage() {
    double total = lavage() + sechage();
    if (lavageInterne) {
        if (classeVehicule == 'C') total += 40;
        else total += 30;
    }
    return total;
    }
    
        
    @Override
    public String toString() {
        return super.toString() +"-"+ String.valueOf(lavageInterne);
    }

}
