package org.example.hibernatetestapp.service;

public class CartService {
  private CartRepository cartRepository;
  private ProductRepository productRepository;
  private OrderRepository orderRepository;

  public CartService() {
    this.cartRepository = new CartRepository();
    this.productRepository = new ProductRepository();
    this.orderRepository = new OrderRepository();
  }

  public void addProductToCart(Long cartId, Long productId, int quantity) {
    Cart cart = cartRepository.getCart(cartId);
    Product product = productRepository.getProduct(productId);

    OrderItem orderItem = new OrderItem();
    orderItem.setProduct(product);
    orderItem.setQuantity(quantity);

    cart.addItem(orderItem);
    cartRepository.saveCart(cart);
  }

  public void checkout(Long cartId) {
    Cart cart = cartRepository.getCart(cartId);

    Order order = new Order();
    order.setItems(cart.getItems());
    order.setOrderDate(new Date());

    orderRepository.saveOrder(order);
  }
}
