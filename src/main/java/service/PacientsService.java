package service;

import model.Pacient;
import repositories.pacient.PacientRepository;

public class PacientsService {

    private PacientRepository pacientRepository;

    public PacientsService(){
        pacientRepository = PacientRepository.build(PacientRepository.Type.DB);
    }

    public void register(Pacient pacient){
        pacientRepository.addPacient(pacient);
    }
}
