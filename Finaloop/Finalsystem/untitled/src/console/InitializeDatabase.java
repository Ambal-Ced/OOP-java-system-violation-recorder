package console;
import java.sql.*;
import java.util.Scanner;

public class InitializeDatabase {
    static String url = "jdbc:postgresql://localhost:5432/";

    static String user = "postgres";
    static String password = "postgres";
    static String dbName1 = "data";
    static String dbName2 = "reqaccrej";
    static String dbName3 = "req";
    static String dbName4 = "updata";
    static String dbName5 = "userlog";
    public static void initializes(){
        line l = new line();
        l.margin_top();
        l.margin_left("Initializing Database 0%");
        load();
        Datas();
        load();
        l.clear();
        l.margin_top();
        l.margin_left("Initializing Database 20%");
        load();
        reqaccrejs();
        load();
        l.clear();
        l.margin_top();
        l.margin_left("Initializing Database 40%");
        load();
        Requests();
        load();
        l.clear();
        l.margin_top();
        l.margin_left("Initializing Database 60%");
        load();
        userps();
        load();
        l.clear();
        l.margin_top();
        l.margin_left("Initializing Database 80%");
        load();
        updatas();
        load();
        l.clear();
        l.margin_top();
        l.margin_left("Initializing Database 100%");
        load();
        l.clear();
        l.margin_top();
        l.margin_left("Database has been initialized");
        l.clear();
        l.margin_top();
        l.margin_left("Proceeding on initializing Code");
        load();
        l.clear();
        l.margin_top();
        l.margin_left("Please Include the JAR file on the Project Structure Library");
        load();
        l.clear();
        l.margin_top();
        l.margin_left("\tAll Done");
        l.pause();

    }

    public static void load(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void Datas(){
        line l = new line();
        try {
            // Connecting to PostgreSQL server
            Connection connection = DriverManager.getConnection(url, user, password);

            // Creating the database
            Statement statement = connection.createStatement();
            String sql = "CREATE DATABASE " + dbName1;
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            l.margin_left("    Loading Database");
    }
        try {
            Datastable();
        }catch (Exception e){

        }
}


    public static void reqaccrejs(){
        line l = new line();
        try {
            // Connecting to PostgreSQL server
            Connection connection = DriverManager.getConnection(url, user, password);

            // Creating the database
            Statement statement = connection.createStatement();
            String sql = "CREATE DATABASE " + dbName2;
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            l.margin_left("    Loading Database");
        }
        try {
            reqaccrejstable();
        }catch (Exception e){
        }
    }

    public static void Requests(){
        line l = new line();
        try {
            // Connecting to PostgreSQL server
            Connection connection = DriverManager.getConnection(url, user, password);

            // Creating the database
            Statement statement = connection.createStatement();
            String sql = "CREATE DATABASE " + dbName3;
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            l.margin_left("    Loading Database");
        }
        try {
            Requeststable();
        }catch (Exception e){

        }
    }

    public static void updatas(){
        line l = new line();
        Scanner s = new Scanner(System.in);
        try {
            // Connecting to PostgreSQL server
            Connection connection = DriverManager.getConnection(url, user, password);

            // Creating the database
            Statement statement = connection.createStatement();
            String sql = "CREATE DATABASE " + dbName4;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            l.margin_left("    Loading Database");
        }
        try {
            updatastable();
        }catch (Exception e){
            //
        }
    }

    public static void userps(){
        line l = new line();
        try {
            // Connecting to PostgreSQL server
            Connection connection = DriverManager.getConnection(url, user, password);

            // Creating the database
            Statement statement = connection.createStatement();
            String sql = "CREATE DATABASE " + dbName5;
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            l.margin_left("    Loading Database");
        }
        try {
            userpstable();
        }catch (Exception e){

        }
    }

    public static void Datastable() {

        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + "srcode VARCHAR(255) PRIMARY KEY,"
                + "fname VARCHAR(255),"
                + "mname VARCHAR(255),"
                + "lname VARCHAR(255)"
                + ")";

        String sql2 = "CREATE TABLE IF NOT EXISTS violation ("
                + "srcode VARCHAR(255) REFERENCES students(srcode),"
                + "violation_info VARCHAR(255),"
                + "violation_count VARCHAR(255)"
                + ")";

        try (Connection connection = DriverManager.getConnection(url + dbName1, user, password)) {
            try (PreparedStatement studentsStatement = connection.prepareStatement(sql)) {
                studentsStatement.executeUpdate();
            }
            try (PreparedStatement violationStatement = connection.prepareStatement(sql2)) {
                violationStatement.executeUpdate();
            }
        } catch (SQLException e) {

        }
    }

    public static void reqaccrejstable(){
        String sql = "create table Accept(acceptID Serial Primary Key," +
                "reqida int," +
                "accept_ Varchar(30)" +
                ")";
        String sql2 = "create table Reject(rejectID Serial Primary Key," +
                "reqidr INT," +
                "reject_ Varchar(255)" +
                ")";
        try (Connection connection = DriverManager.getConnection(url + dbName2, user, password)) {
            try (PreparedStatement studentsStatement = connection.prepareStatement(sql)) {
                studentsStatement.executeUpdate();
            }
            try (PreparedStatement violationStatement = connection.prepareStatement(sql2)) {
                violationStatement.executeUpdate();
            }
        } catch (SQLException e) {

        }

    }
    public static void Requeststable(){

        String sql = "create table request" +
                "(" +
                "Unique_ID Serial Primary Key," +
                "Request Varchar(350)" +
                ")";
        try (Connection connection = DriverManager.getConnection(url + dbName3, user, password)) {
            try (PreparedStatement studentsStatement = connection.prepareStatement(sql)) {
                studentsStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updatastable() {
        line l = new line();
        Scanner s = new Scanner(System.in);
        String sql = "CREATE TABLE userpass (" +
                "    username VARCHAR(150)," +
                "    password_ VARCHAR(150)," +
                "    email VARCHAR(255)," +
                "    uniid SERIAL PRIMARY KEY" +
                ")";
        try (Connection connection = DriverManager.getConnection(url + dbName4, user, password)) {
            try (PreparedStatement studentsStatement = connection.prepareStatement(sql)) {
                studentsStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        l.margin_left_input("Enter User Name (Admin): ");
        String username = s.nextLine();
        l.margin_left_input("Enter Password: ");
        String password = s.nextLine();
        l.margin_left_input("Enter Email: ");
        String email = s.nextLine();
        System.out.println("");
        DBconnection.CreateAccAdmin(username, password, email);
    }
    public static void userpstable() {
        String sql = "create table userp(username Varchar(255)," +
                "password Varchar(255)," +
                "email varchar(255)," +
                "uid Serial Primary key)";
        try (Connection connection = DriverManager.getConnection(url + dbName5, user, password)) {
            try (PreparedStatement studentsStatement = connection.prepareStatement(sql)) {
                studentsStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

