package com.example.AzureApp2.repositories;


import com.example.AzureApp2.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Long> {
}