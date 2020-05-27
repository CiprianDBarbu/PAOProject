package repositories.hospital;

import model.Hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListHospitalRepository implements HospitalRepository{

    private List<Hospital>hospitals = new ArrayList<>();

    @Override
    public void addHospital(Hospital hospital) {
        hospitals.add(hospital);
    }

    @Override
    public Optional<Hospital> findHospitalByName(String name) {
        for(Hospital it : hospitals){
            if(it.getName().equals(name)){
                return Optional.of(it);
            }
        }
        return Optional.empty();
    }
}
