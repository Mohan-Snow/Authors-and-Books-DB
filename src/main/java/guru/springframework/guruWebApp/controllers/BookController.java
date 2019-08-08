package guru.springframework.guruWebApp.controllers;

import guru.springframework.guruWebApp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// it tells that this's a Spring Bean
// it's now gonna be a Spring Manage Component
@Controller
public class BookController {

    private BookRepository bookRepository;

    // it requests for the repository so Spring will autowire it automatically
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // when it comes to the books URL this method's gonna get invoked
    @RequestMapping("/book")
    public String getBooks(Model model) {

        // here we adding an attribute called books to the model
        model.addAttribute("books", bookRepository.findAll());

        // returning the string books >>
        // this's gonna tell Spring MVC to associate this
        // with a view called books
        return "books";
    }


}
