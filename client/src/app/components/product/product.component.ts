import { Component, OnInit, Input } from '@angular/core';
import { ProductService } from '../../product.service';
import { Observable } from 'rxjs';
import { Product } from '../../models/interfaces';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  @Input() product: Product;
  products$: Observable<Product[]>;
  selectedProduct: Product;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  onSelect(product: Product) {
    this.selectedProduct = product;
  }
}
