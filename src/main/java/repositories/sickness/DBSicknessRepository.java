package repositories.sickness;

import managers.DBConnectionManager;
import model.Sickness;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBSicknessRepository implements SicknessRepository {
    @Override
    public void addSickness(Sickness sickness) {
        String sql = "INSERT INTO sicknesses VALUES (NULL,?,?,?)";

        try(
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){
            statement.setString(1,sickness.getName());
            statement.setString(2,sickness.getMedicineAgainst());
            String symptoms = "";
            List<String>symptList = sickness.getSymptoms();
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
    public Optional<Sickness> findSicknessByName(String name) {
        String sql = "SELECT * FROM sicknesses WHERE name = ?";

        try(
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){
            statement.setString(1,name);

            ResultSet set = statement.executeQuery();

            if(set.next()){
                Sickness sickness = new Sickness();
                sickness.setId(set.getInt("id"));
                sickness.setName(set.getString("name"));
                sickness.setMedicineAgainst(set.getString("medicine"));
                String symptList = set.getString("symptoms");
                String[] attr = symptList.split(",");
                List<String>symptoms = new ArrayList<>();
                for (int i = 0; i<attr.length; i++){
                    symptoms.add(attr[i]);
                }
                sickness.setSymptoms(symptoms);

                return   Optional.of(sickness);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
