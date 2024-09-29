package com.akimi.hibernate_sandbox_mvn;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class Books {

    @PersistenceContext
    private EntityManager entityManager;

    // Create a new Book
    public void save(Book book) {
        entityManager.persist(book);
    }

    // Read a Book by ID
    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    // Read all Books
    public List<Book> findAll() {
        return entityManager.createQuery("from Book", Book.class).getResultList();
    }

    // Update a Book
    public void update(Book book) {
        entityManager.merge(book);
    }

    // Delete a Book
    public void deleteById(Long id) {
        Book book = entityManager.find(Book.class, id);
        if (book != null) {
            entityManager.remove(book);
        }
    }

}
