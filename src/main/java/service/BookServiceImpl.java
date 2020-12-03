package service;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.BookRepository;

public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public Book save(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public void remove(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public Page<Book> findAllByNameContaining(String string, Pageable pageable) {
        return bookRepository.findAllByNameContaining(string, pageable);
    }
}
