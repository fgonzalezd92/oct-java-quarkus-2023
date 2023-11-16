package com.herbalife;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class BookService {

    @Inject
    BookRepository bookRepository;

    public void create(String title, String author, double price) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);
        bookRepository.persist(book);
    }

    public List<Book> getAll() {
        return bookRepository.listAll();
    }

    public Book updatePrice(String title, double price) {
        Book book = bookRepository.find("title", title).firstResult();
        book.setPrice(price);
        bookRepository.update(book);
        return book;
    }

    public void delete(String title) {
        bookRepository.delete("title", title);
    }
}
