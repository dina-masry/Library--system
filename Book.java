package com.company;

public class Book {

    private String bookName, price, noCopies, auther, isbn, department;

    public Book() {
    }

    public Book(String bookName, String price, String noCopies, String auther, String isbn, String department) {
        this.bookName = bookName;
        this.price = price;
        this.noCopies = noCopies;
        this.auther = auther;
        this.isbn = isbn;
        this.department = department;
    }

    public  String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public  String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public  String getNoCopies() {
        return noCopies;
    }

    public void setNoCopies(String noCopies) {
        this.noCopies = noCopies;
    }

    public  String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public  String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
