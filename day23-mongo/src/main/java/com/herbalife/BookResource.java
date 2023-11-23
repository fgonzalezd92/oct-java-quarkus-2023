package com.herbalife;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/books")
public class BookResource {
    @Inject
    BookService bookService;

    @PATCH
    public Book updatePrice(@QueryParam("title") String title,
                            @QueryParam("price") double price) {
        return bookService.updatePrice(title, price);
    }

    @DELETE
    public void delete(@QueryParam("title") String title) {
        bookService.delete(title);
    }

    @GET
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @POST
    public void create(@QueryParam("title") String title,
                       @QueryParam("author") String author,
                       @QueryParam("price") double price) {
        bookService.create(title, author, price);
    }
}
