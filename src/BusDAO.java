import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusDAO {
    public static void busDetail(int bus_no ) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "Select * from bus where bus_no = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setInt(1, bus_no);
        ResultSet resultSet = prepareStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("Your bus details for Bus id "+ bus_no + " are :\n");
            System.out.println("Bus NO: " + resultSet.getInt("bus_no"));
            System.out.println("Availability " + resultSet.getBoolean("is_available"));
            System.out.println("Total Seats: " + resultSet.getInt("capacity"));
        }
    }
    public static void All_bus() throws SQLException{
        Connection connection = DBConnection.getConnection();
        String query = "Select bus_no, source, destination from bus";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultset= preparedStatement.executeQuery();
        System.out.print("BusNO"+ " ");
        System.out.print("Source" + "  ");
        System.out.println("Destination"+ " ");
        while(resultset.next()){
            int id = resultset.getInt("bus_no");
            String source = resultset.getString("source");
            String destination = resultset.getString("destination");
            System.out.print(id+ "   ");
            System.out.print(source + "  ");
            System.out.println(destination+ " ");
        }
    }
    public static int CheckSeat(int bus_no) throws SQLException{
        Connection connection = DBConnection.getConnection();
        String query= "select capacity from bus where bus_no = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setInt(1, bus_no);
        ResultSet resultset = preparedStatement.executeQuery();
        if (resultset.next()) {
            return resultset.getInt("capacity");
        }
        return 0;
    }
}
