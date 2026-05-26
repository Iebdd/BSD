#import "@preview/ilm:2.0.0": *
#import "@preview/meander:0.4.1"

#set text(lang: "en")
#set page(margin: 2cm)
#let day = datetime.today()
#show link: set text(rgb("#0000EE"))

#show: ilm.with(
  title: [EPay \ #text(24pt,"Requirements Engineering - Projekt")],
  authors: "Andreas Hofer, Patrick Pramberger, Samuel Ulz",
  date: day,
  abstract: [])

= Projektbeschreibung
#let img1 = figure(
  image("assets/mockup.jpeg", width: 80%),
  caption: [Mockup des ScamPrevention Mechanismus'],
)
#meander.reflow({
  import meander: *
  placed(horizon + right, img1)
  container()
  content[
    #lorem(570)
  ]
  })
= Ziele des Projekts
= System und Kontextbeschreibung
= Personas
== Andreas
== Patrick
== Samuel
= Ermittlung der Anforderungen
== Andreas
== Patrick
== Samuel
= Dokumentation der Anforderungen
== Natürlichsprachig
== Datenflussdiagramm
== Use-Case Diagramm
== Klassenmodell
= Akzeptanzkriterien