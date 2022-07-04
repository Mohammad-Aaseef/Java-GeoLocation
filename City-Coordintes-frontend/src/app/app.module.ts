import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CityComponent } from './city/city.component';
import {HttpClientModule, HTTP_INTERCEPTORS} from  '@angular/common/http';
import { ApiResponseComponent } from './api-response/api-response.component';
import { HttpErrorInterceptor } from 'src/http-error-interceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxJsonViewerModule } from 'ngx-json-viewer';
// import { AceEditorModule } from 'ng2-ace-editor';



@NgModule({
  declarations: [
    AppComponent,
    CityComponent,
    ApiResponseComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgxJsonViewerModule,
    // AceEditorModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpErrorInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
