package com.akimi.hibernate_sandbox_mvn;

import java.util.List;

import org.hibernate.Session;
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

    public List<Item> findAll() {
	Session session = sessionFactory.getCurrentSession();
	return session.createQuery("from Item", Item.class).list();
    }

    public Item findById(Long id) {
	Session session = sessionFactory.getCurrentSession();
	return session.get(Item.class, id);
    }

    public void save(Item item) {
	Session session = sessionFactory.getCurrentSession();
	session.saveOrUpdate(item);
    }

    public void delete(Long id) {
	Session session = sessionFactory.getCurrentSession();
	Item item = session.get(Item.class, id);
	if (item != null) {
	    session.delete(item);
	}
    }

}
