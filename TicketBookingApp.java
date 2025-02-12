
import java.time.LocalDateTime;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now(); // Auto-generate booking time
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last;
    private int ticketCount = 0;

    // Add a new ticket at the end of the circular linked list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber);
        if (last == null) {
            last = newTicket;
            last.next = last; // Circular connection to itself
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket; // Update last node to the newly added ticket
        }
        ticketCount++;
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = last.next, prev = last;
        do {
            if (current.ticketId == ticketId) {
                if (current == last && current.next == last) { // Only one ticket in list
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last) {
                        last = prev; // Update last node if deleting the last one
                    }
                }
                ticketCount--;
                System.out.println("Ticket " + ticketId + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket ID " + ticketId + " not found.");
    }

    // Display all tickets in the circular list
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = last.next;
        System.out.println("\nCurrent Ticket Reservations:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId +
                               ", Customer: " + temp.customerName +
                               ", Movie: " + temp.movieName +
                               ", Seat: " + temp.seatNumber +
                               ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    // Search for tickets by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = last.next;
        boolean found = false;
        do {
if(temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket Found -> ID: " + temp.ticketId + 
                                   ", Customer: " + temp.customerName +
                                   ", Movie: " + temp.movieName +
                                   ", Seat: " + temp.seatNumber +
                                   ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != last.next);

        if (!found) {
            System.out.println("No ticket found for query: " + query);
        }
    }

    // Count total number of booked tickets
    public void countTickets() {
        System.out.println("Total tickets booked: " + ticketCount);
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding tickets
        system.addTicket(101, "Alice", "Inception", "A1");
        system.addTicket(102, "Bob", "Interstellar", "B2");
        system.addTicket(103, "Charlie", "Inception", "C3");
        system.addTicket(104, "David", "Tenet", "D4");

        // Display tickets
        system.displayTickets();

        // Searching tickets
        System.out.println("\nSearching for 'Inception'...");
        system.searchTicket("Inception");

        System.out.println("\nSearching for 'Alice'...");
        system.searchTicket("Alice");

        // Removing a ticket
        System.out.println("\nRemoving ticket 102...");
        system.removeTicket(102);
        system.displayTickets();

        // Counting total tickets
        system.countTickets();
    }
}

