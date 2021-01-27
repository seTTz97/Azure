package com.example.AzureApp2.bootstrap;

import com.example.AzureApp2.model.Author;
import com.example.AzureApp2.model.Book;
import com.example.AzureApp2.repositories.AuthorRepo;
import com.example.AzureApp2.repositories.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public BootstrapData(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        //hard coding to add some authors and books
        Author adam = new Author("Adam", "Mickiewicz");
        Book dziady = new Book("Dziady część III");
        adam.getBooks().add(dziady);
        dziady.getAuthors().add(adam);

        Author henryk = new Author("Henryk", "Sienkiewicz");
        Book potop = new Book("Potop");
        henryk.getBooks().add(potop);
        potop.getAuthors().add(henryk);

        authorRepo.save(adam);
        bookRepo.save(dziady);
        authorRepo.save(henryk);
        bookRepo.save(potop);

    }
}
