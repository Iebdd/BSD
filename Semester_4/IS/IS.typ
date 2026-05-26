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
= ERP
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
== Aufgaben
Ein ERP System hat vier grobe Aufgabenbereiche:
+ Administration
 - Haltung von Daten für Geschäftsfälle, wie Aufträge etc
+ Disposition
 - Automatisierung von Routinevorgängen sowie fristgerechter Planung.
+ Kennzahlenbildung
 - Tracking von Kennzahlen zur 
+ Analyse der Kennzahlen
== Integration
Um ein ERP-System zu verwenden, muss man dieses zuerst integrieren. Nach Mertens existieren vier Dimensionen der Integration:
- 
- Gegenstand
 - Man muss den Gegenstand der Integration definieren: Was muss überhaupt integriert werden? Welche Prozesse sind involviert? -> Zuerst Prozessmanagement
- Richtung
 - Welche Funktionsbereiche und auf welche Ebene soll es integriert werden? Soll es Horizontal viele Abläufe auf gleicher Ebene integrieren? Soll es Vertikal bis zur Führungsebene integriert werden?
- Umfang
 - Was soll die Intensität der Integration sein? Wie viele betriebliche Funktionen sollen integrieren werden? Wenn alle Bereiche lückenlos integriert werden spricht man von voller Integration.
== Unterscheidungsmerkmale
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
== Vorteile
Da ERP-Systeme so weit verbreitet sind, erhält man in der Regel keinen Wettbewerbsvorteil durch eine Einführung. Umgekehrt bedeutet es jedoch, dass es sehr wohl ein Nachteil sein kann kein ERP-System zu haben. 
= Informationssysteme
== Auswahl von Informationssystem
Wenn man ein IT-System einführen will, muss man zuerst eines auswählen. Dabei gibt es mehrere Aspekte zu betrachten
=== Produktivitätsparadoxon
Wenn man ein neues System einführt erwartet man sich einen Effizienzgewinn da man ja ein neues System hat, was jedoch oft nicht oder zumindest nicht sofort eintritt. Das hängt damit zusammen, dass die Einführung eines neuen Systems immer mit der Änderung bestehender, Eliminierung alter und Erstellung neuer Prozesse einhergeht. Dadurch muss das Unternehmen zuerst die neuen Prozesse lernen und sieht so nicht sofort einen Effizienzgewinn. Ein paar Ursachen sind:
==== Lern- und Anpassungseffekte
Bei Einführung auf ein neues System wird in der Regel versucht, Teile der Arbeit zu automatisieren. Mitarbeiter, welche mit diesen zu automatisierenden Arbeiten beschäftigt sind, könnten Bedenken haben, sie würden obsolet werden, was ihre Effizienz verringert oder gar den Prozess sabotieren lässt.
Neue Software benötigt zusätzlich in der Regel bessere Hardware, wodurch PCs und Server welche eventuell noch brauchbar wären, obsolet werden.
==== Nutzung technischer Potenziale
Auch wenn man ein neues, theoretisch effizienteres, System eingeführt hat, kann man nur schwer messen, ob dieser wirklich eintritt. Man kann ebenfalls nur schwer herausfinden ob das gesamte Potenzial des Systems auch wirklich ausgenutzt wird. Eventuell müssen Mitarbeiter nachweisen, dass sie Effizient arbeiten, was wiederum zu einer verringerten Effizienz führt.
==== Managementfehler
Mitarbeiter in Managementpositionen haben oft einen großen Einfluss, doch nicht unbedingt hohe technische Kenntnisse. Dadurch werden Entscheidungen neue Prozesse einzuführen weniger aufgrund realer Vorteile, sondern aus Angst vor eventuellen Wettbewerbsnachteilen oder Prestige treffen.
== Standardsoftware
Standardsoftware ist Software, welche unternehmensneutral anwendbar ist und so weit verbreitete allgemeine Probleme lösen kann. Einige Beispiel für eine solche Software sind Microsoft Office Produkte, SAP oder Jira. Die Wahl eines Standardprodukts kann große Vorteile bieten, da sie in der Regel kostengünstiger als spezielle Systeme und leichter in der Einführung sind. Es kann jedoch sein, dass ein Unternehmen spezialisiert ist und so die Software anpassen muss, was wieder mehr Zeit bei der Einführung bedarf.
== Individualsoftware
Das Gegenstück zur Standardsoftware ist die Individualsoftware. Hierbei wird ein Produkt an die invididuellen Bedürfnisse des Unternehmens angepasst, da sie spezifisch dafür entwickelt werden. Eine solche Software kann zu Wettbewerbsvorteilen führen, da diese Software sich der von den Konkurrenten unterscheidet. In der Regel ist es eine gute Idee die Prozesse des Kerngeschäfts durch Individualsoftware zu lösen, während Peripherieprozesse eher Standardsoftware verwenden sollten.
Individualsoftware ist jedoch in der Regel teurer in der Anschaffung und hat auch eine längere Entwicklungsdauer. Es könnte auch passieren, dass, wenn man die Entwicklung des Programms outsourced, Hintergründe über Betriebsprozesse an Rivalen fallen
== Make or Buy
Bei der Entscheidung ob man Software zukauft oder diese selbst entwickeln lässt, muss man die Eigenkompetenz im Vergleich zu dem Dienstleister und der strategischen Bedeutung für den Auftraggeber beachten.
#table(
  columns: (auto, auto, auto, auto),
  inset: 5pt,
  table.header(table.cell(inset: 0pt)[], table.cell(inset: 0pt)[],  table.cell(inset: 0pt)[],  table.cell(inset: 0pt)[], ),
  table.cell(
    rowspan: 3,
    align: horizon + center,
    rotate(-90deg, reflow: true)[Strategische Bedeutung \ für den Auftraggeber]
  ),
  table.cell(align: horizon, rotate(-90deg, reflow: true)[Hoch]),
  table.cell(align: horizon, inset: 30pt)[Unklar],
  table.cell(align: horizon, inset: 30pt)[Make],
  table.cell(align: horizon, rotate(-90deg, reflow: true)[Niedrig]),
  table.cell(align: horizon, inset: 30pt)[Buy],
  table.cell(align: horizon, inset: 30pt)[Unklar],
  [],
  table.cell(align: center)[Niedrig],
  table.cell(align: center)[Hoch],
  [],
  table.cell(align: center, colspan: 3)[Eigenkompetenz im Vergleich \ zu dem Dienstleister]
)
= Wissensamanagement
== Grundlagen
Eine Wissensgesellschaft unterscheidet sich in der Hinsicht, dass einzelne Menschen sich in eine Richtung spezialisieren und so neues Wissen generieren. Dabei machen sie sich jedoch auch von anderen Menschen abhängig.
Grundmerkmale einer Wissensgesellschaft ist die Schrift als externer Informationsspeicher um Wissen beständig abrufbar zu machen. Diese Wissensbestände steigen seit geraumer Zeit (Irgendwann im 20. Jahrhundert) exponentiell an, getrieben durch die Industrialisierung und Digitalisierung. Es wird auch zunehmends mit Wissen gehandelt und der Wert von Wissen im Allgemeinen anerkannt. Dadurch werden auch vermeintlich triviale Prozesse intensiveres Wissen vorraussetzen.
Die Folgen einer solchen Gesellschaft ist, dass Anforderungen ständig variieren, sodass man nie ausgelernt hat sondern sich ständig weiterentwickeln muss. Durch den Fokus auf Wissen, welcher in den Köpfen der Angestellten gefangen ist, besteht auch mehr Fokus darauf dieses Wissen zu behalten (humanorientiertes Wissensmanagement).
=== Zeichen
Zugrunde jeder Wissensgesellschaft liegen Zeichen. Diese sind der Wertevorrat an Symbolen um Wissen zu repräsentieren. Zeichen sind zwar eindeutig aber nicht eineindeutig (Ein Zeichen hat immer nur eine Bedeutung, kann aber in einem anderen Kontext eine andere eindeutige Bedeutung haben). Zeichen werden kodiert (ob als Schriftzeichen oder Binär).
=== Information
Informationen sind Zeichen in einem Kontext. Sie entsteht durch Existenz in einem Muster oder durch Aussage über Daten. Information kann also als kodiertes Wissen gesehen werden.
In der Regel sollte Information einen Neuigkeitswert haben, redundante Information kann jedoch dazu benutzt werden um dessen Existenz zu bestätigen. Information kann auch verunsichern, wenn diese im Widerspruch zu bisherigem Wissen steht.
=== Wissen
Wissen ist ist Information kombiniert mit Erfahrung, Kontext, Interpretation und/oder Reflektion. Im Gegensatz zu Daten, welche außerhalb von Menschen gespeichert sind, ist Wissen vernetzt und steuert das Verhalten von Menschen. Wissen ist nicht direkt wahrnehmbar und es kann nur indirekt von außen zugegriffen werden.
==== Modell nach Wersig
Nach Wersig ist Wissen die Struktur des "internen Außenweltmodells". Das interne Weltbild wird durch Perzeptoren eines Organismus' geformt, wenn dieser mit der Außenwelt interagiert. Wissen existiert so immer im Zusammenhang mit Menschen und einem System
==== Subjektivität von Wissen
Da Wissen stets im Kontext einer Person steht, gilt dieses allgemein als subjektiv wahr. (Da Wissen einer Person von dieser als wahr angenommen wird.) Da Wissen jedoch oft objektiv verifizierbar ist, kann Wissen gleichzeitig subjektiv wahr und objektiv falsch sein. Wissen kann auch widersprülich sein, was jedoch erst erkennbar wird, wenn dieses für die gleiche Situation angewandt wird.










