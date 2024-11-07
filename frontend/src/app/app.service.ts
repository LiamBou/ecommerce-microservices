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

  addOrder(order: Order) {
    //return this.http.post(`${this.baseUrl}/order`, order);
    console.log(order);
    return this.http.post(`http://localhost:8082/order`, order);
  }
}

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = 'http://localhost:8084';

  constructor(private http: HttpClient, private stockService: StockService) {
  }

  addProduct(product: Product) {
    const {stockQuantity, id, ...productWithoutStock} = product;
    console.log(productWithoutStock);
    // return this.http.post(`${this.baseUrl}/product`, productWithoutStock);
    return this.http.post(`http://localhost:8083/product`, productWithoutStock);
  }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.baseUrl}/product`);
  }

  deleteProduct(id: string) {
    this.stockService.editStock(id, -1).subscribe(() => {
      return this.http.delete(`${this.baseUrl}/product/${id}`);
    });
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

  editStock(product_id: String, newQuantity: number) {
    //return this.http.post(`${this.baseUrl}/stock/add/${product_id}/${newQuantity}`, {});
    return this.http.post(`http://localhost:8081/add/${product_id}/${newQuantity}`, {});

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

  clearCart() {
    this.cookieService.delete(this.cartKey);
  }
}
