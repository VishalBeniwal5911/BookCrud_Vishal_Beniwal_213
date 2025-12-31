package com.vishal.Bookcrud.repository;

import com.vishal.Bookcrud.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}