import {Component, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {NgForOf, NgOptimizedImage} from "@angular/common";
import {Product, Stock} from "../app.interface";
import {CartService, ProductService, StockService} from "../app.service";
import {MatDividerModule} from '@angular/material/divider';
import {MatIconModule} from '@angular/material/icon';
import {MatFabButton, MatIconButton} from '@angular/material/button';
import {Router} from '@angular/router';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterOutlet, NgForOf, NgOptimizedImage, MatDividerModule, MatIconModule, MatFabButton, MatIconButton],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  products: Product[] = [];
  stocks: Stock[] = [];
  title = 'frontend';

  constructor(private productService: ProductService,
              private stockService: StockService,
              private cartService: CartService,
              private router: Router) {
  }

  ngOnInit() {
    this.productService.getProducts().subscribe((products) => {
      this.products = products;
      this.stockService.getStocks().subscribe((stocks) => {
        this.stocks = stocks;
        this.products.forEach(product => {
          const stock = this.stocks.find(s => s.article_id === product.id);
          if (stock) {
            product['stockQuantity'] = stock.quantity;
          } else {
            product['stockQuantity'] = 0;
          }
        });
      });
    });
  }

  addToBucket(product: Product) {
    let cart = this.cartService.getCart();
    let cartItem = cart.find(item => item.product?.id === product.id);

    if (cartItem) {
      cartItem.quantity += 1;
      cartItem.totalPrice = cartItem.quantity * product.price;
    } else {
      cartItem = {
        product: product,
        quantity: 1,
        totalPrice: product.price
      };
      cart.push(cartItem);
    }

    this.cartService.updateCart(cart);
    console.log(cartItem);
  }

  viewCart() {
    this.router.navigate(['/cart']).then(r => console.log());
  }

  viewAdmin() {
    this.router.navigate(['/admin']).then(r => console.log());
  }
}
