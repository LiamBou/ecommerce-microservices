import {Component, OnInit} from '@angular/core';
import {CartService} from '../app.service';
import {CartItem} from '../app.interface';
import {CommonModule} from '@angular/common';
import {MatFabButton, MatIconButton} from '@angular/material/button';
import {MatIcon} from '@angular/material/icon';
import {Location} from '@angular/common';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule, MatFabButton, MatIcon, MatIconButton],
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartItems: CartItem[] = [];

  constructor(private cartService: CartService,
              private Location: Location) {
  }

  ngOnInit() {
    this.cartItems = this.cartService.getCart();
  }

  decreaseQuantity(item: CartItem) {
    if (item.quantity > 1) {
      item.quantity--;
      item.totalPrice = item.product.price * item.quantity;
      this.updateCart();
    }
  }

  increaseQuantity(item: CartItem) {
    item.quantity++;
    item.totalPrice = item.product.price * item.quantity;
    this.updateCart();
  }

  deleteItem(item: CartItem) {
    this.cartItems = this.cartItems.filter(cartItem => cartItem !== item);
    this.updateCart();
  }

  private updateCart() {
    this.cartService.updateCart(this.cartItems);
  }

  goBack() {
    this.Location.back();
  }
}