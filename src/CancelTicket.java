import java.sql.*;

public class CancelTicket {

    public static void cancelTicket(int pass_id) throws SQLException {

        Connection connection = DBConnection.getConnection();

        // 1️⃣ Get bus_id and ticket count
        String findQuery =
                "SELECT bus_id, No_of_tickets FROM passengers WHERE pass_id = ?";
        PreparedStatement findPs = connection.prepareStatement(findQuery);
        findPs.setInt(1, pass_id);

        ResultSet rs = findPs.executeQuery();

        if (!rs.next()) {
            System.out.println("❌ No passenger found with ID: " + pass_id);
            return;
        }

        int busId = rs.getInt("bus_id");
        int tickets = rs.getInt("No_of_tickets");

        // 2️⃣ Delete passenger
        String deleteQuery = "DELETE FROM passengers WHERE pass_id = ?";
        PreparedStatement deletePs = connection.prepareStatement(deleteQuery);
        deletePs.setInt(1, pass_id);
        deletePs.executeUpdate();

        // 3️⃣ Restore seats
        String updateQuery =
                "UPDATE bus SET capacity = capacity + ? WHERE bus_no = ?";
        PreparedStatement updatePs = connection.prepareStatement(updateQuery);
        updatePs.setInt(1, tickets);
        updatePs.setInt(2, busId);
        updatePs.executeUpdate();

        System.out.println("Ticket cancelled successfully");
    }
}
