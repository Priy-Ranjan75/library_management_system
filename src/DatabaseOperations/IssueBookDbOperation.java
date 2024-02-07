/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseOperations;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author DELL
 */
public class IssueBookDbOperation {

    public static void save(IssueBook b) {
       
        String query = "insert into  issuebook values('" + b.getBookId() + "','" + b.getBookName() + "','" + b.getSubject() + "','" + b.getRegirstration() + "','" + b.getStudentName() + "','" + b.getCollegeRoll() + "','" + b.getIssueDate() + "','" + b.getReturnDate() + "')";
        
        DbOperations.setDataOrDelete(query, "Book issued  Successfully! ");
    }    
    
    public static ArrayList<IssueBook> getAllRecords() {
        ArrayList<IssueBook> arraylist = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from issuebook ");
            while (rs.next()) {
                IssueBook bk = new IssueBook();
                bk.setBookId(rs.getString("bookid"));
                bk.setBookName(rs.getString("bookname"));
                
                bk.setSubject(rs.getString("subject"));
                bk.setRegirstration(rs.getString("registration"));
                bk.setStudentName(rs.getString("studentname"));
                bk.setCollegeRoll(rs.getString("classroll"));
                bk.setIssueDate(rs.getString("issuedate"));
                bk.setReturnDate(rs.getString("returndate"));
                arraylist.add(bk);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return arraylist;
    }
    
     public static ArrayList<IssueBook> getAllRecordsOnCreteria(String regno) {
        ArrayList<IssueBook> arraylist = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from issuebook where registration='"+regno+"'");
             while (rs.next()) {
                IssueBook bk = new IssueBook();
                bk.setBookId(rs.getString("bookid"));
                bk.setBookName(rs.getString("bookname"));
                
                bk.setSubject(rs.getString("subject"));
                bk.setRegirstration(rs.getString("registration"));
                bk.setStudentName(rs.getString("studentname"));
                bk.setCollegeRoll(rs.getString("classroll"));
                bk.setIssueDate(rs.getString("issuedate"));
                bk.setReturnDate(rs.getString("returndate"));
                arraylist.add(bk);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return arraylist;
    }
    
}
