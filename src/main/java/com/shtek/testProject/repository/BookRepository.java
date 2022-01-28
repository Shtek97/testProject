package com.shtek.testProject.repository;

import com.shtek.testProject.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
