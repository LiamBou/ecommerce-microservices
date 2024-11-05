import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {MatDivider} from '@angular/material/divider';
import {MatFabButton, MatIconButton} from '@angular/material/button';
import {MatIcon} from '@angular/material/icon';
import {NgForOf, NgOptimizedImage} from '@angular/common';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MatDivider, MatFabButton, MatIcon, MatIconButton, NgForOf, NgOptimizedImage],
  template: '<router-outlet></router-outlet>',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
