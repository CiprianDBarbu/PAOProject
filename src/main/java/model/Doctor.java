package model;

public class Doctor extends Person{


    public Doctor() {
    }

    public Doctor(int id, int age, String name) {
        super(id, age, name);
    }



    @Override
    public String toString() {
        return id+","+
                name+","+
                age+",";
    }


}
