package repositories.sickness;

import model.Sickness;

import java.util.Optional;

public interface SicknessRepository {

    enum Type{
        DB, FILE, LIST
    }

    void addSickness(Sickness sickness);
    Optional<Sickness> findSicknessByName(String name);


    static SicknessRepository build(Type type){
        switch (type){
            case DB: return new DBSicknessRepository();
            case FILE: return new FileSicknessRepository();
            case LIST: return new ListSicknessRepository();
        }
        throw new RuntimeException("No such type!");
    }
}
