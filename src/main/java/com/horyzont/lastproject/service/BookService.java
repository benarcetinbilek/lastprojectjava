package com.horyzont.lastproject.service;

import com.horyzont.lastproject.dao.BookDao;
import com.horyzont.lastproject.entities.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    public BookEntity registerBook(String title) {
        BookEntity entity = new BookEntity();
        entity.setTitle(title);
        entity.setAvailable(true);
        bookDao.save(entity);
        return entity;
    }

    public String deleteBook(Integer id) {
        BookEntity entity = new BookEntity();
        entity.setId(id);
        bookDao.delete(entity);
        return "client deleted";
    }

    public List<BookEntity> getAllBook(){
        return bookDao.findAll();
    }

}
