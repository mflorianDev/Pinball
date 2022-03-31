# Software Architektur & Design - Semesterprojekt

## Programmierung von Entwurfsmustern
Programmierung von Entwurfsmustern in einer Gruppe von 2 Personen.

### Aufgabenstellung

Verwenden sie die Entwurfsmuster (Kompositum, Befehl, Zustand und Singleton), um einen Ablauf eines Flipperautomaten zu simulieren.

#### Zustand-Muster
Es sollen folgende Zustände simuliert werden: NoCredit, Ready, Playing, End;
Der Flipper befindet sich anfangs im NoCredit-Zustand.
Nach Einwurf einer Münze wechselt dieser in den Ready-Zustand und bleibt dort, bis der Start-Knopf gedrückt wird.
Der Start-Knopf versetzt den Automaten in den Playing-Zustand.
Zu jedem Zeitpunkt können weitere Münzen eingeworfen werden, welche den Kredit erhöhen.
Ist eine Kugel 3-mal verloren gegangen, so wechseln sie in den EndState, bei welchem sie ein Spiel gewinnen können. Danach wechselt der Automat, je nach Kredit, in den No-Credit- bzw. Ready-Zustand.

#### Befehl- & Kompositum-Muster
Erstellen sie ein paar Elemente (z. B. Rampe, Target, Bumper), welche sie beliebig oft instanziieren können.
Verwenden sie das Command-Pattern (Befehl bzw. Kommando), um zu spezifizieren, was passiert, wenn ein gewisses Element getroffen wird.
Beispielsweise können sie Punkte erhalten oder es öffnet sich eine Rampe, oder sie wechseln in einen anderen Zustand.
Verwenden sie auch das Kompositum-Muster zusammen mit dem Kommando-Muster, um komplexere Befehle auszufuhren.

#### Singleton-Muster
Verwenden sie das Singleton-Muster, wo es ihnen geeignet erscheint.

#### Visitor-Muster:
Verwenden sie das Visitor Pattern (Besucher) und implementieren sie einen Besucher, welcher eine Liste von abstrakten Flipper-Elementen durchlaufen kann.
