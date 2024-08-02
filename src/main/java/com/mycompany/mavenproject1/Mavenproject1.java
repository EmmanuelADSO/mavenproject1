
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mavenproject1 {

    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3307/jdbctest";
        Connection conexion;
        Statement statement; 
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario,password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("Nombre"));
            }
            
            // Inserción de datos
            statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'Novoa');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("Nombre"));
            }
            
            //Actualizacion de datos
            statement.execute("UPDATE `usuarios` SET `nombre` = 'Jose Emmanuel' WHERE `usuarios`.`id` = 1;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("Nombre"));
            }
            
            // Eliminacion de datos
            statement.execute("DELETE FROM `usuarios` WHERE `usuarios`.`id` = 5");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(rs.getString("Nombre"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Mavenproject1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
