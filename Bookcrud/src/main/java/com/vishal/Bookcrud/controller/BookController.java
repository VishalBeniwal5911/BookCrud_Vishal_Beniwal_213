package com.vishal.Bookcrud.controller;

import com.vishal.Bookcrud.entity.Book;
import com.vishal.Bookcrud.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // POST /employees
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    // GET /employees
    @GetMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    // PUT /employees/{id}
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book) {
        return service.updateBook(id, book);
    }

    // DELETE /employees/{id}
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "Book deleted successfully";
    }
}