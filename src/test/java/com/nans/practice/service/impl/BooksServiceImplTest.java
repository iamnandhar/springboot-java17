package com.nans.practice.service.impl;

import com.nans.practice.model.Books;
import com.nans.practice.repository.BooksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BooksServiceImplTest {
    @Mock
    private BooksRepository booksRepository;

    @InjectMocks
    private BooksServiceImpl booksServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchBooks() {
        List<Books> booksList = Arrays.asList(
                new Books("1", "Book1", "Author1", BigDecimal.TEN),
                new Books("2", "Book2", "Author2", BigDecimal.ONE)
        );
        when(booksRepository.findAll()).thenReturn(booksList);
        List<Books> result = booksServiceImpl.fetchBooks();
        assertEquals(2, result.size());
        verify(booksRepository, times(1)).findAll();
    }

    @Test
    void testSaveBooks() {
        Books book = new Books("3", "Book3", "Author3", BigDecimal.ZERO);
        when(booksRepository.save(book)).thenReturn(book);
        Books result = booksServiceImpl.saveBooks(book);
        assertEquals(book, result);
        verify(booksRepository, times(1)).save(book);
    }
}

