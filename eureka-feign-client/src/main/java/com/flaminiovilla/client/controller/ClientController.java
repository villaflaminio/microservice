package com.flaminiovilla.client.controller;

import com.flaminiovilla.client.client.BookClient;
import com.flaminiovilla.client.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private BookClient bookClient;

    @GetMapping("/data")
    public List<Book> getData() {
        return bookClient.findAll();
    }
}
