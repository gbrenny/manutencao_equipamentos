package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/manutencao_equipamentos";
    private static final String USER = "postgres";
    private static final String PASSWORD = "gb1728391994";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Conexão bem-sucedida!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
