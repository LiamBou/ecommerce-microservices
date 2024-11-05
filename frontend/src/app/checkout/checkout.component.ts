import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MatButton, MatFabButton, MatIconButton} from '@angular/material/button';
import {MatIcon} from '@angular/material/icon';
import {Location} from '@angular/common';
import {MatFormField} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {MatLabel} from '@angular/material/form-field';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';


@Component({
  selector: 'app-checkout',
  standalone: true,
  imports: [CommonModule, MatFabButton, MatIcon, MatIconButton, MatButton, MatFormField, MatInput, MatLabel, ReactiveFormsModule],
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css'],
})
export class CheckoutComponent implements OnInit {
  checkoutForm: FormGroup = new FormGroup({});

  constructor(
    private Location: Location,
    private router: Router,
    private fb: FormBuilder) {
  }

  ngOnInit() {
    this.checkoutForm = this.fb.group({
      cardNumber: ['', [Validators.required, Validators.pattern('^[0-9]{16}$')]],
      expiryDate: ['', [Validators.required, Validators.pattern('^(0[1-9]|1[0-2])\/?([0-9]{2})$')]],
      cvv: ['', [Validators.required, Validators.pattern('^[0-9]{3}$')]],
      cardholderName: ['', Validators.required]
    });

  }

  pay(): void {
    if (this.checkoutForm.valid) {
      this.Location.back();
    } else {
      console.log('Form is invalid');
    }
  }

  goBack() {
    this.router.navigate(['/cart']).then(r => console.log());
  }
}
