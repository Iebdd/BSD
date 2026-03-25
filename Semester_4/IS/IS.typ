#import "@preview/ilm:2.0.0": *

#set text(lang: "de")
#set page(margin: 2cm)
#let day = datetime.today()

#show: ilm.with(
  title: [Informationssysteme\ FH Campus 02],
  authors: "Andreas Hofer",
  date: day,
  abstract: [],
)

= Grundbegriffe
Um Informationssysteme zu beschreiben muss man zuerst die Grundbegriffe definieren:
== Information
In ihrer grundlegenden Form sind Zeichen wertlos. Eine zufällige Anordnung aus Zeichen "4s€-23" bietet keine Information. Erst mit einer gewissen Syntax kann man dieser interpretieren. Wenn man danach "-5 €" sieht, weiß man zwar, dass es sich wahrscheinlich um eine Währung handelt, was das jedoch bedeutet weiß man nicht. Hierbei benötigt man ebenfalls die Semantik. Wenn man so den Kontext der Zeichen weiß und so erfährt, dass es sich um einen Kontostand handelt, erhält man schon bedeutend mehr Information. Doch erst die Vernetzung mit der Information führt zu Wissen, da man eventuell schlussfolgert, dass man bei einem negativen Kontostand nicht viel Geld oder gar Schulden hat. So kann man Information in der Wissenstreppe nach North kategorisieren:
- Zeichen
 - Alleine keine Übermittlung
 - Zeichen und Syntax bilden Daten
  - Übermittlung ohne Kontext
  - Daten und Semantik bilden Information
   - Vermittelt Information jedoch ohne Verbindung
   - Information und Vernetzung bildet Wissen
Jegliche Information ist dem Information Lifecycle unterworfen.
+ Beschaffung
 - Informationen werden von einem Menschen oder einer Maschine generiert oder erschaffen und gesammelt
 - Es ist ebenfalls relevant Information zu finden (Zum Beispiel mittels Web Crawler)
+ Speicherung
 - Informationen werden gespeichert und ihnen wird mittels Metainformationen ein Kontext verliehen
+ Verwaltung
 - Informationen werden verarbeitet indem es nach Wichtigkeit kategorisiert und Zugriff anhand dessen eingeschränkt wird
+ Verteilung
 - Informationen werden übertragen oder verteilt und konsumiert oder verwendet
 - Basieren auf Push- oder Pull-Prinzip
  - Pull verteilt die Information auf Anfrage (Zum Beispiel ansteuern einer Website)
  - Push vertetlt die Information ohne Initative des Empfängers (Newsletters, Spam)
+ Entsorgung
 - Informationen werden wieder gelöscht
=== Wissen
Nur Vernetzte Information ist Wissen. Dieses existiert exklusiv in mentalen Objekten, kann also nicht gespeichert werden. Jegliche Datenbanken speichern Informationen, welche erst in Wissen umgewandelt werden müssen
== System
Ein System ist ein klar abgegrenztes Gebilde welches eine Funktion erfüllt. Das System selbst enthält dabei Elemente welche diese Funktion ermöglichen. Es ist umgeben von der Umwelt und besitzt einen Input und einen Output. Ein System kann als Black Box betrachtet werden, da man nicht zwangsmäßig die inneren Abläufe kennen muss um es zu verwenden.
== Informationssystem
Ein Informationssystem ist dadurch ein System welches Information verwaltet. Diese dienen der Bereitstellung (Beschaffung und Aufbereitung) von Information. Für dieses System ist es wichtig, dass die Information:
- korrekt
- in der richtigen Menge
- zur richtigen Zeit
- am richtigen Ort
- an die richtigen Personen
- in geeigneter Form
- mit akzeptabler Qualität
- aus den richtigen Systemen
- mit wirtschaftlich optimalem Aufwand
bereitgestellt wird.
=== Anwendungssystem
Das Anwendungssystem ist eine Komponente des Informationssystem. Dieses stellt die Software, die Daten und die Hardware zur Verfügung. Erst wenn ein Mensch ein Anwendungssystem benutzt, wird dieses zum Informationssystem. Ein Informationssystem besteht daher stets aus Mensch und Maschine und bildet so ein Sozio-technisches System.
== Technische Klassifizierung
IS können auch nach ihrer Architektur klassifiziert werden.
- Hardwarearchitektur
 - Hardwarebasierte Architektur physischen Geräte betrifft. (z.B. ob es ein Heim-PC, oder eine Großrechner oder ein Mobilgerät ist)
- Softwarearchitektur
 - Softwarebasierte Architektur wie auf einem Desktopsystem, ob es eine Client/Serverarchitektur oder ein verteiltes System ist.
== ERP
Enterprise Resource Planning (ERP) ist die Aufgabe Ressourcenplanung für unternehmerische Tätigkeiten zu planen.
Dessen Vorgänger ist das Manufacturing Resource Planning (MRP) welches in den 70er Jahren für die grundlegende Planung entwickelt wurde. Dieses wurde in den 80er Jahren von MRP2 ersetzt, welches eine ganzheitliche Planung der Ressourcen eines Fertigungsunternehmens darstellt. Im Idealfall soll es die operative Planung in Mengeneinheiten sowie die finanzielle Planung in Geldeinheiten kombinieren und durch Simulationskomponenten What-If Fragen beantworten. Im deutschen Raum spricht man heute jedoch meist von PPS anstatt MRP2 und wird immer noch anstatt von ERP Systemen in spezialisierten Unternehmen verwendet wird.
In ERP gibt es stets zwei Arten von Planung:
- Indikativ
 - Gibt nur Empfehlungen was gemacht werden sollte
 - Wenn Vorschläge für Führungskräfte erstellt werden sollte, werden meist nur Empfehlungen gegeben
- Imperativ
 - Gibt genaue Vorgaben was gemacht werden muss
Zusätzlich teilt man diese Planung in drei zeitliche Kategorien:
- Kurzfristige Planung
 - Planung für die unmittelbare Zukunft
- Mittelfristige Planung
 - Planung für die nächsten Monate
- Langfristige Planung
 - Strategieplanung der Ausrichtung des Unternehmens (Zeitspanne abhängig vom Unternehmen)
Da ERP ein gesamtheitliches System ist, kann auch garantiert werden, dass die Daten jederzeit aktuell und einheitlich sind.
=== Aufgaben
Ein ERP System hat vier grobe Aufgabenbereiche:
+ Administration
 - Haltung von Daten für Geschäftsfälle, wie Aufträge etc
+ Disposition
 - Automatisierung von Routinevorgängen sowie fristgerechter Planung.
+ Kennzahlenbildung
 - Tracking von Kennzahlen zur 
+ Analyse der Kennzahlen
=== Integration
Um ein ERP-System zu verwenden, muss man dieses zuerst integrieren. Nach Mertens existieren vier Dimensionen der Integration:
- 
- Gegenstand
 - Man muss den Gegenstand der Integration definieren: Was muss überhaupt integriert werden? Welche Prozesse sind involviert? -> Zuerst Prozessmanagement
- Richtung
 - Welche Funktionsbereiche und auf welche Ebene soll es integriert werden? Soll es Horizontal viele Abläufe auf gleicher Ebene integrieren? Soll es Vertikal bis zur Führungsebene integriert werden?
- Umfang
 - Was soll die Intensität der Integration sein? Wie viele betriebliche Funktionen sollen integrieren werden? Wenn alle Bereiche lückenlos integriert werden spricht man von voller Integration.
=== Unterscheidungsmerkmale
Es gibt eine Vielzahl von ERP Systemen. Abhängig von den Anforderungen des Unternehmens können gewisse Systeme Vor- oder Nachteile bieten:
- Branchenausrichtung
 - ERP Systeme können Branchenspezifisch oder -neutral sein. Branchenneutrale Systeme sind zwar allgemein einsetzbar, benötigen jedoch meist mehr Aufwand um sie zu integrieren. Branchenspezifische Systeme sind zwar in der Regel etwas eingeschränkter, bieten jedoch spzeifischere Möglichkeiten für diese Branche
- Skalierbarkeit
 - ERP Systeme können besser und schlechter anhand der Eingabemenge skalieren. In der Regel spricht man von einer guten Skalierung, wenn ein System bei doppelter Eingabemenge keinen Effizienzverlust hat, also auch doppelt so lange benötigt. Eine schlechte Skalierbarkeit ist gegeben, wenn durch doppelte Eingabemenge die vierfache Zeit benötigt wird.
 - Eine weitere Möglichkeit Skalierbarkeit zu beschreiben ist die Erweiterbarkeit des Systems, sodass man bei doppelter Ausführung des Systems eine nahezu doppelte Effizienz hat.
- Allgemeine Anforderungen
 - Ungeachtet der spezifischen Anforderungen, gibt es auch allgemeine Anforderung die eher von vielen Unternehmen gebraucht werden:
  - Gesetzliche Anforderungen
   - Eventuelle gesetzliche Anforderungen wie die DSGVO oder DORA können relevant ihrer Einhaltung sein
  - Hochverfügbarkeit
   - Muss das ERP-System eine sehr hohe Verfügbarkeit aufweisen?
  - Datensicherheit
   - Sind Daten nach einem Systemausfall oder Datenverlust wiederherstellbar?
  - Manipulationssicherheit
   - Sind Daten sicher vor externer Manipulation?
- Mandatenfähigkeit
 - Ein System ist fähig zwischen verschiedenen Benutzern innerhalb einer Datenbank zu unterscheiden. Also ist jeder Datensatz einem Benutzer zugeordnet und ein Benutzer kann, trotz Verwendung der gleichen Datenbank nur seine eigenen Einträge sehen.
=== Vorteile
Da ERP-Systeme so weit verbreitet sind, erhält man in der Regel keinen Wettbewerbsvorteil durch eine Einführung. Umgekehrt bedeutet es jedoch, dass es sehr wohl ein Nachteil sein kann kein ERP-System zu haben.










