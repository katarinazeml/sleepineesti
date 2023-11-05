import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MainPageComponent} from "./pages/main-page/main-page.component";
import {LoginPageComponent} from "./pages/login-page/login-page.component";
import {AuthGuard} from "./auth/AuthGuard";
import {RegisterPageComponent} from "./pages/register-page/register-page.component";
import {HousingAddPageComponent} from "./pages/housing-add-page/housing-add-page.component";
import {HousingPageComponent} from "./pages/housing-page/housing-page.component";
import {BookingHistoryPageComponent} from "./pages/booking-history-page/booking-history-page.component";
import {MatDialogModule} from "@angular/material/dialog";
import {FormsModule} from "@angular/forms";

const routes: Routes = [
  {path: '', component: MainPageComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginPageComponent},
  {path: 'register', component: RegisterPageComponent},
  {path: 'housing/add', component: HousingAddPageComponent},
  {path: 'housing/:id', component: HousingPageComponent},
  {path: 'booking/history', component: BookingHistoryPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), MatDialogModule, FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
