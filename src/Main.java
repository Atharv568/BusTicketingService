import java.sql.*;
import java.util.*;
public class Main {
    private static final String url ="jdbc:mysql://localhost:3306/busticketing_db";
    private static final String username ="root";
    private static final String password ="Atharv@568";
    public static void busDetail(int bus_no ) throws SQLException{
        Connection connection = DriverManager.getConnection(url, username, password);
        String query = "Select * from bus where bus_no = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(query);
        prepareStatement.setInt(1, bus_no);
        ResultSet resultSet = prepareStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("Your bus details for Bus id "+ bus_no + " are :\n");
            System.out.println("Bus ID: " + resultSet.getInt("bus_no"));
            System.out.println("Availability " + resultSet.getBoolean("is_available"));
            System.out.println("Total Seats: " + resultSet.getInt("capacity"));
        }
    }
    public static void passengerDetail(String name, int age, int amount ) throws SQLException{
      Connection connection = DriverManager.getConnection(url, username, password);
      String query = "Insert into passengers(name, age, amount) values (?, ?, ?)";
      PreparedStatement prepareStatement= connection.prepareStatement(query);
      prepareStatement.setString(1, name);
      prepareStatement.setInt(2, age);
      prepareStatement.setInt(3, amount);
      int rowsAffected =prepareStatement.executeUpdate();
      if(rowsAffected>0){
          System.out.print("Ticket is booked Successfully");
      } else{
          System.out.println("Sorry for the inconvinence caused, can't book right now ! ");
      }
    }
    public static void main (String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();

        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to Lucknow Bus Terminal");
            System.out.println("Choose the option : \n 1. Bus Details \n 2. Passenger Bookings");
            int choice= sc.nextInt();
            sc.nextLine();
            if(choice==1){
                 System.out.print("Enter the bus id : ");
                 int id = sc.nextInt();
                 busDetail(id);
            }else{
                 System.out.print("Enter the details of the passenger : ");
                 System.out.println("Name :");
                 String name= sc.nextLine();
                 System.out.println("Age : ");
                 int age = sc.nextInt();
                 System.out.print("Amount : ");
                 int amount = sc.nextInt();
                 passengerDetail(name, age, amount);
            }
        }catch( SQLException e){
            e.printStackTrace();

        }
    }
}
