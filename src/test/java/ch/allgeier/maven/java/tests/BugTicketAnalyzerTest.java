package ch.allgeier.maven.java.tests;

import ch.allgeier.maven.java.tasks.BugTicket;
import ch.allgeier.maven.java.tasks.BugTicketAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BugTicketAnalyzerTest {

    @Test
    void countsOpenCriticalTickets() {
        List<BugTicket> tickets = List.of(
                new BugTicket("B-100", "OPEN", "CRITICAL"),
                new BugTicket("B-101", "DONE", "CRITICAL"),
                new BugTicket("B-102", "OPEN", "MAJOR"),
                new BugTicket("B-103", "OPEN", "CRITICAL")
        );

        assertEquals(2, BugTicketAnalyzer.countOpenCriticalTickets(tickets));
    }

    @Test
    void returnsOpenTicketsSortedByPriorityAndId() {
        List<BugTicket> tickets = List.of(
                new BugTicket("B-104", "OPEN", "MINOR"),
                new BugTicket("B-102", "OPEN", "CRITICAL"),
                new BugTicket("B-103", "DONE", "CRITICAL"),
                new BugTicket("B-101", "OPEN", "MAJOR"),
                new BugTicket("B-100", "OPEN", "CRITICAL")
        );

        List<String> sortedIds = BugTicketAnalyzer.openTicketIdsByPriority(tickets);

        assertEquals(List.of("B-100", "B-102", "B-101", "B-104"), sortedIds);
    }

    @Test
    void handlesNullTicketListAsEmpty() {
        assertEquals(0, BugTicketAnalyzer.countOpenCriticalTickets(null));
        assertEquals(List.of(), BugTicketAnalyzer.openTicketIdsByPriority(null));
    }
}
