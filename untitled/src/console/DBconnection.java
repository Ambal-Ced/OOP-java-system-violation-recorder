package console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBconnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/updata";
    private static final String URL2 = "jdbc:postgresql://localhost:5432/userlog";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    public static boolean isValidAdmin(String username, String password) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM userpass WHERE username = ? AND password_ = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // Returns true if a record is found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's requirements
            return false;
        }
    }
    public static boolean isvalidUser(String username, String password){
        try (Connection connection = DriverManager.getConnection(URL2, USER, PASSWORD)) {
            String sql = "SELECT * FROM userp WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // Returns true if a record is found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's requirements
            return false;
        }
    }
    public static void CreateAccUser(String username, String password, String email){
        try(Connection connection = DriverManager.getConnection(URL2, USER, PASSWORD)){
            String sql = "INSERT INTO userp(username, password, email) VALUES (?,?,?)";
            try(PreparedStatement insertstatement = connection.prepareStatement(sql)){
                insertstatement.setString(1, username);
                insertstatement.setString(2, password);
                insertstatement.setString(3, email);
                insertstatement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void CreateAccAdmin(String username, String password, String email){
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            String sql = "INSERT INTO userpass(username, password_, email) VALUES (?,?,?)";
            try(PreparedStatement insertstatement = connection.prepareStatement(sql)){
                insertstatement.setString(1, username);
                insertstatement.setString(2, password);
                insertstatement.setString(3, email);
                insertstatement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}