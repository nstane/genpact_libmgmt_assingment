package com.genpact.librarymgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan(basePackages = "com.genpact.librarymgmt")
@TestPropertySource(value = "classpath:application-test.properties")
public class CommonTestContext {

    @Autowired
    protected TestRestTemplate restTemplate;
    protected static final String BOOK_API = "/api/book";
    protected static final String BOOK_API_WITH_ID = "/api/book/{id}";
    protected static final String LIBRARY_API_WITH_ID = "/api/library/{id}";
    protected static final String BOOK_TITLE = "Spring developer guide";
    protected static final String BOOK_AUTHOR = "Narender Singh";
    protected static final String BOOK_AUTHOR_2 = "Narender Singh Tanwar";
    protected static final String LIBRARY_BOOKS_API = "/api/library/{id}/books";

}
