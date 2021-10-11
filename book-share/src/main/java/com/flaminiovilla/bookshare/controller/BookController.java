package com.flaminiovilla.bookshare.controller;

import com.flaminiovilla.bookshare.model.Book;
import com.flaminiovilla.bookshare.model.dto.BookDTO;
import com.flaminiovilla.bookshare.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    /**
     * restituisce tutti i librit  che contengono la stringa di ricerca nel titolo
     * @return List<Book>
     * se null restituisce []
     */
    @PostMapping("/search/{search}")
    List<Book> search(@PathVariable("search") String search){
        return bookService.search(search);
    }


    /**
     * search from id:
     * {"id" : }

     * @return News
     */
    @PostMapping("/findById")
    Optional<Book> findById(@RequestBody BookDTO bookDTO){
        return bookService.findById(bookDTO);
    }

}
