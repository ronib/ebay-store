import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { ProductService as ProductService } from './product.service';
import { defer } from 'rxjs';

const mockProducts = {

  "itemSummaries": [
    {
      "itemId": "v1|254261181655|0", 
      "title": "CAA MCKFL 500 Lumens Ambi Flashlight for MCK Micro Roni ", 
      "image": { "imageUrl": "https://i.ebayimg.com/thumbs/images/g/qtwAAOSwYX9dACf3/s-l225.jpg" }, 
      "price": { "value": "59.00", "currency": "USD" }, 
      "condition": "New", 
      "thumbnailImages": [{ "imageUrl": "https://i.ebayimg.com/00/s/OTg4WDk3OA==/z/qtwAAOSwYX9dACf3/$_0.PNG?set_id=8800005007" }], 
    },
    { 
      "itemId": 
      "v1|324130407119|0", "title": " CAA Roni 500 Lumens Flashlight Plus Thumb Stop  Micro Roni  / Stab 19 or 17 MCK", 
      "image": { "imageUrl": "https://i.ebayimg.com/thumbs/images/g/b1YAAOSw4BlevFE2/s-l225.jpg" }, 
      "price": { "value": "59.00", "currency": "USD" }, 
      "condition": "New", 
      "thumbnailImages": [{ "imageUrl": "https://i.ebayimg.com/00/s/NTA0WDUwMA==/z/b1YAAOSw4BlevFE2/$_0.JPG?set_id=880000500F" }]
    }]
};

describe('ProductService', () => {
  let service: ProductService;
  let httpClientSpy: { get: jasmine.Spy };


  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ProductService]
    });
    service = TestBed.inject(ProductService);
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);

  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get products data',
    inject([HttpTestingController, ProductService],
      (
        httpMock: HttpTestingController,
        apiService: ProductService
      ) => {

        expect(mockProducts).toBeInstanceOf(Object);
        httpClientSpy.get.and.returnValue(asyncData(mockProducts));

        apiService.getProducts("").subscribe(
          products => {
            expect(httpClientSpy.get.calls.count()).toBe(1, 'one call');
          },
          fail
        );



      }
    )
  );

});

export function asyncData<T>(data: T) {
  return defer(() => Promise.resolve(data));
}