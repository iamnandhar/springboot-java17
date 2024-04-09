package com.nans.practice.controller;

import com.nans.practice.model.Books;
import com.nans.practice.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BooksController {

    private final BooksService booksService;

    @GetMapping("/")
    public void getData() {
        booksService.fetchBooks();
    }

    @PostMapping("/")
    public void saveData(@RequestBody Books book) {
        booksService.saveBooks(book);
    }
}
