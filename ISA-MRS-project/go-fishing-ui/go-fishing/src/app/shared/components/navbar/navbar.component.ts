import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import {
  faArrowRightFromBracket,
  faArrowRightToBracket,
  faHouseChimney,
  faUser,
} from '@fortawesome/free-solid-svg-icons';
import { filter } from 'rxjs/operators';
import { StartpageLoginService } from 'src/app/features/startpage/components/startpage-login/startpage-login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  loginIcon = faArrowRightToBracket;
  registerIcon = faUser;
  homeIcon = faHouseChimney;
  logoutIcon = faArrowRightFromBracket;

  showLoginButton = true;
  showRegisterButton = true;
  showHomeButton = true;

  constructor(
    private router: Router,
    private loginService: StartpageLoginService
  ) {
    this.router.events
      .pipe(
        filter(
          (event): event is NavigationEnd => event instanceof NavigationEnd
        )
      )
      .subscribe((event) => {
        switch (event.url) {
          case '/':
            this.homeClicked();
            break;
          case '/login':
          case '/register':
            this.loginOrRegClicked();
            break;
          default:
            break;
        }
      });
  }

  get showLogoutButton() {
    return localStorage.getItem('jwt') !== null;
  }

  ngOnInit(): void {
    this.showHomeButton = false;
  }

  loginOrRegClicked() {
    this.showLoginButton = false;
    this.showRegisterButton = false;
    this.showHomeButton = true;
  }

  homeClicked() {
    this.showLoginButton = true;
    this.showRegisterButton = true;
    this.showHomeButton = false;
  }

  logout() {
    this.loginService.logout();
  }
}
