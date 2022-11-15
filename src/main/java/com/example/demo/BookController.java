package com.example.demo;

import com.example.demo.persistence.BookEntity;
import com.example.demo.persistence.BookRepository;
import com.example.demo.persistence.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    private final SearchService searchService;

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookEntity> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(value = "/books/isbn/{isbn}")
    public List<BookEntity> searchBooksByIsbn(@PathVariable String isbn) {
        return searchService.searchBookEntities(isbn);
    }

    @GetMapping("/initialIndexing")
    public void triggerInitialIndexing() {
        searchService.triggerInitialIndexing();
    }
}
