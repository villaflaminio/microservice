package com.flaminiovilla.client.service;

import org.springframework.stereotype.Component;

@Component
public class BookService {

//    @Autowired
//    private BookRepository bookRepositor;
//
//    public List<Book> findAll() {
//        return bookRepositor.findAll();
//    }
//
//    public List<Book> search(String search) {
//        Optional<List<Book>> bookList =  bookRepositor.findByTitleContains(search);
//
//        if(bookList.isEmpty())
//            return null;
//        return bookList.get();
//    }
//
//
//
//    public Book create(BookDTO bookDTO) {
//        if (!bookRepositor.existsByTitle(bookDTO.title)) {
//            return bookRepositor.save(Book.builder()
//                    .googleBookId(bookDTO.googleBookId)
//                    .isbn(bookDTO.isbn)
//                    .title(bookDTO.title)
//                    .description(bookDTO.description)
//                    .price(bookDTO.price)
//                    .phoneNumber(bookDTO.phoneNumber)
//                    .build());
//        }
//        throw new BasicException(BasicException.basicExceptionCode.ILLEGAL_ARGUMENT);
//
//    }
//
//    public Book update(BookDTO bookDTO) {
//        if (bookRepositor.existsById(bookDTO.id)) {
//            return bookRepositor.save(Book.builder()
//                    .id(bookDTO.id)
//                    .googleBookId(bookDTO.googleBookId)
//                    .isbn(bookDTO.isbn)
//                    .title(bookDTO.title)
//                    .description(bookDTO.description)
//                    .price(bookDTO.price)
//                    .phoneNumber(bookDTO.phoneNumber)
//                    .build());
//        }
//        throw new BasicException(BasicException.basicExceptionCode.ILLEGAL_ARGUMENT);
//
//    }
//
//    public Optional<Book> findById(BookDTO bookDTO) {
//        return bookRepositor.findById(bookDTO.id);
//    }
//
//    public Boolean delete(Long id) {
//        if(bookRepositor.existsById(id)) {
//            try {
//                bookRepositor.deleteById(id);
//                return true;
//            } catch (Exception e) {
//                throw new BasicException(BasicException.basicExceptionCode.ID_NOT_EXIST);
//            }
//        }
//        throw new BasicException(BasicException.basicExceptionCode.ILLEGAL_ARGUMENT);
//    }
}