package org.example.hibernatetestapp.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(cascade = CascadeType.ALL)
  private Set<OrderItem> items;

  private Date orderDate;

  // Конструкторы, геттеры и сеттеры
}
