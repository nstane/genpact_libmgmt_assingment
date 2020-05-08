package com.genpact.librarymgmt.controller;


import com.genpact.librarymgmt.dto.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan(basePackages = "com.genpact.librarymgmt")
@TestPropertySource(value = "classpath:application-test.properties")
public class BookControllerTestE2E {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String BOOK_API = "/api/book";
    private static final String BOOK_TITILE = "Spring developer guide";
    private static final String BOOK_AUTHOR = "Narender Singh";
    private static final String BOOK_AUTHOR_2 = "Narender Singh Tanwar";

    @Test
    public void testBookController() {
        // Get all books and verify
        ResponseEntity<List> bookResponse = restTemplate.getForEntity(BOOK_API, List.class);
        assertTrue(bookResponse.getBody().isEmpty());

        // Add a new book and verify
        ResponseEntity<Book> newAddedBookResponse = restTemplate.postForEntity(
                BOOK_API,
                new Book(BOOK_TITILE, BOOK_AUTHOR),
                Book.class
        );

        Book newAddedBook = newAddedBookResponse.getBody();
        assertNotNull(newAddedBook);
        assertEquals(newAddedBook.getAuthor(), BOOK_AUTHOR);

        String bookApiUrlWithId = BOOK_API + "/" + newAddedBook.getId();

        // Update a book
        restTemplate.put(
                bookApiUrlWithId,
                new Book(BOOK_TITILE, BOOK_AUTHOR_2),
                Book.class
        );

        // Get and verify update author name
        newAddedBookResponse = restTemplate.getForEntity(bookApiUrlWithId, Book.class);

        assertEquals(newAddedBookResponse.getBody().getAuthor(), BOOK_AUTHOR_2);

        // Delete
        restTemplate.delete(bookApiUrlWithId);

        // Verify there is no object after delete
        bookResponse = restTemplate.getForEntity(BOOK_API, List.class);
        assertTrue(bookResponse.getBody().isEmpty());
    }
}
