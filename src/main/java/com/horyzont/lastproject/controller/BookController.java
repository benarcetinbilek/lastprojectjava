package com.horyzont.lastproject.controller;

import com.horyzont.lastproject.entities.BookEntity;
import com.horyzont.lastproject.entities.ClientEntity;
import com.horyzont.lastproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/register/{title}")
    public BookEntity register(@PathVariable String title){
        return bookService.registerBook(title);
    }

    @GetMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
    }

    @GetMapping("/getAll")
    public List<BookEntity> getAllBook() {
        return bookService.getAllBook();
    }

}