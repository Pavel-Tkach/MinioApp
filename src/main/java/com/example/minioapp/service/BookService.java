package com.example.minioapp.service;

import com.example.minioapp.dto.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class BookService {

    private final ImageStorageService imageStorageService;

    public Book saveBook(Book book, MultipartFile imageFile) {
        try {
            String imageUrl = imageStorageService.uploadImage(imageFile);
            book.setImageUrl(imageUrl);
            return book;
        } catch (Exception e) {
            throw new RuntimeException("Failed to save book.", e);
        }
    }
}
