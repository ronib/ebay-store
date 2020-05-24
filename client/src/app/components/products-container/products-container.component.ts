import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../../models/interfaces';
import { ProductService} from '../../product.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-products-container',
  templateUrl: './products-container.component.html',
  styleUrls: ['./products-container.component.scss']
})
export class ProductsContainerComponent implements OnInit {

  products$: Observable<Product[]>;
  selectedProduct: Product;
  selected = 'best';
  searchValue = '';


  constructor(private productService: ProductService) { }

  ngOnInit(): void {
 
  }

  onSearch(){
    this.products$ = this.productService.getProducts(this.searchValue);
  }

  onSelect(product: Product) {
    this.selectedProduct = product;
  }

}
