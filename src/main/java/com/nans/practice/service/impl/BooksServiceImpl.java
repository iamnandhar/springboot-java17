package com.nans.practice.service.impl;

import com.nans.practice.model.Books;
import com.nans.practice.repository.BooksRepository;
import com.nans.practice.service.BooksService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("firstService")
@Slf4j
@AllArgsConstructor
public class BooksServiceImpl implements BooksService {

    private BooksRepository booksRepository;
    @Override
    public List<Books> fetchBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Books saveBooks(Books book) {
        return booksRepository.save(book);
    }
}
