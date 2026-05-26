#import "@preview/ilm:2.0.0": *

#set text(lang: "de")
#set page(margin: 2cm)
#let day = datetime.today()

#show: ilm.with(
  title: [Grundlagen maschinelles Lernen und künstliche Intelligenz\ FH Campus 02],
  authors: "Andreas Hofer",
  date: day,
  abstract: [],
)

= Was ist Intelligenz?
Intelligenz hat keine einheitliche Definition, die vorherrschende Definition bei Machine Learning ist jedoch das Memory-Prediction-Framework von Jeff Howkins welches besagt, dass "Intelligenz nicht primär durch Verhalten oder Rechenpower definiert wird, sondern durch die Fähigkeit des Gehirns, Muster aus der Vergangenheit zu speichern, um daraus kontinuierlich Vorhersagen über die Zukunft zu treffen.". Also werden Informationen aus vergangenen Erfahrungen verwendet um in der Zukunft besser agieren zu können. Auf dieser Technologie basieren alle gängigen LLM-Modelle.
== Terminologie
= KI-Modelle
KI-Modelle sind in ihrer grundlegendsten Form ein Algorithmus welcher Input verwendet um davon zu lernen und so ein fertiges, an die Daten angepasstes, Modell zu erstellen, welches danach anhand dieser Daten Output generiert. Ein KI-Modell besteht also immer aus einem Modell und Daten. Ein Modell mit unterschiedlichen Daten wird zu einem anderen fertigen Modell führen und ein anderes Anfangsmodell wird mit den gleichen Daten ein anderes Modell erstellen.
== Inferenz
Inferenz ist der Prozess ein fertiges Modell durch weiteres Training an neue Daten anzupassen. Dadurch kann man eine Modell updaten ohne es völlig neu trainieren zu müssen, was zu deutlich geringeren Kosten führt.
= ML-Fundamente
Machine Learning ist, einen ML-Algorithmus zu verwenden um Daten zu verarbeiten um so ein Modell zu erstellen. Im Grunde hat ein solcher Algorithmus vier Komponenten:
- Das Modell
- Das Ziel (Objective Function)
- Ein Optimierungsprozess (Optimization Algorithm)
Das Modell verwendet nun anfänglich zufällige Parameter und probiert, wie nah es damit am Ziel ist. Dem Ziel wird dabei ein Wert zugewiesen damit es weiß, wie nahe es an dem Ziel ist. Danach werden die Parameter angepasst und der Vorgang wiederholt. Wenn es durch diese Veränderungen näher am Ziel ist, werden diese Änderungen gelernt.
Falls das Ziel und die Optimierung gut gewählt worden sind, wird das Modell irgendwann in der Lage sein dieses Problem zu lösen. Das Problem hierbei ist jedoch, dass das Modell dadurch nur dieses eine Ziel lernt und bei neuen Problemen schlecht abschneiden wird.
== Supervised Learning
Um dieses Problem zu lösen, kann man Supervised Learning verwenden um die verschiedenen Arten von Problemen zu beschriften um so für jedes Problem ein eigenes Ziel zu definieren. Das Modell wird danach nicht mehr an einem einzelnen Ziel gemessen, sondern an dem Durchschnittlichen Abschneiden aller Ziele abhängig vom Problem.
== Unsupervised Learning
Die meisten Daten sind jedoch nicht bekannt und das Beschriften ist sehr aufwändig, wodurch man unsupervised Learning verwenden kann. Dabei werden unbekannte Daten an das Modell übergeben, wonach dieses die Daten interpretiert und anhand dessen zu Schlussfolgerungen kommt.
== Semi-Supervised Learning
Oft hat man viel zu viele Daten. Hierbei kann man eine Kombination aus Supervised und Unsupervised Learning verwenden. Dabei werden zuerst mit Unsupervised Learning die Daten analysiert und in Cluster geteilt um sie so grundlegend zu beschriften. Danach werden diese beschrifteten Daten in Supervised Learning verwendet um das echte Problem zu lösen.
== Reinforcement Learning
Beim Reincorcement Learning wird statt einem Ziel ein positiver oder negativer Ausgang belohnt. Jedes Mal wenn das Modell so agiert wie erwartet, wird es belohnt und jedes Mal wenn es nicht so agiert, wird es nicht belohnt. Das Modell versucht die Belohnung zu maximieren und so den besten Ausgang zu finden.
= Data Processing
Daten sind nicht selten sofort verwendbar, wodurch sie zuerst angepasst werden müssen damit das Modell diese verwenden kann.
== Fehlende Daten
Wenn Datenpunkte fehlende Parameter haben, muss man diese ausbessern, damit sie das Modell nicht stören. Die zwei einfachsten Strategien dafür sind die Datenpunkte mit fehlenden Parametern einfach zu löschen, oder Platzhalterwerte einzuführen.
Man sollte jedoch nur das Löschen von Daten in Betracht ziehen, wenn man viele Daten hat, da man sonst eventuell nicht genug Daten übrig hat.
Wenn man die fehlenden Daten befüllt, kann man den Durchschnitt aller anderen Werte der Spalte verwenden um so einen Wert einzusetzen welcher die restlichen Daten nicht stört. Dadurch können die anderen Parameter des Datenpunkts trotzdem verwendet werden. Man muss jedoch überlegen, welche der Mittelwerte man verwendet. Das arithmetische Mittel ist sehr anfällig für Ausreißer, wodurch man gegebenfalls entweder den Median (Den Wert in der Mitte aller Daten) oder den Mean (Den Wert der am häufigsten vorkommt) verwenden kann.
== Normalisierung
Daten verschiedener Datensätze haben eventuell andere Skalen um die Parameter zu messen, wodurch man diese normalisieren sollte. Bei der Normalisierung werden alle Daten auf ein standardisiertes Maß zwischen 0 und 1 gebracht. Das kann man mit der Normalisierungsformel: $X`=frac(X-X_(min), X_(max)-X_(min))$ durchführen.
== Label-Kodierung
Wenn man Text hat der sich nicht gut miteinander vergleichen lässt, kann man diesen Text durch einen Code ersetzen. Wenn man zum Beispiel jedes einzigartige Label durch einen numerischen Wert ersetzt, kann man diese danach miteinander vergleichen (Falls eine klare Reihung der Texte existiert).
== Train Test Split
Wenn man einen Datensatz hat, mit dem man ein Modell trainieren will, sollte man nicht den gesamten Datensatz für das Training selbst verwenden, da man danach mit nicht in den Trainingsdaten enthaltenen Daten überprüfen sollte, wie gut das Modell ist. Aus diesem Grund sollte man Datensätze jeweils in einem Verhältnis von 80:20 spalten, wobei 80% der Daten zum trainieren und 20% der Daten zum überprüfen verwendet werden sollten. Wenn man sehr viele Daten hat, kann man die Trainingsdaten wiederum in einem Verhältnis von 80:20 spalten um einen Validierungsdatensatz zu generieren um jederzeit gegen diese Daten testen zu können und so Echtzeitfeedback zu erhalten.
== Resampling
== Feature Extraction
== Feature Engineering
Daten sind in der Regel nur in Zahlen und Strings geteilt, wodurch der Informationsgehalt ohne dem Kontext nur begrenzt ist. Man kann diesen Kontext hinzufügen indem man die Datentypen konvertiert. Zeitdaten sind zum Beispiel oft als Datumsstring oder als Unix Time kodiert. Wenn man diese in ein Date Time Objekt umwandelt, kann der Algorithmus diesen effektiver verwenden.
== Over-/Underfitting
Wenn man ein Modell zu sehr auf einen spezifischen Datensatz trainiert, kann es passieren, dass dieses overfitted ist. Dabei hat es das Rauschen und einzigartige Details des Datensets in sich aufgenommen und gibt zwar sehr guten Output für diesen Datensatz, jedoch relativ schlechte für andere, oft sogar ähnliche, Datensätze. Man kann overfitting erkennen, wenn die Ergebnisse für den Trainingsdatensatz sehr gut, aber sehr schlecht für den Testdatensatz sind.
Overfitting kann verhindert werden indem das Modell nicht zu viel an einem einzigen Datensatz trainiert.
Underfitting tritt hingegen auf, wenn das Modell unzureichend die Merkmale des Datensatzes aufnehmen kann und dieses somit nicht wiedergeben kann.
== Loss Function
Die Loss Function
== Arten von Parametern
Es gibt zwei Arten von Parametern: Model Parameters und Hyperparameters.
Model Parameters sind die Daten, welche von dem Algorithmus intern verwendet werden um die Qualität des Durchgangs auszuwerten.
Hyperparamaters hingegen sind Parameter über den Lernprozess selbst wie die Menge an Durchläufen oder andere Strategiespezifischen Parameter wie n
= ML-Modellfamilien
== Selbst gebaute Modelle
=== Traditionelle ML-Modelle
==== Ensemble Modelle
Die traditionellen Modelle können auch kombiniert werden um bessere Ergebnisse zu liefern. Dabei unterscheidet man zwischen Bagging und Boosting.
- Boosting
 - 
=== Linear Regression
Linear Regression versucht einen linearen Zusammenhang zwischen Datenpunkten zu bilden. 
== Deep-Learning Modelle
Deep Learning ist die Anwendung von linearer Regression in großem Maß um zu einer Entscheidung zu kommen. Dazu wird ein Grundbaustein namens Perceptron verwendet
=== Perceptron
Ein Perceptron ist in seiner einfachsten Ausführung ein Baustein welcher eine Vielzahl von Werten zu einem einzigen Wert kombiniert. Dazu nimmt dieser die gesemten Inputparameter und kommt anhand einer Funktion zu einer Entscheidung. Diese Funktion kombiniert den Input mit einem weight und kombiniert diese um zu entscheiden wie stark dieser input den beeinflusst. Wenn man zum Beispiel 5 inputs hat, die wahr oder falsch sein können, haben diese jeweils ein weight zwischen 0 und 1 und der input wird akzeptiert wenn der output einen gewissen Schwellenwert überschreitet.
=== Backpropagation
Diese Teile müssen jedoch aus ihrem Output lernen. Um das ermöglichen, werden die weights mittels backpropagation anhand des outputs angepasst. Wenn man zum Beispiel ein Bild evaluieren will um zu sehen ob es ein Hund ist und der Algorithmus zum Schluss kommt, dass es ein Hund ist obwohl das nicht stimmt, werden die weights von vorne nach hinten anhand der Ergebnisse leicht angepasst.
== Vortrainierte Modelle
Während alle bisher besprochenen Modelle nur die Werkzeuge zur Erstellung des eigenen Systems zu Verfügung stellen, werden vortrainierte Modelle wie der Name sagt von jemand anderes trainiert und der Endbenutzer verwendet dieses fertige Modell oder passt es falls nötig weiter an.
=== Foundation Modelle
Vortrainierte Modelle basieren nahezu immer auf neuronalen Netzwerken da der Aufwand diese zu trainieren immens ist. Solche Modelle besitzen gewisse Grundstrukturen:
==== Primitives
Die fundamentalsten Elemente eines solchen Modells:
===== Prompt
Der Prompt ist die strukturierte Eingabe wie das Modell eine Aufgabe ausführen soll. Dabei unterscheidet man zwischen drei Detailgraden:
- Zero-Shot
 - Es wird kein zusätzlicher Kontext sondern nur die relevante Frage gestellt. Z.B. "Schreib mir einen Text"
- One-Shot
 - Es werden ein paar Details bezüglich des gewünschten Produkts mitgegeben wie das Thema, die Länge, das Publikum, etc.
- Few-Shot
 - Es werden eine größere Menge an Details mitgegeben wie die den strukturellen Aufbau, einen Referenztext oder ein vorgegebenes Layout
===== Embedding
Das Embedding ist die Vektorrepräsentation der relevanten Objekte. Dabei wird die Nähe der Objekte zueinander als Wahrscheinlichkeit der Relevanz dieser gewertet.
===== Modell
Das Modell das in der Verarbeitung verwendet wird. Bei solchen Modellen werden nahezu immer Large Language Models (LLM) gemeint, da diese die größte Populirät besitzen, es gibt jedoch auch andere wie visuelle oder auditive vortrainierte Modelle.
==== Komposition
Elemente die bei der Erstellung des Outputs relevant werden
===== Function Call
Erlaubt es Modellen gezielt strukturierte FUnktionen oder APIs aufzurufen anstatt nur Text zu generieren.
===== Vector Datenbank
Eine Vector DB speichert Embeddingvektoren effizient ab um sie so für Ähnlichkeitssuchen so schnell wie möglich für Suchen verwenden zu können.
===== Context Awareness
Verwendet Kontext außerhalb des Vektorraums. Es gibt zwei Arten:
- Retrieval Augmented Generation (RAG)
 - Relevante Information wird aus externen Quellen gesucht in dem Moment in dem sie benötigt wird
- Context Augmented Generation (CAG)
 - Kontext wird vorab bereitgestellt (indem relevante Daten dem System zur Verfügung gestellt wird)
===== Guardrails
LLMs erzeugen nachweislich in großem Maß fehlerhafte Information, weshalb man Regeln und Kontrollen benötigt um sicherzustellen, dass diese sicher, korrekt und regelkonform bleiben.
===== Multimodal AI
Die Fähigkeit mehrere Datentypen wie Bilder, Video oder Audio zusammen mit Text zu verarbeiten.
==== Deployment
===== KI-Agenten
LLM-Systeme die Ziele selbstständig planen und Entscheidungen zu treffen oder Aktionen durchzuführen.
===== Fine-Tuning
Gezieltes Nachtrainieren eines vortrainierten Modells für eine spezifische Aufgabe. Das neue Wissen wird dabei direkt in den Modellparametern gespeichert
===== Framework
Frameworks stellen Bausteine und Werkzeuge bereit um 
===== TODO 1
===== TODO 2
==== Emerging
===== Multi-Agenten Systeme
Eine Kooperation aus mehreren KI-Agenten die etwas erreichen wollen und sich dabei gegenseitig kontrollieren. Dadurch können Aufgaben verlässlicher oder komplexere Aufgaben gelöst werden.
===== Synthetische Daten
Künstlich erzeugte Daten die reale ergänzen oder ersetzen
===== MCP
Ein standardisiertes Protokoll mit dem Modelle, Agenten und externe Datenquellen strukturiert Kontext austauschen können
===== Explainability
Methoden mit denen KI Entscheidungen von KI-Modellen nachvollziehbar und interpretierbar gemacht werden.
===== Thinking Models
Thinking Modelle verwenden Zwischenschritte um die Antwort zu planen und so zu anderen Schlussfolgerungen zu kommen. So können komplexere Aufgaben robuster gelöst werden. Das hängt damit zusammen, dass ein kleinerer Kontext eines Prompts in der Regel zu einem besseren output führt. 
= ML-Anwendung
== ML-Fähigkeiten
== Domänenspezifische Anwendungen
== ML-gestützte Systemlösungen























