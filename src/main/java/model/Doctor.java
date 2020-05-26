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
                age;
    }

    public void checkSickness(Pacient pacient){
        //verifica prin lista de boli si daca min 2 simptome ale pacientului seamana cu cele ale unei boli ii scire boala
    }
}
