package com.genpact.librarymgmt.controller;

import com.genpact.librarymgmt.dto.Library;
import com.genpact.librarymgmt.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryRepository repository;
    @GetMapping
    public List<Library> findAll() {
        return repository.findAll();
    }

    @GetMapping("/search")
    public Library findBySearchKeyWord(@RequestParam("searchKeyWord") final String searchKeyWord) {
        return repository.findByNameLike(searchKeyWord);
    }
}
