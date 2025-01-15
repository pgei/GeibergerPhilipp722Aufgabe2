package main.application;

import main.model.Medikament;
import main.model.Patient;
import main.repository.InMemoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {

    /**
     * Repository für Medikamente
     */
    private final InMemoryRepository<Medikament> drugRepository;

    /**
     * Repository für Patienten
     */
    private final InMemoryRepository<Patient> patientRepository;

    /**
     * Konstruktor für Service-Klasse die Business-Logik verwaltet
     *
     * @param dRepository   Repository für Medikamente
     */
    public Service(InMemoryRepository<Medikament> dRepository, InMemoryRepository<Patient> pRepository) {
        this.drugRepository = dRepository;
        this.patientRepository = pRepository;
    }

    public void createDrug(String name, int price, String disease){
        if (!drugRepository.containsKey(name)) {
            drugRepository.create(new Medikament(name, price, disease));
        } else {
            System.out.println("Es existiert bereits ein Medikament mit diesem Namen!");
        }
    }

    public Medikament getDrug(String name) {return (Medikament) drugRepository.get(name);}

    public void updateDrug(String name, int price, String disease) {
        List<Patient> patients = patientRepository.getAll();
        Medikament updatedDrug = new Medikament(name, price, disease);
        for (Patient patient : patients) {
            for (Medikament m : patient.getDrugs()) {
                if (m.getId().equals(name)) {
                    patient.getDrugs().remove(m);
                    patient.getDrugs().add(updatedDrug);
                }
                break;
            }
        }
        drugRepository.update(updatedDrug);
    }

    public void deleteDrug(String name) {
        List<Patient> patients = patientRepository.getAll();
        for (Patient patient : patients) {
            for (Medikament m : patient.getDrugs()) {
                if (m.getId().equals(name)) {
                    patient.getDrugs().remove(m);
                }
                break;
            }
        }
        drugRepository.delete(name);
    }

    public void createPatient(int id, String name, int age, String diagnosis) {
        if (!patientRepository.containsKey(id)) {
            patientRepository.create(new Patient(id, name, age, diagnosis));
        } else {
            System.out.println("Es existiert bereits ein Patient mit dieser ID!");
        }
    }

    public Patient getPatient(int id) {
        return (Patient) patientRepository.get(id);
    }

    public void updatePatient(int id, String name, int age, String diagnosis, ArrayList<Medikament> list) {
        Patient patient = new Patient(id, name, age, diagnosis);
        patient.setDrugs(list);
        patientRepository.update(patient);
    }

    public void deletePatient(int id) {
        patientRepository.delete(id);
    }


}
