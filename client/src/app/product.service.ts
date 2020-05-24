import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Product } from './models/interfaces';
import { HttpClient }    from '@angular/common/http';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getProducts(searchValue: string): Observable<Product[]> {
    return this.http.get<any>(`${environment.apiUrl}/search/${searchValue}`).pipe(
      map(summary => summary["itemSummaries"])
    );
  }

}
