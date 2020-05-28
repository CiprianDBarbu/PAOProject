package service;

import model.Appointment;
import model.Medicine;
import model.Prescription;
import model.Sickness;
import repositories.medicine.FileMedicineRepository;

import java.util.ArrayList;
import java.util.List;

public class TreatPacient {
    private List<String>pacientSymptoms = Appointment.getInstance().getPacient().getPersonalSymptoms();
    private List<Sickness>sicknesses = new SicknessesService().getAllSicknesses();
    private List<String>medicines = new ArrayList<>();
    private float total;
    private List<String>believedSicknesses = new ArrayList<>();

    public void treat(){
        for(String pacientS:pacientSymptoms){
            for(Sickness sickness : sicknesses){
                if(sickness.getSymptoms().contains(pacientS)) {
                    if (believedSicknesses.contains(sickness.getName()) == false) {
                        believedSicknesses.add(sickness.getName());
                        medicines.add(sickness.getMedicineAgainst());
                    }
                }
                }
            }
        Appointment.getInstance().setSicknesses(believedSicknesses);
        }


    public void calculateSum(){
        for(String med:medicines){
            Medicine medicine = new FileMedicineRepository().findMedicineByName(med);
            total = total + medicine.getPrice();

            List<Medicine>medicinesList = new ArrayList<>();
            for(String it :medicines){
                medicinesList.add(new FileMedicineRepository().findMedicineByName(it));
            }
            Appointment.getInstance().setPrescription(new Prescription(medicinesList,total));
        }
    }

}
