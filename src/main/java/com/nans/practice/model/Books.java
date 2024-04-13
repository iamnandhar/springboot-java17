package com.nans.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "Books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    @Id
    private String id;
    private String bookName;
    private String author;
    private BigDecimal price;
}
