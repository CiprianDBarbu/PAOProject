package model;

import java.util.ArrayList;
import java.util.List;

public class Pacient extends Person{

    private List<String>personalSymptoms;   //pacientul are diferite simptome pe care doctorul le va studia
    private Sickness sickness;

    public Pacient(){
        personalSymptoms = new ArrayList<String>();
        sickness = null;
    }


    public List<String> getPersonalSymptoms() {
        return personalSymptoms;
    }

    public void setPersonalSymptoms(List<String> personalSymptoms) {
        this.personalSymptoms = personalSymptoms;
    }

    @Override
    public String toString() {
        String out = id+"," +
                name+","+
                age;
        for(String it : personalSymptoms){
            out = out + ","+it;
        }
        return out;
    }
}
