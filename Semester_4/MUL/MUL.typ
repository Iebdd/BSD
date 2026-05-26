#import "@preview/ilm:2.0.0": *

#set text(lang: "de")
#set page(margin: 2cm)
#let day = datetime.today()

#show: ilm.with(
  title: [Markup Languages\ FH Campus 02],
  authors: "Andreas Hofer",
  date: day,
  abstract: [],
)

= Was ist eine Markupsprache?
Ein Markupsprache ist eine Auszeichnungssprache
= Document Type Definition (DTD)
Während XML sehr flexibel ist, können viele Programme nur bestimmte Arten von XML verarbeiten. Zum Beispiel kann Photoshop nur SVG XML Dokumente verarbeiten. Um anzuzeigen welche Art von XML Dokument bereitgestellt wird, kann man die Document Type Definition (DTD) am Anfang des Dokuments angeben. XML Dokumente benötigen jedoch kein DTD, solange die Syntax valide ist. DTD kann dabei zusätzliche Vorschriften angeben um zu zeigen, was benötigt wird um ein Dokument als valide einzustufen. Ein XML-Dokument ist gültig solange es irgendeine DTD Deklaration enthält (<DOCTYPE) und alle im DTD definierten Vorschriften erfüllt.
== Einschänkungen
Während ein DTD die grobe Struktur des XML Dokuments angibt, ist das genau Erscheinungsbild nicht gegeben. So besagt ein DTD nichts über:
- Das Erscheinungsbild des Wurzelelements aus.
 - 