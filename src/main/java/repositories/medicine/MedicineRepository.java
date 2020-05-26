package repositories.medicine;

import model.Medicine;

import java.util.Optional;

public interface MedicineRepository {
    enum Type{
        DB, FILE, LIST
    }

    void addMedicine(Medicine medicine);
    Optional<Medicine> findMedicineByName(String name);

    static MedicineRepository build(Type type){
        switch (type){
            case DB: return new DBMedicineRepository();
            case FILE: return  new FileMedicineRepository();
            case LIST: return new ListMedicineRepository();
        }

        throw new RuntimeException("No such type!");
    }
}
