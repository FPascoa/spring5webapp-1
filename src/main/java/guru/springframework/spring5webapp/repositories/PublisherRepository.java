package guru.springframework.spring5webapp.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {


  default List<Book> getBooks(Publisher publisher) {
    List<Book> books = new ArrayList<>();
    Iterable<Publisher> all = findAll();
    for (Publisher p : all) {
      p.getBooks().iterator().forEachRemaining(books::add);
    }

    return books;
  }
}
