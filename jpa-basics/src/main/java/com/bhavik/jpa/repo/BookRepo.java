package com.bhavik.jpa.repo;

import com.bhavik.jpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
