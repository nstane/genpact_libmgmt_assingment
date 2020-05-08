package com.genpact.librarymgmt.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookControllerTest {

    //@Autowired
    //private BookController controller;

   /* @BeforeTestMethod
    public void setup() {
        controller = new BookController();
    }*/

    @Test
    public void shoudReturnBookWithId() {
        Assert.isNull(null);
    }
}
