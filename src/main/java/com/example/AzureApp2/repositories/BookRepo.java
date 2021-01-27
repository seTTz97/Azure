package com.example.AzureApp2.repositories;

import com.example.AzureApp2.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
}
