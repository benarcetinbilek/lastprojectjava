package com.horyzont.lastproject;

import com.horyzont.lastproject.entities.BookEntity;
import com.horyzont.lastproject.entities.BookLoanEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;


@SpringBootApplication
public class LibraryManagementApp {

    public static  void main (String[] args) {
        SpringApplication.run(LibraryManagementApp.class, args);
    }



}
