package model;

import repositories.doctor.ListDoctorRepository;

import java.util.ArrayList;
import java.util.List;

public class Sickness {

    private int id;
    private String name;
    private List<String>symptoms;
    private String medicineAgainst;


    public Sickness(){
        symptoms = new ArrayList<String>();
    }

    public Sickness(int id, String name, List<String> symptoms, String medicineAgainst) {
        this.id = id;
        this.name = name;
        this.symptoms = symptoms;
        this.medicineAgainst = medicineAgainst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public String getMedicineAgainst() {
        return medicineAgainst;
    }

    public void setMedicineAgainst(String medicineAgainst) {
        this.medicineAgainst = medicineAgainst;
    }

    @Override
    public String toString() {
        String out;
        out = id+","+
                name+","+
                medicineAgainst;
        for(String it : symptoms){
            out += "," + it;
        }
        return out;
    }
}
