package console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Dbconnectionre {
    private static final String URL = "jdbc:postgresql://localhost:5432/req";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static  final  String URL2 = "jdbc:postgresql://localhost:5432/reqaccrej";
    public static void insertreq(String query){
        String sql = "INSERT INTO request(request) VALUES (?)";
        try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)){
                preparedStatement.setString(1,query);
                preparedStatement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void req() {
        line l = new line();
        String sql = "SELECT * FROM request";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int reqid = resultSet.getInt("Unique_ID");
                        String request = resultSet.getString("Request");
                        l.margin_left(String.format("║ %-12s %-35s ║", "Unique Id:", reqid));
                        l.margin_left(String.format("║ %-12s %-35s ║", "Request:", request));
                        l.margin_left("╠══════════════════════════════════════════════════╣");
                    }
                        l.margin_left("╚══════════════════════════════════════════════════╝");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void accept(String reqdata) {
        int reqdataa = Integer.parseInt(reqdata);
        try (Connection connection = DriverManager.getConnection(URL2, USER, PASSWORD)) {
            String sql = "INSERT INTO accept(accept_,reqida) VALUES (?,?)";
            try (PreparedStatement insertstatement = connection.prepareStatement(sql)) {
                insertstatement.setString(1, "Your Request Has Been Approved");
                insertstatement.setInt(2, reqdataa);
                insertstatement.executeUpdate();
                delete(reqdataa);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void delete(int reqdataa){
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)){
            String sql = "DELETE FROM request WHERE Unique_ID = ?";
            try (PreparedStatement deletestatement = connection.prepareStatement(sql)){
            deletestatement.setInt(1,reqdataa);
            deletestatement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void reject(String reqdata){
        int reqdataa = Integer.parseInt(reqdata);
        try (Connection connection = DriverManager.getConnection(URL2, USER, PASSWORD)) {
            String sql = "INSERT INTO reject(reject_,reqidr) VALUES (?,?)";
            try (PreparedStatement insertstatement = connection.prepareStatement(sql)) {
                insertstatement.setString(1, "Your Request Has Been Rejected/Decline");
                insertstatement.setInt(2, reqdataa);
                insertstatement.executeUpdate();
                delete(reqdataa);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
