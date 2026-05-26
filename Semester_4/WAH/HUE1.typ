#import "@preview/ilm:2.0.0": *

#set text(lang: "en")
#set page(margin: 2cm)
#let day = datetime.today()
#show link: set text(rgb("#0000EE"))

#show: ilm.with(
  title: [Wissenschaftliches Arbeiten und Hypothesenbildung - Hausübung: Richtig Lesen Üben],
  authors: "Andreas Hofer",
  date: day,
  abstract: [],
  table-of-contents: none)



= Schritt 1
SQ3R steht für:
- Survey
 - Überblick über den Text verschaffen indem Überschriften, Inhaltsverzeichnis oder Stichwörter im Text überflogen werden.
- Question
 - Versuchen herauszufinden, welche Teile des Textes relevant für die eigene Arbeit sind.
- Read
 - Die Kapitel die man als relevant erkannt hat nun vollständig lesen. Bei Bedarf Teile markieren oder Bemerkungen hinzufügen.
- Recite
 - Das Gelesene nun in eigene Worte fassen und (idealerweise) auf einen Satz pro Abschnitt komprimieren.
- Review
 - Die Zusammenfassung erneut lesen und sicherstellen, dass es den gelesenen Text auch wirklich wiedergibt und relevant ist.
= Schritt 2
- Survey
 - Da mein Thema Big Data ist, ist der Titel schon vielversprechend. Bei Überfliegen der Kapitelnamen scheint es in dem Paper um die Speicherung und Bereitstellung von großen Datenmengen zu gehen. Verschiedene Big Data Architekturen sind vielleicht nicht direkt für meine Themen relevant, ermöglichen diese jedoch. Das vierte Kapitel hat allein schon durch die Überschrift die wahrscheinlich größte Relevanz.
- Question
 - Die ersten drei Kapitel scheinen nur einen Überblick und Hintergrund von Big Data zu geben und sind deshalb wahrscheinlich nicht von direkter Relevanz. Bei einer Suche der vier Schlagwörter befinden sich alle relevanten im vierten Kapitel, weshalb dieses wahrscheinlich wirklich die relevanteste Information hat. Das fünfte Kapitel hat zwar auch relevante Information, geht jedoch sehr ins Detail, welches für eine Arbeit die sich nicht direkt mit diesem Thema beschäftigt eventuell etwas zu viel ist.
- Read
 - Das Kapitel scheint sich größtenteils verschiedenen Anwendungen der relevanten Techniken zu widmen. Ein großer Teil beschäftigt sich auch mit der Funktionsweise von Neuronalen Netzwerken.
- Recite
 + Es gibt verschiedenste Techniken zu Analyse von Datenmengen, welche sich oft überschneiden.
 + Es gibt jedoch keine objektiv beste Lösung für jedes Problem.
 + Verschiedene statistische Methoden wie MapReduce, Expectation Maximization und Support Vector Machine können verwendet werden.
 + Machine Learning kann auch für Data Mining verwendet werden. Dabei werden große Datenmengen analysiert um relevante Informationen zu extrahieren.
 + Neural Networks sind eine der meistverwendeten Machine Learning Techniken und simulieren die Funktion eines Gehirns.
 + Neural Networks sind jedoch sehr komplex wodurch sie teuer zu betreiben und ineffizient in der Verarbeitung sind.
 + Es gibt jedoch Techniken um ihre Effizienz zu erhöhen. Zwei Beispiele sind die Verwendung von Hash-Maps und FPGA-Hardware
 + Deep Learning ist eine weitere Technik die Neural Networks verwendet um Daten zu klassifizieren, wobei in einem Beispiel eine Trefferrate ähnlich zu der von Menschen erzielt wurde
- Review
 - Diese zusammengefasste Information könnte verwendet werden um einen Hintergrund zu liefern warum Big Data wichtig ist. Da man bei all diesen Techniken große Datenmengen benötigt müssen relevante Algorithmen schnell und effizient sein.
























