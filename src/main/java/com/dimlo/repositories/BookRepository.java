package com.dimlo.repositories;

import com.dimlo.entity.Book;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface BookRepository extends CrudRepository<Book, Integer> {




}
