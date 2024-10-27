package org.example.hibernatetestapp.repository;

public class OrderRepository {
  private SessionFactory sessionFactory;

  public OrderRepository() {
    sessionFactory = new Configuration().configure().buildSessionFactory();
  }

  public void saveOrder(Order order) {
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    session.save(order);
    transaction.commit();
    session.close();
  }
}
