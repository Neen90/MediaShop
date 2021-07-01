package com.vdab.mediashop.services;

import com.vdab.mediashop.domain.Book;
import com.vdab.mediashop.domain.Fiction;
import com.vdab.mediashop.domain.NonFiction;
import com.vdab.mediashop.repositories.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRespository bookRespository;

    public List<Book> getAllBooks() {
        return bookRespository.getAllBooks();
    }

    public List<Fiction> getAllFictBooks() {
        return bookRespository.getAllFictBooks();
    }

    public List<NonFiction> getAllNonFictBooks() {
        return bookRespository.getAllNonFictBooks();
    }

    public void saveFiction(Fiction newFiction) {
        bookRespository.saveFiction(newFiction);

    }
    public void saveNonFiction(NonFiction newNonFiction) {
        bookRespository.saveNonFiction(newNonFiction);
    }

    public Fiction findFictionById(long id) {
        return bookRespository.findFictionById(id);
    }

    public void updateFiction(Fiction fiction) {
        bookRespository.updateFiction(fiction);
    }

    public NonFiction findNonFictionById(long id) {
        return bookRespository.findNonFictionById(id);
    }

    public void updateNonFiction(NonFiction nonFiction) {
        bookRespository.updateNonFiction(nonFiction);
    }

    public void deleteFiction(long id) {
        bookRespository.deleteFiction(id);
    }

    public void deleteNonFiction(long id) {
        bookRespository.deleteNonFiction(id);
    }
}
