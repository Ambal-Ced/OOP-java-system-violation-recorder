package console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBConnectionNew {
    private static final String URL = "jdbc:postgresql://localhost:5432/data";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    public static boolean isSrCodeExist(String srCode) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT COUNT(*) FROM students WHERE srcode = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, srCode);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int count = resultSet.getInt(1);
                        return count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static StudentInfo getStudentInfo(String srCode) {
        StudentInfo studentInfo = new StudentInfo();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT lname, fname, mname FROM students WHERE srcode = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, srCode);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        studentInfo.setLastName(resultSet.getString("lname"));
                        studentInfo.setFirstName(resultSet.getString("fname"));
                        studentInfo.setMiddleName(resultSet.getString("mname"));
                    }
                }
            }
            query = "SELECT violation_info FROM violation WHERE srcode = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, srCode);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        studentInfo.addViolationInfo(resultSet.getString("violation_info"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentInfo;
    }
    public static void Insertvio(String srCode, String otherJavaFileData) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO violation (srcode, violation_info) VALUES (?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, srCode);
                insertStatement.setString(2, otherJavaFileData);
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Editvio(String srCode, String firstData, String secondData) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Updating data in the violation table
            String updateQuery = "UPDATE violation SET violation_info = ? WHERE srcode = ? AND violation_info = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setString(1, secondData);
                updateStatement.setString(2, srCode);
                updateStatement.setString(3, firstData);
                updateStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void AddStudent(String srCode, String fname, String lname, String mname){
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            String sql = "INSERT INTO Students (Lname, Fname, mname, SrCode) VALUES (?, ?, ?, ?);";
            try(PreparedStatement inserstatement = connection.prepareStatement(sql)){
                inserstatement.setString(1,lname);
                inserstatement.setString(2,fname);
                inserstatement.setString(3,mname);
                inserstatement.setString(4,srCode);

                inserstatement.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void DeleteStudent(String Srcode) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM students WHERE srcode = ?";
            try (PreparedStatement deletestatement = connection.prepareStatement(sql)) {
                deletestatement.setString(1, Srcode);
                deletestatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


