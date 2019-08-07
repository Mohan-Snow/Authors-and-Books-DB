package guru.springframework.guruWebApp.repositories;

import guru.springframework.guruWebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
