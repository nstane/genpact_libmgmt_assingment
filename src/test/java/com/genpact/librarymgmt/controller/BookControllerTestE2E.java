package com.genpact.librarymgmt.controller;


import com.genpact.librarymgmt.dto.Book;
import com.genpact.librarymgmt.dto.Library;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.*;

public class BookControllerTestE2E extends CommonTestContext {

    @Test
    public void testBookController() {

        Library library = restTemplate.getForObject(LIBRARY_API_WITH_ID, Library.class, 1);

        // Get all books and verify
        ResponseEntity<List> bookResponse = restTemplate.getForEntity(BOOK_API, List.class);
        assertTrue(bookResponse.getBody().isEmpty());

        // Add a new book and verify
        ResponseEntity<Book> newAddedBookResponse = restTemplate.postForEntity(
                BOOK_API,
                new Book(BOOK_TITLE, BOOK_AUTHOR, library),
                Book.class
        );

        Book newAddedBook = newAddedBookResponse.getBody();
        assertNotNull(newAddedBook);
        assertEquals(newAddedBook.getAuthor(), BOOK_AUTHOR);

        // Update a book
        restTemplate.put(
                BOOK_API_WITH_ID,
                new Book(BOOK_TITLE, BOOK_AUTHOR_2, library),
                newAddedBook.getId()
        );

        // Get and verify update author name
        newAddedBookResponse = restTemplate.getForEntity(BOOK_API_WITH_ID, Book.class, newAddedBook.getId());

        assertEquals(newAddedBookResponse.getBody().getAuthor(), BOOK_AUTHOR_2);

        // Delete
        restTemplate.delete(BOOK_API_WITH_ID, newAddedBook.getId());

        // Verify there is no object after delete
        bookResponse = restTemplate.getForEntity(BOOK_API, List.class);
        assertTrue(bookResponse.getBody().isEmpty());
    }
}
