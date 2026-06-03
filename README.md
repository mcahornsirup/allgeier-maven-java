# allgeier-maven-java

Java-Programmierprojekt mit JUnit-Tests für reine Java-Aufgaben.

## Zweck im Assessment

Dieses Repository dient **P01 - Programmierkenntnisse** und zeigt, wie Kandidaten Java-Code analysieren, fachliche Anforderungen aus Tests ableiten und gezielt korrigieren.

## Technischer Stack

| Komponente | Version |
|---|---|
| JUnit Jupiter | 6.1.0 |
| Java | 25 |
| Maven | 3.9+ |
| Reporting | Maven Surefire |

## Aufgaben

Das Projekt enthält zwei Java-Programmieraufgaben:

1. **PasswordPolicy**: Validierung einer Passwortregel.
2. **BugTicketAnalyzer**: Auswertung und Sortierung von Bug-Tickets.

## Voraussetzungen

- JDK 25+
- Maven 3.9+

## Ausführen

```bash
mvn clean test
```

## Reports

Surefire-Ergebnisse liegen nach dem Lauf unter:

```text
target/surefire-reports/
```

## Projektstruktur

```text
src/test/java/ch/allgeier/maven/java/tasks/   Java-Aufgaben
src/test/java/ch/allgeier/maven/java/tests/   JUnit-Tests
pom.xml                                      Maven-Konfiguration
```

## Hinweise für das Assessment

Das Projekt enthält bewusst eingebaute Fehler. Kandidaten sollen das Fehlerbild analysieren, die Ursache finden und eine fachlich passende Korrektur umsetzen. Die Auflösung steht nicht in dieser README.
