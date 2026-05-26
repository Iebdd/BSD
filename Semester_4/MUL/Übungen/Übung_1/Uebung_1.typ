#import "@preview/ilm:2.0.0": *
#import "@preview/codly:1.3.0": *
#import "@preview/codly-languages:0.1.10": *
#import "@preview/cetz:0.5.2"


#set text(lang: "en")
#set page(margin: 2cm)
#let day = datetime.today()

#show: ilm.with(
  title: [Markup Languages - Übungsblatt 1 - XML+DTD\ FH Campus 02],
  authors: "Andreas Hofer",
  date: day,
  abstract: [],
)
#show: codly-init.with()

= Well-formed (5%)
Markieren Sie die Stellen in folgenden XML-Datei, die den Anforderungen an well-formed XML-  Dokumente widersprechen und schreiben Sie ein passendes Stichwort dazu:
#codly(languages: codly-languages, header-cell-args: (align: center))
```xml
<?xml version="1.0" encoding="UTF-8"?>
<rss version=2.0> <!-- Keine Anführungszeichen -->
 <channel>
       <title>NETZEITUNG.DE Wissenschaft</title>
       <link>http://www.netzeitung.de/wissenschaft/<link> <!-- Kein Querstrich im closing tag -->
       <language>de</language>
   <item>
      <title>Verdacht auf Mord an Tutanchamun ... </title>
      <date>2005-03-08T13:45:31+02:00</date>
      <description>Tutanchamun starb als junger Mann.
      Jetzt haben Forscher ...</description>
      <link>http://www.netzeitung.de/wissenschaft/</link>
      <!-- zweiter Artikel -->
  <!-- Closing tag fehlt -->
  <item>
     <title>Blauer Planet in Schwarzweiß</title>
     <date>2005-03-08T12:19:23+02:00</description> <!-- Falscher closing tag -->
     <description>Die Kometensonde "Rosetta" ...</date> <!-- Falscher closing tag -->
     <link>http://www.netzeitung.de/spezial/weltraum/</link>
   </item>
 <channel> <!-- Kein Querstrich im closing tag -->
</rss>

```
- Zeile 2
 - Keine Anführungszeichen um das Attribut: "2.0"
- Zeile 5
 - Querstrich bei link closing tag fehlt
- Zeile 13
 - Closing tag item fehlt
- Zeile 17
 - Closing tag von description statt date
- Zeile 18
 - Closing tag von date statt description
- Zeile 21
 - Querstrich bei channel closing tag fehlt
#pagebreak()
== Korrigierte Version
#codly(languages: codly-languages)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<rss version="2.0">
 <channel>
       <title>NETZEITUNG.DE Wissenschaft</title>
       <link>http://www.netzeitung.de/wissenschaft/</link>
       <language>de</language>
   <item>
      <title>Verdacht auf Mord an Tutanchamun ... </title>
      <date>2005-03-08T13:45:31+02:00</date>
      <description>Tutanchamun starb als junger Mann.
      Jetzt haben Forscher ...</description>
      <link>http://www.netzeitung.de/wissenschaft/</link>
      <!-- zweiter Artikel -->
  </item>
  <item>
     <title>Blauer Planet in Schwarzweiß</title>
     <date>2005-03-08T12:19:23+02:00</date>
     <description>Die Kometensonde "Rosetta" ...</description>
     <link>http://www.netzeitung.de/spezial/weltraum/</link>
   </item>
 </channel>
</rss>

```
= XML-Baum I (4%)
#grid(columns: 1, align: horizon,
  image("assets/XML_Tree.png"),
  image("assets/XML_Legend.png"))
XML:
#codly(languages: codly-languages)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Alpha id="1">
  <Beta nr="2">
    <Gamma>
      <Omega>
        <Zeta>
          Sigma
        </Zeta>
      </Omega>
    </Gamma>
    <Eta psi="5" rho="7">
      Thau
    </Eta>
  </Beta>
</Alpha>

```

= XML-Baum II (3%)
Zeichnen Sie für das folgende XML-Dokument den vollständigen Baum. Textknoten, die nur aus Leerzeichen und Zeilenumbrüchen bestehen, können weggelassen werden.
#codly(languages: codly-languages)
```xml
<!-- Liste von Geheimdiensten -->
<Geheimdienste>
  <Land name="US">
    <Geheimdienst kurz="NSA">National Security Agency</Geheimdienst>
    <Geheimdienst kurz="CIA">Central Intelligence Agency</Geheimdienst>
  </Land>
  <Land name="UK">
    <Geheimdienst kurz="MI6">Secret Intelligence Service</Geheimdienst>
  </Land>
</Geheimdienste>

```
XML-Baum:
#cetz.canvas({
  import cetz.draw: *
  set-style(polygon: (radius: 1))
  circle((4, 0), name: "root")
  circle((0, -2.5), name: "Land_US")
  circle((8, -2.5), name: "Land_UK")
  circle((8, -6), name: "MI6")
  circle((-2.5, -6), name: "CIA")
  circle((2.5, -6), name: "NSA")
  polygon((2.5, -2.8), 3, angle: 90deg, name: "US_att")
  polygon((10.5, -2.8), 3, angle: 90deg, name: "UK_att")
  rect((1.623, -3.85), (3.377, -3.35), name: "US_text")
  rect((9.623, -3.85), (11.377, -3.35), name: "UK_text")
  rect((-3.75, -10), (-1.25, -8), name: "CIA_desc")
  rect((1.25, -10), (3.75, -8), name: "NSA_desc")
  rect((7, -10), (9.5, -8), name: "MI6_desc")
  polygon((0, -6.3), 3, angle: 90deg, name: "NSA_att")
  polygon((5, -6.3), 3, angle: 90deg, name: "CIA_att")
  polygon((10.5, -6.3), 3, angle: 90deg, name: "MI6_att")
  rect((-0.877, -7.35), (0.877, -6.85), name: "NSA_text")
  rect((4.123, -7.35), (5.877, -6.85), name: "CIA_text")
  rect((9.623, -7.35), (11.377, -6.85), name: "MI6_text")
  content("root", [Geheim\ dienste])
  content("Land_US", [Land])
  content("Land_UK", [Land])
  content("US_att", [name])
  content("UK_att", [name])
  content("US_text", [US])
  content("UK_text", [UK])
  content("NSA", [Geheim\ dienst])
  content("CIA", [Geheim\ dienst])
  content("MI6", [Geheim\ dienst])
  content("NSA_att", [kurz])
  content("CIA_att", [kurz])
  content("MI6_att", [kurz])
  content("NSA_text", [NSA])
  content("CIA_text", [CIA])
  content("MI6_text", [MI6])
  content("NSA_desc", [National\ Security\ Agency])
  content("CIA_desc", [Central\ Intelligence\ Agency])
  content("MI6_desc", [Secret\ Intelligence\ Service])
  line("root", "Land_US")
  line("root", "Land_UK")
  line("Land_US", "NSA")
  line("Land_US", "CIA")
  line("Land_UK", "MI6")
  line("NSA", "NSA_desc")
  line("CIA", "CIA_desc")
  line("MI6", "MI6_desc")
})
= DTD 1 (4%)
#codly(languages: codly-languages, header: [*XML-Ausschnitt:*])
```xml
<adresse>
  <anrede>...</anrede>
  <name>
    <nachname>...</nachname>
    <vorname>...</vorname>
  </name>
  <strasse>...</strasse>
  <postanschrift>
    <plz>...</plz>
    <wohnort>...</wohnort>
  </postanschrift>
  <email>...</email>
</adresse>
```
#codly(languages: codly-languages, header: [*DTD:*])
```xml
<!ELEMENT adresse (anrede, name, strasse, postanschrift, email*)>
<!ELEMENT anrede (#PCDATA)>
<!ELEMENT name (nachname, vorname)>
<!ELEMENT nachname (#PCDATA)>
<!ELEMENT vorname (#PCDATA)>
<!ELEMENT strasse (#PCDATA)>
<!ELEMENT postanschrift (plz, wohnort)>
<!ELEMENT plz (#PCDATA)>
<!ELEMENT wohnort (#PCDATA)>
<!ELEMENT email (#PCDATA)>
```








