export interface IAdventure {
	id?: number;
	name: string;
	promoDescription: string;
	price: number;
	capacity: number;

	instructorId: number;
	instructorBiography: string;
}

export class Adventure {
    id?: number;
	name: string;
	promoDescription: string;
	price: number;
	capacity: number;

	instructorId: number;
	instructorBiography: string;

	constructor(object: IAdventure) {
		this.name = object.name;
		this.promoDescription = object.promoDescription;
		this.price = object.price;
		this.capacity = object.capacity;
		this.instructorId = object.instructorId;
		this.instructorBiography = object.instructorBiography;
	}
}