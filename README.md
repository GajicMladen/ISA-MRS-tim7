# GoFishing
Projektni zadatak iz predmeta Internet softverske arhitekture i Metodologije razvoja softvera.

Autori: 
- Jovan Tomić SW 48/2019
- Mladen Gajić SW 39/2019
- Đorđe Jovanović SW 42/2019

Korišćene tehnologije:
- Angular za front-end
- Spring Boot za back-end
- PostgreSQL baza podataka.

# Uputstvo za pokretanje PostgreSQL baze podataka
- Potrebno je instalirati [PostgreSQL](https://www.postgresql.org/download/) bazu podataka
- Potrebno je kreirati novu bazu koristeći pgAdmin ili komandnu liniju. Naziv baze mora biti `ISAMRStim7`
- U datoteci `/go-fishing-api/src/main/resources/application.properties` potrebno je izmeniti atribute `spring.datasource.username` i `spring.datasource.password` tako da odgovaraju kredencijalima za bazu
- Pokretanjem Spring Boot aplikacije, baza podataka biće populisana testnim podacima koji se nalaze u `/go-fishing-api/src/main/resources/data-postgres.sql`

# Uputstvo za pokretanje Spring Boot aplikacije (Eclipse)
- Potrebno je importovati `go-fishing-api` u workspace: Import -> Maven -> Existing Maven Project
- Potrebno je instalirati sve zavisnosti iz `pom.xml` datoteke.
- Desnim klikom na projekat u Package Explorer-u, potrebno je odabrati Run as -> Java Application

# Uputstvo za pokretanje Angular aplikacije
Preduslov je da na uređaju postoji instaliran [Node.js](https://nodejs.org/en/download/) i [npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)
- U konzolu je potrebno uneti sledeću komandu za instalaciju Angular CLI: `npm install -g @angular/cli`
- Nakon toga, potrebno je pozicionirati se u direktorijum `go-fishing-ui/go-fishing` i pokrenuti komandu `ng serve` ili `ng serve --open` ukoliko želimo da se automatski otvori i browser.
