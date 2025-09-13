package com.nans.practice.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BooksTest {
    @Test
    void testNoArgsConstructorAndSetters() {
        Books book = new Books();
        book.setId("1");
        book.setBookName("Test Book");
        book.setAuthor("Author");
        book.setPrice(BigDecimal.TEN);
        assertEquals("1", book.getId());
        assertEquals("Test Book", book.getBookName());
        assertEquals("Author", book.getAuthor());
        assertEquals(BigDecimal.TEN, book.getPrice());
    }

    @Test
    void testAllArgsConstructorAndGetters() {
        Books book = new Books("2", "Another Book", "Writer", BigDecimal.ONE);
        assertEquals("2", book.getId());
        assertEquals("Another Book", book.getBookName());
        assertEquals("Writer", book.getAuthor());
        assertEquals(BigDecimal.ONE, book.getPrice());
    }

    @Test
    void testEqualsAndHashCode() {
        Books book1 = new Books("3", "Book", "A", BigDecimal.ZERO);
        Books book2 = new Books("3", "Book", "A", BigDecimal.ZERO);
        assertEquals(book1, book2);
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    void testToString() {
        Books book = new Books("4", "Book", "A", BigDecimal.ZERO);
        assertTrue(book.toString().contains("Book"));
    }
}

