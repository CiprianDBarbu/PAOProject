package model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private int id;
    private  String name;

    //private Doctor[] doctorList = new Doctor[100];

    List<Doctor> doctorList = new ArrayList<>();    //isi creeaza lista de doctori cu cei care exista in repository

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

    /*
    public Doctor[] getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(Doctor[] doctorList) {
        this.doctorList = doctorList;
    }
    */

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
