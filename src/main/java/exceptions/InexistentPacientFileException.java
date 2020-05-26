package exceptions;

public class InexistentPacientFileException extends  RuntimeException{

    public InexistentPacientFileException(){super("PACIENTS file doesnt exist!");}
}
