package com.wangyousong.practice.audit.service;

import com.wangyousong.practice.audit.entity.Book;
import com.wangyousong.practice.audit.repository.BookRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Resource
    private BookRepository bookRepository;


    public Book editBookDetails(String isbn, Book book){
        return bookRepository.findByIsbn(isbn)
                .map(existingBook -> {
                    var bookToUpdate = new Book(
                            existingBook.getId(),
                            existingBook.getIsbn(),
                            book.getTitle(),
                            book.getAuthor(),
                            book.getPrice(),
                            book.getPublisher(),
                            existingBook.getCreatedBy(),
                            existingBook.getCreatedAt(),
                            existingBook.getUpdatedBy(),
                            existingBook.getUpdatedAt(),
                            existingBook.getVersion()
                    );
                    return bookRepository.save(bookToUpdate);
                }).orElseGet(() -> addBookToCatalog(book));
    }

    private Book addBookToCatalog(Book book) {
        Book bookToSave = Book.of(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getPublisher());
        return bookRepository.save(bookToSave);
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
