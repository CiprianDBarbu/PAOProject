package exceptions;

public class InexistentDoctorFileException extends RuntimeException{

    public InexistentDoctorFileException() {
        super("DOCTORS file doesn't exist!");
    }
}
