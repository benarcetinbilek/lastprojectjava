package com.horyzont.lastproject.entities;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "current_book_loans")
public class BookLoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name="client_id", referencedColumnName = "id")
    @OneToOne
    private ClientEntity client;

    @JoinColumn(name="book_id", referencedColumnName = "id")
    @OneToOne
    private BookEntity book;

    @Column(name = "loan_date")
    private String loan_date;

    @Column(name = "due_date")
    private String due_date;


    public Integer getId() {
        return id;
    }

    public ClientEntity getClient() {return client;}

    public BookEntity getBook() {return  book;}

    public String getLoan_date() {return loan_date;}

    public  String getDue_date() {return due_date;}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public void setLoan_date(String loan_date) {
        this.loan_date = loan_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
}
