package com.nans.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nans.practice.model.Books;
import com.nans.practice.service.BooksService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BooksController.class)
class BooksControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BooksService booksService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetData() throws Exception {
        List<Books> booksList = Arrays.asList(
                new Books("1", "Book1", "Author1", BigDecimal.TEN),
                new Books("2", "Book2", "Author2", BigDecimal.ONE)
        );
        when(booksService.fetchBooks()).thenReturn(booksList);
        mockMvc.perform(get("/api/books/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[1].id").value("2"));
    }

    @Test
    void testSaveData() throws Exception {
        Books book = new Books("3", "Book3", "Author3", BigDecimal.ZERO);
        when(booksService.saveBooks(Mockito.any(Books.class))).thenReturn(book);
        mockMvc.perform(post("/api/books/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("3"));
    }
}

