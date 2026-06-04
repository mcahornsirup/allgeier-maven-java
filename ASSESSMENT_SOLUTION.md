# Assessment-Lösung: allgeier-maven-java

> **ACHTUNG:** Diese Datei ist ausschliesslich für Prüfer bestimmt und darf nicht an Kandidaten weitergegeben werden.

## Eingebaute Fehler

### Bug 1 - Falsche Mindestlänge der Passwortregel

**Datei:** `src/test/java/ch/allgeier/maven/java/tasks/PasswordPolicy.java`
**Methode:** `isValid(String password)`
**Code:** `password.length() < 9`

**Fehlerbild:**
```text
AssertionFailedError: expected: <false> but was: <true>
```

**Ursache:** Die fachliche Regel verlangt mindestens 10 Zeichen. Die Implementierung akzeptiert bereits 9 Zeichen.

**Korrektur:** `password.length() < 9` -> `password.length() < 10`

**Erwartetes Verhalten nach Korrektur:** `rejectsPasswordShorterThanTenCharacters` besteht.

---

### Bug 2 - Offene kritische Tickets werden falsch gezählt

**Datei:** `src/test/java/ch/allgeier/maven/java/tasks/BugTicketAnalyzer.java`
**Methode:** `countOpenCriticalTickets(List<BugTicket> tickets)`
**Code:** Es wird nur nach `priority == CRITICAL` gefiltert.

**Fehlerbild:**
```text
AssertionFailedError: expected: <2> but was: <3>
```

**Ursache:** Geschlossene bzw. erledigte Tickets werden mitgezählt. Die Methode muss auf `status == OPEN` und `priority == CRITICAL` filtern.

**Korrektur:** Zusätzlichen Filter ergänzen:

```java
.filter(ticket -> "OPEN".equals(ticket.status()))
.filter(ticket -> "CRITICAL".equals(ticket.priority()))
```

**Erwartetes Verhalten nach Korrektur:** `countsOpenCriticalTickets` besteht.

---

### Bug 3 - Falsche Sortierung offener Tickets

**Datei:** `src/test/java/ch/allgeier/maven/java/tasks/BugTicketAnalyzer.java`
**Methode:** `openTicketIdsByPriority(List<BugTicket> tickets)`
**Code:** `.sorted(Comparator.comparing(BugTicket::id))`

**Fehlerbild:**
```text
AssertionFailedError: expected: <[B-100, B-102, B-101, B-104]> but was: <[B-100, B-101, B-102, B-104]>
```

**Ursache:** Die Methode sortiert nur nach ID. Fachlich sollen offene Tickets zuerst nach Priorität sortiert werden: `CRITICAL`, `MAJOR`, `MINOR`. Innerhalb gleicher Priorität wird nach ID sortiert.

**Korrektur:** Prioritätsrang einführen und Sortierung anpassen:

```java
.sorted(Comparator
        .comparingInt(BugTicketAnalyzer::priorityRank)
        .thenComparing(BugTicket::id))
```

**Erwartetes Verhalten nach Korrektur:** Alle Tests bestehen.
