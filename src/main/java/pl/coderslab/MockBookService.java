package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MockBookService {
    private List<Book> list;
    private static Long nextId = 3L;
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay	Horstmann, Gary Cornell", "Helion",
                "programming"));
    }
    public void addBook(Book book) {
        book.setId(nextId++);
        list.add(book);
    }
    public Book showBook(Long id) {
        Book book1 = new Book();
        for (Book book : list) {
            if (book.id == id) {
                book1 = book;
            }
        } return book1;
    }
    public void editBook(int id, Book book) {
        list.set(id - 1, book);

    }
    public void deleteBook(int id) {
        list.remove(id - 1);
    }
    public Long getNextId() {
        return nextId;
    }

    public void setNextId(Long nextId) {
        this.nextId = nextId;
    }

    public MockBookService(List<Book> list) {
        this.list = list;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
