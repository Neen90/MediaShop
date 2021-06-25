package com.vdab.mediashop.repositories;

import com.vdab.mediashop.domain.Book;
import com.vdab.mediashop.domain.Fiction;
import com.vdab.mediashop.domain.Game;
import com.vdab.mediashop.domain.NonFiction;
import com.vdab.mediashop.services.BookService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookRespository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> getAllBooks() {
        TypedQuery<Book> books = entityManager.createQuery("select b from Book b",Book.class);
            return books.getResultList();
        }

    public List<Fiction> getAllFictBooks() {
        TypedQuery<Fiction> fictBooks = entityManager.createQuery("select f from Fiction f",Fiction.class);
        return fictBooks.getResultList();
    }

    public List<NonFiction> getAllNonFictBooks() {
        TypedQuery<NonFiction> nonFictBooks = entityManager.createQuery("select nf from NonFiction  nf",NonFiction.class);
        return nonFictBooks.getResultList();
    }
}