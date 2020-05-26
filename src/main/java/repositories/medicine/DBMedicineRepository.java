package repositories.medicine;

import managers.DBConnectionManager;
import model.Medicine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DBMedicineRepository implements  MedicineRepository{
    @Override
    public void addMedicine(Medicine medicine) {

        String sql = "INSERT INTO medicines VALUES(NULL,?)";

        try(
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){
            statement.setString(1, Integer.toString(medicine.getId()));
            statement.setString(2, medicine.getName());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Medicine> findMedicineByName(String name) {

        String sql = "SELECT * FROM medicines WHERE name = ?";

        try(
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){
            statement.setString(1, name);

            ResultSet set = statement.executeQuery();

            if(set.next()){
                int id = set.getInt("id");
                String u = set.getString("name");
                float pr = set.getFloat("price");

                return  Optional.of(new Medicine(id,u,pr));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
