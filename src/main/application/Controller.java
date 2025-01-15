package main.application;

import main.model.Medikament;
import main.model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void createDrug(Scanner scanner) {
        System.out.println("Bitte gebe den Namen an:");
        String name = scanner.nextLine();
        System.out.println("Bitte gebe den Preis an:");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Bitte gebe die Krankheit an:");
        String disease = scanner.nextLine();
        service.createDrug(name, price, disease);
    }

    public void getDrug(Scanner scanner) {
        System.out.println("Bitte gebe den Namen an:");
        String searchname = scanner.nextLine();
        if (service.getDrug(searchname) != null) {
            System.out.println(service.getDrug(searchname).toString());
        } else {
            System.out.println("Kein Medikament mit diesem Namen existiert!");
        }
    }

    public void updateDrug(Scanner scanner) {
        System.out.println("Bitte gebe den Namen des Produktes an:");
        Medikament drug = service.getDrug(scanner.nextLine());
        if (drug != null) {
            System.out.println("Folgende Daten sind gespeichert:");
            System.out.println(drug);
            System.out.println("Bitte gebe den neuen Preis an:");
            int price2 = Integer.parseInt(scanner.nextLine());
            System.out.println("Bitte gebe die neue Krankheit an:");
            String disease = scanner.nextLine();
            service.updateDrug(drug.getId(), price2, disease);
        } else {
            System.out.println("Kein Produkt mit diesem Namen existiert!");
        }
    }

    public void deleteDrug(Scanner scanner) {
        System.out.println("Bitte gebe den Namen an:");
        service.deleteDrug(scanner.nextLine());
    }

    public void createPatient(Scanner scanner) {
        System.out.println("Bitte gebe die Id ein:");
        int patientid = Integer.parseInt(scanner.nextLine());
        System.out.println("Bitte gebe den Namen an:");
        String name = scanner.nextLine();
        System.out.println("Bitte gebe das Alter an:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Bitte gebe die Diagnose an:");
        service.createPatient(patientid, name, age, scanner.nextLine());
    }

    public void getPatient(Scanner scanner) {
        System.out.println("Bitte gebe die Id an:");
        int searchid = Integer.parseInt(scanner.nextLine());
        if (service.getPatient(searchid) != null) {
            System.out.println(service.getPatient(searchid).toString());
        } else {
            System.out.println("Kein Patient it dieser Id existiert!");
        }
    }

    public void updatePatient(Scanner scanner) {
        System.out.println("Bitte gebe die Id ein:");
        Patient patient = service.getPatient(Integer.parseInt(scanner.nextLine()));
        if (patient != null) {
            System.out.println("Folgende Daten sind gespeichert:");
            System.out.println(patient);
            System.out.println("Bitte gebe den neuen Namen an:");
            String newname = scanner.nextLine();
            System.out.println("Bitte gebe das neue Alter an:");
            int newage = Integer.parseInt(scanner.nextLine());
            System.out.println("Bitte gebe die neue Diagnose an:");
            String newdiagnosis = scanner.nextLine();
            System.out.println("Bitte gebe den Namen des neuen Medikaments an:");
            Medikament newdrug = service.getDrug(scanner.nextLine());
            if (newdrug != null) {
                ArrayList<Medikament> list = patient.getDrugs();
                list.add(newdrug);
                service.updatePatient((int) patient.getId(), newname, newage, newdiagnosis, list);
            } else {
                System.out.println("Kein solches Medikament existiert!");
            }
        } else {
            System.out.println("Kein Patient mit dieser Id existiert!");
        }
    }

    public void deletePatient(Scanner scanner) {
        System.out.println("Bitte gebe die Id an:");
        service.deletePatient(Integer.parseInt(scanner.nextLine()));
    }



}
