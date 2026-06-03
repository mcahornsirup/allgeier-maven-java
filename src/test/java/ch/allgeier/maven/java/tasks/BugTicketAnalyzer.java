package ch.allgeier.maven.java.tasks;

import java.util.Comparator;
import java.util.List;

public final class BugTicketAnalyzer {

    private BugTicketAnalyzer() {
    }

    public static long countOpenCriticalTickets(List<BugTicket> tickets) {
        if (tickets == null) {
            return 0;
        }

        return tickets.stream()
                .filter(ticket -> "CRITICAL".equals(ticket.priority()))
                .count();
    }

    public static List<String> openTicketIdsByPriority(List<BugTicket> tickets) {
        if (tickets == null) {
            return List.of();
        }

        return tickets.stream()
                .filter(ticket -> "OPEN".equals(ticket.status()))
                .sorted(Comparator.comparing(BugTicket::id))
                .map(BugTicket::id)
                .toList();
    }
}
