package repositories.hospital;

import managers.DBConnectionManager;
import model.Hospital;
import model.Pacient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBHospitalRepository implements HospitalRepository{

    @Override
    public void addHospital(Hospital hospital) {
        String sql = "INSERT INTO hospitals VALUES (NULL,?,?)";

        try(
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ){
            statement.setString(1, hospital.getName());
            String docs = "";
            List<String> docsList = hospital.getDoctorList();
            for(String it : docsList){
                docs += it + ",";
            }
            statement.setString(2,docs);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Hospital> findHospitalByName(String name) {
        String sql = "SELECT * FROM hospitals WHERE name = ?";
        try(
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ){
            statement.setString(1,name);

            ResultSet set = statement.executeQuery();

            if(set.next()){
               Hospital hospital = new Hospital();
                hospital.setId(set.getInt("id"));
                hospital.setName(set.getString("name"));
                String docsList = set.getString("doctors");
                String[] attr = docsList.split(",");
                List<String>doctors = new ArrayList<>();
                for (int i = 0; i<attr.length; i++){
                    doctors.add(attr[i]);
                }
                hospital.setDoctorList(doctors);

                return Optional.of(hospital);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
