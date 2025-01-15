package main.model;

import java.util.ArrayList;

public class Patient implements ID {

    private final int id;
    private String name;
    private int age;
    private String diagnosis;
    private ArrayList<Medikament> drugs;

    public Patient(int id, String name, int age, String diagnosis) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.drugs = new ArrayList<>();
    }

    @Override
    public Object getId() {return this.id;}
    public String getName() {return this.name;}
    public int getAge() {return this.age;}
    public String getDiagnosis() {return this.diagnosis;}
    public ArrayList<Medikament> getDrugs() {return this.drugs;}

    public void setDrugs(ArrayList<Medikament> drugs) {this.drugs = drugs;}

    /**
     * Methode die einen menschenlesbaren String für die Inhalte des Objektes generiert
     *
     * @return  String der Inhalt des Objektes darstellt
     */
    @Override
    public String toString() {
        return "Patient "+this.id+": (Name "+this.name+", Alter "+this.age+", Diagnose "+this.diagnosis+" Medikamente "+this.drugs.toString()+")";
    }

}
