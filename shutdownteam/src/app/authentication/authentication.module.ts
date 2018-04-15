import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

import { LoginComponent } from './login/login.component';
import {FormsModule} from '@angular/forms';
import { AuthenticationRoutes } from './authentication.routing';
import {AuthenticateService} from '../service/authenticate.service';

@NgModule({
  imports: [ 
    CommonModule,
    FormsModule,
  
    RouterModule.forChild(AuthenticationRoutes)
  ],
  declarations: [
    LoginComponent
  ],
  providers : [
    AuthenticateService
  ]
})

export class AuthenticationModule {}
