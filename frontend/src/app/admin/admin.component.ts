import {Component, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {NgClass, NgForOf, NgOptimizedImage} from "@angular/common";
import {MatDividerModule} from '@angular/material/divider';
import {MatIconModule} from '@angular/material/icon';
import {MatButton, MatFabButton, MatIconButton} from '@angular/material/button';
import {Location} from '@angular/common';
import {MatFormField} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {ProductService, StockService} from '../app.service';
import {Product, Stock} from '../app.interface';


@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [RouterOutlet, NgForOf, NgOptimizedImage, MatDividerModule, MatIconModule, MatFabButton, MatIconButton, MatFormField, MatInput, MatButton, FormsModule, NgClass],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit {
  products: Product[] = [];
  stocks: Stock[] = [];
  product: Product = {
    id: '0',
    name: '',
    race: '',
    color: '',
    price: 0,
    description: '',
    image: '',
    stockQuantity: 0
  }

  constructor(
    private Location: Location,
    private productService: ProductService,
    private stockService: StockService,
  ) {
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

    this.product = {
      id: '0',
      name: '',
      race: '',
      color: '',
      price: 0,
      description: '',
      image: '',
      stockQuantity: 0
    }
  }

  addProduct() {
    console.log(this.product);
    this.productService.addProduct(this.product).subscribe(response => {
      console.log('Product added successfully', response);
    }, error => {
      console.error('Error adding product', error);
    });
    this.stockService.editStock(this.product.id, this.product.stockQuantity);
  }

  editStock(id: string, quantity: number) {
    this.stockService.editStock(id, quantity).subscribe(() => {
      this.ngOnInit();
    });
  }

  deleteProduct(id: string) {
    this.productService.deleteProduct(id);
    this.editStock(id, -1);
    this.ngOnInit();
  }

  goBack() {
    this.Location.back();
  }

}
