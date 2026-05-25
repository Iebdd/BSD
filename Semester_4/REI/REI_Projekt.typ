#import "@preview/ilm:2.0.0": *
#import "@preview/meander:0.4.1"

#set text(lang: "en")
#set page(margin: 1cm)
#let day = datetime.today()
#show link: set text(rgb("#0000EE"))

#show: ilm.with(
  title: [EPay \ #text(24pt,"Requirements Engineering - Projekt")],
  authors: "Andreas Hofer, Patrick Pramberger, Samuel Ulz",
  date: day,
  abstract: [])

= Projektbeschreibung
#let img1 = figure(
  image("assets/mockup.jpeg", width: 70%),
  caption: [Mockup des ScamPrevention Mechanismus'],
)
#meander.reflow({
  import meander: *
  placed(horizon + right, img1)
  container()
  content[
    eBay zählt zu den größten Online-Marktplätzen weltweit, auf dem täglich Millionen Transaktionen zwischen privaten und gewerblichen Nutzern stattfinden. Trotz bestehender Sicherheitsmechanismen verursachen Betrugsdelikte, insbesondere Dreiecksbetrug, gefälschte Produktangebote und nicht zugestellte Waren, jährlich erhebliche finanzielle Schäden und nachhaltige Vertrauensverluste bei Nutzern. \
    *ePay* ist ein in eBay integriertes Sicherheits- und Zahlungsmodul, das sich funktional an PayLivery von Willhaben orientiert. Das Kernprinzip: Der Kaufbetrag wird nach erfolgreichem Kaufabschluss nicht sofort an den Verkäufer ausgezahlt, sondern in einem Treuhandkonto (Escrow) gehalten. Erst wenn der Käufer den Warenempfang ausdrücklich bestätigt, oder eine definierte Frist abläuft, wird die Zahlung freigegeben. Ergänzend setzt ePay auf drei weitere Schutzmechanismen:
    - *Duplikaterkennung:* Bei jeder Inseratserstellung analysiert ein Algorithmus automatisch Text und Bilder und vergleicht diese mit bestehenden Inseraten anderer Nutzer. Hohe Ähnlichkeit deutet auf Dreiecksbetrug hin und wird automatisch einem eBay-Mitarbeiter zur Prüfung eskaliert.
    - *Shadow-Ban:* Als Scammer identifizierte Nutzer werden still gesperrt.  Ihre Inserate verschwinden aus der öffentlichen Suche, ohne dass sie davon Kenntnis erhalten.
    - *TrustScore:* Für jeden registrierten Nutzer wird ein dynamischer Vertrauenswert (0–100) berechnet, basierend auf Transaktionshistorie, erhaltenen Bewertungen und Verhaltensdaten. Er ist öffentlich auf dem Nutzerprofil sichtbar.
  ]
  })
== Definitionen und Abkürzungen
#table(
  columns: (auto, auto),
  inset: 8pt,
  align: horizon,
  table.header(
    [*Begriff*], [*Definition*]
  ),
  [Escrow], [Treuhandkonto, das Zahlungen bis zur Empfangsbestätigung des Käufers zurückhält],
  [Shadow-Ban], [Stilles Sperren eines Nutzers. Dadurch bleiben Inserate für ihn sichtbar, sind aber öffentlich nicht auffindbar],
  [TrustScore], [Numerischer Vertrauenswert eines Nutzers (0–100), errechnet aus Transaktions- und Verhaltenshistorie],
  [Dreiecksbetrug], [Betrugsschema, bei dem ein Täter Produkte inseriert, die er nicht besitzt, und sie mit gestohlenen Zahlungsdaten Dritter kauft],
  [FA], [Funktionale Anforderung],
  [NFA], [Nicht-funktionale Anforderung],
  [DFD], [Datenflussdiagramm]
)
== Stakeholder
#table(
  columns: (auto, auto, auto, auto, auto),
  inset: 8pt,
  align: horizon,
  table.header(
    [*Name*], [*Funktion*], [*Verfügbarkeit*], [*Wissen*], [*Relevanz*]
  ),
  [Käufer], [Endnutzer (Käufer)], [Hoch (regelmäßig aktiv)], [Grundkenntnisse Plattform], [Hohe Nutzerzufriedenheit],
  [Verkäufer], [Endnutzer (Verkäufer)], [Hoch (regelmäßig aktiv)], [Verkaufserfahrung], [Umsatz & Plattformvertrauen],
  [Sachbearbeiter], [Fraud-Sachbearbeiter], [Täglich], [Fraud-Analyse, Systemkenntnisse], [Betrugsprävention],
  [Zahlungsdienstleister], [Externer Systempartner (Escrow)], [Jederzeit], [Zahlungsinfrastruktur], [Finanzielle Abwicklung],
  [eBay (Plattformbetreiber)], [Auftraggeber / Systembetreiber], [Jederzeit], [Plattform,\ Businessprozesse], [Strategische Entscheidungen],
  [Paketdienstleister], [Logistikpartner], [Hoch], [Versandprozesse], [Grundlage für Zahlungsfreigabe]
)
= Ziele des Projekts
  Das Hauptziel unseres Produkts ist, die Plattform als sichersten und vertrauenswürdigsten C2C-Marktplatz der Welt zu positionieren. Konkret sollen Betrugsdelikte durch das ePay-Bezahlsystem und die Inseratserkennung signifikant reduziert, und das Käufervertrauen durch transparente Sicherheitsmechanismen gestärkt werden. Außerdem soll die Plattform dadurch für neue Nutzergruppen attraktiver werden, die bislang aus Sicherheitsbedenken auf Online-Marktplätze verzichtet haben.
== Sicherer und benutzerfreundlicherer Zahlungsprozess
- Der ePay-Zahlungsprozess soll für alle Nutzergruppen, unabhängig von technischer Vorerfahrung, intuitiv, verständlich und sicher nutzbar sein, sodass Käufer und Verkäufer dem System von der ersten Interaktion an vertrauen.
- Ein einfacher, klar strukturierter Zahlungsablauf senkt die Abbruchrate im Checkout, reduziert Supportanfragen und erhöht die Akzeptanz von ePay als primäre Zahlungsmethode. Nutzer, die den Prozess verstehen, bestätigen Empfänge zuverlässiger und lösen damit Zahlungen schneller aus, zum Vorteil aller Transaktionsparteien.
- Mindestens 90 % der Nutzer schließen einen ePay-Checkout in unter 3 Minuten ohne externe Hilfe ab (gemessen per Session-Tracking)
== Prävention von Dreiecksbetrug
- Durch den automatischen Vergleich neu erstellter Inserate mit bestehenden Angeboten sollen betrügerisch kopierte Inserate erkannt und dem Fraud Team zur Prüfung eskaliert werden, bevor ein Schaden für Käufer oder legitime Verkäufer entsteht.
- Die frühzeitige Erkennung von Duplikat-Inseraten unterbricht Dreiecksbetrugsmaschen bereits an der Quelle, entlastet das Fraud Team durch automatische Vorselektion und schützt legitime Verkäufer davor, dass ihre Produktfotos und -beschreibungen für betrügerische Zwecke missbraucht werden. Das Vertrauen in die Plattform wird nachhaltig gestärkt.
- Verdachtsfälle werden innerhalb von 60 Sekunden nach Inseratsveröffentlichung im Fraud-Dashboard sichtbar
== Shadow-Ban
- Wenn ein Dreiecksbetrüger identifiziert und bestätigt wurde, wird über diesen ein Shadow Ban verhängt. Ein Shadow Ban bedeutet, dass der Account zwar immer noch ohne Einschränkung benutzt werden kann, jedoch keine der eigenen Inserate mehr für andere ersichtlich sind und Nachrichten an andere Nutzer werden nicht zugestellt, sind aber als solche ausgewiesen.
- Diese Maßnahme soll die Zeit zwischen einer Identifikation und Erstellung eines neuen Accounts verzögern.
== TrustScore: Transparente Vertrauensbewertung
- Der TrustScore soll jedem Nutzer auf einen Blick eine verlässliche, datenbasierte Einschätzung der Vertrauenswürdigkeit eines Handelspartners liefern, ohne dass Käufer oder Verkäufer selbst aufwändige Recherchen anstellen müssen.
- Ein transparenter und nachvollziehbarer Vertrauenswert senkt die Hemmschwelle für Transaktionen mit unbekannten Handelspartnern, fördert das Wachstum der Plattform durch mehr abgeschlossene Deals und setzt gleichzeitig einen positiven Anreiz für Nutzer, sich regelkonform und verlässlich zu verhalten, um ihren Score zu verbessern.
- 100% der registrierten Nutzer besitzen einen sichtbaren TrustScore spätestens 24 Stunden nach ihrer ersten Transaktion
= System und Kontextbeschreibung
Folgende Elemente werden im Projekt in Betracht gezogen:
- *System (innen) - ePay System*
 - Escrow-Zahlungslogik
 - TrustScore-System
 - Algorithmische Betrugserkennung
 - Shadow-Ban-System
 - Fraud-Dashboard
- *Kontext (relevant)*
 - Käufer
 - Verkäufer
 - eBay-Plattform
 - Zahlungsdienstleister
 - eBay Fraud Team
- *Irrelevante Umgebung*
 - restliches Internet
 - andere Plattformen
 - externe Systeme ohne direkte Schnittstelle
#figure(
 image("assets/Systemkontext.png", width: 90%),
 caption: [Graphische Darstellung des Systemkontexts]
)
= Personas
== Die Gelegenheitsverkäuferin
#table(
  columns: (11%, 19%, 70%),
  inset: 5pt,
  align: horizon,
  stroke: none,
  table.cell(stroke: (top: 1pt, left: 1pt))[], table.cell(stroke: (top: 1pt))[], table.cell(stroke: (right: 1pt, top: 1pt))[#text(size: 18pt, fill: rgb("#0651c9"))[Sarah Müller]],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Biografie]],
  table.cell(stroke: (left: 1pt))[Alter:], [28], 
  table.cell(rowspan: 3, inset: (left: 12pt), stroke: (right: 1pt))[Sarah lebt in Wien und verkauft regelmäßig gebrauchte Kleidung, Bücher und kleinere Haushaltsgegenstände über eBay. Sie nutzt primär ihr Smartphone für das Erstellen von Inseraten und die Kommunikation mit Käufern. Digitale Anwendungen sind ihr vertraut, jedoch bevorzugt sie einfache und intuitive Prozesse ohne technische Komplexität.], 
  table.cell(stroke: (left: 1pt))[Beruf:], [Marketing-\ assistenting],
  table.cell(stroke: (left: 1pt))[Technik\ affinität:],[Mittel],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Verhalten & Nutzungskontext]],
  table.cell(stroke: (left: 1pt))[eBay\ Nutzung:], [2-3 Verkäufe pro Monat],
  table.cell(rowspan: 2, stroke: (right: 1pt))[
  - Erstellt Inserate meist abends oder am Wochenende
  - Reagiert schnell auf Nachrichten, erwartet das auch von Käufern
  - Versendet Ware innerhalb von 1–2 Tagen nach Zahlung
  - Nutzt hauptsächlich mobile App statt Desktop],
  table.cell(stroke: (left: 1pt))[Geräte:], [Smartphone (primär), Laptop]
)
#v(0pt, weak: true)
#table(
  columns: (50%, 50%),
  inset: 5pt,
  stroke: none,
  table.cell(inset: 0pt, colspan: 2)[],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Ziele]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Schmerzpunkte]],
  table.cell(stroke: (left: 1pt))[  
  - Sicherheit: Garantie, dass sie bezahlt wird, bevor sie versendet
  - Effizienz: Schneller und möglichst unkomplizierter Verkaufsprozess
  - Transparenz: Klarer Überblick über Zahlungsstatus und Transaktionen
  - Vertrauen: Aufbau eines guten Verkäuferprofils
  ],
  table.cell(stroke: (right: 1pt))[
  - Unsicherheit bei Zahlungen und Angst vor Betrug
  - Rückbuchungen nach Versand der Ware
  - Unzuverlässige Käufer (keine Zahlung / keine Rückmeldung)
  - Zu viele Schritte im Verkaufs- oder Zahlungsprozess
  - Unklare Statusmeldungen (z. B. „Ist das Geld wirklich da?“)
  ],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Bedürfnisse an das System]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Bezug zu ePay
  ]],
  table.cell(stroke: (left: 1pt))[
  - Klare Anzeige: „Zahlung gesichert“ vor Versand
  - Automatisierte und verständliche Statusupdates
  - Minimaler Klickaufwand im Verkaufsprozess
  - Mobile-optimierte Bedienung
  - Schnelle Auszahlung nach Bestätigung
  ],
  table.cell(inset: (left: 13pt), stroke: (right: 1pt))[
    Sarah profitiert direkt vom Escrow-Mechanismus, da Zahlungen sicher hinterlegt sind, bevor sie die Ware versendet. Der transparente Zahlungsstatus reduziert ihre Unsicherheit erheblich. Der TrustScore stärkt ihre Glaubwürdigkeit als Verkäuferin und erhöht die Wahrscheinlichkeit erfolgreicher Verkäufe. Eine einfache, mobile Bedienung ist für sie entscheidend für die Akzeptanz des Systems.
  ],
  table.cell(colspan: 2, stroke: (left: 1pt, right: 1pt))[#text(size: 15pt)[Typisches Nutzungsszenario]],
  table.cell(colspan: 2, stroke: (left: 1pt, bottom: 1pt, right: 1pt))[Sarah verkauft eine Jacke für 45 €. Nach dem Kauf sieht sie sofort den Status „Zahlung im Escrow gesichert“. Sie verschickt die Ware am nächsten Tag. Nach der Empfangsbestätigung wird das Geld automatisch freigegeben, und sie erhält eine Benachrichtigung über den Zahlungseingang.]
)
#pagebreak()
== Der Power-Seller
#table(
  columns: (11%, 19%, 70%),
  inset: 5pt,
  align: horizon,
  stroke: none,
  table.cell(stroke: (top: 1pt, left: 1pt))[], table.cell(stroke: (top: 1pt))[], table.cell(stroke: (right: 1pt, top: 1pt))[#text(size: 18pt, fill: rgb("#0651c9"))[Markus Steiner]],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Biografie]],
  table.cell(stroke: (left: 1pt))[Alter:], [45], 
  table.cell(rowspan: 3, inset: (left: 12pt), stroke: (right: 1pt))[Markus betreibt seit mehreren Jahren einen erfolgreichen Onlinehandel über eBay und erzielt damit seinen Hauptumsatz. Er verkauft vor allem Elektronik, Haushaltsgeräte und Sammlerstücke. Seine Geschäftsprozesse sind effizient organisiert, und er nutzt eBay täglich intensiv. Für ihn sind stabile Abläufe, schnelle Zahlungsflüsse und ein guter Ruf essenziell für den wirtschaftlichen Erfolg.], 
  table.cell(stroke: (left: 1pt))[Beruf:], [Selbstständiger Elektronikhändler],
  table.cell(stroke: (left: 1pt))[Technik\ affinität:],[Hoch],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Verhalten & Nutzungskontext]],
  table.cell(stroke: (left: 1pt))[eBay\ Nutzung:], [50-100 Verkäufe pro Monat],
  table.cell(rowspan: 2, stroke: (right: 1pt))[
  - Verarbeitet täglich mehrere Bestellungen parallel
  - Nutzt hauptsächlich Desktop für Verwaltung und Analyse
  - Optimiert kontinuierlich seine Inserate (Texte, Bilder, Preise)
  - Reagiert schnell auf Kundenanfragen und Bewertungen
  - Arbeitet teilweise mit automatisierten Prozessen (z. B. Versand, Tracking)],
  table.cell(stroke: (left: 1pt))[Geräte:], [Desktop (primär), Tablet, Smartphone]
)
#v(0pt, weak: true)
#table(
  columns: (50%, 50%),
  inset: 5pt,
  stroke: none,
  table.cell(inset: 0pt, colspan: 2)[],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Ziele]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Schmerzpunkte]],
  table.cell(stroke: (left: 1pt))[  
  - Maximierung des Umsatzes durch hohe Verkaufsfrequenz
  - Schnelle und planbare Auszahlung zur Sicherung des Cashflows
  - Aufbau und Erhalt eines sehr hohen TrustScores (> 85)
  - Schutz seiner Angebote vor Betrug und Nachahmung
  - Effiziente Abwicklung großer Transaktionsmengen
  ],
  table.cell(stroke: (right: 1pt))[
  - Verzögerte Auszahlungen beeinträchtigen Liquidität
  - Betrüger kopieren Inserate (Dreiecksbetrug) und schädigen seinen Ruf
  - Unsichere Käufer oder problematische Transaktionen erhöhen Supportaufwand
  - Fehlende Transparenz bei Prüfprozessen (z. B. warum etwas markiert wird)
  - Skalierungsprobleme bei hohem Verkaufsvolumen
  ],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Bedürfnisse an das System]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Bezug zu ePay
  ]],
  table.cell(stroke: (left: 1pt))[
  - Schnelle, verlässliche und nachvollziehbare Zahlungsfreigaben
  - Transparente Statusanzeigen für alle Transaktionen
  - Hohe Systemstabilität auch bei vielen parallelen Vorgängen
  - Effektiver Schutz vor Inseratskopien
  - Klare Priorisierung oder Vorteile bei hohem TrustScore
  ],
  table.cell(inset: (left: 13pt), stroke: (right: 1pt))[
    Markus profitiert besonders vom TrustScore-System, da ein hoher Wert seine Sichtbarkeit und Vertrauenswürdigkeit steigert. Der Escrow-Mechanismus sorgt für sichere Transaktionen, muss jedoch gleichzeitig effizient genug sein, um seinen Cashflow nicht zu beeinträchtigen. Die Duplikaterkennung dient ihm indirekt als Schutz seiner Inserate und reduziert das Risiko von Reputationsschäden durch Betrug.
  ],
  table.cell(colspan: 2, stroke: (left: 1pt, right: 1pt))[#text(size: 15pt)[Typisches Nutzungsszenario]],
  table.cell(colspan: 2, stroke: (left: 1pt, bottom: 1pt, right: 1pt))[Markus verkauft täglich mehrere Produkte im Wert von jeweils über 100 €. Nach Abschluss eines Kaufs wird der Betrag im Escrow gesichert. Er versendet die Ware noch am selben Tag. Nach Empfangsbestätigung durch den Käufer wird die Zahlung freigegeben. Parallel erkennt das System ein kopiertes Inserat eines anderen Nutzers und meldet es automatisch dem Fraud Team.]
)
#pagebreak()
== Die Schnäppchenkäuferin
#table(
  columns: (11%, 19%, 70%),
  inset: 5pt,
  align: horizon,
  stroke: none,
  table.cell(stroke: (top: 1pt, left: 1pt))[], table.cell(stroke: (top: 1pt))[], table.cell(stroke: (right: 1pt, top: 1pt))[#text(size: 18pt, fill: rgb("#0651c9"))[Lena Fischer]],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Biografie]],
  table.cell(stroke: (left: 1pt))[Alter:], [22], 
  table.cell(rowspan: 3, inset: (left: 12pt), stroke: (right: 1pt))[Lena studiert Informatik im Master und nutzt eBay regelmäßig, um günstige gebrauchte Produkte für Studium und Alltag zu kaufen – insbesondere Elektronik, Fachbücher und Sportartikel. Sie ist sehr internetaffin, informiert sich schnell und effizient und kennt typische Betrugsmaschen. Eine negative Erfahrung mit einem Fake-Inserat hat ihr Vertrauen in Online-Marktplätze jedoch nachhaltig beeinflusst.], 
  table.cell(stroke: (left: 1pt))[Beruf:], [Masterstudentin Informatik],
  table.cell(stroke: (left: 1pt))[Technik\ affinität:],[Sehr hoch],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Verhalten & Nutzungskontext]],
  table.cell(stroke: (left: 1pt))[eBay\ Nutzung:], [5-10 Käufe pro Monat],
  table.cell(rowspan: 2, stroke: (right: 1pt))[
  - Sucht gezielt nach günstigen Angeboten mit gutem Preis-Leistungs-Verhältnis
  - Vergleicht mehrere Inserate parallel
  - Analysiert Bewertungen und Verkäuferprofile vor dem Kauf
  - Nutzt überwiegend das Smartphone für Suche und Kaufabschluss
  - Erwartet schnelle, klare Informationen ohne unnötige Schritte],
  table.cell(stroke: (left: 1pt))[Geräte:], [Smartphone (primär), Laptop]
)
#v(0pt, weak: true)
#table(
  columns: (50%, 50%),
  inset: 5pt,
  stroke: none,
  table.cell(inset: 0pt, colspan: 2)[],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Ziele]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Schmerzpunkte]],
  table.cell(stroke: (left: 1pt))[  
  - Maximale Sicherheit beim Onlinekauf
  - Minimierung des Risikos von Betrug oder Fehlkäufen
  - Schnelle Entscheidungsfindung ohne lange Recherche
  - Einfache und transparente Rückabwicklung im Problemfall
  - Gute Deals bei gleichzeitig geringem Risiko
  ],
  table.cell(stroke: (right: 1pt))[
  - Angst vor Betrug durch Fake-Inserate oder nicht gelieferte Ware
  - Zeitaufwändige Prüfung von Verkäufern (Bewertungen, Profile etc.)
  - Komplizierte Rückerstattungsprozesse mit vielen Formularen
  - Unklare oder intransparente Zahlungs- und Sicherheitsmechanismen
  - Unsicherheit, ob ein Angebot vertrauenswürdig ist
  ],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Bedürfnisse an das System]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Bezug zu ePay
  ]],
  table.cell(stroke: (left: 1pt))[
  - Sofort erkennbare Vertrauensindikatoren (z. B. TrustScore)
  - Klare Aussage: „Geld ist abgesichert“
  - Einfache, automatisierte Rückerstattungsmechanismen
  - Transparente Statusanzeigen für Zahlung und Lieferung
  - Minimaler Aufwand zur Bewertung von Verkäufern
  ],
  table.cell(inset: (left: 13pt), stroke: (right: 1pt))[
    Lena profitiert stark vom TrustScore als schnelles und verlässliches Signal für die Vertrauenswürdigkeit eines Verkäufers. Der Escrow-Mechanismus reduziert ihr wahrgenommenes Risiko erheblich, da ihr Geld erst nach bestätigtem Erhalt freigegeben wird. Dadurch kann sie schneller Kaufentscheidungen treffen, ohne umfangreiche Hintergrundprüfungen durchführen zu müssen.
  ],
  table.cell(colspan: 2, stroke: (left: 1pt, right: 1pt))[#text(size: 15pt)[Typisches Nutzungsszenario]],
  table.cell(colspan: 2, stroke: (left: 1pt, bottom: 1pt, right: 1pt))[Lena findet einen gebrauchten Laptop zu einem sehr guten Preis. Statt lange Bewertungen zu analysieren, verlässt sie sich auf den hohen TrustScore des Verkäufers. Während des Bezahlvorgangs sieht sie, dass die Zahlung im Escrow gesichert ist. Nachdem die Ware geliefert wurde, bestätigt sie den Empfang per Klick. Wäre das Produkt nicht angekommen, hätte sie gewusst, dass ihr Geld geschützt ist.]
)
#pagebreak()
== Der Skeptische Erstkäufer
#table(
  columns: (11%, 19%, 70%),
  inset: 5pt,
  align: horizon,
  stroke: none,
  table.cell(stroke: (top: 1pt, left: 1pt))[], table.cell(stroke: (top: 1pt))[], table.cell(stroke: (right: 1pt, top: 1pt))[#text(size: 18pt, fill: rgb("#3a7de8"))[Thomas Bauer]],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Biografie]],
  table.cell(stroke: (left: 1pt))[Alter:], [55], 
  table.cell(rowspan: 3, inset: (left: 12pt), stroke: (right: 1pt))[Thomas arbeitet als Buchhalter und ist im Umgang mit digitalen Systemen eher vorsichtig und zurückhaltend. Online-Marktplätze hat er bisher gemieden, da er ihnen nicht vollständig vertraut. Durch eine Empfehlung eines Bekannten erwägt er nun erstmals, ein gebrauchtes Rennrad über eBay zu kaufen. Sicherheit und Verständlichkeit stehen für ihn dabei an oberster Stelle.], 
  table.cell(stroke: (left: 1pt))[Beruf:], [Buchhalter],
  table.cell(stroke: (left: 1pt))[Technik\ affinität:],[Niedrig],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Verhalten & Nutzungskontext]],
  table.cell(stroke: (left: 1pt))[eBay\ Nutzung:], [Erstnutzer (1 geplanter Kauf)],
  table.cell(rowspan: 2, stroke: (right: 1pt))[
  - Informiert sich vor dem Kauf sehr gründlich
  - Liest Texte aufmerksam und vollständig
  - Vermeidet komplexe oder unklare Prozesse
  - Nutzt ausschließlich Desktop (keine App-Erfahrung)
  - Bricht Prozesse sofort ab, wenn Unsicherheit entsteht],
  table.cell(stroke: (left: 1pt))[Geräte:], [Desktop (primär)]
)
#v(0pt, weak: true)
#table(
  columns: (50%, 50%),
  inset: 5pt,
  stroke: none,
  table.cell(inset: 0pt, colspan: 2)[],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Ziele]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Schmerzpunkte]],
  table.cell(stroke: (left: 1pt))[  
  - Absolute Sicherheit vor Betrug oder finanziellen Verlusten
  - Klare und verständliche Erklärung aller Schritte
  - Vertrauen in den gesamten Kaufprozess
  - Erfolgreicher erster Kauf ohne negative Erfahrung
  ],
  table.cell(stroke: (right: 1pt))[
  - Angst vor Datenmissbrauch und unsicheren Zahlungen
  - Misstrauen gegenüber unbekannten Verkäufern
  - Unverständliche technische Begriffe oder Prozesse
  - Fehlende Transparenz darüber, was mit seinem Geld passiert
  - Komplexe oder überladene Benutzeroberflächen
  ],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Bedürfnisse an das System]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Bezug zu ePay
  ]],
  table.cell(stroke: (left: 1pt))[
  - Sehr klare, einfache und verständliche Kommunikation („Plain Language“)
  - Sichtbare Sicherheitsmechanismen mit Erklärung (nicht nur technisch, sondern verständlich)
  - Schritt-für-Schritt geführter Kaufprozess
  - Vertrauenssignale (z. B. TrustScore, sichere Zahlungsabwicklung)
  - Minimierung von Entscheidungen und Komplexität
  ],
  table.cell(inset: (left: 13pt), stroke: (right: 1pt))[
    Das Escrow-Prinzip ist für Thomas der entscheidende Faktor für Vertrauen. Die einfache Botschaft „Dein Geld wird erst freigegeben, wenn du die Ware erhalten hast“ reduziert seine größte Angst – den Verlust seines Geldes. In Kombination mit einem sichtbaren TrustScore des Verkäufers kann ePay ihn erstmals dazu bringen, einen Kauf auf der Plattform abzuschließen.
  ],
  table.cell(colspan: 2, stroke: (left: 1pt, right: 1pt))[#text(size: 15pt)[Typisches Nutzungsszenario]],
  table.cell(colspan: 2, stroke: (left: 1pt, bottom: 1pt, right: 1pt))[Thomas findet ein gebrauchtes Rennrad und liest die Angebotsseite sorgfältig durch. Während des Bezahlvorgangs wird ihm klar und verständlich erklärt, dass sein Geld zunächst sicher verwahrt wird. Diese Information gibt ihm genug Vertrauen, den Kauf abzuschließen. Nach Erhalt der Ware bestätigt er den Empfang und versteht den Ablauf als sicher und nachvollziehbar.]
)
#pagebreak()
== Die Trust & Safety Analystin
#table(
  columns: (11%, 19%, 70%),
  inset: 5pt,
  align: horizon,
  stroke: none,
  table.cell(stroke: (top: 1pt, left: 1pt))[], table.cell(stroke: (top: 1pt))[], table.cell(stroke: (right: 1pt, top: 1pt))[#text(size: 18pt, fill: rgb("#3a7de8"))[Jana Hoffmann]],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Biografie]],
  table.cell(stroke: (left: 1pt))[Alter:], [35], 
  table.cell(rowspan: 3, inset: (left: 12pt), stroke: (right: 1pt))[Jana arbeitet seit über 6 Jahren im Trust & Safety Team von eBay und ist auf die Erkennung und Bearbeitung von Betrugsfällen spezialisiert. Ihr Arbeitsalltag besteht aus der Analyse verdächtiger Aktivitäten, der Bewertung von Nutzerkonten sowie der Durchsetzung von Maßnahmen wie Sperren oder Einschränkungen. In komplexeren Fällen arbeitet sie mit anderen Teams und externen Stellen wie Strafverfolgungsbehörden zusammen.], 
  table.cell(stroke: (left: 1pt))[Beruf:], [Trust & Safety Analystin, eBay],
  table.cell(stroke: (left: 1pt))[Technik\ affinität:],[Hoch],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Verhalten & Nutzungskontext]],
  table.cell(stroke: (left: 1pt))[eBay\ Nutzung:], [Intern, täglich],
  table.cell(rowspan: 2, stroke: (right: 1pt))[
  - Schnelle und präzise Identifikation von Betrugsfällen
  - Reduktion manueller Recherche durch automatisierte Voranalyse
  - Priorisierung der wichtigsten und kritischsten Fälle
  - Klare Entscheidungsgrundlagen für Maßnahmen (z. B. Shadow-Ban)
  - Minimierung von Fehlentscheidungen (False Positives und False Negatives)],
  table.cell(stroke: (left: 1pt))[Geräte:], [Desktop(primär), Laptop]
)
#v(0pt, weak: true)
#table(
  columns: (50%, 50%),
  inset: 5pt,
  stroke: none,
  table.cell(inset: 0pt, colspan: 2)[],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Ziele]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Schmerzpunkte]],
  table.cell(stroke: (left: 1pt))[  
  - Schnelle und präzise Identifikation von Betrugsfällen
  - Reduktion manueller Recherche durch automatisierte Voranalyse
  - Priorisierung der wichtigsten und kritischsten Fälle
  - Klare Entscheidungsgrundlagen für Maßnahmen (z. B. Shadow-Ban)
  - Minimierung von Fehlentscheidungen (False Positives und False Negatives)
  ],
  table.cell(stroke: (right: 1pt))[
  - Hohe Anzahl an False Positives aus bestehenden Systemen
  - Unvollständige oder schlecht aufbereitete Informationen in Meldungen
  - Zeitaufwändige manuelle Analyse einzelner Fälle
  - Fehlende Priorisierung (alle Fälle wirken gleich wichtig)
  - Fragmentierte Systeme ohne zentrale Übersicht],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Bedürfnisse an das System]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Bezug zu ePay
  ]],
  table.cell(stroke: (left: 1pt))[
  - Zentrale, übersichtliche Darstellung aller Verdachtsfälle
  - Klare Kontextinformationen (Inserate, Nutzerprofil, TrustScore, Historie)
  - Automatische Priorisierung nach Risiko und Relevanz
  - Nachvollziehbare Entscheidungen des Algorithmus (Erklärbarkeit)
  - Schnelle, direkte Aktionen (z. B. Shadow-Ban mit wenigen Klicks)
  ],
  table.cell(inset: (left: 13pt), stroke: (right: 1pt))[
    Jana ist Hauptnutzerin des Fraud-Dashboards innerhalb von ePay. Die Duplikaterkennung liefert ihr vorgefilterte Verdachtsfälle, wodurch sie sich auf relevante Fälle konzentrieren kann. Durch die strukturierte Darstellung von Kontextinformationen (Inserate, TrustScore, Historie) kann sie schneller fundierte Entscheidungen treffen und Shadow-Bans effizient verhängen oder aufheben.
  ],
  table.cell(colspan: 2, stroke: (left: 1pt, right: 1pt))[#text(size: 15pt)[Typisches Nutzungsszenario]],
  table.cell(colspan: 2, stroke: (left: 1pt, bottom: 1pt, right: 1pt))[Das System meldet automatisch ein neues Inserat mit hoher Ähnlichkeit zu einem bestehenden Angebot. Jana öffnet den Fall im Dashboard und sieht sofort alle relevanten Informationen: das verdächtige Inserat, das Original, den Ähnlichkeitswert sowie das Nutzerprofil mit TrustScore. Auf Basis dieser Informationen entscheidet sie innerhalb weniger Minuten, einen Shadow-Ban zu verhängen.]
)
#pagebreak()
== Der Dreiecksbetrug-Täter
#table(
  columns: (11%, 19%, 70%),
  inset: 5pt,
  align: horizon,
  stroke: none,
  table.cell(stroke: (top: 1pt, left: 1pt))[], table.cell(stroke: (top: 1pt))[], table.cell(stroke: (right: 1pt, top: 1pt))[#text(size: 18pt, fill: rgb("#3a7de8"))[Kevin Braun]],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Biografie]],
  table.cell(stroke: (left: 1pt))[Alter:], [29], 
  table.cell(rowspan: 3, inset: (left: 12pt), stroke: (right: 1pt))[Kevin ist Teil eines organisierten Betrugsnetzwerks und spezialisiert auf Dreiecksbetrug in Online-Marktplätzen. Er erstellt regelmäßig neue Accounts, kopiert erfolgreiche Inserate anderer Verkäufer (inkl. Bilder und Beschreibungen) und bietet diese zu leicht günstigeren Preisen an. Zur Abwicklung nutzt er gestohlene Zahlungsdaten Dritter. Sein Ziel ist es, möglichst lange unentdeckt zu bleiben und kontinuierlich Einnahmen zu generieren.], 
  table.cell(stroke: (left: 1pt))[Beruf:], [Unbekannt (vermutlich kriminell organisiert)],
  table.cell(stroke: (left: 1pt))[Technik\ affinität:],[Hoch],
  table.cell(stroke: (left: 1pt))[], [], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Verhalten & Nutzungskontext]],
  table.cell(stroke: (left: 1pt))[eBay\ Nutzung:], [Mehrere Fake-Accounts parallel],
  table.cell(rowspan: 2, stroke: (right: 1pt))[
 - Erstellt und verwaltet mehrere Accounts parallel
 - Kopiert systematisch erfolgreiche Inserate (Text & Bilder)
 - Nutzt VPN und wechselnde Geräte zur Verschleierung
 - Reagiert schnell auf Sperren durch Erstellung neuer Accounts
 - Optimiert Betrugsstrategien basierend auf Systemverhalten],
  table.cell(stroke: (left: 1pt))[Geräte:], [VPN, wechselnde Geräte und IP-Adressen]
)
#v(0pt, weak: true)
#table(
  columns: (50%, 50%),
  inset: 5pt,
  stroke: none,
  table.cell(inset: 0pt, colspan: 2)[],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Ziele]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Schmerzpunkte]],
  table.cell(stroke: (left: 1pt))[  
 - Maximierung der Anzahl erfolgreicher Betrugstransaktionen
 - Minimierung der Entdeckungswahrscheinlichkeit
 - Schnelle Monetarisierung gestohlener Zahlungsdaten
 - Verlängerung der Lebensdauer einzelner Accounts
  ],
  table.cell(stroke: (right: 1pt))[
 - Automatische Erkennung von Inseratsduplikaten
 - Schnelle Sperrung oder Einschränkung von Accounts
 - Sichtbare Warnsignale für andere Nutzer (z. B. niedriger TrustScore)
 - Manuelle Prüfungen durch Sicherheitsteams
 - Nachvollziehbare Mustererkennung durch Systeme],
  table.cell(stroke: (left: 1pt))[#text(size: 15pt)[Bedürfnisse an das System]], table.cell(stroke: (right: 1pt))[#text(size: 15pt)[Bezug zu ePay
  ]],
  table.cell(stroke: (left: 1pt))[
 - Möglichkeiten zur Umgehung von Erkennungssystemen
 - Fehlende oder langsame Reaktion auf verdächtige Aktivitäten
 - Geringe Transparenz für Nutzer über Betrugsindikatoren
 - Hohe Toleranz gegenüber neuen Accounts
  ],
  table.cell(inset: (left: 13pt), stroke: (right: 1pt))[
    Kevin ist das primäre Ziel der Sicherheitsmechanismen von ePay. Die Duplikaterkennung identifiziert seine kopierten Inserate frühzeitig und erzeugt Verdachtsfälle. Der Shadow-Ban verhindert, dass seine Angebote weiterhin sichtbar sind, ohne ihn direkt zu warnen wodurch seine Strategie unterlaufen wird. Zusätzlich erschwert ein niedriger TrustScore die Glaubwürdigkeit seiner Accounts.
  ],
  table.cell(colspan: 2, stroke: (left: 1pt, right: 1pt))[#text(size: 15pt)[Typisches Nutzungsszenario]],
  table.cell(colspan: 2, stroke: (left: 1pt, bottom: 1pt, right: 1pt))[Kevin kopiert ein erfolgreiches Inserat eines Elektronikartikels und stellt es mit leicht reduziertem Preis ein. Kurz nach Veröffentlichung erkennt das System eine hohe Ähnlichkeit zu bestehenden Angeboten und erstellt einen Verdachtsfall. Das Fraud Team überprüft den Fall und verhängt einen Shadow-Ban, wodurch Kevins Inserat für andere Nutzer unsichtbar wird, während er selbst keinen direkten Hinweis darauf erhält.]
)
= Ermittlung der Anforderungen
== Funktionale Anforderungen
#table(
  columns: (auto, auto),
  inset: 8pt,
  align: horizon,
  table.header(
    [*ID*], [*Beschreibung*]
  ),
  [FA-01], [Nach Abschluss eines Kaufes *muss* das System den Zahlungsbetrag automatisch in ein Escrow-Konto einzahlen],
  [FA-02], [Nach der Veröffentlichung eines Inserats *muss* das System eine algorithmengestützte Ähnlichkeitsanalyse durchführen und verdächtige Inserate im Fraud-Dashboard anzeigen.],
  [FA-03], [Nach der Empfangsbestätigung durch den Käufer *muss* das System den im Escrow-Konto gehaltenen Zahlungsbetrag automatisch an den Verkäufer freigeben.],
  [FA-04], [Das System *muss* alle von der Inseratüberprüfung erzeugten Verdachtsfälle in einem internen Mitarbeiter-Dashboard anzeigen.],
  [FA-05], [Jeder registrierte Nutzer *muss* einen öffentlich einsehbaren TrustScore zwischen 0 und 100 besitzen, der die Vertrauenswürdigkeit eines Benutzers darstellt.]
)
== Nicht-Funktionale Anforderungen
#table(
  columns: (auto, auto),
  inset: 8pt,
  align: horizon,
  table.header(
    [*ID*], [*Beschreibung*]
  ),
  [NFA-01], [Der TrustScore *muss* nach jeder abgeschlossenen Transaktion innerhalb von 24 Stunden neu berechnet werden.],
  [NFA-02], [Falls ein Benutzer einen Shadow-Ban erhält *soll* dies die Erstellung eines neuen betrügerischen Accounts um 7 Tage verzögern.],
  [NFA-03], [Nach freigegebener Zahlung *muss* die Zahlung innerhalb von 24 Stunden überwiesen werden.],
  [NFA-04], [Bei Verwendung von ePay *soll* die Häufigkeit von erfolgreichen Dreiecksbetrugsfällen bei weniger als 0,1 % aller Benutzer liegen.]
)
= Dokumentation der Anforderungen
== Natürlichsprachig
ePay integriert sich nahtlos in den bestehenden eBay-Checkout-Prozess. Sobald ein Käufer
einen Kauf mit ePay abschließt, wird sein Zahlungsbetrag automatisch auf das ePay-Treuhandkonto übertragen und nicht direkt an den Verkäufer. Der Verkäufer erhält eine
Benachrichtigung, dass die Zahlung gesichert ist, und kann die Ware bedenkenlos versenden. Nach Eingang der Sendung bestätigt der Käufer den Empfang per Klick; das System gibt daraufhin den Betrag an den Verkäufer frei. Bestätigt der Käufer nicht, löst ein automatischer Countdown die Freigabe nach 14 Tagen aus. Parallel dazu analysiert ein Algorithmus im Hintergrund jedes neue Inserat auf Ähnlichkeit mit bestehenden Angeboten. Verdächtige Fälle landen im Fraud-Dashboard, wo Mitarbeiter entscheiden, ob ein Shadow-Ban verhängt wird. Alle Nutzerprofile tragen einen TrustScore, der transparent die Vertrauenswürdigkeit eines Nutzers kommuniziert.
== Datenflussdiagramm
#figure(
  image("assets/DataFlowDiagram.png", width: 90%)
)
== Use-Case Diagramm
#figure(
  image("assets/useCase.svg", width: 45%)
)
== Klassenmodell
#figure(
  image("assets/ClassDiagram.svg", width: 50%)
)
= Akzeptanzkriterien
#text(size: 15pt)[*FA-01 - Escrow Einzahlung*]
+ *Wenn* ein Käufer einen Kauf erfolgreich abschließt, *und wenn* die Zahlung vom Zahlungsdienstleister bestätigt wurde, *dann soll* der vollständige Zahlungsbetrag innerhalb von *30 Sekunden* im Escrow-Konto verbucht sein.
+ *Wenn* die Zahlung nicht erfolgreich ist, *dann soll* kein Betrag im Escrow-Konto gespeichert werden und eine Fehlermeldung angezeigt werden.
+ *Wenn* eine Transaktion abgeschlossen ist, *dann soll* der Zahlungsstatus im System als *"ESCROWED"* angezeigt werden.
#text(size: 15pt)[*FA-02 - Hintergrundanalyse & Anzeige*]
+ *Wenn* ein neues Inserat veröffentlicht wird, *dann soll* innerhalb von *60 Sekunden* eine Algorithmus-gestützte Ähnlichkeitsanalyse gestartet werden.
+ *Wenn* die Ähnlichkeit zu einem bestehenden Inserat *$eq.gt$ 85 %* beträgt, *dann soll* automatisch ein Verdachtsfall im Fraud-Dashboard erstellt werden.
+ *Wenn* ein Verdachtsfall erstellt wird, *dann soll* dieser folgende Informationen enthalten:
 - verdächtiges Inserat
 - Referenz-Inserat
 - Ähnlichkeitswert
 - Nutzerprofil
+ *Wenn* ein Inserat nicht als verdächtig eingestuft wird, *dann soll* kein Eintrag im Fraud-Dashboard erstellt werden.
#text(size: 15pt)[*FA-03 - Zahlungsfreigabe*]
+ *Wenn* der Käufer bestätigt, dass die Ware in Ordnung ist, *dann soll* der Zahlungsbetrag innerhalb von *60 Sekunden* an den Verkäufer freigegeben werden.
+ *Wenn* die Freigabe erfolgt, *dann soll* der Transaktionsstatus auf *"RELEASED"* gesetzt werden.
+ *Wenn* der Käufer die Empfangsbestätigung mehrfach ausführt, *dann soll* die Zahlung *nur einmal* freigegeben werden.
+ *Wenn* der Käufer innerhalb von *3 Tagen* nach Erhalt der Ware keine Empfangsbestätigung übermittelt, wird die Zahlung *trotzdem* freigegeben.
+ *Wenn* die Zahlung freigegeben wurde *dann soll* diese innerhalb von zwei Werktagen beim Verkäufer eingehen.
#text(size: 15pt)[*FA-04 - Verdachtsfallanzeige*]
+ *Wenn* ein Verdachtsfall aufkommt, *dann soll* dieser auf dem Dashboard von autorisierten Mitarbeitern eingesehen werden können.
+ *Wenn* ein Verdachtsfall eingesehen wird, *dann sollen* folgende Felder aufrufbar sein: verdächtiges Inserat, Originalinserat, berechneter Ähnlichkeitswert, Nutzerprofil des Verdächtigen (inkl. TrustScore), Zeitstempel der Erkennung
+ *Wenn* ein Verdachtsfall bearbeitet wird, *dann soll* das System empfohlene Maßnahmen bereitstellen.
#text(size: 15pt)[*FA-05 - TrustScore-Zuweisung*]
+ *Wenn* ein Nutzer sein Konto erfolgreich registriert, *dann soll* innerhalb von *24 Stunden* ein TrustScore einsehbar sein.
+ *Wenn* ein Nutzer ein Inserat, Verkäuferprofil oder Checkout-Seite aufruft, *dann soll* der TrustScore angezeigt werden.
#text(size: 15pt)[*NFA-01 - TrustScore-Anpassung*]
+ *Wenn* eine ePay-Transaktion erfolgreich abgeschlossen wurde, *dann soll* der TrustScore beider Parteien innerhalb von *24 Stunden* angepasst werden.
+ *Wenn* der TrustScore angepasst wird, *dann soll* dieser ebenfalls innerhalb von *24 Stunden* öffentlich einsehbar sein.

#text(size: 15pt)[*NFA-02 - Shadow-Ban*]
+ *Wenn* einem Nutzer ein Shadow-Ban zuteil wird, *dann soll* dieser erst nach *7 Tagen* etwas davon merken.
+ *Wenn* ein Nutzer Shadow-Banned ist, *dann soll* die Erstellung eines neuen Accounts um *7 Tage* verzögert werden.

#text(size: 15pt)[*NFA-03 - Treuhänderüberweisung*]
+ *Wenn* eine Transaktion erfolgreich abgeschlossen wurde und der Käufer die Zahlung freigegeben hat, *dann soll* die Verzögerung, bis der Verkäufer das Geld erhält nicht mehr als *24 Stunden* betragen.

#text(size: 15pt)[*NFA-04 - Betrugsbekämpfung*]
+ *Wenn* ePay seit mindestens 12 Monaten produktiv betrieben wird, *dann soll* die monatliche Inzidenzrate an Dreiecksbetrugen weniger als *0,1 %* der monatlichen Transaktionen betragen.
