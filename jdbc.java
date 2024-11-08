package com.org.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Crud_sys {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Crud"; 
        String user = "root"; 
        String password = "Veera@2006";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");

            // Insert multiple records
            String insertSql = "INSERT INTO Crud_pro(name, age) VALUES(?, ?)";
            PreparedStatement insertStatement = con.prepareStatement(insertSql);
            String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hank"};
            int[] ages = {20, 25, 30, 35, 40, 45, 50, 55};

            for (int i = 0; i < 8; i++) {
                insertStatement.setString(1, names[i]);
                insertStatement.setInt(2, ages[i]);
                insertStatement.executeUpdate();
            }
            System.out.println("8 Rows inserted.");
            String deleteSql = "DELETE FROM Crud_pro WHERE id = ?";
            PreparedStatement deleteStatement = con.prepareStatement(deleteSql);
            deleteStatement.setInt(1, 4);
            int rowsDeleted = deleteStatement.executeUpdate();
            System.out.println("Rows deleted with id=4: " + rowsDeleted);

            String selectSql = "SELECT * FROM Crud_pro";
            Statement selectStatement = con.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectSql);
            
            System.out.println("Data from Crud_pro table:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                                   ", Name: " + resultSet.getString("name") +
                                   ", Age: " + resultSet.getInt("age"));
            }
            insertStatement.close();
            deleteStatement.close();
            selectStatement.close();
            resultSet.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
