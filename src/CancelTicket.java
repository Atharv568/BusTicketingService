import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancelTicket {
    public static void cancelTicket(int pass_id) throws SQLException {
        Connection connection =DBConnection.getConnection();
        String query= "Delete from passengers where pass_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, pass_id);
        int rowsAffected = preparedStatement.executeUpdate();
        if(rowsAffected>0){
            System.out.print("Your ticket is successfully cancelled");
        } else {
            System.out.print("Retry Again");
        }
    }
}
