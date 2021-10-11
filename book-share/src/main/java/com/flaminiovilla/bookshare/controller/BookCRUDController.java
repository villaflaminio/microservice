package com.flaminiovilla.bookshare.controller;

import com.flaminiovilla.bookshare.model.Book;
import com.flaminiovilla.bookshare.model.dto.BookDTO;
import com.flaminiovilla.bookshare.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book")
public class BookCRUDController {

    @Autowired
    private BookService bookService;


    /**
     * Crea Book
     * @return Book
     */
    @PostMapping("/create")
    @ResponseBody
    public Book create(@RequestBody BookDTO bookDTO){
        return bookService.create(bookDTO);
    }


    /**
     * Update Book
     * @return Category
     */
    @PutMapping("/update")
    @ResponseBody
    public Book update(@RequestBody BookDTO bookDTO){
        return bookService.update(bookDTO);
    }

    /**
     * delete from id
     * {"id" : }
     * @return Boolean
     */
    @DeleteMapping("/delete")
    public Boolean delete(@RequestBody BookDTO bookDTO){
        return bookService.delete(bookDTO.id);
    }

}
