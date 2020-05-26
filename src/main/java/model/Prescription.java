package model;

import java.util.List;

public class Prescription {

    private List<Medicine> medicines;
    private float price;

    public Prescription(List<Medicine> medicines) {
        this.medicines = medicines;
        price = 0;
    }

    public List<Medicine> getMedicinesAgainst() {
        return medicines;
    }

    public void setMedicinesAgainst(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void calculatePrice(){
        for(Medicine it : medicines){
            price += it.getPrice();
        }
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "medicines=" + medicines +
                ", price=" + price +
                '}';
    }
}
