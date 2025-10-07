
import java.util.*;

class Flight {
    private String flightNumber;
    private String destination;
    private String origin;
    private boolean isAvailable = true;

    public Flight(String flightNumber, String origin, String destination) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
    }

    public void showDetails() {
        System.out.println("Flight: " + flightNumber + " | " + origin + " -> " + destination + " | Available: " + isAvailable);
    }

    public String getFlightNumber() { return flightNumber; }
    public String getDestination() { return destination; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}

class Person {
    private String name;
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public String getId() { return id; }
}

class Passenger extends Person {
    public Passenger(String name, String id) {
        super(name, id);
    }

    public void bookFlight(Flight f) {
        if (f.isAvailable()) {
            f.setAvailable(false);
            System.out.println(getName() + " booked flight " + f.getFlightNumber() + " to " + f.getDestination());
        } else {
            System.out.println("Sorry, flight " + f.getFlightNumber() + " is already booked.");
        }
    }
}

class Staff extends Person {
    public Staff(String name, String id) {
        super(name, id);
    }

    public Flight addFlight(String flightNumber, String origin, String destination) {
        System.out.println(getName() + " added flight " + flightNumber);
        return new Flight(flightNumber, origin, destination);
    }

    public void manageFlight(Flight f, boolean open) {
        f.setAvailable(open);
        if (open) {
            System.out.println(getName() + " reopened flight " + f.getFlightNumber());
        } else {
            System.out.println(getName() + " closed flight " + f.getFlightNumber());
        }
    }
}

class AirlineSystem {
    private List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight f) {
        flights.add(f);
    }

    public void listFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            for (Flight f : flights) {
                f.showDetails();
            }
        }
    }

    public Flight findFlight(String flightNumber) {
        for (Flight f : flights) {
            if (f.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return f;
            }
        }
        return null;
    }
}

public class AirlineDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AirlineSystem system = new AirlineSystem();

        // Preload some flights
        system.addFlight(new Flight("AF101", "Mumbai", "Paris"));
        system.addFlight(new Flight("BA202", "Kigali", "London"));

        System.out.println("Welcome to Airline System!");
        System.out.println("Are you a staff or passenger?");
        String role = sc.nextLine();

        if (role.equalsIgnoreCase("staff")) {
            System.out.println("Enter your name: ");
            String name = sc.nextLine();
            Staff staff = new Staff(name, "ST01");

            while (true) {
                System.out.println("\nStaff Menu: ");
                System.out.println("1. List Flights");
                System.out.println("2. Add Flight");
                System.out.println("3. Open/Close Flight");
                System.out.println("4. Exit");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                if (choice == 1) {
                    system.listFlights();
                } else if (choice == 2) {
                    System.out.println("Enter flight number: ");
                    String fn = sc.nextLine();
                    System.out.println("Enter origin: ");
                    String og = sc.nextLine();
                    System.out.println("Enter destination: ");
                    String dn = sc.nextLine();
                    system.addFlight(staff.addFlight(fn, og, dn));
                } else if (choice == 3) {
                    system.listFlights();
                    System.out.println("Enter flight number to manage: ");
                    String fn = sc.nextLine();
                    Flight f = system.findFlight(fn);
                    if (f != null) {
                        System.out.println("Open this flight? (yes/no)");
                        String ans = sc.nextLine();
                        staff.manageFlight(f, ans.equalsIgnoreCase("yes"));
                    } else {
                        System.out.println("Flight not found.");
                    }
                } else if (choice == 4) {
                    break;
                }
            }
        } else if (role.equalsIgnoreCase("passenger")) {
            System.out.println("Enter your name: ");
            String name = sc.nextLine();
            Passenger passenger = new Passenger(name, "P001");

            while (true) {
                System.out.println("\nPassenger Menu: ");
                System.out.println("1. List Flights");
                System.out.println("2. Book Flight");
                System.out.println("3. Exit");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    system.listFlights();
                } else if (choice == 2) {
                    system.listFlights();
                    System.out.println("Enter flight number to book: ");
                    String fn = sc.nextLine();
                    Flight f = system.findFlight(fn);
                    if (f != null) {
                        passenger.bookFlight(f);
                    } else {
                        System.out.println("Flight not found!");
                    }
                } else if (choice == 3) {
                    break;
                }
            }
        } else {
            System.out.println("Invalid role. Exiting...");
        }
        sc.close();
    }
}
