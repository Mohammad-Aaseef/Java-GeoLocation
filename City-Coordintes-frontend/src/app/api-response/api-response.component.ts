import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-api-response',
  templateUrl: './api-response.component.html',
  styleUrls: ['./api-response.component.css']
})
export class ApiResponseComponent implements OnInit {


  @Input() apiResponse = "";
  constructor() { }

  ngOnInit(): void {
  }

}
