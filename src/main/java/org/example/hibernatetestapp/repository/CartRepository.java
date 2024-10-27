package org.example.hibernatetestapp.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CartRepository {
  private SessionFactory sessionFactory;

  public CartRepository() {
    sessionFactory = new Configuration().configure().buildSessionFactory();
  }

  public void saveCart(Cart cart) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    session.saveOrUpdate(cart);
    transaction.commit();
    session.close();
  }

  public Cart getCart(Long id) {
    Session session = sessionFactory.openSession();
    Cart cart = session.get(Cart.class, id);
    session.close();
    return cart;
  }
}
