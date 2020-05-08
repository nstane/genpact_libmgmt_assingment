package com.genpact.librarymgmt.controller;


import com.genpact.librarymgmt.dto.Book;
import com.genpact.librarymgmt.dto.Library;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class LibraryControllerTestE2E extends CommonTestContext {

    @Test
    public void testLibraryController() {

        Library library = restTemplate.getForObject(LIBRARY_API_WITH_ID, Library.class, 1);

        assertNotNull(library);

        // Add a new book and verify
        restTemplate.postForEntity(
                BOOK_API,
                new Book(BOOK_TITLE, BOOK_AUTHOR, library),
                Book.class
        );
        List<Book> books = restTemplate.getForObject(LIBRARY_BOOKS_API, List.class, library.getId());

        //assertEquals(books.size(), 2);
    }
}
