import { Component } from '@angular/core';
import {KeycloakProfile} from "keycloak-js";
import {KeycloakService} from "keycloak-angular";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-front-app';
  public isLoggedIn=false;
  public userProfile:KeycloakProfile|null=null;
  constructor(private keycloak:KeycloakService) {
  }
  async ngOnInit() {
    this.isLoggedIn = this.keycloak.isLoggedIn();

    if (this.isLoggedIn) {
      this.userProfile = await this.keycloak.loadUserProfile();
    }
  }

  logout() {
    this.keycloak.logout();
  }

  login() {
    this.keycloak.login()
  }

  account() {
    window.location.href="http://localhost:8080/realms/sdia-app-realm/account/#/personal-info";
  }
}
