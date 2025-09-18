public class Computer {
    String brandName;
    String CPU;
    String hardDisk;
    
    public Computer(){
          System.out.println("Display in computer");
    }
    public Computer(String brandName){
           this.brandName = brandName;
    }
    void show(){
        System.out.println("Display in computer");
    }
}
public class Laptop extends Computer{
      public Laptop(){
         super();
      }
      public Laptop(String brandName){
          super(brandName);
          this.brandName = "computing machine";
      }
      public Laptop(String CPU){
         super(CPU);
      }
}