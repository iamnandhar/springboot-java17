package com.nans.practice.repository;

import com.nans.practice.model.Books;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
class BooksRepositoryTest {
    @Autowired
    private BooksRepository booksRepository;

    @Test
    void contextLoads() {
        assertThat(booksRepository).isNotNull();
    }
}

