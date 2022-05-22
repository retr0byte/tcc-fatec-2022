import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ControllerService {
  topMenuSearchOpt = false;

  constructor(public auth: AuthService, private http: HttpClient) { }




}
