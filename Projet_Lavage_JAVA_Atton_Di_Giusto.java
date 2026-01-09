/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package StationLavage;

import java.time.LocalDateTime;

/**
 *
 * @author atton
 */
public class Projet_Lavage_JAVA_Atton_Di_Giusto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    // Test Classe Client
    Client c1 = new Client("Pierre", "0612345678");
    Client c2 = new Client("Ugo", "0678978960", "ugo@efrei.net");
    Client c3 = new Client("Ugo", "0600000000");

    System.out.println("Test des constructeurs + toString : ");
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);

    System.out.println("Test de placerApres : ");

    System.out.println("c1 après c2 ? : " + c1.placerApres(c2));

    System.out.println("c2 après c1 ? : " + c2.placerApres(c1));

    System.out.println("c1 après c3 ? : " + c1.placerApres(c3)); // true ou false selon le numéro

    System.out.println("c3 après c1 ? : " + c3.placerApres(c1));

    Client c4 = new Client("Pierre", "0612345678");

    System.out.println("Test clients identiques :");
    System.out.println("c1 après c4 ? : " + c1.placerApres(c4)); 
    System.out.println("c4 après c1 ? : " + c4.placerApres(c1)); 

    // Test PrestationExpress
    PrestationExpress p1 = new PrestationExpress('A', false);
    System.out.println("Express A sans intérieur : " + p1.nettoyage() + " €");
    
    PrestationExpress p2 = new PrestationExpress('A', true);
    System.out.println("Express A avec intérieur : " + p2.nettoyage() + " €");

    PrestationExpress p3 = new PrestationExpress('B', true);
    System.out.println("Express B avec intérieur : " + p3.nettoyage() + " €");

    PrestationExpress p4 = new PrestationExpress('C', true);
    System.out.println("Express C avec intérieur : " + p4.nettoyage() + " €");

    // Test PrestationSale
    PrestationSale s1 = new PrestationSale('A');
    System.out.println("Sale A : " + s1.nettoyage() + " €");
    
    PrestationSale s2 = new PrestationSale('B');
    System.out.println("Sale B : " + s2.nettoyage() + " €");
    
    PrestationSale s3 = new PrestationSale('C');
    System.out.println("Sale C : " + s3.nettoyage() + " €");
    
    // Test PrestationTresSale
    PrestationTresSale t1 = new PrestationTresSale('A', "poils de chien");
    System.out.println("Très sale A (poils de chien) : " + t1.nettoyage() + " €");
    
    PrestationTresSale t2 = new PrestationTresSale('B', "goudron");
    System.out.println("Très sale B (goudron) : " + t2.nettoyage() + " €");
    
    PrestationTresSale t3 = new PrestationTresSale('C', "moustiques");
    System.out.println("Très sale C (moustiques) : " + t3.nettoyage() + " €");
    
    // NB : La classe Prestation on la teste pas elle est abstract
    
    // Test des RDV

    Prestation prestation1 = new PrestationExpress('B', true);

    RendezVous rdv1 = new RendezVous(c1, prestation1);

    System.out.println("Client du rendez-vous : " + rdv1.getClient());
    System.out.println("Prix du rendez-vous : " + rdv1.getPrix() + " €");

    Prestation prestation2 = new PrestationTresSale('C', "goudron");
    RendezVous rdv2 = new RendezVous(c2, prestation2);

    System.out.println("\nDeuxième rendez-vous :");
    System.out.println("Client : " + rdv2.getClient());
    System.out.println("Prix : " + rdv2.getPrix() + " €");
    
    
    
    Etablissement station = new Etablissement("Station Lavage Centrale", 10);
    LocalDateTime lundi10h = LocalDateTime.of(2026, 1, 10, 10, 0);
    LocalDateTime lundi11h = LocalDateTime.of(2026, 2, 12, 11, 0);
    RendezVous rdv3 = station.ajouter(c1, lundi10h, 'A', true);
    System.out.println("Rendez-vous 3 : " + rdv3.getPrix() + " €");
    RendezVous rdv4 = station.ajouter(c2, lundi11h, 'B');
    System.out.println("Rendez-vous 4 : " + rdv4.getPrix() + " €");
    
    

    //station.rechercher(lundi10h.toLocalDate());
    station.rechercher(lundi11h.toLocalTime());
    
    
    }
    
}
