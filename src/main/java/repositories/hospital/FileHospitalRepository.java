package repositories.hospital;

import exceptions.InexistentHospitalFileException;
import model.Hospital;
import service.AuditService;
import service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileHospitalRepository implements HospitalRepository {

    private final  String file = "HOSPITALS";

    @Override
    public void addHospital(Hospital hospital) {
        FileService fileService = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        auditService.writeLog("Hospital added to "+file);
        fileService.addToFile(file, hospital.toString());
    }

    @Override
    public Optional<Hospital> findHospitalByName(String name) {
        Path path = Paths.get(file);
        Hospital hospital = new Hospital();

        try{
            if(!Files.exists(path)){
                throw new InexistentHospitalFileException();
            }
            var list = Files.readAllLines(path);
            for (String u : list){
                String[] attr = u.split(",");

                if(attr[1].equals(name)){
                    hospital.setId(Integer.parseInt(attr[0]));
                    hospital.setName(attr[1]);
                    List<String> docs = new ArrayList<>();
                    for(int i = 3; i < attr.length; i++){
                        docs.add(attr[i]);
                    }
                    hospital.setDoctorList(docs);
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(hospital);
    }
}
