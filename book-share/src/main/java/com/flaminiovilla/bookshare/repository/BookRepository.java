package com.flaminiovilla.bookshare.repository;

import com.flaminiovilla.bookshare.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface BookRepository extends JpaRepository<Book,Long> {
     Optional<List<Book>> findByTitleContains(String section);
     Boolean existsByTitle(String title);

}
