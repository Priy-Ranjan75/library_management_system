/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseOperations;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class LibrarianDbOperation {

    static String mail = "";

    public static void save(Librarian l) {
        String query = "insert into  Librarian(name,email,mobile,address,password,securityQuestion,answer) values('" + l.getName() + "','" + l.getEmail() + "','" + l.getMobileNumber() + "','" + l.getAddress() + "','" + l.getPassword() + "','" + l.getSecurityQuestion() + "','" + l.getAnswer() + "')";

        DbOperations.setDataOrDelete(query, "Librarian Registered Successfully! ");
    }

    public static Librarian login(String email, String password) {
        Librarian lb = null;
        try {
            ResultSet rs = DbOperations.getData("select * from librarian where email ='" + email + "' and password='" + password + "'");
            if (rs.next() == true) {
                lb = new Librarian();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        mail = email;
        return lb;
    }

    public static Librarian getSecurityQuestion(String email) {
        Librarian lbn = null;
        try {
            ResultSet rs = DbOperations.getData("select * from librarian  where email ='" + email + "'");
            while (rs.next()) {
                lbn = new Librarian();
                lbn.setSecurityQuestion(rs.getString("securityQuestion"));
                lbn.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lbn;
    }

    public static void Update(String email, String newPassword) {
        String query = "Update librarian set password='" + newPassword + "' where email='" + email + "'";
        DbOperations.setDataOrDelete(query, "password changed successfully");
    }

    public static void changepassword(String pwd) {
        String query = "Update librarian set password='" + pwd + "' where email='" + mail + "'";
        DbOperations.setDataOrDelete(query, "password changed successfully");
    }

    public static void updateDetails(Librarian lb) {
        String query = "update librarian set name='" + lb.getName() + "',email='" + lb.getEmail() + "',mobile='" + lb.getMobileNumber() + "',address='" + lb.getAddress() + "',securityQuestion='" + lb.getSecurityQuestion() + "',answer='" + lb.getAnswer() + "' where email='" + mail + "'";

        DbOperations.setDataOrDelete(query, "Details Updated Successfully");
        String q1 = "select email from librarian where email='" + lb.getEmail() + "'";
        try {
            ResultSet rs = DbOperations.getData(q1);
            if (rs.next()) {
                mail = rs.getString("email");
            }
        } catch (Exception e) {

        }
    }

    public static void delete() {
        String query = "delete from librarian where email='" + mail + "'";
        DbOperations.setDataOrDelete(query, "Account deleted successfully");
    }

    public static ArrayList<Librarian> getAllRecords() {
        ArrayList<Librarian> arraylist = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from librarian where email='" + mail + "'");
            while (rs.next()) {
                Librarian lb = new Librarian();
                lb.setName(rs.getString("name"));
                lb.setEmail(rs.getString("email"));
                lb.setMobileNumber(rs.getString("mobile"));
                lb.setAddress(rs.getString("address"));
                lb.setPassword(rs.getString("password"));
                lb.setSecurityQuestion(rs.getString("securityQuestion"));
                lb.setAnswer(rs.getString("answer"));
                arraylist.add(lb);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return arraylist;
    }
}
