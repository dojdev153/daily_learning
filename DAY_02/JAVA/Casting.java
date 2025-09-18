 class Computer {
    String brandName;
    int CPU;
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
 class Laptop extends Computer{
      public Laptop(){
         super();
      }
      public Laptop(String brandName){
          super(brandName);
          this.brandName = "computing machine";
      }
      public Laptop(int CPU){
         super();
         this.CPU = CPU;
      }
}

public class Casting{
    public static void main(String[] a){
        new Laptop();
        new Laptop("dell");
        new Laptop(102);
    }
}