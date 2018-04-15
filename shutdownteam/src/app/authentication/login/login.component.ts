import { Component, OnInit, AfterViewInit, OnDestroy, ViewContainerRef  } from '@angular/core';
import { AuthenticateService } from '../../service/authenticate.service';
import { Subscription } from 'rxjs/Subscription';
import { Router } from '@angular/router';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, AfterViewInit {

    //-- ATTRIBUTS
    private userName: string;
    private password: string;
    private postStream$: Subscription;
    //-- END ATTRIBUTS

    //-- CONSTRUCTOR && INJECTING SERVICES 
    constructor(private authenticateService: AuthenticateService, private router: Router) {
    }
    //-- END CONSTRUCTOR && INJECTING SERVICES 

    ngOnInit() {}

    ngAfterViewInit() {
        $(function() {
            $(".preloader").fadeOut();
        });
        $(function() {
            (<any>$('[data-toggle="tooltip"]')).tooltip()
        });
        $('#to-recover').on("click", function() {
            $("#loginform").slideUp();
            $("#recoverform").fadeIn();
        });
    }

    onLoggedin() {
        localStorage.setItem('isLoggedin', 'true');
    }

    //-- METHODES

    //-- LOGIN FUNCTION
    login() {
        if (this.postStream$) { this.postStream$.unsubscribe }

        this.postStream$ = this.authenticateService.login$(this.userName, this.password).subscribe(
            result => {
                if (result.state == 1) {
                } else {
                }
            }
        )
    }
    //-- END LOGIN FUNCTION

    //-- DESTROYING DATA SESSIONS
    ngOnDestroy() {
        if (this.postStream$) { this.postStream$.unsubscribe() }
    }
    //-- END DESTROYING DATA SESSIONS

}
