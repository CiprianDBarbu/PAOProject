package exceptions;

public class InexistentSicknessFileException extends RuntimeException {
    public InexistentSicknessFileException(){super("SICKNESSES file doesnt exist!");}
}
