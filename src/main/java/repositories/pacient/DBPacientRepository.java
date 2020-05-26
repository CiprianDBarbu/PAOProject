package repositories.pacient;

import managers.DBConnectionManager;
import model.Pacient;
import repositories.sickness.ListSicknessRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBPacientRepository implements PacientRepository{
    @Override
    public void addPacient(Pacient pacient) {
        String sql = "INSERT INTO pacients VALUES (NULL,?,?,?)";

        try(
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){
            statement.setString(1, pacient.getName());
            statement.setInt(2, pacient.getAge());
            String symptoms = "";
            List<String>symptList = pacient.getPersonalSymptoms();
            for(String it : symptList){
                symptoms += it + ",";
            }
            statement.setString(3,symptoms);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Pacient> findPacientByName(String name) {
        String sql = "SELECT * FROM pacients WHERE name = ?";
        try(
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
        ){
            statement.setString(1,name);

            ResultSet set = statement.executeQuery();

            if(set.next()){
                Pacient pacient = new Pacient();
                pacient.setId(set.getInt("id"));
                pacient.setName(set.getString("name"));
                pacient.setAge(set.getInt("age"));
                String symptList = set.getString("symptoms");
                String[] attr = symptList.split(",");
                List<String>symptoms = new ArrayList<>();
                for (int i = 0; i<attr.length; i++){
                    symptoms.add(attr[i]);
                }
                pacient.setPersonalSymptoms(symptoms);

                return Optional.of(pacient);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
