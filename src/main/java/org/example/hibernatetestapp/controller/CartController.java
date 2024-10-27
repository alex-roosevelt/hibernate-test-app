package org.example.hibernatetestapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
  private final CartService cartService;

  public CartController() {
    this.cartService = new CartService();
  }

  @PostMapping("/{cartId}/addProduct")
  public String addProductToCart(@PathVariable Long cartId,
      @RequestParam Long productId,
      @RequestParam int quantity) {
    cartService.addProductToCart(cartId, productId, quantity);
    return "Product added to cart.";
  }

  @PostMapping("/{cartId}/checkout")
  public String checkout(@PathVariable Long cartId) {
    cartService.checkout(cartId);
    return "Checkout completed.";
  }
}
