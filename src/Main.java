import java.sql.*;
import java.util.*;
public class Main {

    public static void main (String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();

        }
        try {
            Connection connection = DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to Lucknow Bus Terminal");
            System.out.print("Choose the option : \n 1. Bus Details \n 2. Passenger Bookings :");
            int choice= sc.nextInt();
            sc.nextLine();
            if(choice==1){
                System.out.println("The details of upcomming buses are : ");
                BusDAO.All_bus();
                System.out.print("Enter the bus No : ");
                int id = sc.nextInt();
                BusDAO.busDetail(id);
            }else{
                System.out.println("Enter bus No: ");
                int id = sc.nextInt();
                int seat =BusDAO.CheckSeat(id);
                if(seat>0) {
                    sc.nextLine();
                    System.out.println("Enter the details of the passenger : ");
                    System.out.print("Name : ");
                    String name = sc.nextLine();
                    System.out.print("Age : ");
                    int age = sc.nextInt();
                    System.out.print("No. of tickets ");
                    int No = sc.nextInt();
                    System.out.print("Amount : ");
                    int amount = sc.nextInt();
                    System.out.print("Bus no : ");
                    int bus_no = sc.nextInt();
                    PassengerDAO.passengerDetail(name, age, amount, bus_no, No);
                } else {
                    System.out.println("Regret all tickets are booked");
                }
            }
        }catch( SQLException e){
            e.printStackTrace();

        }
    }
}
