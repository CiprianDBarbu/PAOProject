package repositories.doctor;

import model.Doctor;
import model.Pacient;

import java.util.Optional;

public interface DoctorRepository {

    enum Type{
        DB, FILE, LIST
    }

    void addDoctor(Doctor doctor);
    Optional<Doctor> findDoctorByName(String name);


    static DoctorRepository build(Type type){
        switch (type){
            case DB: return new DBDoctorRepository();
            case FILE: return new FileDoctorRepository();
            case LIST: return new ListDoctorRepository();
        }
        throw new RuntimeException("No such type!");
    }
}
