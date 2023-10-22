package com.wangyousong.practice.audit.controller;

import com.wangyousong.practice.audit.entity.Book;
import com.wangyousong.practice.audit.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping
    public Iterable<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/{isbn}/actions/edit")
    public Book editBookDetails(@PathVariable String isbn, @RequestBody Book book) {
        return bookService.editBookDetails(isbn, book);
    }
}
