package com.shtek.testProject.controllers;

import com.shtek.testProject.models.Book;
import com.shtek.testProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String bookMain(Model model) {
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book-main";
    }

    @GetMapping("/bookAdd")
    public String bookAdd(Model model) {
        return "book-add";
    }

    @PostMapping("/bookAdd")
    public String bookPostAdd(@RequestParam String nameBook, @RequestParam String author, @RequestParam String genre, Model model) {
        Book book = new Book(nameBook, author, genre);
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String bookDetails(@PathVariable(value = "id") long id, Model model) {
        if (!bookRepository.existsById(id)) {
            return "redirect:/";
        }

        Optional<Book> book = bookRepository.findById(id);
        ArrayList<Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "book-details";
    }

    @GetMapping("/{id}/edit")
    public String bookEdit(@PathVariable(value = "id") long id, Model model) {
        if (!bookRepository.existsById(id)) {
            return "redirect:/";
        }

        Optional<Book> book = bookRepository.findById(id);
        ArrayList<Book> res = new ArrayList<>();
        book.ifPresent(res::add);
        model.addAttribute("book", res);
        return "book-edit";
    }

    @PostMapping("/{id}/edit")
    public String bookPostUpdate(@PathVariable(value = "id") long id, @RequestParam String nameBook, @RequestParam String author, @RequestParam String genre, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setNameBook(nameBook);
        book.setAuthor(author);
        book.setGenre(genre);
        bookRepository.save(book);
        return "redirect:/";
    }

    @PostMapping("/{id}/remove")
    public String bookPostDelete(@PathVariable(value = "id") long id, @RequestParam String nameBook, @RequestParam String author, @RequestParam String genre, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
        return "redirect:/";
    }
}
