import { Component, OnInit } from '@angular/core';
import {
  faArrowRightToBracket,
  faHome,
  faHouseChimney,
  faUser,
} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  loginIcon = faArrowRightToBracket;
  registerIcon = faUser;
  homeIcon = faHouseChimney;

  showLoginButton = true;
  showRegisterButton = true;
  showHomeButton = true;

  constructor() {}

  ngOnInit(): void {
    this.showHomeButton = false;
  }

  loginClicked() {
    this.showLoginButton = false;
    this.showRegisterButton = false;
    this.showHomeButton = true;
  }

  homeClicked() {
    this.showLoginButton = true;
    this.showRegisterButton = true;
    this.showHomeButton = false;
  }
}
