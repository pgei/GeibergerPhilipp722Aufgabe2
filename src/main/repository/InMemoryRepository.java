package main.repository;

import main.model.ID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Klasse, die ein Repository abbildet, welches Daten im Speicher lagert, wobei die CRUD-Methoden des Interfaces IRepository implementiert werden.
 *
 * @param <T>   Typ der Objekte, die in diesem Repository gespeichert werden sollen, wobei dieser eine einzigartige ID zur Verfügung stellen muss (siehe {@link ID})
 */
public class InMemoryRepository<T extends ID> {

    /**
     * HashMap in der die Daten des Repositories gespeichert werden
     */
    private final Map<Object,T> repository = new HashMap<>();

    /**
     * Erzeugt ein neues Objekt im Repository, falls dieses dort noch nicht gespeichert wurde
     *
     * @param object    Objekt das im Repository erzeugt werden soll
     */
    public void create(T object) {
        this.repository.putIfAbsent(object.getId(), object);
    }

    /**
     * Abruf eines Objektes das im Repository gespeichert ist über die ID
     *
     * @param id    Einzigartige ID des Objektes das abgerufen werden soll
     * @return      Objekt aus dem Repository oder null, wenn kein Objekt mit der gegebenen ID gefunden wurde
     */
    public T get(Object id) {
        return this.repository.get(id);
    }

    /**
     * Aktualisiert ein bereits existierendes Objekt im Repository
     *
     * @param object    Objekt das aktualisiert werden soll
     */
    public void update(T object) {
        this.repository.replace(object.getId(),object);
    }

    /**
     * Entfernt ein Objekt aus dem Repository, falls es unter der gegebenen ID gefunden werden kann
     *
     * @param id    Einzigartige ID des Objektes das gelöscht werden soll
     */
    public void delete(Object id) {
        this.repository.remove(id);
    }

    /**
     * Abruf aller im Repository gespeicherten Objekte
     *
     * @return  Liste aller Objekte im Repository
     */
    public List<T> getAll() {
        return this.repository.values().stream().toList();
    }

    /**
     * Kontrolliert, ob eine ID schon im Repository schon vergeben worden ist
     *
     * @return  Wahr, wenn bereits ein Objekt mit der gegebenen ID im Repository existiert, sonst falsch
     */
    public boolean containsKey(Object key) {
        return this.repository.containsKey(key);
    }

}
