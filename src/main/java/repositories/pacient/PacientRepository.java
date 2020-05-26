package repositories.pacient;

import model.Pacient;

import java.util.Optional;

public interface PacientRepository {

    enum Type{
        DB, FILE, LIST
    }

    void addPacient(Pacient pacient);
    Optional<Pacient> findPacientByName(String name);


    static PacientRepository build(Type type){
        switch (type){
            case DB: return new DBPacientRepository();
            case FILE: return new FilePacientRepository();
            case LIST: return new ListPacientRepository();
        }
        throw new RuntimeException("No such type!");
    }
}
