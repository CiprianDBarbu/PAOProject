package repositories.doctor;

import model.Doctor;
import repositories.medicine.ListMedicineRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListDoctorRepository implements DoctorRepository {

    private List<Doctor>doctors = new ArrayList<>();

    @Override
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public Optional<Doctor> findDoctorByName(String name) {
        for(Doctor it : doctors){
            if(it.getName().equals(name)){
                return Optional.of(it);
            }
        }
        return Optional.empty();
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}
