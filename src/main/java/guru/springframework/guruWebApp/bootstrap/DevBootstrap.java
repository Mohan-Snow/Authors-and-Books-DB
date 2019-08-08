package guru.springframework.guruWebApp.bootstrap;

import guru.springframework.guruWebApp.model.Author;
import guru.springframework.guruWebApp.model.Book;
import guru.springframework.guruWebApp.model.Publisher;
import guru.springframework.guruWebApp.repositories.AuthorRepository;
import guru.springframework.guruWebApp.repositories.BookRepository;
import guru.springframework.guruWebApp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component // it makes a Spring Bean. It'll get wired up by the Spring Context
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    // they're gonna get autowired here
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    // constructor to have these both fields get injected
    // to let Spring do Dependency Injection
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Eric
        Publisher hc = new Publisher("Harper Collins");
        Author aEric = new Author("Eric", "Evans");
        Book dad = new Book("Domain Driven Design", "1234", hc);
        aEric.getBooks() // get the set of books
                .add(dad);
        dad.getAuthors() // get the set of authors
                .add(aEric);

        publisherRepository.save(hc);
        authorRepository.save(aEric); // saving to repository
        bookRepository.save(dad);


        // Rod
        Publisher worx = new Publisher("Worx");
        Author aRod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        aRod.getBooks().add(noEJB);
        noEJB.getAuthors().add(aRod);

        publisherRepository.save(worx);
        authorRepository.save(aRod);
        bookRepository.save(noEJB);
    }
}
