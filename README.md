# TimeRecordManagement
A simple Tool to keep track of Tasks and how much Time was spent on given Tasks.

# Refactoring
## Projektdefinition
Ein Tool zum Erfassen von Zeiten und Aufgaben. In einem Timesheet können mehrere Projekte erfasst werden.
Pro Projekt können Zeiten gebucht werden. Die Zeiten können auf verschiedene Buckets im Projekt verteilt werden (Meetings, Entwicklungsaufgaben, "aktueller Sprint"?, Fahrtzeiten, etc).
Es soll möglich sein für Buckets einzelne Workflows zu definieren. (zB. soll bei einer neuen Buchung die Alte automatisch geschlossen werden, etc.).
Buchungen können zusätzlich einer Kategorie zugeordnet werden (zB. Daily, Planning, Bugfix, etc...). Darüber hinaus soll es möglich sein Buchungen mit Tags (#Tag) zu versehen.
Der Scope der jeweiligen Attribute soll über Einstellungen festzulegen sein (Projektweit, Sheetweit). Es soll außerdem möglich sein, eigene Attribute anzulegen.

Nach dem Abschluss einer Buchung soll es die Möglichkeit geben Notizen zur jeweiligen Buchung anzugeben.

Es soll außerdem zwei Kategorien von Einstellungen geben: global und Timesheet

Der Editor soll die klassischen Datei- und Bearbeitungsfunktionen bieten.

Künftige Ideen könnten sein:
- Aufgabenplaner mit Deadline (Erinnerungsfunktion)
- Schätzung von zeitlichen Verfügbarkeiten anhand vergangener Aufgaben und anstehendem
- Auswertung mit grafischer Darstellung
- Pluginsystem über Skripte zum Steuern von Abläufen bei Events beim Abschließen oder Beginnen von AUfgaben etc.
- Anbindung an Kalender und Scrumboards(Jira, RunScrum(Scagile), Gitlab)


# Usage
TBD

# Roadmap
## Basic Functionality:
- Datamodel for Tasks
- TrayMenu

## Advanced Functionality
- Runnable Jar
- File save/load
- Overview Window
- Settings Window

## Extended (Future) Functionality:
- Status of Tasks
- Tagging of Tasks
- Task with topics
- Shortcut to Tasks
- Workflow Operations (copy, paste, undo, redo)
- General Options in seperate file(default File, etc.)
- Multiple Language Support
