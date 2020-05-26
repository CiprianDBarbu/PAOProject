package repositories.medicine;

import exceptions.InexistentMedicineFileException;
import model.Medicine;
import service.AuditService;
import service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileMedicineRepository implements MedicineRepository {

    private final String file = "MEDICINES";

    @Override
    public void addMedicine(Medicine medicine) {
        FileService fileService = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        auditService.writeLog("Medicine added to " + file);
        fileService.addToFile(file, medicine.toString());
    }

    @Override
    public Optional<Medicine> findMedicineByName(String name) {
        Path path = Paths.get(file);
        Medicine medicine = null;

        try {
            if (!Files.exists(path)) {
                throw new InexistentMedicineFileException();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String[] attr = u.split(",");
                if (attr[1].equals(name)) {
                    medicine = new Medicine();
                    medicine.setId(Integer.parseInt(attr[0]));
                    medicine.setName(attr[1]);
                    medicine.setPrice(Float.parseFloat(attr[2]));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(medicine);
    }
}
