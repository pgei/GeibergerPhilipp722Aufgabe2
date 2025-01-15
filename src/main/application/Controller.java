package main.application;

import main.model.Medikament;

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



}
