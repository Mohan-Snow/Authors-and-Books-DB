package guru.springframework.guruWebApp.repositories;

import guru.springframework.guruWebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
