import { Injectable } from '@angular/core';
import { Adventure } from 'src/models/adventure';
import { Boat } from 'src/models/boat';
import { Cottage } from 'src/models/cottage';

@Injectable({
  providedIn: 'root',
})
export class StartpagePreviewListService {
  constructor() {}

  // Dummy method, needs implementation with api.
  getBoatPreviewList(): Array<Boat> {
    let boatArray = new Array<Boat>();

    let boat1: Boat = {
      id:1,
      ownerId:1,
      name: 'First Boat',
      description: 'This is our first ever boat.',
      images: [
        'https://www.frauscherboats.com/wp-content/uploads/2020/09/1414_air11.jpg',
      ],
      rulesOfConduct: ['No partying allowed!', 'No drinking allowed!'],
      price: 350,
      deleted: false,
      capacity: 3,
      numOfEngines: 3,
      powerOfEngines: 300,
      maxSpeed: 200,
      averageRating: 3.3,
      boatType: 'Small Fishing Boat',
      length: 25,
      extraFavors:""
    };

    let boat2: Boat = {
      id:2,
      ownerId:1,
      name: 'Second Boat',
      description:
        'This is our second boat. It is quite reliable and we very much recommend it!',
      images: [
        'https://d1nkxkz7ge96ao.cloudfront.net/eyJidWNrZXQiOiJzbW4tbWFpbi1zaXRlLWJ1Y2tldCIsImtleSI6ImltYWdlc1wvaW1hZ2luXC9McktPcmhFcE5FN0FNV3lFQUxRMUpFOE0wTjVsc1VkekxsNU9ZcEZsLmpwZyIsImVkaXRzIjp7InJlc2l6ZSI6eyJ3aWR0aCI6MjYwMCwiaGVpZ2h0IjoxMzAwLCJmaXQiOiJjb3ZlciJ9fX0=',
      ],
      rulesOfConduct: ['No partying allowed!', 'No drinking allowed!'],
      price: 300,
      deleted: false,
      capacity: 10,
      numOfEngines: 13,
      powerOfEngines: 1000,
      maxSpeed: 150,
      averageRating: 4.7,
      boatType: 'Yacht',
      length: 100,
      extraFavors:""
    };

    let boat3: Boat = {
      id:3,
      ownerId:1,
      name: 'Third Boat',
      description: 'This is our third ever boat. It is quite neat!',
      images: [
        'https://alfastreet-marine.com/wp-content/uploads/2020/01/8a.jpg',
      ],
      rulesOfConduct: ['No partying allowed!', 'No drinking allowed!'],
      price: 250,
      deleted: false,
      capacity: 2,
      numOfEngines: 2,
      powerOfEngines: 200,
      maxSpeed: 100,
      averageRating: 3.8,
      length: 20,
      boatType: 'Medium Sized Boat',
      extraFavors:""
    };

    let boat4: Boat = {
      id:4,
      ownerId:1,
      name: 'Fourth Boat',
      description:
        'This is our fourth ever boat. Not very liked amongst users.',
      images: [
        'https://frg-fwm.azurewebsites.net/asset/fwm/Upload/Models/Images/Main/Ferretti/55242.jpg',
      ],
      rulesOfConduct: ['No partying allowed!', 'No drinking allowed!'],
      price: 1000,
      deleted: false,
      capacity: 4,
      numOfEngines: 5,
      powerOfEngines: 550,
      maxSpeed: 500,
      averageRating: 1.9,
      boatType: 'Semi Large Cruiser',
      length: 75,
      extraFavors:""
    };

    let boat5: Boat = {
      id:5,
      ownerId:1,
      name: 'Fifth Boat',
      description: 'This is our fifth ever boat. Best so far',
      images: ['https://nautika-present.com/wp-content/uploads/2020/11/1.png'],
      rulesOfConduct: ['No partying allowed!', 'No drinking allowed!'],
      price: 400,
      deleted: false,
      capacity: 5,
      numOfEngines: 1,
      powerOfEngines: 200,
      maxSpeed: 180,
      averageRating: 4.9,
      boatType: 'Small Boat',
      length: 30,
      extraFavors:""
    };

    boatArray.push(boat1, boat2, boat3, boat4, boat5);
    boatArray.push(boat1, boat2, boat3, boat4, boat5);
    return boatArray;
  }

  // Dummy method, needs implementation with api.
  getCottagePreviewList(): Array<Cottage> {
    let cottageArray = new Array<Cottage>();

    let cottage1: Cottage = {
      name: 'Small Cottage',
      description: 'This is a tiny, cozy cottage',
      images: [
        'https://homeworlddesign.com/wp-content/uploads/2017/01/Pieniny-House-Small-Cottage-14.jpg',
      ],
      rulesOfConduct: ['No smoking', 'No partying'],
      price: 350,
      deleted: false,
      capacity: 2,
      averageRating: 4.4,
      roomCount: 1,
      bedCount: 2,
      ownerId:1,
      id:1,
      extraFavors:""
    };

    let cottage2: Cottage = {
      name: 'Medium Cottage',
      description: 'This is a medium, decently cozy cottage',
      images: [
        'https://static.onecms.io/wp-content/uploads/sites/24/2014/01/cloudland_0_0_0.jpg',
      ],
      rulesOfConduct: ['No smoking', 'No partying'],
      price: 450,
      deleted: false,
      capacity: 3,
      averageRating: 3.8,roomCount: 1,
      bedCount: 2,
      ownerId:1,
      id:1,
      extraFavors:""
    };
    let cottage3: Cottage = {
      name: 'Large Cottage',
      description: 'This is a large, spacious cottage',
      images: [
        'https://images.ctfassets.net/gxwgulxyxxy1/11XYu4kApwYo86SEMgK6mE/2df844c500d2a2085718229d532b0bac/00.jpg',
      ],
      rulesOfConduct: ['No smoking', 'No partying'],
      price: 550,
      deleted: false,
      capacity: 1,
      averageRating: 4.2,roomCount: 1,
      bedCount: 2,
      ownerId:1,
      id:1,
      extraFavors:""
    };
    let cottage4: Cottage = {
      name: 'Extra Large Cottage',
      description: 'This is a very large, humongous cottage',
      images: [
        'https://i0.wp.com/kateandtoms.com/wp-content/uploads/2020/11/marsden-drone-1600x900-1.jpg?resize=1600%2C900&ssl=1',
      ],
      rulesOfConduct: ['No smoking', 'No partying'],
      price: 650,
      deleted: false,
      capacity: 5,
      averageRating: 3.1,
      roomCount: 1,
      bedCount: 2,
      ownerId:1,
      id:1,
      extraFavors:""
    };
    let cottage5: Cottage = {
      name: 'Small Cabin',
      description: 'This is a very small, tiny cabin room',
      images: [
        'https://www.thespruce.com/thmb/DiV3BeT9kD8BfALo2CJsgPJt3YQ=/4000x2667/filters:no_upscale():max_bytes(150000):strip_icc()/Escape-trvler-cabin-5912179f3df78c9283c758a7.jpg',
      ],
      rulesOfConduct: ['No smoking', 'No partying'],
      price: 200,
      deleted: false,
      capacity: 1,
      averageRating: 2.9,
      roomCount: 1,
      bedCount: 2,
      ownerId:1,
      id:1,
      extraFavors:""
    };

    cottageArray.push(cottage1, cottage2, cottage3, cottage4, cottage5);
    return cottageArray;
  }

  // Dummy method, needs implementation with api.
  getAdventurePreviewList(): Array<Adventure> {
    let adventureArray = new Array<Adventure>();

    let adventure1: Adventure = {
      id:1,
      name: 'Big Game Hunting',
      description: 'Your guide will take you bear hunting',
      images: [
        'https://images.squarespace-cdn.com/content/v1/5a8c528880bd5e8953b6b83a/1577638692757-QRN47N8RTM1URSS0O5ER/ArcheryElk.jpg?format=1000w',
      ],
      rulesOfConduct: ['No headshots'],
      price: 270,
      deleted: false,
      capacity: 2,
      averageRating: 3.9,
      extraFavors:"",
      biography: 'Jack Sparrow will take you bear hunting',
    };

    let adventure2: Adventure = {
      id:1,
      name: 'Whale Fishing',
      description: 'Your guide will take you whale fishing',
      images: [
        'https://i.guim.co.uk/img/media/c456b64af93189db3d3d2dca640ca734b6e38687/0_58_2293_1376/master/2293.jpg?width=1200&quality=85&auto=format&fit=max&s=4b276b56ffffaba2c903a39665f4360d',
      ],
      rulesOfConduct: ['No harpoons'],
      price: 800,
      deleted: false,
      capacity: 3,
      averageRating: 3.4,
      extraFavors:"",
      biography: 'Jason Vorhees will take you whale fishing',
    };

    let adventure3: Adventure = {
      id:1,
      name: 'Ski Jumping',
      description: 'Your guide will take you ski jumping',
      images: [
        'https://img.olympicchannel.com/images/image/private/t_16-9_360-203_2x/f_auto/v1538355600/primary/qhguxj7xq4dqwjnlj9zr',
      ],
      rulesOfConduct: ['No parachutes'],
      price: 440,
      deleted: false,
      capacity: 1,
      averageRating: 2.9,
      extraFavors:"",
      biography: 'Cristiano Ronaldo will take you bear hunting',
    };

    let adventure4: Adventure = {
      id:1,
      name: 'Bungee Jumping',
      description: 'Your guide will take you bungee jumping',
      images: [
        'https://img.redbull.com/images/c_crop,w_3000,h_1500,x_0,y_500,f_auto,q_auto/c_scale,w_1200/redbullcom/2018/03/05/060b519f-de01-4cd6-9b97-036a8c6d3fb6/bungee-jumping',
      ],
      rulesOfConduct: ['No bungee rope'],
      price: 170,
      deleted: false,
      capacity: 1,
      averageRating: 4.8,
      extraFavors:"",
      biography: 'Jack Sparrow will take you bungee jumping',
    };

    let adventure5: Adventure = {
      id:1,
      name: 'Boating',
      description: 'Your guide will take you boating',
      images: [
        'https://www.explorebranson.com/sites/default/files/styles/hero/public/blogs/table_rock_lake_0.jpg?itok=hAGoKPxd',
      ],
      rulesOfConduct: ['No fishing'],
      price: 300,
      deleted: false,
      capacity: 2,
      averageRating: 3.9,
      extraFavors:"",
      biography: 'Diego Forlan will take you boating',
    };

    adventureArray.push(
      adventure1,
      adventure2,
      adventure3,
      adventure4,
      adventure5
    );
    return adventureArray;
  }

  filterArrayByParam(array: any, param: string): any {
    let ret: any = [];
    for (let i of array) {
      if (
        this.getObjectValuesString(i)
          .toLowerCase()
          .includes(param.toLowerCase())
      )
        ret.push(i);
    }
    return ret;
  }

  getObjectValuesString(object: any): string {
    let ret: string = '';
    for (let i in object) {
      ret += object[i] + ' ';
    }
    return ret;
  }
}
