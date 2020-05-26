package repositories.doctor;

import model.Doctor;
import model.Pacient;

import java.util.Optional;

public interface DoctorRepository {

    enum Type{
        DB, FILE, ARRAY
    }

    void addDoctor(Doctor doctor);
    Optional<Doctor> findDoctorByName(String name);


    static DoctorRepository build(Type type){
        switch (type){
            //TODO: case DB: return new DBDoctorRepository();
            case FILE: return new FileDoctorRepository();
            case ARRAY: return new ListDoctorRepository();
        }
        throw new RuntimeException("No such type!");
    }
}
