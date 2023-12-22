/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inputan;

import java.sql.*;
import java.sql.ResultSet;

public class DatabaseConnection {

    private Connection conn;
    private Statement stmt;

    public void DatabaseConnection() {
        try {
            // Ganti URL, username, dan password sesuai dengan informasi database Anda
            String url = "jdbc:mysql://localhost:3306/playstation";
            String user = "root";
            String password = "";
            // Membuat koneksi ke database
            conn = DriverManager.getConnection(url, user, password);
           
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
    // Method untuk melakukan query ke database
    public ResultSet executeQuery(String query) {
        try {
            DatabaseConnection(); // pastikan koneksi database sudah dibuka
            stmt = conn.createStatement();

            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method untuk menjalankan query INSERT, UPDATE, DELETE
    public int executeUpdate(String query) {
        try {
            DatabaseConnection(); // pastikan koneksi database sudah dibuka

            stmt = conn.createStatement();

            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Method untuk menutup koneksi ke database
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   

}
