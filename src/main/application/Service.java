package main.application;

import main.model.Medikament;
import main.repository.InMemoryRepository;

import java.util.List;

public class Service {

    /**
     * Repository für Medikamente
     */
    private final InMemoryRepository<Medikament> drugRepository;

    /**
     * Konstruktor für Service-Klasse die Business-Logik verwaltet
     *
     * @param dRepository   Repository für Medikamente
     */
    public Service(InMemoryRepository<Medikament> dRepository) {
        this.drugRepository = dRepository;
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
        Medikament updatedDrug = new Medikament(name, price, disease);
        drugRepository.update(updatedDrug);
    }

    public void deleteDrug(String name) {
        drugRepository.delete(name);
    }


}
