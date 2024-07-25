package com.example.minioapp.controller;

import com.example.minioapp.dto.Book;
import com.example.minioapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Book> createBook(@RequestPart("book") Book book,
                                           @RequestPart("image") MultipartFile image) {
        Book savedBook = bookService.saveBook(book, image);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
}
