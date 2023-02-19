package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.Book;
import pl.coderslab.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private MockBookService mockBookService;

    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }
    @RequestMapping("")
        public List<Book> showBooks() {
            return mockBookService.getList();
    }
    @PostMapping("")
        public void addBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {
            mockBookService.addBook(new Book(mockBookService.getNextId(), isbn, title, author, publisher, type));
        }

    @GetMapping("/{id}")
        public Book showBook(@PathVariable Long id) {
            return mockBookService.showBook(id);
    }
    @PutMapping("")
        public void editBook(@RequestParam int id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam String type) {
        mockBookService.editBook(id, new Book(id, isbn, title, author, publisher, type));
    }

    @DeleteMapping("/{id}")
        public void deleteBook(@PathVariable int id) {
            mockBookService.deleteBook(id);
    }
}
