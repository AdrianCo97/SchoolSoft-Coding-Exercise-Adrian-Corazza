# Uppgift för utvecklare

Din huvuduppgift är att skriva en metod som returnerar en lista med användare som du modifierat enligt instruktionerna
nedan. Utöver det finns det ett antal "kluringar" att lösa. Tillhörandes huvuduppgifterna finns ett par extrauppgifter
som är valfria att lösa. Extrauppgift A består av att skriva enhetstester för de metoder som implementerats i tidigare
uppgifter. Extrauppgift B innefattar att skriva en enkel klient-/serverapplikation som knyter an till huvuduppgiften
genom att indata och utdata för metoderna ska kunna anges och tas emot via en enkel frontend.

Ingen del av uppgiften har några absoluta rätt eller fel lösningar. Det viktiga är att vi kan se din tankeprocess och
hur du valt att lösa olika delar. Vi förväntar oss att du kan motivera din kod och lösningarna på de olika problemen.
Det är OK att lämna logiska luckor och/eller skapa workarounds så länge de är dokumenterade och vi kan förstå ditt
tankesätt. Samtidigt förväntar vi oss varken en komplett eller "fullfjädrad" lösning. Delar av uppgiften har medvetet
lämnats något vaga och öppna för tolkning för att ge dig möjlighet att vara kreativ, men även sätta rimliga gränser för
applikationen. Fråga gärna oss på SchoolSoft om hjälp ifall du kör fast eller inte förstår någon del av uppgiften så
hjälper vi gärna till.

### Krav

För att Jetty ska starta upp korrekt så behöver du använda **Java 8**.

## Huvuduppgift 1 (Java)

Skriv en metod som returnerar användare där förnamnet är omvänt, samt en flagga för om förnamnet är en palindrom.
I `UserJsonHandler.java` finns en metod som returnerar ett antal `User`-objekt som en `String`.

## Huvuduppgift 2 (Kluringar)

- Skriv en metod som kan hitta det n-te största talet i en lista av tal
- Skriv en metod som lägger till nollor framför tal, 1 ska bli "00001" och 100 ska bli "00100"

## Extrauppgift A (Tester)

Skriv tester för de metoder du valt att implementera.

## Extrauppgift B (Klient-/serverapplikation)

Skriv en enkel frontend där det går att ange indata till en eller flera av de metoder/implementationer du skrivit för
huvuduppgiften. Den indata som anges ska skickas till en server som behandlar angiven indata och beräknar resultatet.
Som en bonusuppgift kan du returnera resultatet till frontend som sedan presenteras på lämpligt sätt för användaren.

Servern startas genom att köra `main`-metoden i `Server.java`, där `MethodsAPI.java` innehåller stubbar för endpoints.
Endpoints går att nå via `http://localhost:8081/api/methods/din-endpoint`.

Frontend kan implementeras på valfritt sätt, förslagsvis med hjälp av ett frontend-ramverk som till exempel React eller
Angular. Det är dock helt upp till dig och det går även bra att implementera i ren HTML/JavaScript om så önskas.
Serverdelen ska dock implementeras i Java.
