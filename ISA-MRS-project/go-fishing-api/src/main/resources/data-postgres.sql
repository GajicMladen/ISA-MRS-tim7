-- ADRESE
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
						('Ljubovija', 'Srbija', 'Ljubovijska Luka', '44.131978', '19.447603');
INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Mali Zvornik', 'Srbija', 'Malozvornicka Luka', '44.361090', '19.121489');
INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Mali Zvornik', 'Srbija', 'Sakar 25', '44.361094', '19.121489');
INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Ljubovija', 'Srbija', 'Vrhpolje 8', '44.131974', '19.447603');
INSERT INTO public.address(city, country, street, latitude, longitude) VALUES
						('Ljubovija', 'Srbija', 'Karadjordjeva 10', '44.188249', '19.377129');


            
-- PROFILI
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'p3r5kul45@gmail.com', 'Tomic', 'Jovan', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381607229290', 500, 1);
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'niko.nikic093@gmail.com', 'Gajic', 'Mladen', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381644281080', 1000, 2);					
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'mika.mikic.1389@gmail.com', 'Mikic', 'Mika', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381642298111', 750, 2);
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'pera.peric.1912@gmail.com', 'Peric', 'Pera', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381642222111', 500, 3);
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'jasmin.brodovski@yahoo.com', 'Brodovski', 'Jasmin', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381646447755', 600, 6);
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'luka.hadzibulic@gmail.com', 'Hadzibulic', 'Luka', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381641233211', 400, 7);
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'pera.peric.1912@gmail.com', 'Peric', 'Pera', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381642222111', 0, 3);
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'nb@gmail.com', 'Bajagic', 'NIkola', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+38161234432', 0, 1);
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone,loyalty_points, address_id) VALUES
					(true, false, 'mb@gmail.com', 'Bajagic', 'Marko', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381659997778', 0, 1);
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
					(true, false, 'djordjejovanovic27@gmail.com', 'Jovanovic', 'Djordje', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381642222111', 0, 8);										
INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, loyalty_points, address_id) VALUES
                (true, false, 'mb@gmail.com', 'Klijentovic', 'Klijent', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381659997778', 600, 1);

--KLIJENTI
INSERT INTO public.client(penal_count, suspended, id) VALUES (0, FALSE, 1);

-- VLASNICI KOLIBA				
INSERT INTO public.cottage_owners(id) VALUES(2);
INSERT INTO public.cottage_owners(id) VALUES(1);

-- VLASNICI PLOVILA
INSERT INTO public.boat_owner(id) VALUES (5);
INSERT INTO public.boat_owner(id) VALUES (6);
INSERT INTO public.boat_owner(id) VALUES (7);
INSERT INTO public.boat_owner(id) VALUES (8);


-- INSTRUKTORI
INSERT INTO public.fishing_instructor (id) VALUES (3);
INSERT INTO public.fishing_instructor (id) VALUES (4);

-- ROLE	
INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE (name) VALUES ('ROLE_COTTAGE_OWNER');
INSERT INTO ROLE (name) VALUES ('ROLE_BOAT_OWNER');
INSERT INTO ROLE (name) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO ROLE (name) VALUES ('ROLE_SYSADMIN');

INSERT INTO USER_ROLE(user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLE(user_id, role_id) VALUES (2, 3);

INSERT INTO USER_ROLE(user_id, role_id) VALUES (5, 4);
INSERT INTO USER_ROLE(user_id, role_id) VALUES (6, 4);

INSERT INTO USER_ROLE(user_id, role_id) VALUES (3, 5);
INSERT INTO USER_ROLE(user_id, role_id) VALUES (4, 5);
INSERT INTO USER_ROLE(user_id, role_id) VALUES (10, 6);

-- OFFER - KOLIBE
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 39.6, 10, 'Vikendica Kosmaj', 'Vila Mišeluk se nalazi na samo nekoliko kilometara od Novog Sada što je samo jedan od razloga da je posetite. Idealna je za druženja kako u letnjem periodu, tako i u zimskom. Kada je lepo vreme možete uživati u roštilju pored bazena i prelepom dvorištu. U zimskom periodu, Vaše okupljanje možete napraviti u prostranoj dnevnoj prostoriji. Pored toga tu su i dve spavaće sobe, kuhinja i kupatilo.Ova vila je odličan izbor za momačke i devojačke veceri, kao i za sve ostale tipove druženja. Posetite nas i uverite se!'
	        , 3.3, 2);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 96.7, 25, 'Villa Djosa Vrhpolje', 'Moderna vikendica u blizini restorana Vidikovac na svega 14 minuta od Novog Sada. Nalazi se na 9km od centra. Sama vikendica ima 55 kvadrata i kapacitet za nocenje 5 osoba. Za druženje ili intimnije proslave maksimum je 15 osoba. Poseduje bazen, roštilj, četiri parking mesta, veliko travnato dvorište, dečije igralište, preko 15 mesta za sedenje napolju, ozvučenje, internet, Wi-Fi, Netflix i HBO, kao i kompletno opremljenu kuhinju.', 4.8, 1);

INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 112, 25, 'Rajska Idila', 'Vikendica na Alibegovcu je odličan izbor za sve vrste proslava sa ozvučenjem koje je uračunato u cenu. Pored toga pruža još nekolicinu pogodnosti. Nalazi se na samo 6km od Novog Sada i može da primi čak 50 osoba.Prostarana unutrašnjost raspodeljena je u tri nivoa. U prizemlju se nalazi velika dnevna soba sa zasebnom kuhinjom i kupatilom, kao i stoni tenis koji možete iskoristiti da upotpunite Vaše druženje. Na prvom spratu se nalaze tri spavaće sobe, dnevna soba i kuhinja. Na poslednjem spratu je velika prostorija, u kojoj se nalaze klupe i barski stolovi tako da je idealna za žurke i proslave. Van kuće se nalazi prostrana terasa sa zidanim roštiljem. Vaš boravak može ispuniti i jedna partija basketa, jer je tu i koš. Iskoristite ono što Vam pruža kuća na Alibegovcu i napravite nezaboravan rođendan ili druženje.', 1.1, 3);
	
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 150, 4, 'Sirius apartmani', 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Soluta ex vitae est ea eveniet mollitia voluptatum earum necessitatibus optio et.'
	        , 2.2, 4);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 200, 10, 'Konak Angella', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Laudantium aliquam voluptatibus necessitatibus sequi, accusantium quasi! Similique doloremque ullam voluptatum delectus.', 2.5, 5);

INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 250, 11, 'Milmar Premier', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus quae fugiat dolore excepturi dolorum magni libero nihil voluptas, voluptate quidem.', 4.3, 1);

INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 100, 7, 'Olimp Apartment', 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Soluta ex vitae est ea eveniet mollitia voluptatum earum necessitatibus optio et.'
	        , 3.6, 2);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 115, 8, 'Apartman Jovanovic', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Laudantium aliquam voluptatibus necessitatibus sequi, accusantium quasi! Similique doloremque ullam voluptatum delectus.', 4.4, 3);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 250, 11, 'Pcelica L15', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus quae fugiat dolore excepturi dolorum magni libero nihil voluptas, voluptate quidem.', 4.6, 4);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 100, 8, 'Viceroy', 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Soluta ex vitae est ea eveniet mollitia voluptatum earum necessitatibus optio et.', 1.6, 5);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 115, 10, 'Apartmani Zupa', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Laudantium aliquam voluptatibus necessitatibus sequi, accusantium quasi! Similique doloremque ullam voluptatum delectus.', 3.3, 1);

-- OFFER - BRODOVI
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 500, 4, 'Serendipity', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit illo voluptatum laudantium nulla ab a officia, labore voluptate dicta beatae ipsam. Sequi quod deleniti libero mollitia aliquam sunt dolor dicta aperiam deserunt corrupti repudiandae numquam magnam cupiditate amet nemo ipsa, explicabo nam at esse! Dolore ducimus magni odio molestiae minus dignissimos corporis tempora a cumque deleniti quo quos ea perspiciatis excepturi consequatur, ullam tenetur sunt voluptas, reprehenderit veritatis enim ipsum. Iure ad placeat magnam, animi eum voluptatibus, voluptate ipsum vel aut error architecto, reiciendis eligendi minima? Iure, cumque sit facere ab molestiae ullam reiciendis ipsum! Porro a suscipit quos velit.'
	        , 3.3, 6);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 300, 3, 'Imagination', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Facere iste illum cumque architecto repudiandae fuga facilis corporis, suscipit temporibus aspernatur quisquam doloremque accusamus fugit perferendis. Iste quibusdam reprehenderit accusantium voluptatibus, temporibus animi rem corrupti distinctio. Rem exercitationem eius porro iusto dolorum cum vitae quos numquam fuga tenetur doloremque saepe doloribus similique ipsa, explicabo animi sit soluta. Minima at libero accusantium exercitationem labore cupiditate impedit sunt nostrum, rem eos voluptatibus. Ducimus, illo saepe sint, eos culpa ullam similique amet facilis quam, nostrum error quae. Laboriosam autem saepe ut nesciunt quam ab laborum dolorem. Nihil porro dolorem vero veniam illum excepturi officia!', 4.8, 7);

INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 250, 2, 'Wanderlust', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloribus repellendus odit earum! Tempore assumenda ea labore dolor odit eaque voluptate asperiores velit doloremque accusamus ad ratione quae, necessitatibus culpa facilis reiciendis iusto expedita? Eos, quisquam soluta pariatur ullam ipsum quia fuga suscipit fugiat odio doloribus tempore iure minus, magni dolorem corrupti excepturi inventore maxime, officia rem? Incidunt accusamus numquam laudantium ipsa veritatis id illum, obcaecati rem assumenda sed unde nostrum, sint minus neque molestiae dicta quibusdam tenetur reprehenderit tempora dolorum a voluptatem ad, quisquam perspiciatis. Sapiente aut pariatur, temporibus placeat ratione, dolore repellendus ex eveniet, tenetur corrupti distinctio explicabo beatae!', 1.1, 6);

INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 150, 1, 'Zephyr', 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Sint ut dolore iste quibusdam provident eos error exercitationem, ea voluptate voluptatibus, voluptas facilis suscipit odio. Id vitae necessitatibus ipsum, at dolore quo officia in explicabo, iusto mollitia cum voluptatibus cupiditate consequatur ipsa, reiciendis sed. Libero, amet. Ducimus quae est a, ab facere omnis asperiores atque mollitia, consequuntur, corporis facilis quod porro odit at minus modi. Sint ipsum, non magnam fuga qui veritatis, ex quasi ullam sapiente, corporis ipsam voluptatibus. Dolores, saepe esse labore, atque obcaecati quia perspiciatis sit quam nulla reprehenderit voluptatem doloribus? Asperiores itaque iusto adipisci magnam magni? Dignissimos, laudantium.'
	        , 2.2, 7);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 200, 2, 'Gale', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Temporibus deleniti, ea, saepe dolor ipsum voluptatibus mollitia voluptates fuga vero tempora suscipit explicabo architecto illo alias placeat amet? Numquam iusto quisquam saepe officiis quas, nobis pariatur at voluptatem soluta amet laboriosam sunt fugiat doloremque corrupti enim non rerum praesentium iste harum, aperiam odit veritatis tenetur? Impedit eius odit placeat error, consequatur tenetur facere corrupti illo tempora cupiditate. Reprehenderit repellendus sit tempore!', 2.5, 6);

INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 1150, 10, 'Contessa', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus quae fugiat dolore excepturi dolorum magni libero nihil voluptas, voluptate quidem.', 4.3, 7);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 100, 7, 'Shelly', 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Soluta ex vitae est ea eveniet mollitia voluptatum earum necessitatibus optio et.', 3.6, 6);

INSERT INTO public.offer(
	 price, capacity, name, promo_description, rating, address)
	VALUES ( 125, 25, 'Flash boat', 'S ovim dobro poznatim brendom možete se otisnuti na dalju, bezbednu i prijatnu putešestviju, ili jednostavno užitati u plivanju i pecanju s porodicom i prijateljima.Pametna prostorna rešenja i robustnost sinonimi su za ovaj švedski motorni kruzer. Svakog gosta dočekaće piće dobrodošlice i snekovi. Kapetanovi lokalni specijaliteti dostupni su na zahtev'
	,2.2, 7);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 150, 25, 'SEA ray 275', 'Ova motorna jahta prima do 8 ljudi. Prilično brzo ćete se odvesti van grada kako biste se prepustili uživanju u divljoj prirodi Save i Dunava.Ova udobna i luksuzna jahta opremljena je toaletom, kuhinjom i poseduje 4 ležaja. Posle nekoliko sati provedenih na ovom brodu sigurno ćete poželeti da se na njemu zadržite duže.'
	,2.2, 7);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 96.7, 25, 'Monstery', 'Lepota luksuz i hedonizam zajednički su imenitelji ovog kruzera. Ako odlučite da iznenadite poslovnog , životnog partnera ili samog sebe,provedite nezaboravno vreme koje ćete ovekovečiti jedinstvenim fotografijama.Ovakvi doživljaji moraju ostati zabeleženi'
	, 2.2, 7);
          
-- OFFER - AVANTURE
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 99.99, 10, 'Pecanje na Zvorničkom jezeru', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 3.0, 4);
	
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 129.99, 5, 'Rafting na Drini', 'Nezaboravno iskustvo na Drini! Iskusite sve čari raftinga na Drini. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 3.5, 5);	

INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 199.99, 8, 'Na Drini rafting', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 5.0, 5);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 79.99, 4, 'Pecanja casovi', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 4.2, 4);
INSERT INTO public.offer(
	 price, capacity, name, promo_description , rating, address)
	VALUES ( 49.99, 10, 'Casovi pecanja', 'Nezaboravno iskustvo na Drini! Iskusite sve čari drinskog ribolova. Neopisiva lepota jedne od najbržih evropskih reka će vas ostavitit bez daha. Lorem ipsum dolor sit amet consectetur adipisicing elit. Unde natus, sunt sed maxime ut accusamus dignissimos veniam inventore debitis consequatur temporibus odio facere nobis, tenetur deserunt aut fugit distinctio recusandae.', 1.1, 4);

-- DODAVANJE KOLIBA
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (1, 2 ,2,2);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (2, 2,5,7);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (3, 2,6,9);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (4, 2 ,2,2);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (5, 2,5,7);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (6, 2,6,9);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (7, 2 ,2,2);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (8, 2,5,7);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (9, 2,6,9);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (10, 2 ,2,2);
INSERT INTO public.Cottage(
	id, owner_id,room_count,bed_count)
	VALUES (11, 2,5,7);
	
-- DODAVANJE BRODOVA
INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Some cancel conditions..', 10, 200, 200, 1, 'Speedboat', 12, 5);
INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Some cancel conditions..', 10, 250, 250, 2, 'Kayak', 13, 6);
INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Some cancel conditions..', 12, 300, 300, 3, 'Speedboat', 14, 5);
INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Some cancel conditions..', 8, 350, 350, 4, 'Yacht', 15, 6);
INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Some cancel conditions..', 7, 400, 400, 1, 'Yacht', 16, 5);
INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Some cancel conditions..', 11, 300, 300, 2, 'Speedboat', 17, 6);
INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Some cancel conditions..', 10, 100, 100, 3, 'Kayak', 18, 5);
INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Uzimanje pola depozita', 23.2, 60, 35, 3, 'cruser', 19, 7);
INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Uzimanje pola depozita', 33, 20, 75, 3, 'cruser', 20, 8);
INSERT INTO public.boat(
	cancel_conditions, length, max_speed, motor_power, motors_count, type, id, boat_owner_id)
	VALUES ('Uzimanje pola depozita', 15.7, 80, 98, 5, 'speeder', 21, 7);
	
-- DODAVANJE AVANTURA
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography, equipment, more_info, rules_of_conduct, rules_of_cancelation, deleted)
	VALUES (22, 3, 'Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores ullam quos, sit placeat labore voluptatem dignissimos officiis incidunt, perferendis eos porro nobis autem modi ab aliquam maiores. Dolorem, numquam quod.',
			'Mamci|Mreza za pecanje|Stapovi|Varalice|Prsluci za spasavanje|Cizme|Dodatni camci|Kombinezoni', 'Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.', 'Zabranjeno bacanje smenja|Zabranjeno skakanje u vodu bez dozvole|Zabranjeno donosenje alkohola|Zabranjeno donosenje hrane|Zabranjeno pusenje',
			'U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.', false);
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography, equipment, more_info, rules_of_conduct, rules_of_cancelation, deleted)
	VALUES (23, 4, 'Pera Peric je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores ullam quos, sit placeat labore voluptatem dignissimos officiis incidunt, perferendis eos porro nobis autem modi ab aliquam maiores. Dolorem, numquam quod.',
			'Mamci|Mreza za pecanje|Stapovi|Varalice|Prsluci za spasavanje|Cizme|Dodatni camci|Kombinezoni', 'Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.', 'Zabranjeno bacanje smenja|Zabranjeno skakanje u vodu bez dozvole|Zabranjeno donosenje alkohola|Zabranjeno donosenje hrane|Zabranjeno pusenje',
			'U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.', false);
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography, equipment, more_info, rules_of_conduct, rules_of_cancelation, deleted)
	VALUES (24, 4, 'Pera Peric je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores ullam quos, sit placeat labore voluptatem dignissimos officiis incidunt, perferendis eos porro nobis autem modi ab aliquam maiores. Dolorem, numquam quod.',
			'Mamci|Mreza za pecanje|Stapovi|Varalice|Prsluci za spasavanje|Cizme|Dodatni camci|Kombinezoni', 'Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.', 'Zabranjeno bacanje smenja|Zabranjeno skakanje u vodu bez dozvole|Zabranjeno donosenje alkohola|Zabranjeno donosenje hrane|Zabranjeno pusenje',
			'U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.', false);
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography, equipment, more_info, rules_of_conduct, rules_of_cancelation, deleted)
	VALUES (25, 3, 'Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores ullam quos, sit placeat labore voluptatem dignissimos officiis incidunt, perferendis eos porro nobis autem modi ab aliquam maiores. Dolorem, numquam quod.',
			'Mamci|Mreza za pecanje|Stapovi|Varalice|Prsluci za spasavanje|Cizme|Dodatni camci|Kombinezoni', 'Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.', 'Zabranjeno bacanje smenja|Zabranjeno skakanje u vodu bez dozvole|Zabranjeno donosenje alkohola|Zabranjeno donosenje hrane|Zabranjeno pusenje',
			'U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.', false);
INSERT INTO public.Adventure(
	id, instruktor_id, instructor_biography, equipment, more_info, rules_of_conduct, rules_of_cancelation, deleted)
	VALUES (26, 3, 'Mika Mikić je iskusni ribolovac, gnjurac i plivač. Diplomirao je na fakultetu za sport i rekreaciju na Palama sa prosekom 9,56. Ovim poslom se bavi već 10 godina. Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores ullam quos, sit placeat labore voluptatem dignissimos officiis incidunt, perferendis eos porro nobis autem modi ab aliquam maiores. Dolorem, numquam quod.',
			'Mamci|Mreza za pecanje|Stapovi|Varalice|Prsluci za spasavanje|Cizme|Dodatni camci|Kombinezoni', 'Avantura se održava dva puta dnevno. Prvi termin je u 9h, a drugi u 15h. Mesto okupljanja je gradska plaža. Avantura traje dva sata.', 'Zabranjeno bacanje smenja|Zabranjeno skakanje u vodu bez dozvole|Zabranjeno donosenje alkohola|Zabranjeno donosenje hrane|Zabranjeno pusenje',
			'U slučaju otkazivanja instruktor zadržava 30% uplaćene sume.', false);			


-- SLOBODNI TERMINI			
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 4);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 3);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 5);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 6);
	
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 12);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 13);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 15);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 16);
	
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-15T14:30:00', '2022-06-16T10:00:00', 22);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 24);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 23);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 25);
INSERT INTO public.free_period (
	start_date_time, end_date_time, offer_id)
	VALUES ('2022-06-01T00:00:01', '2022-06-30T00:00:01', 26);

--REZERVACIJE
INSERT INTO public.reservation(end_date_time, start_date_time, status, total_price, client_id, grade, offer_id)
	VALUES ('2022-05-31T00:00:01', '2022-05-30T00:00:01', 0, 365.36, 1, null, 1);
INSERT INTO public.reservation(end_date_time, start_date_time, status, total_price, client_id, grade, offer_id)
    	VALUES ('2022-05-25T00:00:01', '2022-05-24T00:00:01', 1, 120.5, 1,  null, 1);
INSERT INTO public.reservation(end_date_time, start_date_time, status, total_price, client_id,  grade, offer_id)
    	VALUES ('2022-05-25T00:00:01', '2022-05-24T00:00:01', 3, 120.5, 1,  null, 1);
INSERT INTO public.reservation(end_date_time, start_date_time, status, total_price, client_id,  grade, offer_id)
    	VALUES ('2022-05-25T00:00:01', '2022-05-24T00:00:01', 3, 120.5, 1,  null, 20);
INSERT INTO public.reservation(end_date_time, start_date_time, status, total_price, client_id,  grade, offer_id)
    	VALUES ('2022-05-25T00:00:01', '2022-05-24T00:00:01', 2, 120.5, 1,  null, 19);

INSERT INTO public.reservation(end_date_time, start_date_time, status, total_price, client_id, grade, offer_id)
	VALUES ('2022-05-31T00:00:01', '2022-05-30T00:00:01', 0, 365.36, 1, null, 1);
INSERT INTO public.reservation(end_date_time, start_date_time, status, total_price, client_id, grade, offer_id)
    	VALUES ('2022-05-25T00:00:01', '2022-05-24T00:00:01', 1, 120.5, 1, null, 1);
INSERT INTO public.reservation(end_date_time, start_date_time, status, total_price, client_id, grade, offer_id)
    	VALUES ('2022-05-25T00:00:01', '2022-05-24T00:00:01', 3, 120.5, 1, null, 1);
      
--ZALBE
INSERT INTO public.complaint(for_offer, from_owner, offender_id, pusnih_offender, status, text, reservation_id)
	VALUES (false, false, 1, true, 0, 'zalim se na klijenta indijanca, ostavio je haos!',1);
INSERT INTO public.complaint(for_offer, from_owner, offender_id, pusnih_offender, status, text, reservation_id)
	VALUES (false, true, 1, true, 0, 'zalim se na klijenta indijanca, ostavio je haos!',2);

