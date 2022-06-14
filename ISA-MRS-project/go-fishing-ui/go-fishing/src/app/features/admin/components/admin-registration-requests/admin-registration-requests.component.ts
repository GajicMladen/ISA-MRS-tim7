import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MessageService, MessageType } from 'src/app/shared/services/message-service/message.service';

@Component({
  selector: 'app-admin-registration-requests',
  templateUrl: './admin-registration-requests.component.html',
  styleUrls: ['./admin-registration-requests.component.css']
})
export class AdminRegistrationRequestsComponent implements OnInit {

  adminId: number;

  requests = [
    {
      id: 1,
      name: 'Marko Stančić',
      role: 'Instruktor',
      reason: 'Želim da zaradim novac.'
    },
    {
      id: 2,
      name: 'Luka Tešić',
      role: 'Vlasnik vikendice',
      reason: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Totam ad, dignissimos error at aut quidem! '
    },
    {
      id: 3,
      name: 'Ognjen Vasić',
      role: 'Vlasnik broda',
      reason: 'Ullam odit, illum, corporis placeat quo quae quod aperiam, ex impedit molestiae quos magni vero.Ullam odit, illum, corporis placeat quo quae quod aperiam, ex impedit molestiae quos magni vero.'
    }
  ]

  beingRefused: number = -1;

  constructor(private route: ActivatedRoute,
              private messageService: MessageService) { }

  ngOnInit(): void {
    this.adminId = Number(this.route.snapshot.paramMap.get('id'));
  }

  RequestBeingRefused(id: number) {
    this.beingRefused = id;
    //console.log("---" + this.beingRefused);
  }

  RefuseRequest() {
    this.requests.forEach((element, index) => {if(element.id === this.beingRefused) this.requests.splice(index, 1)});
    this.messageService.showMessage('Zahtev za registraciju odbijen!', MessageType.SUCCESS);
  }

  AcceptRequest(id: number) {
    console.log(id);
    this.requests.forEach((element, index) => {if(element.id === id) this.requests.splice(index, 1)});
    this.messageService.showMessage('Zahtev za registraciju prihvaćen!', MessageType.SUCCESS);
  }

}
