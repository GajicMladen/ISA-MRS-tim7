INSERT INTO public.korisnik(
	tip,  aktivan, ime, korisnicko_ime, lozinka, obrisan, prezime, telefon, tip_korisnika, broj_penala, suspendovan, address_id)
	VALUES ('VV',  true, 'Mladen', 'mladen', 'mladen', false, 'Gajic', '0644281080', null , null, null, null);
INSERT INTO public.korisnik(
	tip, aktivan, ime, korisnicko_ime, lozinka, obrisan, prezime, telefon, tip_korisnika, broj_penala, suspendovan, address_id)
	VALUES ('VV', true, 'Ognjen', 'ognjen', 'ognjen', false, 'Gajic', '0645595595', null , null, null, null);
INSERT INTO public.korisnik(
	tip,  aktivan, ime, korisnicko_ime, lozinka, obrisan, prezime, telefon, tip_korisnika, broj_penala, suspendovan, address_id)
	VALUES ('VV', true, 'Lazar', 'a', 'a', false, 'Pavkovic', '064478999878', null , null, null, null);


INSERT INTO public.usluga(
	 cena, kapacitet, naziv, promo_opis, adresa_usluge)
	VALUES ( 39.6, 10, 'Vikendica Kosmaj', 'Prelepa vikendica na kosmaju sa pogledom na BG', null);
INSERT INTO public.usluga(
	 cena, kapacitet, naziv, promo_opis, adresa_usluge)
	VALUES ( 96.7, 25, 'Villa Djosa Vrhpolje', 'Fantasticna vikendica na drini sa pogledom na LJuboviju,odlicna za zurke', null);
	

INSERT INTO public.vikendica(
	id, vlasnik_id)
	VALUES (1, 1);
INSERT INTO public.vikendica(
	id, vlasnik_id)
	VALUES (2, 3);