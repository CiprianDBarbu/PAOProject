package model;

public class Appointment {

    enum State {
        GOINGTO,
        ONGOING,
        DONE
    }

    private int id;
    private Pacient pacient;
    private Doctor doctor;

    private State state;
    //private Date date; //the date of the apointment

}
