package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Book book = new Book();
    }

    @Test
    public void shouldUseEquals () {
        Book book1 = new Book(2, "Жизнь взаимы", 80, "Ремарк");
        Book book2 = new Book(2, "Жизнь взаимы", 80, "Ремарк");

        assertEquals(book1, book2);
    }

}