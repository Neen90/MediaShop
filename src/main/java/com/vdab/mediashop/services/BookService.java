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
}
