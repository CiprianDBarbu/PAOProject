package repositories.sickness;

import model.Sickness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListSicknessRepository implements SicknessRepository {

    private List<Sickness>sicknesses = new ArrayList<>();

    @Override
    public void addSickness(Sickness sickness) {
        sicknesses.add(sickness);
    }

    @Override
    public Optional<Sickness> findSicknessByName(String name) {
        for(Sickness it : sicknesses){
            if(it.getName().equals(name)){
                return Optional.of(it);
            }
        }
        return Optional.empty();
    }

    public List<Sickness> getSicknesses() {
        return sicknesses;
    }
}
