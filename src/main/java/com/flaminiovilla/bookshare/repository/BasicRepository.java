package com.flaminiovilla.bookshare.repository;

import com.flaminiovilla.bookshare.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
    Boolean existsByEmail(String username);
}
