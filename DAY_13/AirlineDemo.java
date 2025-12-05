import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// ==============================
// ENUMS (Other Language Features)
// ==============================
enum FlightStatus {
    AVAILABLE,
    BOOKED,
    CLOSED
}

// ===========================================
// OOP: Class, Encapsulation, this, static, DRY
// ===========================================
class Flight {
    // === Class Components: variables ===
    private String flightNumber;
    private String destination;
    private String origin;
    private double price;
    private FlightStatus status = FlightStatus.AVAILABLE; // uses Enum

    // === static: shared by all flights (DRY for currency) ===
    private static final NumberFormat CURRENCY_FORMAT =
            NumberFormat.getCurrencyInstance(Locale.US);

    // === Constructor ===
    public Flight(String flightNumber, String origin, String destination, double price) {
        this.flightNumber = flightNumber;  // this keyword
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    // === Encapsulation: getters / setters ===
    public String getFlightNumber() { return flightNumber; }
    public String getDestination() { return destination; }
    public String getOrigin() { return origin; }
    public double getPrice() { return price; }

    public synchronized FlightStatus getStatus() { // synchronized: thread-safe read
        return status;
    }

    public synchronized void setStatus(FlightStatus status) {
        this.status = status;
        // notify threads waiting for flight availability (wait/notifyAll)
        notifyAll();
    }

    public synchronized boolean isAvailable() {
        return status == FlightStatus.AVAILABLE;
    }

    // === Concurrency: wait() / notifyAll() demo ===
    public synchronized void waitUntilAvailable() throws InterruptedException {
        while (!isAvailable()) {
            wait();
        }
    }

    // === Methods: behavior ===
    public void showDetails() {
        // I/O Formatting: printf + format specifiers
        System.out.printf("Flight: %-6s | %-10s -> %-10s | Price: %s | Status: %s%n",
                flightNumber, origin, destination,
                CURRENCY_FORMAT.format(price), status);
    }

    // Used for saving to text file (I/O)
    public String toFileLine() {
        // DRY: single place to define file format
        return flightNumber + "," + origin + "," + destination + "," + price + "," + status;
    }

    // Used for loading from text file (I/O)
    public static Flight fromFileLine(String line) {
        String[] parts = line.split(",");
        if (parts.length != 5) return null;
        Flight f = new Flight(
                parts[0],
                parts[1],
                parts[2],
                Double.parseDouble(parts[3])
        );
        f.setStatus(FlightStatus.valueOf(parts[4]));
        return f;
    }
}

// =======================================
// ABSTRACTION: Abstract class + Inheritance
// =======================================
abstract class Person {
    protected String name;  // protected: visible in subclasses
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Encapsulation
    public String getName() { return name; }
    public String getId() { return id; }

    // Abstraction: subclasses must say what their role is
    public abstract String getRole();

    // Polymorphism: overriding toString
    @Override
    public String toString() {
        return getRole() + "{name='" + name + "', id='" + id + "'}";
    }
}

// ===================================
// Abstraction via INTERFACE (Bookable)
// ===================================
interface Bookable {
    // May throw an UNCHECKED exception (BookingException)
    void bookFlight(Flight f);
}

// ====================================
// Custom Runtime Exception (Unchecked)
// ====================================
class BookingException extends RuntimeException {  // RuntimeException -> unchecked
    public BookingException(String message) {
        super(message);
    }
}

// ==================================
// Passenger: Inheritance + Interface
// ==================================
class Passenger extends Person implements Bookable {

    public Passenger(String name, String id) {
        super(name, id);   // super: calls parent constructor
    }

    @Override
    public String getRole() {
        return "Passenger";
    }

    // === Polymorphism: Method Overriding (from Bookable) ===
    @Override
    public void bookFlight(Flight f) {
        if (f == null) {
            // Example of unchecked exception usage
            throw new BookingException("Flight cannot be null");
        }
        synchronized (f) { // Thread-safe booking
            if (f.isAvailable()) {
                f.setStatus(FlightStatus.BOOKED);
                System.out.println(getName() + " booked flight "
                        + f.getFlightNumber() + " to " + f.getDestination());
            } else {
                System.out.println("Sorry, flight " + f.getFlightNumber()
                        + " is not available. Current status: " + f.getStatus());
            }
        }
    }

    // === Method Overloading (compile-time polymorphism) ===
    public void bookFlight(Flight f, boolean waitIfFull) {
        if (waitIfFull) {
            try {
                // Concurrency: wait for availability
                f.waitUntilAvailable();
                bookFlight(f);  // re-use DRY
            } catch (InterruptedException e) {
                System.out.println("Booking interrupted for " + getName());
                Thread.currentThread().interrupt();
            }
        } else {
            bookFlight(f);
        }
    }
}

// =========================
// Staff: Inheritance (OOP)
// =========================
class Staff extends Person {

    public Staff(String name, String id) {
        super(name, id);
    }

    @Override
    public String getRole() {
        return "Staff";
    }

    public Flight addFlight(String flightNumber, String origin, String destination, double price) {
        System.out.println(getName() + " added flight " + flightNumber);
        return new Flight(flightNumber, origin, destination, price);
    }

    public void manageFlight(Flight f, boolean open) {
        if (open) {
            f.setStatus(FlightStatus.AVAILABLE);
            System.out.println(getName() + " reopened flight " + f.getFlightNumber());
        } else {
            f.setStatus(FlightStatus.CLOSED);
            System.out.println(getName() + " closed flight " + f.getFlightNumber());
        }
    }
}

// ==================================
// Checked Exception (extends Exception)
// ==================================
class FlightNotFoundException extends Exception { // Checked exception
    public FlightNotFoundException(String message) {
        super(message);
    }
}

// ===============================
// Regex helper (Pattern/Matcher)
// ===============================
class InputValidator {
    // Regex: 2 letters + 3 digits: e.g. "AF101"
    private static final Pattern FLIGHT_PATTERN = Pattern.compile("^[A-Z]{2}\\d{3}$");

    public static boolean isValidFlightNumber(String fn) {
        if (fn == null) return false;
        Matcher m = FLIGHT_PATTERN.matcher(fn.toUpperCase());
        return m.matches();
    }
}

// ================================
// Collections, Generics, I/O, etc.
// ================================
class AirlineSystem {
    // Collections + Generics: List, Map
    private final List<Flight> flights = new ArrayList<>();              // List
    private final Map<String, Flight> flightMap = new HashMap<>();       // Map

    // DRY helper to insert into both list and map
    public synchronized void addFlight(Flight f) {
        flights.add(f);
        flightMap.put(f.getFlightNumber().toUpperCase(), f);
    }

    // Generic method + wildcards (Collections and Generics)
    public static void printAnyList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public void listFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            // Lambda expressions + method reference
            flights.forEach(Flight::showDetails);
        }
    }

    // Polymorphism: Method Overloading
    public Flight findFlight(String flightNumber) throws FlightNotFoundException {
        if (!InputValidator.isValidFlightNumber(flightNumber)) {
            throw new FlightNotFoundException("Invalid flight number format (use e.g. AB123)");
        }
        Flight f = flightMap.get(flightNumber.toUpperCase());
        if (f == null) {
            throw new FlightNotFoundException("Flight " + flightNumber + " not found");
        }
        return f;
    }

    // Overloaded findFlight: search by origin/destination
    public List<Flight> findFlight(String origin, String destination) {
        // Lambda + streams (still core collections/lambdas)
        List<Flight> result = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getOrigin().equalsIgnoreCase(origin)
                    && f.getDestination().equalsIgnoreCase(destination)) {
                result.add(f);
            }
        }
        return result;
    }

    // ==============================
    // I/O Streams: load/save flights
    // ==============================

    // Character Stream + BufferedReader (Advanced Streams)
    public void loadFlightsFromFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) return; // no file yet

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                Flight f = Flight.fromFileLine(line);
                if (f != null) {
                    addFlight(f);
                }
            }
        }
    }

    // Character Stream + BufferedWriter (Advanced Streams)
    public void saveFlightsToFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Flight f : flights) {
                bw.write(f.toFileLine());
                bw.newLine();
            }
        }
    }

    // Byte Stream + DataOutputStream (Advanced Streams)
    public void logBooking(String fileName, Passenger p, Flight f) {
        // Example of checked exception handling (IOException)
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileName, true)))) {
            dos.writeUTF("Booking: " + p.getName() + " -> " + f.getFlightNumber());
        } catch (IOException e) {
            System.out.println("Failed to log booking: " + e.getMessage());
        }
    }
}

// ==================================
// Concurrency & Executor Framework
// ==================================
class AutoSaveTask implements Runnable {
    private final AirlineSystem system;
    private final String fileName;

    public AutoSaveTask(AirlineSystem system, String fileName) {
        this.system = system;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        // Thread life cycle: created -> runnable -> running -> terminated
        try {
            system.saveFlightsToFile(fileName);
            System.out.println("[AutoSave] Flights saved by " +
                    Thread.currentThread().getName());
        } catch (IOException e) {
            System.out.println("[AutoSave] Error saving flights: " + e.getMessage());
        }
    }
}

// =======================
// MAIN APP (AirlineDemo)
// =======================
public class AirlineDemo {
    public static void main(String[] args) {
        // Process vs Thread: This is a single Java process.
        // Threads we create below run inside this process.

        // Set Locale (Scanning + Locales)
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);  // Scanning (Scanner)
        sc.useDelimiter("\n");                // custom delimiter example

        AirlineSystem system = new AirlineSystem();

        // ================================
        // I/O: Load initial data from file
        // ================================
        try {
            system.loadFlightsFromFile("flights.txt");
        } catch (IOException e) {
            System.out.println("Could not load flights: " + e.getMessage());
        }

        // Preload some flights if file was empty
        if (system.findFlight("MU101").isEmpty()) {
            // Just a safe pre-load with try/catch
            system.addFlight(new Flight("AF101", "Mumbai", "Paris", 450.0));
            system.addFlight(new Flight("BA202", "Kigali", "London", 550.0));
            system.addFlight(new Flight("MU101", "Kigali", "Mumbai", 500.0));
        }

        // ==================================
        // Executor Framework for background tasks
        // ==================================
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Concurrency vs Parallelism: if multiple CPU cores available, tasks may run in parallel.
        // Here, autosave task runs periodically in separate thread(s).

        // Schedule periodic autosave using scheduled executor
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(
                new AutoSaveTask(system, "flights.txt"),
                5,  // initial delay
                30, // period seconds
                TimeUnit.SECONDS
        );

        System.out.println("Welcome to Airline System!");
        System.out.println("Are you a staff or passenger?");
        String role = sc.nextLine().trim();

        if (role.equalsIgnoreCase("staff")) {
            System.out.println("Enter your name: ");
            String name = sc.nextLine();
            Staff staff = new Staff(name, "ST01");

            while (true) {
                System.out.println("\nStaff Menu: ");
                System.out.println("1. List Flights");
                System.out.println("2. Add Flight");
                System.out.println("3. Open/Close Flight");
                System.out.println("4. Search Flight by Route");
                System.out.println("5. Exit");
                System.out.print("Choice: ");

                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) { // Runtime exception example
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                try { // Exception Handling: try/catch/finally
                    if (choice == 1) {
                        system.listFlights();
                    } else if (choice == 2) {
                        System.out.print("Enter flight number (e.g. AB123): ");
                        String fn = sc.nextLine().trim().toUpperCase();
                        System.out.print("Enter origin: ");
                        String og = sc.nextLine();
                        System.out.print("Enter destination: ");
                        String dn = sc.nextLine();
                        System.out.print("Enter price: ");
                        double price = Double.parseDouble(sc.nextLine());

                        if (!InputValidator.isValidFlightNumber(fn)) {
                            System.out.println("Invalid flight number format.");
                            continue;
                        }

                        Flight newFlight = staff.addFlight(fn, og, dn, price);
                        system.addFlight(newFlight);
                    } else if (choice == 3) {
                        system.listFlights();
                        System.out.print("Enter flight number to manage: ");
                        String fn = sc.nextLine();
                        Flight f;
                        try {
                            f = system.findFlight(fn);
                        } catch (FlightNotFoundException ex) {
                            System.out.println(ex.getMessage());
                            continue;
                        }

                        System.out.print("Open this flight? (yes/no): ");
                        String ans = sc.nextLine();
                        staff.manageFlight(f, ans.equalsIgnoreCase("yes"));
                    } else if (choice == 4) {
                        System.out.print("Enter origin: ");
                        String og = sc.nextLine();
                        System.out.print("Enter destination: ");
                        String dn = sc.nextLine();
                        List<Flight> found = system.findFlight(og, dn);
                        if (found.isEmpty()) {
                            System.out.println("No flights on that route.");
                        } else {
                            found.forEach(Flight::showDetails); // lambda + method ref
                        }
                    } else if (choice == 5) {
                        break;
                    } else {
                        System.out.println("Invalid choice.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid numeric input: " + e.getMessage());
                } finally {
                    // finally always executes: good place for cleanup/logging
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
                System.out.print("Choice: ");

                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                try {
                    if (choice == 1) {
                        system.listFlights();
                    } else if (choice == 2) {
                        system.listFlights();
                        System.out.print("Enter flight number to book (e.g. AB123): ");
                        String fn = sc.nextLine();
                        Flight f;
                        try {
                            f = system.findFlight(fn);
                        } catch (FlightNotFoundException ex) {
                            System.out.println(ex.getMessage());
                            continue;
                        }

                        // Use executor service to simulate sending confirmation in background
                        executor.submit(() -> {
                            // Thread-safe booking using lambda (Lambda Expression)
                            passenger.bookFlight(f);
                            system.logBooking("bookings.bin", passenger, f);
                            System.out.println("[Async] Confirmation sent to " + passenger.getName()
                                    + " on thread " + Thread.currentThread().getName());
                        });

                    } else if (choice == 3) {
                        break;
                    } else {
                        System.out.println("Invalid choice.");
                    }
                } catch (BookingException be) {
                    // Unchecked exception catch
                    System.out.println("Booking error: " + be.getMessage());
                } finally {
                    // Could place cleanup here
                }
            }
        } else {
            System.out.println("Invalid role. Exiting...");
        }

        // =============================
        // Graceful shutdown of threads
        // =============================
        executor.shutdown();
        scheduler.shutdown();
        try {
            // Wait for tasks to finish
            executor.awaitTermination(5, TimeUnit.SECONDS);
            scheduler.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Save flights on exit (I/O Streams)
        try {
            system.saveFlightsToFile("flights.txt");
        } catch (IOException e) {
            System.out.println("Error saving flights: " + e.getMessage());
        }

        sc.close();
        System.out.println("Goodbye from Airline System!");
    }
}
