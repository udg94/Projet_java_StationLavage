/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StationLavage;

/**
 *
 * @author atton
 */

public class PrestationSale extends Prestation {

    public PrestationSale(char classeVehicule) {
        super(classeVehicule);
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
    double prix = 5;
    if (classeVehicule == 'B') prix *= 1.5;
    else if (classeVehicule == 'C') prix *= 1.75;
    return prix;
}

    @Override
    public double nettoyage() {
    double interieur = (classeVehicule == 'C') ? 40 : 30;
    return lavage() + sechage() + prelavage() + interieur;
}
// Pour la classeVehicule 'C' on a une méthode un peu différente mais quand on compare on voit que ça agit pareil
// C'était plus simple à écrire comme ça

}