package com.genpact.librarymgmt.controller;

import com.genpact.librarymgmt.dto.Book;
import com.genpact.librarymgmt.exceptions.BookNotException;
import com.genpact.librarymgmt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping
    public List<Book> getAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") final Long id) {
        Book book = repository.findById(id).orElse(null);
        if(Objects.isNull(book)) {
            throw new BookNotException("Book with given id not present");
        } else {
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }
    }

    @PostMapping
    public Book add(@RequestBody final Book book) {
        return repository.saveAndFlush(book);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable("id") final Long id, @RequestBody final Book book) {
        if (Objects.isNull(id)) {
            return new ResponseEntity("Invalid id for update", HttpStatus.BAD_REQUEST);
        } else {
            book.setId(id);
            return new ResponseEntity(repository.saveAndFlush(book), HttpStatus.ACCEPTED);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable("id") final Long id) {
        repository.deleteById(id);
        return new ResponseEntity("Object with id deleted.", HttpStatus.ACCEPTED);
    }

}
