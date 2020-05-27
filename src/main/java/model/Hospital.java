package model;

import repositories.sickness.ListSicknessRepository;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private int id;
    private  String name;
    List<String> doctorList = new ArrayList<>();

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

    public List<String> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<String> doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public String toString() {
        String out = "";
        out = id+","+ name;
        for(String it : doctorList){
            out += ","+it;
        }
        return out;
    }
}
