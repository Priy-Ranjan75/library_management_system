/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseOperations;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class DbOperations {

    public static void setDataOrDelete(String query, String msg) {
      
        try {

            Connection con = ConnectionProviderClass.getCon();
            Statement st = con.createStatement();

            st.executeUpdate(query);
            if (!msg.equals("")) {
                JOptionPane.showMessageDialog(null, msg);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static ResultSet getData(String query){
        try{
            Connection con=ConnectionProviderClass.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            return rs;
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
           return null;
        }
    }
}
