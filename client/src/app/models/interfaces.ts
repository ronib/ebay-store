import { logging } from 'protractor';
import { DecimalPipe } from '@angular/common';

export interface Product {
    itemId: number;
    title: string;
    price: any;
    image: any;
    condition: string;
    thumbnailImages: []; 
}


