package com.flaminiovilla.client.client;

import com.flaminiovilla.client.model.Book;
import com.flaminiovilla.client.model.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name="BOOK-SHARE-SERVICE" )
public interface BookClient {
    static final String RELATIVE_PATH_BOOK = "/book";

    @PostMapping(RELATIVE_PATH_BOOK + "/search/{search}")
    public List<Book> search(@PathVariable("search") String search);

    @GetMapping(RELATIVE_PATH_BOOK + "/findAll")
    public List<Book> findAll();

    @PostMapping(RELATIVE_PATH_BOOK + "/findById")
    public Optional<Book> findById(@RequestBody BookDTO bookDTO);
}
