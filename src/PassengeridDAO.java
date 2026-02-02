import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassengeridDAO {
    public static void ShowPassengerID(String name, int age) throws SQLException {
        Connection connection =DBConnection.getConnection();
        String query ="Select pass_id from passengers where name = ? and age = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        ResultSet resultset = preparedStatement.executeQuery();

        if(resultset.next()){
            System.out.println("Your passenegr id is : "+ resultset.getInt("pass_id"));
        } else{
            System.out.println("Passenger id not found");
        }

    }

}
