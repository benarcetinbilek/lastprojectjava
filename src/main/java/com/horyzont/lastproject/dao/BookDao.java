package com.horyzont.lastproject.dao;

import com.horyzont.lastproject.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<BookEntity, Integer> {


}
