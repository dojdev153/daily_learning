package DAY_13;
class Flight {
    private String flightNumber;
    private String destination;
    private boolean isAvailable = true;

    public Flight(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
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

    public void manageFlight(Flight f, boolean open) {
        f.setAvailable(open);
        if (open) {
            System.out.println(getName() + " reopened flight " + f.getFlightNumber());
        } else {
            System.out.println(getName() + " closed flight " + f.getFlightNumber());
        }
    }
}

abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    abstract void accessSystem();
}

class PassengerUser extends User {
    public PassengerUser(String name) {
        super(name);
    }

    @Override
    void accessSystem() {
        System.out.println(name + " accesses system to book flights.");
    }
}

class StaffUser extends User {
    public StaffUser(String name) {
        super(name);
    }

    @Override
    void accessSystem() {
        System.out.println(name + " accesses system to manage flights.");
    }
}
public class AirlineDemo {
    public static void main(String[] args) {
        Flight f1 = new Flight("AF101", "Paris");
        Flight f2 = new Flight("EK202", "Dubai");

        Passenger passenger1 = new Passenger("Alice", "P001");
        Staff staff1 = new Staff("Bob", "S001");

        User u1 = new PassengerUser("Alice");
        User u2 = new StaffUser("Bob");

        u1.accessSystem();
        u2.accessSystem();

        passenger1.bookFlight(f1);
        passenger1.bookFlight(f1);

        staff1.manageFlight(f1, true);
        passenger1.bookFlight(f1);

        System.out.println("Flight " + f1.getFlightNumber() + " availability: " + f1.isAvailable());
        System.out.println("Flight " + f2.getFlightNumber() + " availability: " + f2.isAvailable());
    }
}
