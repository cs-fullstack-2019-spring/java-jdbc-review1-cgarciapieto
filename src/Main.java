import java.sql.*;
import java.util.Scanner;

public class Main {

    private final static String url = "jdbc:postgresql://localhost:5432/soccer_match";
    private final static String user = "student";
    private final static String password = "C0d3Cr3w";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");




            String SQL = "SELECT * from game ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                System.out.println(rs.getString("mdate"));
//                System.out.println(rs.getString("stadium"));
                System.out.println(rs.getString("team1"));
                System.out.println(rs.getString("team2"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) {

        Scanner user_input = new Scanner(System.in);
        String User;
        System.out.println("1: list match results");

        User = user_input.next();
//        System.out.println(User);

        connect();
    }
}







