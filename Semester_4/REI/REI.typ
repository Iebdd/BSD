#import "@preview/ilm:2.0.0": *
#import "@preview/fletcher:0.5.8" as fletcher: diagram, node, edge
#import fletcher.shapes: pill, parallelogram, diamond, hexagon, brace

#set text(lang: "en")

#show: ilm.with(
  title: [Requirments Engineering],
  authors: "Andreas Hofer",
  date: datetime.today(),
  abstract: [],
  cover-page: none
)

= Anforderungen
== Klassifikation von Anforderungen
Anforderungen besitzen verschiedene Merkmale um diese einteilen zu können.
=== Merkmale
In der Regel können Anforderungen in drei Gruppen geteilt werden:
- Basismerkmale
 - Grundlegende Anforderungen welche, falls sie nicht erfüllt werden, zu unerfüllten Erwartungen und Unzufriedenheit führt.
 - Erfüllung führt nicht direkt zu Kundenzufriedenheit, da diese erwartet werden
- Leistungsmerkmale
 - Nice-to-Have Merkmale welche eventuell von Benutzern erwartet, jedoch nicht vorrausgesetzt werden.
 - Erfüllung führt direkt zu Kundenzufriedenheit
- Begeisterungsmerkmale

== Anforderungen ermitteln
Um Anforderungen überhaupt beschreiben zu können, muss man diese zuerst ermitteln. Dabei gibt es einige Quellen:
- Stakeholder
=== Wo sind diese zu finden?
Man muss wissen wo diese Quellen zu finden sind. Einige Personen an bestimmten Orten sind:
- Im Projekt
 - Der Projektleiter
 - Analytiker
 - Designer
=== Relevanz
Nicht jeder Stakeholder hat die gleiche Relevanz im Projekt. Stakeholder werden von A bis D klassifiziert um zu beschreiben wie involviert diese im Projekt sind und wie oft diese über Vorkommnisse informiert werden wollen.
=== Satzschablone
Im Anforderungsmanagement kann man eine Satzschablone verwenden um Anforderungen zu definieren:
+ Wann?/Unter welchen Bedingungen?
 - Wann oder unter welchen Umständen soll etwas geschehen?
+ Muss/Soll/Kann/Wird?
 - Gibt die Verbindlichkeit der Anforderungen
  - Muss - bindends
  - Sollte - dringend empfohlen
  - Kann - Nice to have
  - Wird - Zukünftlich verbindlich
+ Das System
 - Das System das beschrieben werden soll
+ Art der Funktionalität
 - Was soll die Anforderung bewirken?
 - Benutzerinteraktion:
  - Das System stellt dem Benutzer die Prozessfunktion zur Verfügung
 - Schnittstellenanforderung:
  - Das System führt den Prozess in Abhängigkeit eines dritten aus
 - Selbstständige Systemaktivität
  - Anforderung bei der das System eigenständig etwas durchführt
+ Das Objekt
 - Optionale Ergänzung zum Prozesswort
  - Fragen wie: Was? Wo? etc.
+ Prozesswort
 - Identifizierung des Prozesses
 - In der Regel ein Verb das eine Tätigkeit beschreibt

 #diagram(
node-fill: blue,
(
node((0,0.75), rect(text(white, [Warum?]))),
edge((0,0.75), (1,0), "->"),
edge((0,0.75), (1,0.5), "->"),
edge((0,0.75), (1,1), "->"),
edge((0,0.75), (1,1.5), "->"),
node((1,0), [Muss]),
node((1,0.5), [Soll]),
node((1,1), [Kann]),
node((1,1.5), [Wird]),
)
)


















