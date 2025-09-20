class Vehicle{
    Vehicle(){
        System.out.println("vehicle created");
    }
}
class Car extends Vehicle{
    Car(){
        super();
        System.out.println("Car created");
    }
}

public class Super{
    public static void main(String[] args){
        Car mycar = new Car();
    }
}
