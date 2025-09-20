class Vehicle{
     void move(){
         System.out.println("moving");
     }
}
class Car extends Vehicle{
     void fast(){
         System.out.println("i'm fast");
     }
     void playMusic(){
        system.out.println("i play music");
     }
}

class Cast3{
    public static void main(String[] args){
        Vehicle v = new Car();
        v.move();
        car c = (Car)v;
        c.playMusic();
    }
}