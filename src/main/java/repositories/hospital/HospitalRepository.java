package repositories.hospital;

import model.Doctor;
import model.Hospital;
import repositories.doctor.DBDoctorRepository;
import repositories.doctor.DoctorRepository;
import repositories.doctor.FileDoctorRepository;
import repositories.doctor.ListDoctorRepository;

import java.util.Optional;

public interface HospitalRepository {
    enum Type{
        DB, FILE, LIST
    }

    void addHospital(Hospital hospital);
    Optional<Hospital> findHospitalByName(String name);


    static HospitalRepository build(HospitalRepository.Type type){
        switch (type){
            case DB: return new DBHospitalRepository();
            case FILE: return new FileHospitalRepository();
            case LIST: return new ListHospitalRepository();
        }
        throw new RuntimeException("No such type!");
    }
}
