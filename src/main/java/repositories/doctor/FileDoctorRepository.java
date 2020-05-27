package repositories.doctor;

import exceptions.InexistentDoctorFileException;
import exceptions.InexistentMedicineFileException;
import model.Doctor;
import model.Medicine;
import service.AuditService;
import service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileDoctorRepository implements DoctorRepository{

    private final String file = "DOCTORS";

    @Override
    public void addDoctor(Doctor doctor) {
        FileService fileService = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        auditService.writeLog("Doctor added to " + file);
        fileService.addToFile(file, doctor.toString());
    }

    @Override
    public Optional<Doctor> findDoctorByName(String name) {
        Path path = Paths.get(file);
        Doctor doctor = null;

        try {
            if (!Files.exists(path)) {
                throw new InexistentDoctorFileException();
            }
            var list = Files.readAllLines(path);
            for (String u : list) {
                String[] attr = u.split(",");

                if (attr[1].equals(name)) {
                    doctor = new Doctor();
                    doctor.setId(Integer.parseInt(attr[0]));
                    doctor.setName(attr[1]);
                    doctor.setAge(Integer.parseInt(attr[2]));

                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(doctor);
    }
}
