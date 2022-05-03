--INSERT INTO public.cottage_owners(
--	active, name,password,email, deleted, lastname, phone, penal_count, suspended, address_id)
--	VALUES (true, 'Mladen', 'mladen','mladengajic00@gmail.com', false, 'Gajic', '0644281080',null, null, null);
--INSERT INTO public.cottage_owners(
--	active, name, password,email, deleted, lastname, phone, penal_count, suspended, address_id)
--	VALUES (true, 'Ognjen', 'ognjen','giskovic98@gmail.com', false, 'Gajic', '0645595595',null, null, null);
--INSERT INTO public.cottage_owners(
--	type,  active, name, password,email, deleted, lastname, phone,penal_count, suspended, address_id)
--	VALUES (true, 'Lazar', 'a','aaa@gmail.com', false, 'Pavkovic', '064478999878', null, null, null);


--INSERT INTO public.offer(
--	 price, capacity, name, promo_description , address)
--	VALUES ( 39.6, 10, 'Vikendica Kosmaj', 'Vila Mišeluk se nalazi na samo nekoliko kilometara od Novog Sada što je samo jedan od razloga da je posetite. Idealna je za druženja kako u letnjem periodu, tako i u zimskom. Kada je lepo vreme možete uživati u roštilju pored bazena i prelepom dvorištu. U zimskom periodu, Vaše okupljanje možete napraviti u prostranoj dnevnoj prostoriji. Pored toga tu su i dve spavaće sobe, kuhinja i kupatilo.Ova vila je odličan izbor za momačke i devojačke veceri, kao i za sve ostale tipove druženja. Posetite nas i uverite se!'
--	        , null);
--INSERT INTO public.offer(
--	 price, capacity, name, promo_description , address)
--	VALUES ( 96.7, 25, 'Villa Djosa Vrhpolje', 'Moderna vikendica u blizini restorana Vidikovac na svega 14 minuta od Novog Sada. Nalazi se na 9km od centra. Sama vikendica ima 55 kvadrata i kapacitet za nocenje 5 osoba. Za druženje ili intimnije proslave maksimum je 15 osoba. Poseduje bazen, roštilj, četiri parking mesta, veliko travnato dvorište, dečije igralište, preko 15 mesta za sedenje napolju, ozvučenje, internet, Wi-Fi, Netflix i HBO, kao i kompletno opremljenu kuhinju.', null);
--
--INSERT INTO public.offer(
--	 price, capacity, name, promo_description , address)
--	VALUES ( 96.7, 25, 'Rajska Idila', 'Vikendica na Alibegovcu je odličan izbor za sve vrste proslava sa ozvučenjem koje je uračunato u cenu. Pored toga pruža još nekolicinu pogodnosti. Nalazi se na samo 6km od Novog Sada i može da primi čak 50 osoba.Prostarana unutrašnjost raspodeljena je u tri nivoa. U prizemlju se nalazi velika dnevna soba sa zasebnom kuhinjom i kupatilom, kao i stoni tenis koji možete iskoristiti da upotpunite Vaše druženje. Na prvom spratu se nalaze tri spavaće sobe, dnevna soba i kuhinja. Na poslednjem spratu je velika prostorija, u kojoj se nalaze klupe i barski stolovi tako da je idealna za žurke i proslave. Van kuće se nalazi prostrana terasa sa zidanim roštiljem. Vaš boravak može ispuniti i jedna partija basketa, jer je tu i koš. Iskoristite ono što Vam pruža kuća na Alibegovcu i napravite nezaboravan rođendan ili druženje.', null);
--
--
--INSERT INTO public.Cottage(
--	id, owner_id)
--	VALUES (1, 1);
--INSERT INTO public.Cottage(
--	id, owner_id)
--	VALUES (2, 3);
--INSERT INTO public.Cottage(
--	id, owner_id)
--	VALUES (3, 3);

INSERT INTO public.address(city, country, street) VALUES
						('Novi Sad', 'Serbia', 'Tihomira Ostojica 2');

INSERT INTO public.users(active, deleted, email, lastname, name, password, phone, address_id) VALUES
					(true, false, 'p3r5kul45@gmail.com', 'Tomic', 'Jovan', '$2a$10$XeS1WZloSVVq2Z2dJd3L7ePADJy51sWu/oLqcy.Qcmppr6VcUtcr6', '+381607229290', 1);

INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');

INSERT INTO USER_ROLE(user_id, role_id) VALUES (1, 2);
--INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 2); -- user-u dodeljujemo rolu USER
--INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2); -- admin-u dodeljujemo rolu USER
--INSERT INTO USER_ROLE (user_id, role_id) VALUES (3, 2); -- user-u dodeljujemo rolu ADMIN