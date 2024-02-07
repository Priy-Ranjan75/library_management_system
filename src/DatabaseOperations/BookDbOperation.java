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
public class BookDbOperation {
     public static void save(Books b){
        String query = "insert into  book values('"+b.getBookId()+"','"+b.getBookName()+"','"+b.getAuthorName()+"','"+b.getSubject()+"','"+b.getSemester()+"',"+b.getQuantity()+")";
         
        DbOperations.setDataOrDelete(query, "Book added Successfully! ");
    }
public static ArrayList<Books> getAllRecords() {
        ArrayList<Books> arraylist = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from book ");
            while (rs.next()) {
                Books bk=new Books();
                bk.setBookId(rs.getString("bookid"));
                bk.setBookName(rs.getString("bookname"));
                bk.setAuthorName(rs.getString("authorname"));
                bk.setSubject(rs.getString("subject"));
                bk.setSemester(rs.getString("semester"));
                bk.setQuantity(rs.getString("quantity"));
                arraylist.add(bk);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return arraylist;
    }
  public static ArrayList<Books> getRecordsOnCreteria(String basedOn,String selector) {
        ArrayList<Books> arraylist = new ArrayList<>();
        try {
            //ResultSet rs = DbOperations.getData("select * from book where '"+basedOn+"'='"+selector+"'");
            ResultSet rs = DbOperations.getData("select * from book where "+basedOn+" = '"+selector+"'");
            while (rs.next()) {
                Books bk=new Books();
                bk.setBookId(rs.getString("bookid"));
                bk.setBookName(rs.getString("bookname"));
              bk.setAuthorName(rs.getString("authorname"));
                bk.setSubject(rs.getString("subject"));
                bk.setSemester(rs.getString("semester"));
                bk.setQuantity(rs.getString("quantity"));
                arraylist.add(bk);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return arraylist;
    }    
  public static void Update(Books bk){
       
        String query="update book set bookname='"+bk.getBookName()+"', authorname='"+bk.getAuthorName()+"',subject='"+bk.getSubject()+"',semester='"+bk.getSemester()+"',quantity='"+bk.getQuantity()+"' where bookid='"+bk.getBookId()+"'";
       //String query="update book set bookname='"+bk.getBookName()+"' where bookid='"+bk.getBookId()+"'";
       DbOperations.setDataOrDelete(query, "Book updated successfully");
      
    }
  public static void updateQuantity(String bid,String qty){
      String query="update book set quantity='"+qty+"' where bookid='"+bid+"'";
      DbOperations.setDataOrDelete(query, "Book Quantity Updated Successfully");
  }
  
   public static void delete(String id){
        String query="delete from book where bookid='"+id+"'";
        DbOperations.setDataOrDelete(query, "Book deleted successfully");
    }
  public static ArrayList<Books> getBookIdQty(String bid) {
        ArrayList<Books> arraylist = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select bookid,quantity from book where bookid='"+bid+"'");
            if(rs.next()) {
                Books bk = new Books();
                bk.setBookId(rs.getString("bookid"));
               bk.setQuantity(rs.getString("quantity"));
                arraylist.add(bk);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return arraylist;
    }
 
    
}
