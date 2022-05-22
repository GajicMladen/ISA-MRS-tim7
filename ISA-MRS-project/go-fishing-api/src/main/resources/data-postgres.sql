

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

						
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, address_id) VALUES
					(true, false, 'p3r5kul45@gmail.com', 'Tomic', 'Jovan', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381607229290', 1);

INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, address_id) VALUES
					(true, false, 'niko.nikic093@gmail.com', 'Gajic', 'Mladen', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381644281080', 1);
					
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, address_id) VALUES
					(true, false, 'mika.mikic.1389@gmail.com', 'Mikic', 'Mika', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381642298111', 2);
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, address_id) VALUES
					(true, false, 'pera.peric.1912@gmail.com', 'Peric', 'Pera', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381642222111', 3);
					
					
INSERT INTO public.cottage_owners(
	id)
	VALUES (2);
	
INSERT INTO public.fishing_instructor (id) VALUES (3);
INSERT INTO public.fishing_instructor (id) VALUES (4);

INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE (name) VALUES ('ROLE_COTTAGE_OWNER');
INSERT INTO ROLE (name) VALUES ('ROLE_BOAT_OWNER');
INSERT INTO ROLE (name) VALUES ('ROLE_INSTRUCTOR');

INSERT INTO USER_ROLE(user_id, role_id) VALUES (1, 2);
INSERT INTO USER_ROLE(user_id, role_id) VALUES (2, 3);

INSERT INTO USER_ROLE(user_id, role_id) VALUES (3, 5);
INSERT INTO USER_ROLE(user_id, role_id) VALUES (4, 5);

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
	VALUES ( 199.99, 8, 'Na Drini rafting', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 5);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 79.99, 4, 'Pecanja casovi', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 4);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 49.99, 10, 'Casovi pecanja', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 4);

	
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
