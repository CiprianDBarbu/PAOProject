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

        String sql = "INSERT INTO medicines VALUES(NULL,?,?)";

        try(
                Connection con = DBConnectionManager.getInstance().createConnection();
                PreparedStatement statement = con.prepareStatement(sql);
                ){
            statement.setString(1, medicine.getName());
            statement.setFloat(2, medicine.getPrice());

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
                Medicine medicine = new Medicine();
                medicine.setId(set.getInt("id"));
                medicine.setName(set.getString("name"));
                medicine.setPrice(set.getFloat("price"));

                return  Optional.of(medicine);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
