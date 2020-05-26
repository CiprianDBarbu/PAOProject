package repositories.pacient;

import model.Pacient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListPacientRepository implements PacientRepository {

    private List<Pacient> pacients = new ArrayList<>();
    private int n;

    @Override
    public void addPacient(Pacient pacient) {
        pacients.add(pacient);
    }

    @Override
    public Optional<Pacient> findPacientByName(String name) {
        for(Pacient it : pacients){
            if(it.getName().equals(name)){
                return Optional.of(it);
            }
        }

        return Optional.empty();
    }

    public List<Pacient> getPacients() {
        return pacients;
    }
}
