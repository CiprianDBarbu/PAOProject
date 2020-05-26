package repositories.medicine;

import model.Medicine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListMedicineRepository implements  MedicineRepository {

    private List<Medicine> medicines = new ArrayList<>();

    @Override
    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    @Override
    public Optional<Medicine> findMedicineByName(String name) {
        for(Medicine it : medicines){
            if(it.getName().equals(name)){
                return Optional.of(it);
            }
        }

        return Optional.empty();
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }
}
