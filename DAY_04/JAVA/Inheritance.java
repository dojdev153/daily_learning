class Shape{
    double Area(){
        System.out.println("i have area");
    }
}
class Rectangle extends Shape{
      double len,win;
      Rectangle(double l, double w){
        this.len = l;
        this.win = w;
        
      }
        @Override
        double Area(){
            return len*win;
        }
}
class Circle extends Shape{
    double radius;
        @Override
        void Area(){
            System.out.println("i have area");
        }
}

class Inheritance{
    public static void main(String[] args){

    }
}