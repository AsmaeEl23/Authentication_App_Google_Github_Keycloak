import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
  products:any
  constructor(private http:HttpClient) {
    this.http
      .get("http://localhost:8082/products")
      .subscribe(
        {
          next:value=> {
            console.log(value)
            this.products=value},
          error:err => {
            console.log(err)
          }
        }
      )

  }
}
