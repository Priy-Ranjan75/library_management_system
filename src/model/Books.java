/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class Books {
   private String bookId;
  private String bookname;
  private String authorname;
  private String subject;
  private String semester;
   private String quantity;
 

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookname;
    }

    public void setBookName(String bookName) {
        this.bookname = bookName;
    }

    public String getAuthorName() {
        return authorname;
    }

    public void setAuthorName(String authorName) {
        this.authorname = authorName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

  
 
}
