import { Component, OnInit } from '@angular/core';
import { StartpageLoginService } from 'src/app/features/startpage/components/startpage-login/startpage-login.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
  user: any;

  constructor(private userService: StartpageLoginService) {}

  ngOnInit(): void {
    this.user = this.userService.user;
  }
}
