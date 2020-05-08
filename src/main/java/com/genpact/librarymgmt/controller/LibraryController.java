package com.genpact.librarymgmt.controller;

import com.genpact.librarymgmt.dto.Book;
import com.genpact.librarymgmt.dto.Library;
import com.genpact.librarymgmt.repository.BookRepository;
import com.genpact.librarymgmt.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryRepository repository;

    @Autowired
    private BookRepository bookRepository;
    @GetMapping
    public List<Library> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Library> find(@PathVariable("id") final Long id) {
        return repository.findById(id);
    }

    @GetMapping("/{id}/books")
    public List<Book> findAllBooks(@PathVariable("id") final Long id) {
        return bookRepository.findBookByLibrary_Id(id);
    }
}
