package com.nans.practice.repository;

import com.nans.practice.model.Books;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BooksRepository {

    private final List<Books> booksList = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger();

    public Books save(Books book) {
        book.setBookId(counter.incrementAndGet());
        booksList.add(book);
        return book;
    }

    public List<Books> findAll() {
        return booksList;
    }
}
