package com.vishal.Bookcrud.service;

import com.vishal.Bookcrud.entity.Book;
import com.vishal.Bookcrud.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book updateBook(Long id, Book book) {
        Book existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());

        return repository.save(existing);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
