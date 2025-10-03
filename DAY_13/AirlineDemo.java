import java.util.Scanner;
class Flight {
    private String flightNumber;
    private String destination;
    private String origin;
    private boolean isAvailable = true;

    public Flight(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.origin = origin;
    }
    public void showDetails(){
        System.out.println("Flight: " + flightNumber + " | " + origin + "->" + destination + "| available: " + isAvailable());
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
        Scanner sc = new Scanner(System.in);
        Flight f1 = new Flight("AF101", "Paris");

        System.out.println("Welcome to Airline System!");
        System.out.println("Are you a staff or passenger?");
        String role = sc.nextLine();

        if(role.equalsIgnoreCase("staff")){
            System.out.println("Enter your name: ");
            String name = sc.nextLine();
            Staff staff = new Staff(name, "ST01");

            f1.showDetails();
            System.out.println("do you want to open this flight? (yes/no)");
            String choice = sc.nextLine();
            staff.manageFlight(f1, choice.equalsIgnoreCase("yes"));
        }else if(role.equalsIgnoreCase("passenger")){
                System.out.println("Enter your name: ");
                String name = sc.nextLine();
                Passenger passenger = new Passenger(name, "P001");

                f1.showDetails();
                System.out.println("Do you want to book this flight? (yes/no): ");
                String choice = sc.nextLine();
                if(choice.equalsIgnoreCase("yes")){
                    passenger.bookFlight(f1);
                }
        }else{
            System.out.println("invalid role. Exiting...");
        }
        sc.close();
    }
}