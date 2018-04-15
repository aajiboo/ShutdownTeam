import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { FullComponent } from './layouts/full/full.component';
import { BlankComponent } from './layouts/blank/blank.component';

export const routes: Routes = [
    {
        path: '',
        component: BlankComponent,
        children: [
            {
                path: '',
                redirectTo: 'authentication/login',
                pathMatch: 'full'
            },
            {
                path: 'authentication',
                loadChildren: './authentication/authentication.module#AuthenticationModule'
            }
        ]
    }, 
{
    path: '',
    component: FullComponent,
    children: [
        { path: 'dashboard', loadChildren: './dashboards/dashboard.module#DashboardModule' }
    ]
},
{
    path: '**',
    redirectTo: '404' 
}];

@NgModule({
    imports: [RouterModule.forRoot(routes), NgbModule.forRoot()],
    exports: [RouterModule]
})
export class AppRoutingModule { }

