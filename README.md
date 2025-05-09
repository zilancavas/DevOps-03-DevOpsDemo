# DevOps 03 DevOpsDemo

## Lernjournal Frontend 

| Schritt | Beschreibung | Screenshot |
|--------|--------------|------------|
| 1 | Repository wurde über Visual Studio Code geklont. | ![](images/fronted-01.png) |
| 2 | In den `frontend`-Ordner gewechselt und überprüft, ob `package.json` vorhanden ist. Danach wurden die NPM-Dependencies mit `npm install` installiert. | ![](images/fronted-02.png) |
| 3 | Das Frontend wurde mit `npm start` erfolgreich gestartet und ist unter `localhost:3000` erreichbar. | ![](images/fronted-03.png) |
| 4 | Das Backend wurde mit `./gradlew bootRun` gestartet. Der Spring Boot-Server läuft unter Port 8080. | ![](images/fronted-04.png) |
| 5 | Das Projekt ist im Browser sichtbar. Die Startseite zeigt den Einstieg in die To-Do-Liste. | ![](images/fronted-05.png) |
| 6 | Vorhandenes Frontend wurde erneut gestartet und getestet. Browserport wurde automatisch angepasst (Port 3000 war bereits belegt). | ![](images/fronted-06.png) |
| 7 | Die To-Do-Seite wurde geöffnet und bestehende Kacheln angezeigt. Beispielhafte Einträge wie „Unit Tests“, „Deployment“ und „Organigramm“ sind sichtbar. | ![](images/fronted-07.png) |
| 8 | Eine zusätzliche Kachel „Zilan Test“ wurde im Hauptmenü hinzugefügt, um die Frontenderweiterung zu demonstrieren. | ![](images/fronted-08.png) |
| 9 | Alle Änderungen wurden committed und erfolgreich ins GitHub-Repository gepusht. | ![](images/fronted-09.png) |
| 10 | Die neue Entity-Klasse `ZilanItem` wurde im Backend erstellt, mit Feldern für Name, Beschreibung und Zeitangaben. | ![](images/fronted-10.png) |
| 11 | Das zugehörige Repository-Interface `ZilanItemRepository` wurde erstellt, um CRUD-Zugriffe auf die Datenbank zu ermöglichen. | ![](images/fronted-11.png) |
| 12 | Ein neuer REST-Controller `ZilanItemController` wurde implementiert, der GET-, POST- und PUT-Endpunkte zur Verwaltung von `ZilanItem` bereitstellt. | ![](images/fronted-12.png) |
| 13 | Der REST-Service wurde erfolgreich getestet: Backend läuft, Endpunkte sind über `localhost:8080/Zilan` erreichbar. | ![](images/fronted-13.png) |

## Lernjournal Backend 
| Schritt | Beschreibung                                                                                              | Screenshot              |
|--------|-----------------------------------------------------------------------------------------------------------|--------------------------|
| 1       | Im `backend`-Projekt wurde die Konfiguration der `application.properties` angepasst. Die H2-In-Memory-Datenbank wurde aktiviert und grundlegende Datenbankverbindungsdaten gesetzt. | ![](images/backend-01.png) |

