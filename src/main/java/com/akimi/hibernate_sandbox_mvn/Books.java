package com.akimi.hibernate_sandbox_mvn;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Books {

    private final SessionFactory sessionFactory;

    @Autowired
    public Books(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    public List<Book> findAll() {
	var session = sessionFactory.getCurrentSession();
	return session.createQuery("from Book", Book.class).list();
    }

    public Item findById(Long id) {
	var session = sessionFactory.getCurrentSession();
	return session.get(Item.class, id);
    }

    public void save(Book book) {
	var session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(book);
    }

    public void delete(Long id) {
	var session = sessionFactory.getCurrentSession();
	var item = session.get(Book.class, id);
	if (item != null) {
	    session.delete(item);
	}
    }

}
