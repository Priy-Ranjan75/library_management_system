
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseOperations;

import model.*;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class StudentDboperation {

    public static void save(Student st) {
        String query = "insert into  Student values('" + st.getName() + "','" + st.getClassRoll() + "','" + st.getUniversityRoll() + "','" + st.getRegistration() + "','" + st.getSession() + "','" + st.getGender() + "','" + st.getMobileNumber() + "','" + st.getAadharNumber() + "','" + st.getAddress() + "')";

        DbOperations.setDataOrDelete(query, "Student Registered Successfully! ");
    }

    public static ArrayList<Student> getAllRecords() {
        ArrayList<Student> arraylist = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from Student ");
            while (rs.next()) {
                Student st = new Student();
                st.setName(rs.getString("name"));
                st.setClassRoll(rs.getString("classroll"));
                st.setUniversityRoll(rs.getString("universityroll"));
                st.setRegistration(rs.getString("registration"));
                st.setSession(rs.getString("session"));
                st.setGender(rs.getString("gender"));
                st.setMobileNumber(rs.getString("mobile"));
                st.setAadharNumber(rs.getString("aadhar"));
                st.setAddress(rs.getString("address"));
                arraylist.add(st);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return arraylist;
    }

    public static void Update(Student st) {

        String query = "update Student set name='" + st.getName() + "', classroll='" + st.getClassRoll() + "',universityroll='" + st.getUniversityRoll() + "',session='" + st.getSession() + "',gender='" + st.getGender() + "',mobile='" + st.getMobileNumber() + "',aadhar='" + st.getAadharNumber() + "',address='" + st.getAddress() + "' where registration='" + st.getRegistration() + "'";
        //String query="update book set bookname='"+bk.getBookName()+"' where bookid='"+bk.getBookId()+"'";
        DbOperations.setDataOrDelete(query, "Student details updated .");

    }
    

    public static void delete(String id) {
        String query = "delete from Student where registration='" + id + "'";
        DbOperations.setDataOrDelete(query, "Student deleted successfully");
    }

    public static ArrayList<Student> getRecordsOnCreteria(String selector) {
        ArrayList<Student> arraylist = new ArrayList<>();
        try {
            //ResultSet rs = DbOperations.getData("select * from book where '"+basedOn+"'='"+selector+"'");
            ResultSet rs = DbOperations.getData("select * from Student where registration = '" + selector + "'");
            while (rs.next()) {
                Student st = new Student();
                st.setName(rs.getString("name"));
                st.setClassRoll(rs.getString("classroll"));
                st.setUniversityRoll(rs.getString("universityroll"));
                st.setRegistration(rs.getString("registration"));
                st.setSession(rs.getString("session"));
                st.setGender(rs.getString("gender"));
                st.setMobileNumber(rs.getString("mobile"));
                st.setAadharNumber(rs.getString("aadhar"));
                st.setAddress(rs.getString("address"));
               
                arraylist.add(st);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return arraylist;
    }

}
