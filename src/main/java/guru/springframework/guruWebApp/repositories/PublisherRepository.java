package guru.springframework.guruWebApp.repositories;

import guru.springframework.guruWebApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
