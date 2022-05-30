import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/shared/classes/user';
import { UserService } from 'src/app/shared/services/users-services/user.service';

@Component({
  selector: 'app-cottage-ownerpage',
  templateUrl: './cottage-ownerpage.component.html',
  styleUrls: ['./cottage-ownerpage.component.css']
})
export class CottageOwnerpageComponent implements OnInit {

  ownerId : number;
  owner : User;

  constructor(private route : ActivatedRoute,private userService:UserService ) { }

  ngOnInit(): void {
    this.ownerId = Number(this.route.snapshot.paramMap.get('id'));
    console.log(this.ownerId);
    
    if(!isNaN(this.ownerId)){
      this.userService.findById(this.ownerId).subscribe(user => {
        this.owner = user;
        console.log(this.owner);
      })
    }

  }

}
