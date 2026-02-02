import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassengerDAO {
    public static void passengerDetail(String name, int age, int amount, int bus_no, int No ) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "Insert into passengers(name, age, amount, bus_id, No_of_tickets) values (?, ?, ?, ?, ?)";
        PreparedStatement prepareStatement= connection.prepareStatement(query);
        prepareStatement.setString(1, name);
        prepareStatement.setInt(2, age);
        prepareStatement.setInt(3, amount);
        prepareStatement.setInt(4, bus_no);
        prepareStatement.setInt(5,No);
        int rowsAffected =prepareStatement.executeUpdate();
        if(rowsAffected>0){
            System.out.print("");
        } else{
            System.out.println("Sorry for the inconvinence caused, can't book right now ! ");
        }
        String query1 = "update bus set capacity = capacity - ? where bus_no =?";
        PreparedStatement prepareStatement1 = connection.prepareStatement(query1);
        prepareStatement1.setInt(1,No);
        prepareStatement1.setInt(2,bus_no);

        int updatedRows = prepareStatement1.executeUpdate();

        if (updatedRows > 0) {

            System.out.println("Ticket booked successfully");
            PassengeridDAO.ShowPassengerID(name, age);
        } else {
            System.out.println("Seat update failed");
        }
    }
}
