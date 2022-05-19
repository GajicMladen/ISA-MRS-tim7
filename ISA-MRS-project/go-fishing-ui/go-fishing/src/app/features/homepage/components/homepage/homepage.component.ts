import { Component, OnInit } from '@angular/core';
import { StartpageLoginService } from 'src/app/features/startpage/components/startpage-login/startpage-login.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
  constructor(private userService: StartpageLoginService) {}

  ngOnInit(): void {}

  get userName() {
    return this.userService.userName;
  }
}
