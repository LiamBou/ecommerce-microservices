import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CartItem, Order, Product, Stock} from './app.interface';
import {CookieService} from 'ngx-cookie-service';


@Injectable({
  providedIn: 'root',
})
export class OrderService {
  private baseUrl = 'http://localhost:8084';

  constructor(private http: HttpClient) {
  }

  getOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.baseUrl}/order`);
  }
}

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = 'http://localhost:8084';

  constructor(private http: HttpClient) {
  }

  addProduct(product: Product) {
    return this.http.post(`${this.baseUrl}/product`, product);
  }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/product`);
  }
}


@Injectable({
  providedIn: 'root'
})
export class StockService {
  private baseUrl = 'http://localhost:8084';

  constructor(private http: HttpClient) {
  }

  getStocks(): Observable<Stock[]> {
    return this.http.get<Stock[]>(`${this.baseUrl}/stock/get/all`);
  }
}

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cartKey = 'cart';

  constructor(private cookieService: CookieService) {
  }

  updateCart(cart: CartItem[]) {
    this.cookieService.set(this.cartKey, JSON.stringify(cart));
  }

  getCart(): CartItem[] {
    const cart = this.cookieService.get(this.cartKey);
    return cart ? JSON.parse(cart) : [];
  }
}
