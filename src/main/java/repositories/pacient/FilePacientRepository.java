package repositories.pacient;

import exceptions.InexistentPacientFileException;
import model.Pacient;
import service.AuditService;
import service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilePacientRepository implements PacientRepository {

    private final String file = "PACIENTS";

    @Override
    public void addPacient(Pacient pacient) {
        FileService fileService = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        auditService.writeLog("Pacient added to "+file);
        fileService.addToFile(file,pacient.toString());
    }

    @Override
    public Optional<Pacient> findPacientByName(String name) {

        Path path = Paths.get(file);
        Pacient pacient = null;

        try{
            if(!Files.exists(path)){
                throw new InexistentPacientFileException();
            }
            var list = Files.readAllLines(path);
            for(String u : list){
                String [] attr = u.split(",");
                if(attr[1].equals(name)) {
                    pacient = new Pacient();
                    pacient.setId(Integer.parseInt(attr[0]));
                    pacient.setName(attr[1]);
                    pacient.setAge(Integer.parseInt(attr[2]));
                    List<String> symp = new ArrayList<>();
                    for (int i = 3; i < attr.length; i++) {
                        symp.add(attr[i]);
                    }
                    pacient.setPersonalSymptoms(symp);
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(pacient);
    }


}
