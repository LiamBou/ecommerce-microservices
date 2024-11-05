import {Component, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {NgForOf, NgOptimizedImage} from "@angular/common";
import {MatDividerModule} from '@angular/material/divider';
import {MatIconModule} from '@angular/material/icon';
import {MatButton, MatFabButton, MatIconButton} from '@angular/material/button';
import {Location} from '@angular/common';
import {MatFormField} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import {ProductService, StockService} from '../app.service';
import {Product} from '../app.interface';


@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [RouterOutlet, NgForOf, NgOptimizedImage, MatDividerModule, MatIconModule, MatFabButton, MatIconButton, MatFormField, MatInput, MatButton, FormsModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit {
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
    private stockService: StockService
  ) {
  }

  ngOnInit() {

  }

  addProduct() {
    this.productService.addProduct(this.product);
    this.goBack();
  }

  goBack() {
    this.Location.back();
  }

}
