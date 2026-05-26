#import "@preview/ilm:2.0.0": *

#set text(lang: "en")
#set page(margin: 2cm)
#let day = datetime.today()

#show: ilm.with(
  title: [Digitale Geschäftsmodelle 2 - Projekt],
  authors: "Andreas Hofer, Samuel Ulz, Patrick Pramberger",
  date: day,
  abstract: [])

= Leidenschaften & Skills
Leidenschaft:
- *Andreas*
 - Backen
 - Urbanismus
- *Samuel*
 - Technische Innovationen
 - Gaming
 - Statistiken
 - Musik
 - Reisen
- *Patrick*
 - Fahrzeuge
 - Kompatible Systeme
 - Vertrieb ehrlicher Produkte
 - Sport (Ausdauersport)
 - Mechanische Bauteile
Skills:
- *Andreas*
 - Programmieren
- *Samuel*
 - Singen
 - Musikverständnis
 - Logisches Denken
- *Patrick*
 - Komplexe Dinge verstehen
 - Lösungen finden
 - Handwerklich
 - Sportlich

= Geschäftsidee
Konzept für Selbstbedienungsläden. Dieses Konzept sollte nicht nur auf eine einzelne Sparte anwendbar, sondern allgemein verwendbar sein.
== Businesseigenschaften von Warren Buffet
+ Einzigartigkeit
 - Während der Corona-Pandemie erschienen einige Konzepte für Selbstbedienungsläden, diese verschwanden danach jedoch bald wieder. Heutzutage wurden diese größtenteils wieder verdrängt und es bestehen nur mehr Hofverkäufe und Automatenläden. Aus diesem Grund könnte diese Geschäftsidee durchaus umsetzbar sein.
+ Klebrigkeit
 - Wenn man das Modell anstatt es zu verkaufen als Service mit inbegriffener Wartung anbietet kann man eine wiederkehrende Einnahmequelle aufbauen. Da jeder dieser Läden idealerweise auch etwas verkauft und so Umsatz generiert wäre die wiederkehrende Ausgabe stets mit den Mehreinnahmen gegenüberstellbar.
+ Teuer im Verkauf
 - Da man durch das Modell Personal oder Geschäftsfläche einsparen, beziehungsweise Diebstahl verglichen mit anderen Selbstbedieunungsläden reduzieren kann, könnte man einen relativ hohen Preis durchaus rechtfertigen.
+ Günstig in der Herstellung
 - Der größte Kostenfaktor ist die anfängliche Softwareimplementation. Sobald diese beendet ist, kann man das Konzept mit der Software relativ günstig (abzüglich der Baukosten des Ladens) verkaufen.
== Marktkriterien
+ Schmerzen
 - Da Personal für Einzelhandelsläden immer schwerer zu finden und gleichzeitig teuer ist, könnte man diese Pains mit einem Selbstbedienungskonzept bedienen.
+ Kaufkraft
 - Da das Zielpublikum stets Händler sind welche mit ihrem Laden Profit erwirtschaften wollen, besitzen diese wahrscheinlich genug Kaufkraft um solch ein Konzept kaufen zu wollen.
+ Einfach zu erreichen
 - Supermärkte sind *nicht* einfach zu erreichen, da diese wahrscheinlich kein Interesse an einer unausgegohrenen Idee haben.
 - Stattdessen müsste man zuerst andere Läden als Ziel nehmen wie zum Beispiel Bauernläden, da diese stets offen haben dürfen (in Österreich) und in einem Großteil der Fälle bereits Selbstbedienungsläden sind.
+ Wachsend
 - Bauernläden sind ein wachsender Markt und es gibt zusätzlich einen vermehrten Trend zur Regionalität
 - Ein gutes Konzept, das Diebstahl verringert, könnte auch dazu führen, dass mehr Bauern sich dazu entscheiden einen solchen Laden aufzubauen
== Value Proposition
=== Traumresultat
Das Traumresultat ist, dass der Laden großteils unabhängig agiert und nur sporadisch besucht werden muss. Gleichzeitig würden Diebstähle minimiert werden.
=== Wahrgenommene Wahrscheinlichkeit
Da solche Lösungen bis jetzt nie reibungslos funktioniert haben, würde die Wahrscheinlichkeit eher als gering eingestuft werden. Wenn einige funktionierende Lösungen in Zirkulation wären, könnte man diese als Testimonials verwenden.
Bei Fehlen solcher Testimonials müsste man Studien als Beweis liefern, dass es zu dem Traumresultat führt.
=== Zeitverzögerung
Um die Verzögerung zwischen der Entscheidung zum Kauf zu minimieren sollte man einen Plan erstellen, welche Komponenten man wirklich benötigt und wie man diese integriert. Die Konzeptionierung sollte zum Zeitpunkt des Aufbaus größtneteils bereits abgeschlossen sein.
=== Aufwand
Um den Aufwand seitens des Kunden zu verringern sollte man im Vorhinein überlegen, welche Entscheidungen ein Kunde treffen muss. Das kann zum Beispiel die Größe des Ladens oder die Art der Einrichtung (Regale, Truhen, etc.) sein.
== Externe Innovation
Anfangs gibt es natürlich keine Innovation die man nach außen tragen könnte. Jedoch bräuchte man für einen solchen Laden einiges an externer Technologie die man hinzukaufen müsste:
 - Bezahlsysteme um Diebstähle zu verringern
 - Authentifizierungssysteme um sicherstellen zu können, dass nur autorisierte Personen Zugang erhalten
 - Wenn ein Container als Raum gewählt wird, ein Unternehmen welches diese herstellt
=== Inside-Out
Sobald ein fertiges Softwareprodukt existiert, könnte man die Software und das Know-How der Firma lizensieren, damit andere Firmen in anderen Regionen gleiche Läden anbieten können.
#pagebreak()
== Liefer-Würfel
=== Am Anfang
#table(
  columns: (auto, auto, auto, auto, auto, auto, auto, auto),
  inset: 5pt,
  table.header(
    [], [Dienstleistung], [Support], [Menge], [Geschwi\ ndigkeit], [Konsum], [Skalierung], [Einsparung]
  ),
  table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Dienstleistung]),[] ,[] ,[] ,[] ,[] ,[] , [],
  table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Support]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
      table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Menge]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
      table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Geschwindigkeit]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
      table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Konsum]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
      table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Skalierung]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
      table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Einsparung]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
)
=== Nach Etablierung
#table(
  columns: (auto, auto, auto, auto, auto, auto, auto, auto),
  inset: 5pt,
  table.header(
    [], [Dienstleistung], [Support], [Menge], [Geschwi\ ndigkeit], [Konsum], [Skalierung], [Einsparung]
  ),
  table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Dienstleistung]),[] ,[] ,[] ,[] ,[] ,[] , [],
  table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Support]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
      table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Menge]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
      table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Geschwindigkeit]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
      table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Konsum]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
      table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Skalierung]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
      table.cell(
    align: horizon,
    rotate(-90deg, reflow: true)[Einsparung]) ,[] ,[] ,[] ,[] ,[] ,[] , [],
)
== Vertrieb
#table(
  columns: (),
  inset: 5pt,
  table()
)

Klaus-Uwe Müller. Bauer der einen Selbstbedienungsladen betreibt, aber wenig Zeit dafür hat, da er sehr beschäftigt ist. Will mit seinen Produkten ein eigenständiges Einkommen erwirtschaften ohne das Risiko bestohlen zu werden. Zusätzlich hat er Probleme das Inventar im Blick zu behalten.
*Value Proposition:* Da er mit dem automatischen System eine Zusammenfassung der Verkäufe sowie einen automatischen Verkauf erhält, hat er dadurch ein. 
*Kanal:* Da der Kernmarkt zuerst nur die Steiermark ist, kann diese mit dem Auto befahren werden und so persönliche kaltakquise betreiben.
*Angebot:* Selbstbedienungsladen mit Kamerüberwachung und automatischer Bezahlung um Diebstahl zu minimieren.
*Garantie:* Volle Zufriedenheit oder bis zu 70% des Anschaffungspreises für Geräte abhängig ihres Zustands (Ganzer Laden wird wieder mitgenommen)
*Dringlichkeit & Verknappung:* Nächster Montagetermin ist frühestens in 3 Monaten
=== Kosten
#table(
  columns: (auto, auto),
  inset: 5pt,
  table.header([Kostenpunkt],[Anzahl], [Kosten]),
  [Treibstoff], [70l], [*100€*],
  [Kilometergeld], [$700"km" * 0,40€$], [*280€*],
  [Broschüren], [100 Stück], [*200€*],
  [*Gesamt*], table.cell(colspan: 2)[*580€*]
)
== Kundenbindung
Bindung der Kunden der Ladenbetreiber durch ein Vorteilsprogramm.
=== Fortschritt
Nach dem ersten Gespräch eine Zusammenfassung des Gesprächs an den Kunden weiterleiten
Nach einem Monat die Daten sammeln und eventuelle Lösungen für die entdeckten Probleme anbieten.
Gleichzeitig von Kunden Feedback mittels QR-Code erbitten.
Nach einem halben Jahr ein Referral-Programm anbieten, wobei ein neuer Kunde zu sechs Monaten an gratis Support führt.
Zusätzlich nach einem halben Jahr einen Report ausschicken um den Fortschritt zu zeigen und so zu zeigen, was das System bringt.
Nach einem Jahr einen weiteren Report ausschicken um den weiteren Fortschritt zu zeigen.
=== Problemlösungszyklus
Wenn der Laden eine Zeit läuft als Add-On den Report als Analytics für den Laden anbieten für eine weitere monatliche Gebühr.
Nachdem Ladenbetreiber den Laden eine Zeit verwendet haben, bieten wir als weitere Lösung eine Möglichkeit für Großkunden automatisch Bestellungen abzugeben.
=== Kosten
*Kosten:* 
#table(
  columns: (auto, auto, auto),
  inset: 5pt,
  table.header([Kostenpunkt],[Anzahl], [Kosten]),
  [6 Monate an Lizenzgebühren], [1], [*539,94€*],
  [Kilometergeld], [$700"km" * 0,40€$], [*280€*],
  [Broschüren], [100 Stück], [*200€*],
  [*Gesamt*], table.cell(colspan: 2)[*1020€*]
)
== Kundengewinnung
Um den ersten Kunden zu gewinnen, könnte man anbieten die bereits existierenden Daten eines potentiellen Kunden zu analysieren um so den Schwund und die monatlichen Kosten etc. in Statistiken herauszufinden. Anhand dieser Daten könnte man dann Lösungsvorschläge für gewisse Probleme machen, wobei man jedoch keinen offensichtlichen pitch für das eigene Produkt machen sollte, da es sonst nicht vertrauenserweckend wirkt. Wenn der Kunde zum Beispiel das subjektive Gefühl hat, dass zu viele Waren gestohlen werden, kann man anhand der Daten zu einer Empfehlung kommen. Diese Empfehlung sollte so objektiv wie möglich sein, damit der Kunde nicht das Gefühl bekommt nur etwas verkauft zu bekommen. \
Sobald man ein paar Kunden gewonnen hat, könnte man einen mehrstufigen Problem-Lösungs-Kreislauf aufbauen indem man die Analysesoftware zur Eigennutzung gratis anbietet
Es gibt mehrere Stufen an Lösungen die geboten werden. Da diese für die Firma mit Kosten verbunden sind, wird nur die erste gratis angeboten, die weiteren Stufen sind jedoch relativ günstig und werden mit jeder Stufe teurer (bieten jedoch auch mehr).
+ Die Analyticssoftware die ein Betreiber eines Ladens automatisch erhält ist gratis verfügbar, da der Laden jedoch die Daten nicht sammeln kann, muss es per Hand eingegeben werden. Beim Verwenden der Software gibt es ein Banner, das darauf hinweist, dass diese Daten bei Verwenden eines Unternehmenseigenen Systems automatisch gesammelt werden und man sich so diese Arbeit sparen könnte.
+ Nur das Kassensystem wird angeboten, wodurch die Sammlung der Daten und Analyse automatisch geschieht, jedoch hat man keinen Schutz vor Diebstahl
+ Das Zugangssystem wird hinzugefügt, wodurch man kontrollieren kann, dass nur 'autorisierte' Personen den Laden betreten. Dadurch kann man den Schwund reduzieren.
+ 
=== Kosten
Kosten pro Analyse werden im Schnitt auf 1000€ geschätzt, da man die Arbeitszeit (etwa 10 Stunden), Fahrtzeit und Verschleiß miteinbeziehen muss. Wenn man annimmt, dass nur jede zehnte Analyse auch zu einem Kauf führt, bedeutet das, dass pro gewonnenen Kunden Kosten von 10.000€ entstehen.
=== Gewinn
Der Aufwand pro Analyse ist relativ hoch und er wird ohne Erwartung von Gegenleistung angeboten, wodurch die Berechnung des Gewinns schwierig ist. Wir nehmen an, dass wir mit keinem Gewinn aussteigen werden und Bestenfalls keinen Verlust machen. Die Gewinnung der Kunden führt jedoch zu einer langfristigen Einnahmequelle wodurch dieser Aufwand sich idealerweise rentiert.
== Skalierung
=== Kennzahlen
==== Maximale Anzahl an Kunden
Da unser Produkt eine langfristige Investition ist, wird der Churn pro Jahre berechnet: \
$frac("Sales Velocity", "Churn")="max. Customers"$ \
$frac(10, 0.04)=250$ -> Jährlich werden 10 Kunden gewonnen und 4\% der Kunden verloren. Dadurch ergibt sich ein Maximum an 250 Kunden.
==== Lifetime-Gross-Profit
Mit einem Churn von 4% pro Jahr bleibt ein Kunde im Durschnitt 25 Jahre. Bei Lizenzgebühren von 1.000€ im Jahr und einem Profit des Erstverkaufs von 7.000€ (20.000€ - 13.000€) ergibt das einen LTGP von 32.000€. \
$"Sales Velocity"*"Lifetime Gross Profit"="max. Money"$ \
$1*(25.000€+7.000€)=32.000€$\
==== Total Addressable Market
In Österreich gibt es 40.000 Haupterwerbstätige Bauern wovon jedoch realistisch nur 5\% einen automatisierten Bauernladen haben wollen.
40.000*32.000*0.05=64.000.000
























