INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Novi Sad', 'Serbia', 'Tihomira Ostojica 2', '45.254410', '19.842550');
INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Mali Zvornik', 'Srbija', 'Nikole Tesle 7', '44.371665', '19.107743');
INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Ljubovija', 'Srbija', 'Karađorđeva 10', '44.188216', '19.377376');
INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Mali Zvornik', 'Srbija', 'Sakar 28', '44.361090', '19.121489');
INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Ljubovija', 'Srbija', 'Vrhpolje 007', '44.131978', '19.447603');
INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Mali Zvornik', 'Srbija', 'Sakar 25', '44.361094', '19.121489');
INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Ljubovija', 'Srbija', 'Vrhpolje 8', '44.131974', '19.447603');
INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Ljubovija', 'Srbija', 'Karadjordjeva 10', '44.188249', '19.377129');

INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
				    (true, false, 'p3r5kul45@gmail.com', 'Tomic', 'Jovan', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381607229290', 500, 1);

INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'niko.nikic093@gmail.com', 'Gajic', 'Mladen', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381644281080', 1000, 2);
				
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'mika.mikic.1389@gmail.com', 'Mikic', 'Mika', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381642298111', 0, 2);
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'pera.peric.1912@gmail.com', 'Peric', 'Pera', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381642222111', 0, 3);
					
					
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'nb@gmail.com', 'Bajagic', 'NIkola', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+38161234432', 0, 1);

INSERT INTO public.users(active, deleted, email, lastname, name, password, phone,loyalty_points, address_id) VALUES
					(true, false, 'mb@gmail.com', 'Bajagic', 'Marko', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381659997778', 0, 1);

INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'djordjejovanovic27@gmail.com', 'Jovanovic', 'Djordje', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381642222111', 0, 8);
					
					
INSERT INTO public.cottage_owners(id) VALUES (2);

	
INSERT INTO public.fishing_instructor (id) VALUES (3);
INSERT INTO public.fishing_instructor (id) VALUES (4);

INSERT INTO public.boat_owner(id) VALUES (5);
INSERT INTO public.boat_owner(id) VALUES (6);

INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE (name) VALUES ('ROLE_COTTAGE_OWNER');
INSERT INTO ROLE (name) VALUES ('ROLE_BOAT_OWNER');
INSERT INTO ROLE (name) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO ROLE (name) VALUES ('ROLE_SYSADMIN');

INSERT INTO USER_ROLE(user_id, role_id) VALUES (1, 2);
INSERT INTO USER_ROLE(user_id, role_id) VALUES (2, 3);

INSERT INTO USER_ROLE(user_id, role_id) VALUES (3, 5);
INSERT INTO USER_ROLE(user_id, role_id) VALUES (4, 5);
INSERT INTO USER_ROLE(user_id, role_id) VALUES (7, 6);

INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 39.6, 10, 'Vikendica Kosmaj', 'Vila Mišeluk se nalazi na samo nekoliko kilometara od Novog Sada što je samo jedan od razloga da je posetite. Idealna je za druženja kako u letnjem periodu, tako i u zimskom. Kada je lepo vreme možete uživati u roštilju pored bazena i prelepom dvorištu. U zimskom periodu, Vaše okupljanje možete napraviti u prostranoj dnevnoj prostoriji. Pored toga tu su i dve spavaće sobe, kuhinja i kupatilo.Ova vila je odličan izbor za momačke i devojačke veceri, kao i za sve ostale tipove druženja. Posetite nas i uverite se!'
	        , null);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 96.7, 25, 'Villa Djosa Vrhpolje', 'Moderna vikendica u blizini restorana Vidikovac na svega 14 minuta od Novog Sada. Nalazi se na 9km od centra. Sama vikendica ima 55 kvadrata i kapacitet za nocenje 5 osoba. Za druženje ili intimnije proslave maksimum je 15 osoba. Poseduje bazen, roštilj, četiri parking mesta, veliko travnato dvorište, dečije igralište, preko 15 mesta za sedenje napolju, ozvučenje, internet, Wi-Fi, Netflix i HBO, kao i kompletno opremljenu kuhinju.', null);

INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 96.7, 25, 'Rajska Idila', 'Vikendica na Alibegovcu je odličan izbor za sve vrste proslava sa ozvučenjem koje je uračunato u cenu. Pored toga pruža još nekolicinu pogodnosti. Nalazi se na samo 6km od Novog Sada i može da primi čak 50 osoba.Prostarana unutrašnjost raspodeljena je u tri nivoa. U prizemlju se nalazi velika dnevna soba sa zasebnom kuhinjom i kupatilom, kao i stoni tenis koji možete iskoristiti da upotpunite Vaše druženje. Na prvom spratu se nalaze tri spavaće sobe, dnevna soba i kuhinja. Na poslednjem spratu je velika prostorija, u kojoj se nalaze klupe i barski stolovi tako da je idealna za žurke i proslave. Van kuće se nalazi prostrana terasa sa zidanim roštiljem. Vaš boravak može ispuniti i jedna partija basketa, jer je tu i koš. Iskoristite ono što Vam pruža kuća na Alibegovcu i napravite nezaboravan rođendan ili druženje.', null);

	
	
INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 99.99, 10, 'Pecanje na Zvorničkom jezeru', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 4);
	
INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 129.99, 5, 'Rafting na Drini', 'Nezaboravno iskustvo na Drini! Iskusite sve čari raftinga na Drini. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 5);	

INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 199.99, 8, 'Na Drini rafting', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 6);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 79.99, 4, 'Pecanja casovi', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 7);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 49.99, 10, 'Casovi pecanja', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 3);

INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 125, 25, 'Flash boat', 'S ovim dobro poznatim brendom možete se otisnuti na dalju, bezbednu i prijatnu putešestviju, ili jednostavno užitati u plivanju i pecanju s porodicom i prijateljima.Pametna prostorna rešenja i robustnost sinonimi su za ovaj švedski motorni kruzer. Svakog gosta dočekaće piće dobrodošlice i snekovi. Kapetanovi lokalni specijaliteti dostupni su na zahtev'
	, null);

INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 150, 25, 'SEA ray 275', 'Ova motorna jahta prima do 8 ljudi. Prilično brzo ćete se odvesti van grada kako biste se prepustili uživanju u divljoj prirodi Save i Dunava.Ova udobna i luksuzna jahta opremljena je toaletom, kuhinjom i poseduje 4 ležaja. Posle nekoliko sati provedenih na ovom brodu sigurno ćete poželeti da se na njemu zadržite duže.'
	, null);

INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 96.7, 25, 'Monstery', 'Lepota luksuz i hedonizam zajednički su imenitelji ovog kruzera. Ako odlučite da iznenadite poslovnog , životnog partnera ili samog sebe,provedite nezaboravno vreme koje ćete ovekovečiti jedinstvenim fotografijama.Ovakvi doživljaji moraju ostati zabeleženi'
	, null);

	
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (1, 2 ,2,2);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (2, 2,5,7);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (3, 2,6,9);

INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography, equipment, more_info, rules_of_conduct, rules_of_cancelation, deleted)
	VALUES (4, 3, 'Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores ullam quos, sit placeat labore voluptatem dignissimos officiis incidunt, perferendis eos porro nobis autem modi ab aliquam maiores. Dolorem, numquam quod.',
			'Mamci|Mreza za pecanje|Stapovi|Varalice|Prsluci za spasavanje|Cizme|Dodatni camci|Kombinezoni', 'Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.', 'Zabranjeno bacanje smenja|Zabranjeno skakanje u vodu bez dozvole|Zabranjeno donosenje alkohola|Zabranjeno donosenje hrane|Zabranjeno pusenje',
			'U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.', false);
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography, equipment, more_info, rules_of_conduct, rules_of_cancelation, deleted)
	VALUES (5, 4, 'Pera Peric je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores ullam quos, sit placeat labore voluptatem dignissimos officiis incidunt, perferendis eos porro nobis autem modi ab aliquam maiores. Dolorem, numquam quod.',
			'Mamci|Mreza za pecanje|Stapovi|Varalice|Prsluci za spasavanje|Cizme|Dodatni camci|Kombinezoni', 'Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.', 'Zabranjeno bacanje smenja|Zabranjeno skakanje u vodu bez dozvole|Zabranjeno donosenje alkohola|Zabranjeno donosenje hrane|Zabranjeno pusenje',
			'U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.', false);
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography, equipment, more_info, rules_of_conduct, rules_of_cancelation, deleted)
	VALUES (6, 4, 'Pera Peric je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores ullam quos, sit placeat labore voluptatem dignissimos officiis incidunt, perferendis eos porro nobis autem modi ab aliquam maiores. Dolorem, numquam quod.',
			'Mamci|Mreza za pecanje|Stapovi|Varalice|Prsluci za spasavanje|Cizme|Dodatni camci|Kombinezoni', 'Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.', 'Zabranjeno bacanje smenja|Zabranjeno skakanje u vodu bez dozvole|Zabranjeno donosenje alkohola|Zabranjeno donosenje hrane|Zabranjeno pusenje',
			'U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.', false);
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography, equipment, more_info, rules_of_conduct, rules_of_cancelation, deleted)
	VALUES (7, 3, 'Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores ullam quos, sit placeat labore voluptatem dignissimos officiis incidunt, perferendis eos porro nobis autem modi ab aliquam maiores. Dolorem, numquam quod.',
			'Mamci|Mreza za pecanje|Stapovi|Varalice|Prsluci za spasavanje|Cizme|Dodatni camci|Kombinezoni', 'Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.', 'Zabranjeno bacanje smenja|Zabranjeno skakanje u vodu bez dozvole|Zabranjeno donosenje alkohola|Zabranjeno donosenje hrane|Zabranjeno pusenje',
			'U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.', false);
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography, equipment, more_info, rules_of_conduct, rules_of_cancelation, deleted)
	VALUES (8, 3, 'Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores ullam quos, sit placeat labore voluptatem dignissimos officiis incidunt, perferendis eos porro nobis autem modi ab aliquam maiores. Dolorem, numquam quod.',
			'Mamci|Mreza za pecanje|Stapovi|Varalice|Prsluci za spasavanje|Cizme|Dodatni camci|Kombinezoni', 'Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.', 'Zabranjeno bacanje smenja|Zabranjeno skakanje u vodu bez dozvole|Zabranjeno donosenje alkohola|Zabranjeno donosenje hrane|Zabranjeno pusenje',
			'U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.', false);
			
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('29.05.2022.T14:00', '05.06.2022.T10:00', 4);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('07.06.2022.T14:00', '10.06.2022.T10:00', 4);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('14.06.2022.T14:00', '14.06.2022.T18:00', 7);

INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Uzimanje pola depozita', 23.2, 60, 35, 3, 'cruser', 9, 5);

INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Uzimanje pola depozita', 33, 20, 75, 3, 'cruser', 10, 5);

INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Uzimanje pola depozita', 15.7, 80, 98, 5, 'speeder', 11, 6);

