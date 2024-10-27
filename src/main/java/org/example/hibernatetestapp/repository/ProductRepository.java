package org.example.hibernatetestapp.repository;

public class ProductRepository {
  private SessionFactory sessionFactory;

  public ProductRepository() {
    sessionFactory = new Configuration().configure().buildSessionFactory();
  }

  public Product getProduct(Long id) {
    Session session = sessionFactory.openSession();
    Product product = session.get(Product.class, id);
    session.close();
    return product;
  }
}
