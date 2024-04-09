package com.nans.practice.controller;

import com.nans.practice.model.Books;
import com.nans.practice.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
@SuppressWarnings("unused")
public class BooksController {

    private final BooksService booksService;

    @GetMapping("/")
    public List<Books> getData() {
        return booksService.fetchBooks();
    }

    @PostMapping("/")
    public Books saveData(@RequestBody Books book) {
        return booksService.saveBooks(book);
    }
}
