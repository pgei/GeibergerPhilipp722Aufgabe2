package main.application;

import main.model.Medikament;
import main.model.Patient;
import main.repository.InMemoryRepository;

import java.util.Scanner;

public class App {

    private final Controller controller;

    /**
     * Konstruktor für Anwendung.
     *
     * @param controller   Service-Klasse, die die Business-Logik abwickeln soll
     */
    public App(Controller controller) {
        this.controller = controller;
    }

    /**
     * Startet die Anwendung, zeigt das Hauptmenü an und verarbeitet Nutzereingaben inklusive grundlegender Eingabevalidierung
     */
    public void start() {
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println("++ Dr. House Krankenhausmanagement ++");
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("""
                    \n++++++++++++++++++++++++++++
                    Wähle eine Option
                    1. Erstelle Medikament
                    2. Rufe Medikament auf
                    3. Aktualisiere Medikament
                    4. Entferne Medikament
                    5. Erstelle Patient
                    6. Rufe Patient auf
                    7. Aktualisiere Patient
                    8. Entferne Patient
                    9. Filtere Patienten auf Diagnose
                    10. Beende Anwendung
                    ++++++++++++++++++++++++++++
                    """);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        controller.createDrug(scanner);
                        break;
                    case 2:
                        controller.getDrug(scanner);
                        break;
                    case 3:
                        controller.updateDrug(scanner);
                        break;
                    case 4:
                        controller.deleteDrug(scanner);
                        break;
                    case 5:
                        controller.createPatient(scanner);
                        break;
                    case 6:
                        controller.getPatient(scanner);
                        break;
                    case 7:
                        controller.updatePatient(scanner);
                        break;
                    case 8:
                        controller.deletePatient(scanner);
                        break;
                    case 9:
                        controller.filterDiagnosis(scanner);
                        break;
                    case 10:
                        System.out.println("System wird heruntergefahren!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice of option, please try again!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice, please only enter an integer number!");
            }
        }
    }

    /**
     * Die Hauptmethode zum Starten der App
     *
     * @param args  Argumente der Kommandozeile
     */
    public static void main(String[] args) {
        InMemoryRepository<Medikament> drugs = new InMemoryRepository<Medikament>();
        InMemoryRepository<Patient> patients = new InMemoryRepository<Patient>();
        Service s = new Service(drugs, patients);
        Controller c = new Controller(s);
        App application = new App(c);
        application.start();
    }

}
