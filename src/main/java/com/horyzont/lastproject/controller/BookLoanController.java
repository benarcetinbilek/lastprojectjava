package com.horyzont.lastproject.controller;

import com.horyzont.lastproject.entities.BookEntity;
import com.horyzont.lastproject.entities.BookLoanEntity;
import com.horyzont.lastproject.service.BookLoanService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("loan")
public class BookLoanController {

    @Autowired
    BookLoanService bookLoanService;

    @GetMapping("/loanBook/{clientId}/{bookId}")
    public void loanBook(@PathVariable Integer clientId, @PathVariable Integer bookId){
         bookLoanService.loanBook(clientId, bookId);
    }

    @GetMapping("/getAll")
    public List<BookLoanEntity> getAllBookLoan() {
        return bookLoanService.getAllBookLoan();
    }


    @GetMapping("/removeLoan/{loanId}")
    public void deleteLoan(@PathVariable Integer loanId){bookLoanService.deleteLoan(loanId);}

    //get client id
    //get book id
    //check availability
    //change availability
    //write current book loans

    //after book returned change availability

}
