package guru.springframework.spring5webapp.Bootstrap;

import guru.springframework.spring5webapp.Repositories.AuthorRepository;
import guru.springframework.spring5webapp.Repositories.BookRepository;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Desing", "12345");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johson");
        Book book = new Book("J2EE", "54321");
        rod.getBooks().add(book);
        book.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: "+ bookRepository.count());
    }


}
