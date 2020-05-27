package repositories.doctor;

import managers.DBConnectionManager;
import model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DBDoctorRepository implements DoctorRepository {
    @Override
    public void addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors VALUES (NULL,?,?,?)";

        try(
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){
            statement.setString(1,doctor.getName());
            statement.setInt(2,doctor.getAge());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Doctor> findDoctorByName(String name) {
        String sql = "SELECT * FROM doctors WHERE name = ?";
        try(
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){
            statement.setString(1,name);

            ResultSet set = statement.executeQuery();

            if(set.next()){
                Doctor doctor = new Doctor();
                doctor.setId(set.getInt("id"));
                doctor.setName(set.getString("name"));
                doctor.setAge(set.getInt("age"));

                return  Optional.of(doctor);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
