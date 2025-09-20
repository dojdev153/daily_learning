class Shape{
    void Sides(){
         System.out.println("i have sides");
    }
}
class Circle extends Shape{
    void Radius(){
         System.out.println("i have radius");
    }
}
class Square extends Shape{
    void Diagonal(){
         System.out.println("i have a Diagonal");
    }
}

public class Cast4{
    public static void main(String[] a){
         Shape b = new Circle();
         b.Sides();
         Shape c = new Square();
         c.Sides();

         Shape[] shapes = new Shape[3];
         shapes[0] = new Circle();
         shapes[1] = new Square();
         shapes[2] = new Circle();

         for(Shape s : shapes){
            s.Sides();
         }
    }
}