package com.horyzont.lastproject.service;

import com.horyzont.lastproject.dao.BookDao;
import com.horyzont.lastproject.dao.BookLoanDao;
import com.horyzont.lastproject.entities.BookEntity;
import com.horyzont.lastproject.entities.BookLoanEntity;
import com.horyzont.lastproject.entities.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookLoanService {


    @Autowired
    BookDao bookDao;

    @Autowired
    BookLoanDao bookLoanDao;


    public void loanBook(Integer client_id, Integer book_id) {

        Optional<BookEntity> bookById = bookDao.findById(book_id);

        if(bookById != null){
            BookEntity bookAvailable = bookById.get();
            if(bookAvailable.getAvailable()){

                ClientEntity clientEntity = new ClientEntity();
                clientEntity.setId(client_id);

                BookEntity bookEntity = new BookEntity();
                bookEntity.setId(book_id);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                Date loanDate = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(loanDate);
                c.add(Calendar.DATE, 7);
                Date dueDate = c.getTime();

                BookLoanEntity bookLoanEntity = new BookLoanEntity();
                bookLoanEntity.setClient(clientEntity);
                bookLoanEntity.setBook(bookEntity);
                bookLoanEntity.setLoan_date(sdf.format(loanDate));
                bookLoanEntity.setDue_date(sdf.format(dueDate));
                bookLoanDao.save(bookLoanEntity);

                bookAvailable.setAvailable(false);
                bookDao.save(bookAvailable);

            }else {
                System.out.printf("book is not available");
            }
        }


    }

    public List<BookLoanEntity> getAllBookLoan() {return bookLoanDao.findAll();}

    public String deleteLoan( Integer loanId){
        BookLoanEntity entity = new BookLoanEntity();
        entity.setId(loanId);

        Optional<BookLoanEntity> loanEntityOptional = bookLoanDao.findById(loanId);

        if(loanEntityOptional != null){
            BookLoanEntity loanEntity = loanEntityOptional.get();
            BookEntity bookEntity = loanEntity.getBook();

            if (bookEntity != null) {
                Boolean isAvailable = bookEntity.getAvailable();
                if(isAvailable){
                    bookEntity.setAvailable(true);
                    bookDao.save(bookEntity);
                    bookLoanDao.delete(entity);
                }

            }
        }
        return "loan deleted";
    }

}
