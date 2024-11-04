import {Component, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {NgForOf, NgOptimizedImage} from "@angular/common";
import {HttpClient} from "@angular/common/http";
import {Order} from "./app.interface";
import {OrderService} from "./app.service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NgForOf, NgOptimizedImage],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  products: Order[] = [];
  title = 'frontend';

  constructor(private orderService : OrderService) {}

    ngOnInit() {
      console.log("Getting products");
        this.orderService.getOrders().subscribe((products)=>{
            this.products = products;
        })
  }
}
