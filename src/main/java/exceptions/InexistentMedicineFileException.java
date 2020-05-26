package exceptions;

public class InexistentMedicineFileException extends RuntimeException{

    public InexistentMedicineFileException() {
        super("MEDICINE file doesn't exist!");
    }

}
