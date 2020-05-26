package exceptions;

public class InexistentHospitalFileException extends RuntimeException {

    public InexistentHospitalFileException(){super("HOSPITAL file doesnt exist!");}
}
