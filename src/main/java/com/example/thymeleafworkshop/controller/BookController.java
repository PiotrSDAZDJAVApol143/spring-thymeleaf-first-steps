package com.example.thymeleafworkshop.controller;

import com.example.thymeleafworkshop.model.Book;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")

public class BookController {

    private final List<Book> books;

    public BookController() {
        this.books = new ArrayList<>();
        books.add(new Book("Ogniem i Mieczem", "Henryk Sienkiewicz"));
        books.add(new Book("Pan Tadeusz", "Adam Mickiewicz"));
        books.add(new Book("Lalka", "Bolesław Prus"));
        books.add(new Book("Chłopi", "Władysław Reymont"));
    }

    @GetMapping("/all")
    public String showAllBooks(ModelMap model) {
        model.addAttribute("books", books);
        model.addAttribute("newBook", new Book());
        model.addAttribute("bookToDelete", new Book());
        return "book";
    }
    @PostMapping("/addBook")
    public String addBook(@Valid @ModelAttribute ("newBook") Book book){   // @ModelA... działa jak @RequestBody
        System.out.println(book);
        books.add(book);

        return "redirect:/book/all";
    }
    @PostMapping("/delete")
    public String deleteBook(@ModelAttribute("bookToDelete") Book bookToDelete) {
        books.removeIf(book -> book.getTitle().equals(bookToDelete.getTitle()));
        return "redirect:/book/all";
    }


}
