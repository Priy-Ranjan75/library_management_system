/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseOperations;

import java.sql.*;

/**
 *
 * @author DELL
 */
public class ConnectionProviderClass {

    public static Connection getCon() {
        
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "saulty");       
            return con;
            } 
         catch (Exception e) {
            System.out.println("error occours due to   " + e.toString());
            return null;
        }
    }

}
