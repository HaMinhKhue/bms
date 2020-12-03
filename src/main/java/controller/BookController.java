package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.BookService;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public ModelAndView bookList(@RequestParam("s")Optional<String>s, @PageableDefault(size = 3)Pageable pageable){
        Page<Book> books;
        if (s.isPresent()){
            books=bookService.findAllByNameContaining(s.get(),pageable);
        }else {
            books=bookService.findAll(pageable);
        }
        ModelAndView modelAndView=new ModelAndView("/book/list");
        modelAndView.addObject("books",books);
        return modelAndView;
    }
}
