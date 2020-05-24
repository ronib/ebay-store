import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from '@angular/material/card';
import {MatSelectModule} from '@angular/material/select';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    NoopAnimationsModule,
    MatCardModule,
    MatSelectModule
  ],
  exports: [
    CommonModule,
    NoopAnimationsModule,
    MatCardModule,
    MatSelectModule
  ]
})
export class SharedModule { }
