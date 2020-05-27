package main;

import gui.MainMenu;

public class Main {
    public static void main(String[] args) {

        /*//add pacients in list
        System.out.println("\nList of pacients:");
        ListPacientRepository listPacientRepository = new ListPacientRepository();
        Pacient p1 = new Pacient();
        p1.setId(1);
        p1.setName("Julius");
        p1.setAge(32);
        List<String> p1Symptoms = Arrays.asList("febra","dureri","roseata");
        p1.setPersonalSymptoms(p1Symptoms);

        Pacient p2 = new Pacient();
        p2.setId(2);
        p2.setName("Maximus");
        p2.setAge(17);
        List<String> p2Symptoms = Arrays.asList("febra","amorteala");
        p2.setPersonalSymptoms(p2Symptoms);

        Pacient p3 = new Pacient();
        p3.setId(3);
        p3.setName("Jonas");
        p3.setAge(68);
        List<String> p3Symptoms = Arrays.asList("febra","dureri","roseata","vedere pierduta");
        p3.setPersonalSymptoms(p3Symptoms);
        listPacientRepository.addPacient(p1);
        listPacientRepository.addPacient(p2);
        listPacientRepository.addPacient(p3);

        var pacientArray = listPacientRepository.getPacients();
        for(Pacient pacient : pacientArray){
            System.out.println(pacient);
        }



        //add pacients to PACIENTS file
        FilePacientRepository filePacientRepository = new FilePacientRepository();
        filePacientRepository.addPacient(p1);
        filePacientRepository.addPacient(p2);
        filePacientRepository.addPacient(p3);

        //add pacients to DB
        DBPacientRepository dbPacientRepository = new DBPacientRepository();
        *//*dbPacientRepository.addPacient(p1);
        dbPacientRepository.addPacient(p2);
        dbPacientRepository.addPacient(p3);*//*
        *//*PacientsService pacientsService = new PacientsService();
        pacientsService.register(p1);
        pacientsService.register(p2);
        pacientsService.register(p3);*//*


        System.out.println("TEST "+dbPacientRepository.findPacientByName("Julius"));

        //add medicines in list
        System.out.println("\nList of medicines:");
        ListMedicineRepository listMedicineRepository = new ListMedicineRepository();
        Medicine m1 = new Medicine(1,"Paracetamol",15);
        Medicine m2 = new Medicine(2,"Ibuprofen",20);
        Medicine m3 = new Medicine(3,"Nurofen forte", 35);
        listMedicineRepository.addMedicine(m1);
        listMedicineRepository.addMedicine(m2);
        listMedicineRepository.addMedicine(m3);
        var medicineArray = listMedicineRepository.getMedicines();
        for(Medicine it : medicineArray){
            System.out.println(it);
        }

        FileMedicineRepository fileMedicineRepository = new FileMedicineRepository();
        fileMedicineRepository.addMedicine(m1);
        fileMedicineRepository.addMedicine(m2);
        fileMedicineRepository.addMedicine(m3);
        System.out.println("TEST " + fileMedicineRepository.findMedicineByName("Nurofen forte"));

        //add doctors in list
        System.out.println("\nList of doctors:");
        ListDoctorRepository listDoctorRepository = new ListDoctorRepository();
        Doctor d1 = new Doctor(1,53,"Georgescu");
        Doctor d2 = new Doctor(2,64,"Ciomu");
        Doctor d3 = new Doctor(3,49,"Ionescu");
        listDoctorRepository.addDoctor(d1);
        listDoctorRepository.addDoctor(d2);
        listDoctorRepository.addDoctor(d3);
        var doctorArray = listDoctorRepository.getDoctors();
        for(Doctor it : doctorArray){
            System.out.println(it);
        }

        FileDoctorRepository fileDoctorRepository = new FileDoctorRepository();
        fileDoctorRepository.addDoctor(d1);
        fileDoctorRepository.addDoctor(d2);
        fileDoctorRepository.addDoctor(d3);
        System.out.println("TEST "+ fileDoctorRepository.findDoctorByName("Ciomu"));

        //add sicknesses in list
        System.out.println("\nList of sicknesses:");
        ListSicknessRepository listSicknessRepository = new ListSicknessRepository();
        List<String> s1Symptoms = Arrays.asList("febra","vedere pierduta");
        Sickness s1 = new Sickness(1,"Ebola",s1Symptoms,m1.getName());
        List<String> s2Symptoms = Arrays.asList("febra","anosmie","epuizare");
        Sickness s2 = new Sickness(2,"COVID",s2Symptoms,m2.getName());
        List<String> s3Symptoms = Arrays.asList("durere de burta","greata");
        Sickness s3 = new Sickness(3,"Indigestie",s3Symptoms,m2.getName());
        listSicknessRepository.addSickness(s1);
        listSicknessRepository.addSickness(s2);
        listSicknessRepository.addSickness(s3);
        var sicknessList = listSicknessRepository.getSicknesses();
        for(Sickness it : sicknessList){
            System.out.println(it);
        }

        FileSicknessRepository fileSicknessRepository = new FileSicknessRepository();
        fileSicknessRepository.addSickness(s1);
        fileSicknessRepository.addSickness(s2);
        fileSicknessRepository.addSickness(s3);
        System.out.println("TEST "+fileSicknessRepository.findSicknessByName("COVID"));
        */

        new MainMenu();
    }
}
