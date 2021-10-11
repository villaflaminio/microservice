package com.flaminiovilla.bookshare.service;

import com.flaminiovilla.bookshare.exception.BasicException;
import com.flaminiovilla.bookshare.model.Book;
import com.flaminiovilla.bookshare.model.dto.BookDTO;
import com.flaminiovilla.bookshare.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepositor;

    public List<Book> findAll() {
        return bookRepositor.findAll();
    }

    public List<Book> search(String search) {
        Optional<List<Book>> bookList =  bookRepositor.findByTitleContains(search);

        if(bookList.isEmpty())
            return null;
        return bookList.get();
    }



    public Book create(BookDTO bookDTO) {
        if (!bookRepositor.existsByTitle(bookDTO.title)) {
            return bookRepositor.save(Book.builder()
                    .googleBookId(bookDTO.googleBookId)
                    .isbn(bookDTO.isbn)
                    .title(bookDTO.title)
                    .description(bookDTO.description)
                    .price(bookDTO.price)
                    .condition(bookDTO.condition)
                    .phoneNumber(bookDTO.phoneNumber)
                    .build());
        }
        throw new BasicException(BasicException.basicExceptionCode.ILLEGAL_ARGUMENT);

    }

    public Book update(BookDTO bookDTO) {
        if (!bookRepositor.existsById(bookDTO.id)) {
            return bookRepositor.save(Book.builder()
                    .id(bookDTO.id)
                    .googleBookId(bookDTO.googleBookId)
                    .isbn(bookDTO.isbn)
                    .title(bookDTO.title)
                    .description(bookDTO.description)
                    .price(bookDTO.price)
                    .condition(bookDTO.condition)
                    .phoneNumber(bookDTO.phoneNumber)
                    .build());
        }
        throw new BasicException(BasicException.basicExceptionCode.ILLEGAL_ARGUMENT);

    }

    public Optional<Book> findById(BookDTO bookDTO) {
        return bookRepositor.findById(bookDTO.id);
    }

    public Boolean delete(Long id) {
        if(bookRepositor.existsById(id)) {
            try {
                bookRepositor.deleteById(id);
                return true;
            } catch (Exception e) {
                throw new BasicException(BasicException.basicExceptionCode.ID_NOT_EXIST);
            }
        }
        throw new BasicException(BasicException.basicExceptionCode.ILLEGAL_ARGUMENT);
    }
}