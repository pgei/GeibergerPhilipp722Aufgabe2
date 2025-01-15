package main.model;

public class Medikament implements ID {

    private final String name;
    private int price;
    private String disease;

    /**
     * Konstruktor eines Medikament-Objektes
     *
     * @param name      Name, der dem Medikament zugewiesen werden soll, fungiert auch als Identifier (Id)
     * @param price     Preis des Medikaments
     * @param disease   Krankheit die mit dem Medikament behandelt wird
     */
    public Medikament(String name, int price, String disease) {
        this.name = name;
        this.price = price;
        this.disease = disease;
    }

    @Override
    public String getId() {return this.name;}
    public int getPrice() {return this.price;}
    public String getDisease() {return this.disease;}

    public void setPrice(int price) {this.price = price;}
    public void setDisease(String disease) {this.disease = disease;}

    /**
     * Methode die einen menschenlesbaren String für die Inhalte des Objektes generiert
     *
     * @return  String der Inhalt des Objektes darstellt
     */
    @Override
    public String toString() {
        return "Medikament "+this.name+": (Preis "+this.price+", Krankheit "+this.disease+")";
    }


}
