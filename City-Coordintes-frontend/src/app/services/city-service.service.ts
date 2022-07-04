import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { catchError, map } from 'rxjs/operators';
import { HelloWorldBean } from '../hello-world-bean';
import { GoogleGeoCode } from '../Response/GoogleGeoCode';
import 'rxjs/add/observable/of';

@Injectable({
  providedIn: 'root'
})
export class CityServiceService {
 
  baseurl = "http://localhost:8080/geocode/";
  baseurl1 = "http://localhost:8080/helloworld";

  constructor(private http: HttpClient) { }

  getCityCoordinates(val?: any) :Observable<any>{
    const URL = this.baseurl;
    let queryParams = new HttpParams();
    queryParams = queryParams.append('address', val);
    queryParams = queryParams.append('ssl', true);
    return this.http.get<any>(URL, { params: queryParams })
  }

  // gethelloworld(): Observable<any>{
  //   const URL = this.baseurl1;
  //   // const headers= new HttpHeaders()
  //   //   .set('content-type', 'text')
  //   //   .set('Access-Control-Allow-Origin', '*');
  //     return this.http.get<HelloWorldBean>(URL);
  // }
}
