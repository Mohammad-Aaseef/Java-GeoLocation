import { formatCurrency } from '@angular/common';
import { compileDeclareClassMetadata, compilePipeFromMetadata } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Subscription } from 'rxjs';
import { CityModel } from '../city-model';
import { CityServiceService } from '../services/city-service.service';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {
  value: any;
  apiResponse: any;
  subscription: Subscription = new Subscription;
  loading: boolean = false;
  error: string = "";
  
  constructor(private service: CityServiceService) { }

  
  CityModel: CityModel = new CityModel;
  ngOnInit(): void {
    this.CityModel = { 
      cityName:""
    };

    // this.service.gethelloworld().subscribe((response)=> {
    //   console.log(response.message)
    //   this.apiResponse = response.message;
    // });
  }

  onClickSubmit(coordinates: NgForm) {
    console.log("You have entered : ", coordinates);
    this.value = coordinates.value.cityName;
    this.loading = true;
    this.subscription =  this.service.getCityCoordinates(this.value).subscribe((response) => {
      //console.log(response.status)
      this.loading = false;
      // if(response.code == 200){
      //   this.apiResponse = response;
      // }
      this.apiResponse = response.data[0];
    }, error => {
      this.error = error;
      this.loading = false;
    }
    );
 }

 ngOnDestroy() {
  this.subscription.unsubscribe();
}
}
