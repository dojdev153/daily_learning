// EnumExercises.java

// 1. Color enum
enum Color {
    RED, GREEN, BLUE
}

// 2. Vehicle class with inner enum
class Vehicle {
    enum VehicleType { CAR, BUS, BIKE }
}

// 3. Day enum
enum Day {
    MON, TUE, WED, THU, FRI, SAT, SUN
}

// 4. Planet enum with mass, radius, and density
enum Planet {
    EARTH(5.97, 6371),
    MARS(0.642, 3389);

    private double mass;   // 10^24 kg
    private double radius; // km

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getDensity() {
        // Very rough density calculation (not to scale, just as example)
        double volume = (4 / 3.0) * Math.PI * Math.pow(radius, 3);
        return mass * 1e24 / volume;
    }
}

// 5. Subject enum with credits
enum Subject {
    JAVA(4), PYTHON(3), DB(2);

    private int credits;

    Subject(int c) { this.credits = c; }

    public int getCredits() { return credits; }

    public void setCredits(int credits) { this.credits = credits; }
}

// 6. Printable interface and Shape enum
interface Printable {
    void print();
}

enum Shape implements Printable {
    CIRCLE {
        public void print() { System.out.println("This is a circle."); }
    },
    SQUARE {
        public void print() { System.out.println("This is a square."); }
    },
    TRIANGLE {
        public void print() { System.out.println("This is a triangle."); }
    }
}

// 7. Level enum
enum Level { LOW, MEDIUM, HIGH }

// 8. Month enum with month numbers
enum Month {
    JAN(1), FEB(2), MAR(3), APR(4), MAY(5), JUN(6),
    JUL(7), AUG(8), SEP(9), OCT(10), NOV(11), DEC(12);

    private int number;

    Month(int number) { this.number = number; }

    public int getNumber() { return number; }
}

// 9. Operation enum with methods
enum Operation {
    ADD {
        public int apply(int a, int b) { return a + b; }
    },
    SUBTRACT {
        public int apply(int a, int b) { return a - b; }
    },
    MULTIPLY {
        public int apply(int a, int b) { return a * b; }
    },
    DIVIDE {
        public int apply(int a, int b) { 
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b; 
        }
    };

    public abstract int apply(int a, int b);
}

// 10. OrderStatus enum
enum OrderStatus {
    NEW, PROCESSING, SHIPPED, DELIVERED, CANCELLED
}

public class EnumExercises {
    public static void main(String[] args) {
        // 1. Print all colors
        System.out.println("1) Colors:");
        for (Color c : Color.values()) {
            System.out.println(" - " + c);
        }

        // 2. Print one VehicleType
        System.out.println("\n2) Vehicle type:");
        System.out.println("Selected vehicle: " + Vehicle.VehicleType.CAR);

        // 3. Use Day in a switch (weekday/weekend)
        System.out.println("\n3) Day type:");
        Day d = Day.SAT;
        switch (d) {
            case SAT:
            case SUN:
                System.out.println(d + " is a weekend");
                break;
            default:
                System.out.println(d + " is a weekday");
        }

        // 4. Planet density
        System.out.println("\n4) Planet densities:");
        for (Planet p : Planet.values()) {
            System.out.println(p + " density = " + p.getDensity());
        }

        // 5. Modify Subject credits
        System.out.println("\n5) Subjects before and after modifying PYTHON credits:");
        System.out.println("Before:");
        for (Subject s : Subject.values()) {
            System.out.println(" - " + s + ": " + s.getCredits());
        }

        // Modify one subject
        Subject.PYTHON.setCredits(5);

        System.out.println("After:");
        for (Subject s : Subject.values()) {
            System.out.println(" - " + s + ": " + s.getCredits());
        }

        // 6. Shape implementing Printable
        System.out.println("\n6) Shapes printing messages:");
        Shape.CIRCLE.print();
        Shape.SQUARE.print();
        Shape.TRIANGLE.print();

        // 7. Level with if-else
        System.out.println("\n7) Level warning:");
        Level level = Level.HIGH;
        if (level == Level.LOW) {
            System.out.println("Low warning.");
        } else if (level == Level.MEDIUM) {
            System.out.println("Medium warning.");
        } else {
            System.out.println("High warning!");
        }

        // 8. Months with numbers
        System.out.println("\n8) Months and their numbers:");
        for (Month m : Month.values()) {
            System.out.println(m + " = " + m.getNumber());
        }

        // 9. Operation enum
        System.out.println("\n9) Operations:");
        int a = 10, b = 5;
        System.out.println("ADD: " + Operation.ADD.apply(a, b));
        System.out.println("SUBTRACT: " + Operation.SUBTRACT.apply(a, b));
        System.out.println("MULTIPLY: " + Operation.MULTIPLY.apply(a, b));
        System.out.println("DIVIDE: " + Operation.DIVIDE.apply(a, b));

        // 10. OrderStatus with messages
        System.out.println("\n10) Order status messages:");
        printOrderMessage(OrderStatus.NEW);
        printOrderMessage(OrderStatus.PROCESSING);
        printOrderMessage(OrderStatus.SHIPPED);
        printOrderMessage(OrderStatus.DELIVERED);
        printOrderMessage(OrderStatus.CANCELLED);
    }

    // For exercise 10
    public static void printOrderMessage(OrderStatus status) {
        switch (status) {
            case NEW:
                System.out.println("Order created.");
                break;
            case PROCESSING:
                System.out.println("Order is being prepared.");
                break;
            case SHIPPED:
                System.out.println("Order is on the way.");
                break;
            case DELIVERED:
                System.out.println("Order delivered.");
                break;
            case CANCELLED:
                System.out.println("Order cancelled.");
                break;
        }
    }
}
