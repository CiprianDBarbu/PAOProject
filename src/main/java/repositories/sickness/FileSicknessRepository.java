package repositories.sickness;

import exceptions.InexistentPacientFileException;
import exceptions.InexistentSicknessFileException;
import model.Medicine;
import model.Pacient;
import model.Sickness;
import service.AuditService;
import service.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FileSicknessRepository implements SicknessRepository {

    private final String file = "SICKNESSES";

    @Override
    public void addSickness(Sickness sickness) {
        FileService fileService = FileService.getInstance();
        AuditService auditService = AuditService.getInstance();
        auditService.writeLog("Sickness added to "+file);
        fileService.addToFile(file,sickness.toString());
    }

    @Override
    public Optional<Sickness> findSicknessByName(String name) {
        Path path = Paths.get(file);
        Sickness sickness = null;

        try{
            if(!Files.exists(path)){
                throw new InexistentSicknessFileException();
            }
            var list = Files.readAllLines(path);
            for(String u : list){
                String [] attr = u.split(",");
                if(attr[1].equals(name)) {
                    sickness = new Sickness();
                    sickness.setId(Integer.parseInt(attr[0]));
                    sickness.setName(attr[1]);
                    sickness.setMedicineAgainst(attr[2]);
                    List<String> symp = new ArrayList<>();
                    for (int i = 3; i < attr.length; i++) {
                        symp.add(attr[i]);
                    }
                    sickness.setSymptoms(symp);
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(sickness);
    }
}

