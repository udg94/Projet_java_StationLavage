/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StationLavage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author atton
 */

public class Etablissement {

    private String nom;
    private int nbClient;
    private int max_nb_client;
    private Client[] tab_Client;
    private RendezVous[][] planning;
    private LocalDateTime calendrier_first_date;
    private LocalDateTime calendrier_last_date;
    private int diff_day_start_end;
    
    // Constructeur
    public Etablissement(String nom, int max_nb_client) {
        this.nom = nom;
        this.max_nb_client = max_nb_client;
        this.nbClient = 0;
        this.tab_Client = new Client[max_nb_client];

        // 7 jours x 16 créneaux (10h → 18h, toutes les 30 min)
        this.calendrier_first_date = LocalDate.now().atTime(10, 0);
        this.calendrier_last_date = LocalDate.now().plusMonths(3).atTime(18, 0);
        
        int nb_day_start_and_end = (int) ChronoUnit.DAYS.between(calendrier_first_date, calendrier_last_date);
        this.diff_day_start_end = nb_day_start_and_end;
        this.planning = new RendezVous[nb_day_start_and_end][16];
        
    }

    // Recherche d'un client par nom et numéro
    public Client rechercher(String nom, String numeroTel) {
        for (int i = 0; i < nbClient; i++) {
            if (tab_Client[i].getNom().equalsIgnoreCase(nom)
                && tab_Client[i].getNumeroTel().equals(numeroTel)) {
                return tab_Client[i];
            }
        }
        return null;
    }

    // Ajouter un client sans email
    public Client ajouter(String nom, String numeroTel) {

        Client existant = rechercher(nom, numeroTel);
        if (existant != null) {
            System.out.println("Le client existe déjà : " + existant);
            return existant;
        }

        if (nbClient >= max_nb_client) {
            System.out.println("Nombre maximum de clients atteint");
            return null;
        }

        Client nouveau = new Client(nom, numeroTel);

        int i = nbClient - 1;
        while (i >= 0 && tab_Client[i].placerApres(nouveau)) {
            tab_Client[i + 1] = tab_Client[i];
            i--;
        }

        tab_Client[i + 1] = nouveau;
        nbClient++;
        return nouveau;
    }

    // Ajouter un client avec email
    public Client ajouter(String nom, String numeroTel, String email) {

        Client existant = rechercher(nom, numeroTel);
        if (existant != null) {
            System.out.println("Le client existe déjà : " + existant);
            return existant;
        }

        if (nbClient >= max_nb_client) {
            System.out.println("Nombre maximum de clients atteint");
            return null;
        }

        Client nouveau = new Client( nom,  numeroTel, email);
        // Regarder et documenter l'erreur

        int i = nbClient - 1;
        while (i >= 0 && tab_Client[i].placerApres(nouveau)) {
            tab_Client[i + 1] = tab_Client[i];
            i--;
        }

        tab_Client[i + 1] = nouveau;
        nbClient++;
        return nouveau;
    }
    
    public LocalDateTime rechercher(LocalDate date){
        LocalDateTime datetime = date.atTime(10, 0);
        if(datetime.isBefore(calendrier_first_date)){
            System.out.println("La date doit être après : " + calendrier_first_date.toString());
            return null;
        }
        
        if(datetime.isAfter(calendrier_last_date)){
            System.out.println("La date doit être avant : " + calendrier_first_date.toString());
            return null;
        }
        
        int diff_day= (int) ChronoUnit.DAYS.between(calendrier_first_date, datetime);
        System.out.println(diff_day);
        String sb = "";
        Boolean as_date = false;
        int[] heure_dispo = new int[17];
        java.util.Arrays.fill(heure_dispo, -1);
        heure_dispo[16] = 1;
        for(int i=0; i<16;i++){
            if(planning[diff_day][i]==null){
                sb += i+") "+(i*30/60+10)+"h "+ (i*30%60) +"min\n";
                as_date = true;
                heure_dispo[i] = 1;
            }
        }
        sb += 16+") aucune de ces heures";
        if(as_date){
            System.out.println("Selectioner une des heures disponilbe");
            System.out.println(sb);
            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();
            while((input>=0 && input<=16 ) && heure_dispo[input]== -1){
                System.out.println("choisicer une valeur donnée");
            }
            if(input==16){
                return null;
            }
            return datetime.plusMinutes(input*30);
        }
        System.out.println("Il n'y a aucune heure disponible");
        return null;
    }
    private int indiceJour(LocalDateTime dateTime) {
        return (int) ChronoUnit.DAYS.between(calendrier_first_date, dateTime);
    } 
    
    private int indiceCreneau(LocalDateTime dateTime) {
        int heure = dateTime.getHour();
        int minute = dateTime.getMinute();
        return (heure - 10) * 2 + (minute >= 30 ? 1 : 0);
    }
    
    public LocalDateTime rechercher(LocalTime time){
        time = time.withMinute(time.getMinute()< 30 ? 0 : 30);
        if(time.isBefore(LocalTime.of(9, 59))){
            System.out.println("La date doit être après 10h");
            return null;
        }
        if(time.isAfter(LocalTime.of(18, 1))){
            System.out.println("La date doit être avant 18h");
            return null;
        }
        int diff_time= (int) ChronoUnit.MINUTES.between(LocalTime.of(10, 0),time); 
        diff_time = diff_time/30;
        
        String sb = "";
        Boolean as_time = false;
        int[] date_dispo = new int[diff_day_start_end+1];
        java.util.Arrays.fill(date_dispo, -1);
        date_dispo[diff_day_start_end] = 1;
        for(int i=0; i<diff_day_start_end; i++){
            if(planning[i][diff_time]==null){
                sb += i+") "+calendrier_first_date.plusDays(i)+"\n";
                as_time = true;
                date_dispo[i] = 1;
            }
        }
        sb += diff_day_start_end+") aucune de ces heures";
        if(as_time){
            System.out.println("Selectioner un des jour disponible");
            System.out.println(sb);
            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();
            while((input>=0 && input<=diff_day_start_end ) && (date_dispo[input]==-1)){
                System.out.println("choisicer une valeur donnée");
            }
            if(input==diff_day_start_end){
                return null;
            }
            return calendrier_first_date.plusDays(input).plusMinutes(diff_time);
        }
        System.out.println("Il n'y a aucune heure disponible");
        return null;
    }
        public RendezVous ajouter(Client client, LocalDateTime dateTime, char classeVehicule, boolean lavageInterne) {
 
        int jour = indiceJour(dateTime);
        int creneau = indiceCreneau(dateTime);
 
        Prestation prestation = new PrestationExpress(classeVehicule, lavageInterne);
 
        RendezVous rdv = new RendezVous(client, prestation);
 
        planning[jour][creneau] = rdv;
 
        return rdv;
    }
    
    public RendezVous ajouter(Client client, LocalDateTime dateTime, char classeVehicule) {
    int jour = indiceJour(dateTime);
    int creneau = indiceCreneau(dateTime);
    Prestation prestation = new PrestationSale(classeVehicule);
    RendezVous rdv = new RendezVous(client, prestation);
    planning[jour][creneau] = rdv;
    return rdv;
    } 
    
    
    public RendezVous ajouter(Client client, LocalDateTime dateTime, char classeVehicule, String salissure) {
    int jour = indiceJour(dateTime);
    int creneau = indiceCreneau(dateTime);
    Prestation prestation = new PrestationTresSale(classeVehicule, salissure);
    RendezVous rdv = new RendezVous(client, prestation);
    planning[jour][creneau] = rdv;
    return rdv;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Etablissement : ").append(nom).append("\n");
        sb.append("Clients :\n");

        for (int i = 0; i < nbClient; i++) {
            sb.append(tab_Client[i]).append("\n");
        }

        return sb.toString();
    }
}
