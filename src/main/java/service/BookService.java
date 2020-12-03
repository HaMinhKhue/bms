package service;

import model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
Page<Book> findAll(Pageable pageable);
Book findById(Long id);
Book save(Book book);
void remove(Long id);
Page<Book> findAllByNameContaining(String string,Pageable pageable);

}