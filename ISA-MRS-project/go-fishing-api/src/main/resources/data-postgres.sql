INSERT INTO public.Users(
	type,  active, name, username, password,email, deleted, lastname, phone, user_type,penal_count, suspended, address_id)
	VALUES ('VV',  true, 'Mladen', 'mladen', 'mladen','mladengajic00@gmail.com', false, 'Gajic', '0644281080',2 , null, null, null);
INSERT INTO public.Users(
	type,  active, name, username, password,email, deleted, lastname, phone, user_type, penal_count, suspended, address_id)
	VALUES ('VV', true, 'Ognjen', 'ognjen', 'ognjen','giskovic98@gmail.com', false, 'Gajic', '0645595595',2 , null, null, null);
INSERT INTO public.Users(
	type,  active, name, username, password,email, deleted, lastname, phone,user_type,  penal_count, suspended, address_id)
	VALUES ('VV', true, 'Lazar', 'a', 'a','aaa@gmail.com', false, 'Pavkovic', '064478999878',2 , null, null, null);
INSERT INTO public.Users (
	type, active, name, username, password, email, deleted, lastname, phone, user_type, penal_count, suspended, address_id)
	VALUES ('IP', true, 'Mika', 'mika', 'mika', 'mika@gmail.com', false, 'Mikic', '0642298115', 3, null, null, null);

	
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
	VALUES ( 99.9, 10, 'Pecanje na Zvorničkom jezeru', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', null);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 99.9, 10, 'Rafting na Drini', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', null);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 99.9, 10, 'Na Drini rafting', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', null);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 99.9, 10, 'Pecanja casovi', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', null);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , address)
	VALUES ( 99.9, 10, 'Casovi pecanja', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', null);

	
	
INSERT INTO public.Cottage(
	id, owner_id)
	VALUES (1, 1);
INSERT INTO public.Cottage(
	id, owner_id)
	VALUES (2, 3);
INSERT INTO public.Cottage(
	id, owner_id)
	VALUES (3, 3);
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography)
	VALUES (4, 4, 'Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina.');
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography)
	VALUES (5, 4, 'Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina.');
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography)
	VALUES (6, 4, 'Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina.');
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography)
	VALUES (7, 4, 'Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina.');