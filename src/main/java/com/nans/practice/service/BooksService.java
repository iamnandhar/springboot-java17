package com.nans.practice.service;

import com.nans.practice.model.Books;

import java.util.List;

public interface BooksService {
    List<Books> fetchBooks();
    Books saveBooks(Books book);
}
