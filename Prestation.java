/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StationLavage;

/**
 *
 * @author atton
 */
public abstract class Prestation {
    protected char 
        classeVehicule; // A, B ou C

    public Prestation(char classeVehicule) {
        this.classeVehicule = classeVehicule;
    }

    public abstract double nettoyage();
    public abstract double lavage();
    public abstract double sechage();
    public abstract double prelavage();
    
    @Override
    public String toString() {
        return String.valueOf(this.classeVehicule);
    }
}
/* 
La classe prestation est abstract et toutes les méthodes seront définies 
dans les sous-classes, on a besoin de rien d'autre ici.
*/