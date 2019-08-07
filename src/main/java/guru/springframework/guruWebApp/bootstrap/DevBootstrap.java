package guru.springframework.guruWebApp.bootstrap;

import guru.springframework.guruWebApp.model.Author;
import guru.springframework.guruWebApp.model.Book;
import guru.springframework.guruWebApp.repositories.AuthorRepository;
import guru.springframework.guruWebApp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component // it makes a Spring Bean. It'll get wired up by the Spring Context
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    // they're gonna get autowired here
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    // constructor to have these both fields get injected
    // to let Spring do Dependency Injection
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // Eric
        Author aEric = new Author("Eric", "Evans");
        Book dad = new Book("Domain Driven Design", "1234", "Harper Collins");
        aEric.getBooks().add(dad);
        dad.getAuthors().add(aEric);

        authorRepository.save(aEric);
        bookRepository.save(dad);

        // Rod
        Author aRod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
        aRod.getBooks().add(noEJB);
        noEJB.getAuthors().add(aRod);

        authorRepository.save(aRod);
        bookRepository.save(noEJB);
    }
}
